package com.JavaNerds.app;

public class VmNetworked extends PlainVM{
    private Integer vmbandwidth;
    protected Integer allocvmbandwidth = 0;

    public VmNetworked(Integer vmType, Integer vmOs, Integer vmcpu, Integer vmram, Integer vmssd, Integer vmbandwidth) {
        super(vmType, vmOs, vmcpu, vmram, vmssd);
        this.vmbandwidth = vmbandwidth;
    }

    @Override
    protected void vmReportArrayAdder() {
        super.vmReportArrayAdder();
        vmReportAvailableArray.add("Bandwidth: "+this.vmbandwidth+" Gb/sec"+"\n");
        vmReportAllocatedArray.add("Bandwidth: "+this.allocvmbandwidth+" Gb/sec"+"\n");
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
        double bandDiv;

        a = ((double)this.vmcpu);
        b = ((double)this.allocvmcpu);
        if (a != 0) {
            cpuDiv = b/a;
        }else{
            cpuDiv = 0;
        }

        a = ((double)this.vmram);
        b = ((double)this.allocvmram);
        if (a != 0) {
            ramDiv = b/a;
        }else{
            ramDiv = 0;
        }

        a = ((double)this.vmssd);
        b = ((double)this.allocvmssd);
        if (a != 0) {
            ssdDiv = b/a;
        }else{
            ssdDiv = 0;
        }

        a = ((double)this.vmbandwidth);
        b = ((double)this.allocvmbandwidth);
        if (a != 0) {
            bandDiv = b/a;
        }else{
            bandDiv = 0;
        }

        this.vmLoad = (cpuDiv+ramDiv+ssdDiv+bandDiv)/4;
    }

    //Getters/Setters
    public Integer getVmbandwidth() {
        return vmbandwidth;
    }

    public void setVmbandwidth(Integer vmbandwidth) {
        this.vmbandwidth = vmbandwidth;
    }

    public Integer getAllocvmbandwidth() {
        return allocvmbandwidth;
    }

    public void setAllocvmbandwidth(Integer allocvmbandwidth) {
        this.allocvmbandwidth = allocvmbandwidth;
    }

}
