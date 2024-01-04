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
