package com.JavaNerds.app;

public class PlainVM extends VM{
    protected Integer vmssd;

    public PlainVM(Integer vmOs, Integer vmcpu, Integer vmram, Integer vmssd) {
        super(vmOs, vmcpu, vmram);
        this.vmssd = vmssd;
    }

    @Override
    public void printVmReport() {
        super.printVmReport();
        System.out.println("VM SSD: "+this.vmssd+" GB");
    }

    public Integer getVmssd() {
        return vmssd;
    }

    public void setVmssd(Integer vmssd) {
        this.vmssd = vmssd;
    }
    
}
