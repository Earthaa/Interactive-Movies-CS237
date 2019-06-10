package com.utils;
import java.util.*;


public class ServerBuffer {
    private static ServerBuffer sbInstance = null;
    //HashSet<String> IDSet;
    private HashMap<String, VideoClip> idMap;
    private PriorityQueue<VideoClip> clipsPQ;
    private int size;
    private int maxCapacity;

    private static final int defaultCapacity = 5;
    private ServerBuffer(int capacity){
        this.maxCapacity = capacity;
        idMap = new HashMap<>();
        clipsPQ = new PriorityQueue<>();
        size = 0;
    }

    public static ServerBuffer getBuffer(){
        if(sbInstance == null)
           sbInstance = new ServerBuffer(defaultCapacity);
        return sbInstance;
    }

    public static ServerBuffer getBuffer(int capacity){
        if(sbInstance == null)
            sbInstance = new ServerBuffer(capacity);
        else
            System.out.println("Buffer has already existed, the size of which is " + Integer.toString(sbInstance.maxCapacity));
        return sbInstance;
    }
    public boolean hasClip(String ID){
        return idMap.containsKey(ID);
    }
    public VideoClip getClip(String ID){
       return idMap.get(ID);
    }

    public void addClip(String ID, VideoClip clip){
        if(idMap.containsKey(ID)){
            System.out.println("This clip has already in the buffer");
            return;
        }
        if(size < maxCapacity){
            idMap.put(ID,clip);
            clipsPQ.add(clip);
            size++;
        }
        else if(clip.compareTo(clipsPQ.peek()) >= 0){
            VideoClip removedOne = clipsPQ.poll();
            idMap.remove(removedOne.getID());
            idMap.put(ID,clip);
            clipsPQ.add(clip);
            System.out.println("Clip: " + removedOne.getID() +" has been removed from the buffer!");
        }

        else{
            System.out.println("Such clip can't be added in into the buffer, for it doesn't have a higher priority");
        }

    }

}
