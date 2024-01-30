package com.JavaNerds.app;

import java.io.Serializable;

public class Program implements Serializable{
    
    private Integer pId;
    private Integer pCpu          = 0;
    private Integer pRam          = 0;
    private Integer pSsd          = 0;
    private Integer pGpu          = 0;
    private Integer pBandwidth    = 0;
    private Integer expectedTime  = null;
    private long    startExecTime = 0;
    private long    executionTime = 0;
    private Double  priority      = 0.0;
    private Integer runCounter    = 0;
    private Integer assignedVm    = 0;
    private Boolean failingCheck  = false;

    public Program(Integer pCpu, Integer pRam, Integer pSsd, Integer pGpu, Integer pBandwidth, Integer expectedTime, Integer pId, Double priority) {
           this.pCpu = pCpu;
           this.pRam = pRam;
           this.pSsd = pSsd;
           this.pGpu = pGpu;
           this.pBandwidth = pBandwidth;
           this.expectedTime = expectedTime;
           this.pId = pId;
           this.priority = priority;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((pId == null) ? 0 : pId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Program other = (Program) obj;
        if (pId == null) {
            if (other.pId != null)
                return false;
        } else if (!pId.equals(other.pId))
            return false;
        return true;
    }

    

    public void startExecutionTimer() {
        startExecTime = System.currentTimeMillis();
    }

    public void printProgramReport() {
        ConsoleColors.setColor(ConsoleColors.GREEN);
        System.out.print("------ ~<Program #"+this.pId+">~ -----");
        System.out.print("\nCPU Cores: "+this.pCpu);
        System.out.print("\nRAM: "+this.pRam+" GB");
        System.out.print("\nSSD: "+this.pSsd+" GB");
        if (this.pGpu > 0) {
            System.out.print("\nGPUs: "+this.pGpu);
        }
        if (this.pBandwidth > 0) {
            System.out.println("\nBandwidth: "+this.pBandwidth+" Gb/sec");
        }
        System.out.println("\nExpected Execution Time: "+this.expectedTime+"sec");
        System.out.println("------------------------------");
        ConsoleColors.reset();
    }

    public void printProgramRunningReport(){
        ConsoleColors.setColor(ConsoleColors.GREEN);
        System.out.println("\n        |");
        System.out.print("----- ~<Program "+this.pId+">~ -----"+"\n");
        System.out.println("Uptime: "+getExecutionTimeInSeconds()+"sec");
        System.out.println("Expected Execution Time: "+this.expectedTime+"sec");
        System.out.print("---------------------------");
        ConsoleColors.reset();;
    }

    //Getters/Setters

    public Boolean getFailingCheck() {
        return failingCheck;
    }

    public void setFailingCheck(Boolean failingCheck) {
        this.failingCheck = failingCheck;
    }

    public Integer getAssignedVm() {
        return assignedVm;
    }

    public void setAssignedVm(Integer assignedVm) {
        this.assignedVm = assignedVm;
    }

    public Integer getRunCounter() {
        return runCounter;
    }

    public void setRunCounter(Integer runCounter) {
        this.runCounter = runCounter;
    }

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
