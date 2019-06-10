package com.utils;
import java.io.*;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import com.constants.Constants;
public class test {
    public static void main(String[] args) throws Exception{
        try{
            String path = Constants.HDFSAddress + "/video";
            FileSystem fs = FileSystem.get(URI.create(path),new Configuration());
            System.out.println(path);
            FileStatus[] status = fs.listStatus(new Path(path));  // you need to pass in your hdfs path
            System.out.println(status.length);
            for(int i = 0; i < status.length; i++){
                String[] tmp = status[i].getPath().toString().split("[/]");
                String[] tmp2 = tmp[tmp.length - 1].split("[.]");


                System.out.println(tmp2[0]);
            }
        }catch(Exception e){
            System.out.println("File not found");
        }
    }
}

