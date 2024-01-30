package com.JavaNerds.app;

public class VmGPU extends PlainVM{
    protected Integer vmgpu;
    protected Integer allocvmgpu = 0;

    public VmGPU (Integer vmType, Integer vmOs, Integer vmcpu, Integer vmram, Integer vmssd, Integer vmgpu) {
        super(vmType, vmOs, vmcpu, vmram, vmssd);
        this.vmgpu = vmgpu;
    }
    
    @Override
    protected void vmReportArrayAdder() {
        super.vmReportArrayAdder();
        vmReportAvailableArray.add("GPUs: "+this.vmgpu+"\n");
        vmReportAllocatedArray.add("GPUs: "+this.allocvmcpu+"\n");
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
        double gpuDiv;

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

        a = ((double)this.vmgpu);
        b = ((double)this.allocvmgpu);
        if (a != 0) {
            gpuDiv = b/a;
        }else{
            gpuDiv = 0;
        }

        this.vmLoad = (cpuDiv+ramDiv+ssdDiv+gpuDiv)/4;
    }

    //Getters/Setters
    public Integer getVmgpu() {
        return vmgpu;
    }

    public void setVmgpu(Integer vmgpu) {
        this.vmgpu = vmgpu;
    }

    public Integer getAllocvmgpu() {
        return allocvmgpu;
    }

    public void setAllocvmgpu(Integer allocvmgpu) {
        this.allocvmgpu = allocvmgpu;
    }
    
}
