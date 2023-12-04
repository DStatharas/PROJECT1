package com.JavaNerds.app;

abstract class VM{

    static Integer vmIdGen = 1;
    protected Integer vmid;
    protected Integer vmcpu;
    protected Integer vmram;
    protected String vmOs;
    protected String[] vmOsOptions = {"WINDOWS", "UBUNTU", "FEDORA"};

    public VM(Integer vmOs, Integer vmcpu, Integer vmram) {
        this.vmid = vmIdGen;
        VM.vmIdGen+=1;
        this.vmOs = vmOsOptions[vmOs];
        this.vmcpu = vmcpu;
        this.vmram = vmram;
    }

    public Integer getVmid() {
        return vmid;
    }
    public void setVmid(Integer vmid) {
        this.vmid = vmid;
    }
    public Integer getVmcpu() {
        return vmcpu;
    }
    public void setVmcpu(Integer vmcpu) {
        this.vmcpu = vmcpu;
    }
    public Integer getVmram() {
        return vmram;
    }
    public void setVmram(Integer vmram) {
        this.vmram = vmram;
    }

}