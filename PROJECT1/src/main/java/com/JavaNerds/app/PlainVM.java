package com.JavaNerds.app;

public class PlainVM extends VM{
    protected Integer vmssd;
    protected Integer allocvmssd = 0;
    

    public PlainVM(Integer vmType, Integer vmOs, Integer vmcpu, Integer vmram, Integer vmssd) {
        super(vmType, vmOs, vmcpu, vmram);
        this.vmssd = vmssd;
    }

    @Override
    protected void vmReportArrayAdder() {
        super.vmReportArrayAdder();
        vmReportAvailableArray.add("SSD: "+this.vmssd+" GB"+"\n");
        vmReportAllocatedArray.add("SSD: "+this.allocvmssd+" GB"+"\n");
    }

    @Override
    public void printVmReport() {
        super.printVmReport();
    }

    @Override
    public void calculateVmLoad() {
        double a;
        double b;
        double cpuDiv;
        double ramDiv;
        double ssdDiv;

        a = this.vmcpu;
        b = this.allocvmcpu;
        cpuDiv = b/a;
        
        a = this.vmram;
        b = this.allocvmram;
        ramDiv = b/a;

        a = this.vmssd;
        b = this.allocvmssd;
        ssdDiv = b/a;

        this.vmLoad = (cpuDiv+ramDiv+ssdDiv)/3;
    }

    //Getters/Setters
    public Integer getVmssd() {
        return vmssd;
    }

    public void setVmssd(Integer vmssd) {
        this.vmssd = vmssd;
    }

    public Integer getAllocvmssd() {
        return allocvmssd;
    }

    public void setAllocvmssd(Integer allocvmssd) {
        this.allocvmssd = allocvmssd;
    }
    
}
