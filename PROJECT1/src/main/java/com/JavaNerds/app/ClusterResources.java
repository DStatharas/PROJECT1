package com.JavaNerds.app;

import java.util.ArrayList;

public class ClusterResources {

    private static ClusterResources singleInstance = null;

    public static ArrayList<VM> vmArray = new ArrayList<>();

    private Integer clcpu = 128;
    private Integer clram = 256;
    private Integer clssd = 2048;
    private Integer clgpu = 8;
    private Integer clbandwidth = 320;

    private ClusterResources () {
        System.out.println("Cluster created!");
    }

    public static synchronized ClusterResources getInstance() {
        if (singleInstance == null) {
            singleInstance = new ClusterResources();
        }
        
        return singleInstance;
    }

    //Getters/Setters
    public static Integer getVmArrayLength() {
        return vmArray.size();
    }

    public Integer getClcpu() {
        return clcpu;
    }

    public void setClcpu(Integer clcpu) {
        this.clcpu = clcpu;
    }

    public Integer getClram() {
        return clram;
    }

    public void setClram(Integer clram) {
        this.clram = clram;
    }

    public Integer getClssd() {
        return clssd;
    }

    public void setClssd(Integer clssd) {
        this.clssd = clssd;
    }

    public Integer getClgpu() {
        return clgpu;
    }

    public void setClgpu(Integer clgpu) {
        this.clgpu = clgpu;
    }

    public Integer getClbandwidth() {
        return clbandwidth;
    }

    public void setClbandwidth(Integer clbandwidth) {
        this.clbandwidth = clbandwidth;
    }

}
