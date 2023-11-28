package com.JavaNerds.app;

import java.util.ArrayList;

public class ClusterResources {

    public static ArrayList<VM> vmArray = new ArrayList<>();

    private static Integer clcpu;
    private static Integer clram;
    private static Integer clssd;
    private static Integer clgpu;
    private static Integer clbandwidth;

    public ClusterResources (Integer clcpu, Integer clram, Integer clssd, Integer clgpu, Integer clbandwidth){
        ClusterResources.clcpu = clcpu;
        ClusterResources.clssd = clssd;
        ClusterResources.clgpu = clgpu;
        ClusterResources.clbandwidth = clbandwidth;
    }

    public static Integer getVmArrayLength() {
        return vmArray.size();
    }

    public static Integer getClcpu() {
        return clcpu;
    }
    public static void setClcpu(Integer clcpu) {
        ClusterResources.clcpu = clcpu;
    }
    public static Integer getClram() {
        return clram;
    }
    public static void setClram(Integer clram) {
        ClusterResources.clram = clram;
    }
    public static Integer getClssd() {
        return clssd;
    }
    public static void setClssd(Integer clssd) {
        ClusterResources.clssd = clssd;
    }
    public static Integer getClgpu() {
        return clgpu;
    }
    public static void setClgpu(Integer clgpu) {
        ClusterResources.clgpu = clgpu;
    }
    public static Integer getClbandwidth() {
        return clbandwidth;
    }
    public static void setClbandwidth(Integer clbandwidth) {
        ClusterResources.clbandwidth = clbandwidth;
    }

}
