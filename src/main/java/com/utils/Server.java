package com.utils;
import java.net.URI;
import java.util.*;
import java.io.*;

import com.constants.Constants;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
public class Server {
    private static Server server = null;
    private ServerBuffer sbBuffer;
    private Map<String,Integer> videoVisitCount;
    private Server() throws IOException{
        sbBuffer = ServerBuffer.getBuffer();
        this.videoVisitCount = new HashMap<>();
        String path = Constants.HDFSAddress + "/video";
        FileSystem fs = FileSystem.get(URI.create(path),new Configuration());
        FileStatus[] status = fs.listStatus(new Path(path));
        //Save all ID and initialize the count to 1
        for(int i = 0; i < status.length; i++){
            String[] tmp = status[i].getPath().toString().split("[/]");
            String ID  = tmp[tmp.length - 1].split("[.]")[0];
            this.videoVisitCount.put(ID,0);
        }
    }

    public static Server getServer() throws IOException{
        if(server == null)
            server = new Server();
        return server;
    }

    public VideoClip getClip (String ID) throws Exception{
        //Such clip doesn't exist
        if(! videoVisitCount.containsKey(ID)){
            throw new Exception("ID does not exist!");
        }
        VideoClip clip = null;
        if(this.sbBuffer.hasClip(ID)){
            clip = this.sbBuffer.getClip(ID);
            //For it has already exists, the clip has already been saved in the buffer, so does the count
            clip.incVisitCount();
            videoVisitCount.put(ID, clip.getVisitCount());
        }
        //Such clip doesn't exist in buufer
        else {
            clip = new VideoClip(ID);
            videoVisitCount.put(ID, videoVisitCount.get(ID) + 1);
            clip.setVisitCount(videoVisitCount.get(ID));

            //If this clip get higher priority or the buffer is not full, refresh the buffer
            this.sbBuffer.addClip(ID,clip);

        }
        return clip;
    }
}
