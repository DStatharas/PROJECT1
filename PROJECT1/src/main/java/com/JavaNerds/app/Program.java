package com.JavaNerds.app;

import java.util.Random;

public class Program {

    Random rand = new Random();
    
    private Integer pId = rand.nextInt(1, 999);
    private Integer pCpu = 0;
    private Integer pRam = 0;
    private Integer pSsd = 0;
    private Integer pGpu = 0;
    private Integer pBandwidth = 0;
    private Integer expectedTime = null;
    private long startExecTime = 0;
    private long executionTime = 0;
    private Double priority = 0.0;

    public Program(Integer pCpu, Integer pRam, Integer pSsd, Integer pGpu, Integer pBandwidth, Integer expectedTime) {
           this.pCpu = pCpu;
           this.pRam = pRam;
           this.pSsd = pSsd;
           this.pGpu = pGpu;
           this.pBandwidth = pBandwidth;
           this.expectedTime = expectedTime;
    }

    public void startExecutionTimer() {
        startExecTime = System.currentTimeMillis();
    }

    public void printProgramReport() {
        System.out.print("----- ~<Program "+this.pId+">~ -----"+"\n");
        System.out.print("CPU Cores: "+this.pCpu+"\n");
        System.out.print("RAM: "+this.pRam+" GB"+"\n");
        System.out.print("SSD: "+this.pSsd+" GB"+"\n"); 
        if (this.pGpu > 0) {
            System.out.print("GPUs: "+this.pGpu+"\n");
        }
        if (this.pBandwidth > 0) {
            System.out.println("Bandwidth: "+this.pBandwidth+" Gb/sec"+"\n");
        }
        System.out.println("Expected Execution Time: "+this.expectedTime+"sec\n");
        System.out.println("--------------");
    }

    //Getters/Setters
    public Integer getpCpu() {
        return pCpu;
    }

    public void setpCpu(Integer pCpu) {
        this.pCpu = pCpu;
    }

    public Integer getpRam() {
        return pRam;
    }

    public void setpRam(Integer pRam) {
        this.pRam = pRam;
    }

    public Integer getpSsd() {
        return pSsd;
    }

    public void setpSsd(Integer pSsd) {
        this.pSsd = pSsd;
    }

    public Integer getpGpu() {
        return pGpu;
    }

    public void setpGpu(Integer pGpu) {
        this.pGpu = pGpu;
    }

    public Integer getpBandwidth() {
        return pBandwidth;
    }

    public void setpBandwidth(Integer pBandwidth) {
        this.pBandwidth = pBandwidth;
    }

    public Integer getExpectedTime() {
        return expectedTime;
    }

    public void setExpectedTime(Integer expectedTime) {
        this.expectedTime = expectedTime;
    }

    public long getStartExecTime() {
        return startExecTime;
    }

    public void setStartExecTime(Integer startExecTime) {
        this.startExecTime = startExecTime;
    }

    public long getExecutionTime() {
        executionTime = System.currentTimeMillis() - startExecTime;
        return executionTime;
    }

    public long getExecutionTimeInSeconds() {
        executionTime = (System.currentTimeMillis() - startExecTime)/1000;
        return executionTime;
    }

    public void setExecutionTime(long executionTime) {
        this.executionTime = executionTime;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Double getPriority() {
        return priority;
    }

    public void setPriority(Double priority) {
        this.priority = priority;
    }

}
