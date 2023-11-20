package com.JavaNerds.app;

abstract class VM implements iVMMethods{
    //a sequential vmid

    protected Integer vmid;
    protected Integer cpu;
    protected Integer ram;
    protected String[] os = {"WINDOWS", "UBUNTU", "FEDORA"};

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
