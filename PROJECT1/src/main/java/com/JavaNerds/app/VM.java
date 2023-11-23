package com.JavaNerds.app;

abstract class VM{
    //a sequential vmid

    protected String os;
    protected Integer vmid;
    protected Integer cpu;
    protected Integer ram;

    public String getOs() {
        return os;
    }
    public void setOs(String os) {
        this.os = os;
    }
    public Integer getVmid() {
        return vmid;
    }
    public void setVmid(Integer vmid) {
        this.vmid = vmid;
    }
    public Integer getCpu() {
        return cpu;
    }
    public void setCpu(Integer cpu) {
        this.cpu = cpu;
    }
    public Integer getRam() {
        return ram;
    }
    public void setRam(Integer ram) {
        this.ram = ram;
    }
    
    
}