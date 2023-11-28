package com.JavaNerds.app;

abstract class VM{

    protected String vmos;
    protected Integer vmid;
    protected Integer vmcpu;
    protected Integer vmram;

    public VM(Integer vmid, Integer vmcpu, Integer vmram) {
        this.vmid = vmid;
        this.vmcpu = vmcpu;
        this.vmram = vmram;
    }

    public String getVmos() {
        return vmos;
    }
    public void setVmos(String vmos) {
        this.vmos = vmos;
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