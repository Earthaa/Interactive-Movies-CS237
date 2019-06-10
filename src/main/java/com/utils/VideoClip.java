package com.utils;
import java.io.*;
import java.net.URI;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import com.constants.Constants;
public class VideoClip implements Comparable<VideoClip> {
    //private FSDataInputStream video;
    private long size;
    private String ID;
    private int visitCount;
    private byte[] video;
    VideoClip(String ID) throws IOException{
        this.ID = ID;
        String pathName = Constants.HDFSAddress + "/video/" +  ID + ".mp4";
        Configuration config=new Configuration();
        FileSystem fs = null;
        FSDataInputStream in = null;
        try {
            fs = FileSystem.get(URI.create(pathName),config);
            in=fs.open(new Path(pathName));

        } catch (IOException e) {
            e.printStackTrace();
        }
        this.video = in.readAllBytes();
        this.size = fs.getFileStatus(new Path(pathName)).getLen();
        this.visitCount = 0;
        in.close();
    }

    VideoClip(VideoClip v){
        this.video = v.video;
        this.size = v.size;
        this.ID = v.ID;
        this.visitCount = v.visitCount;
    }
    public byte[] getVideo(){
        return this.video;
    }

//    public FSDataInputStream getVideo(){
//        return this.video;
//    }
    public long getSize(){
        return this.size;
    }
    public int getVisitCount(){
        return this.visitCount;
    }
    public String getID(){
        return this.ID;
    }

    public void setVisitCount(int s){
        this.visitCount = s;
    }

    //Increase VisitoCount by one
    public void incVisitCount(){
        this.visitCount++;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof VideoClip){
            VideoClip c = (VideoClip)o;
            return this.ID == c.ID;
        }
        return false;
    }

    @Override
    public int compareTo(VideoClip o) {
        if(this.visitCount != o.visitCount)
            return this.visitCount - o.visitCount;
        //Solve tie
        else if(this.size > o.size)
            return 1;
        else if(this.size < o.size)
            return -1;
        else
            return 0;
    }


}
