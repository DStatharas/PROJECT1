package com.JavaNerds.app;

public class ClusterResources {
    //constant?
    private static Integer cpu = 128;
    private static Integer ram = 256;
    private static Integer ssd = 2048;
    private static Integer gpu = 8;
    private static Integer bandwidth = 320;

    public static Integer getCpu() {
        return cpu;
    }
    public static void setCpu(Integer cpu) {
        ClusterResources.cpu = cpu;
    }
    public static Integer getRam() {
        return ram;
    }
    public static void setRam(Integer ram) {
        ClusterResources.ram = ram;
    }
    public static Integer getSsd() {
        return ssd;
    }
    public static void setSsd(Integer ssd) {
        ClusterResources.ssd = ssd;
    }
    public static Integer getGpu() {
        return gpu;
    }
    public static void setGpu(Integer gpu) {
        ClusterResources.gpu = gpu;
    }
    public static Integer getBandwidth() {
        return bandwidth;
    }
    public static void setBandwidth(Integer bandwidth) {
        ClusterResources.bandwidth = bandwidth;
    }

}
