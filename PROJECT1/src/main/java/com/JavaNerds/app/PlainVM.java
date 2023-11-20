package com.JavaNerds.app;

public class PlainVM extends VM{
    protected String runningOs;
    protected Integer ssd;
    
    public PlainVM (Integer vmid, Integer cpu, Integer ram, int os){
        this.vmid = vmid;
        this.cpu = cpu;
        this.ram = ram;
        this.runningOs = this.os[os];
    }

    public String getRunningOs() {
        return runningOs;
    }

    public void setRunningOs(String runningOs) {
        this.runningOs = runningOs;
    }

    public Integer getSsd() {
        return ssd;
    }

    public void setSsd(Integer ssd) {
        this.ssd = ssd;
    }

    
}
