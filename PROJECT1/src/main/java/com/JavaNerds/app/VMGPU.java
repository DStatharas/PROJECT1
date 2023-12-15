package com.JavaNerds.app;

public class VmGPU extends PlainVM{
    protected Integer vmgpu;

    public VmGPU (Integer vmType, Integer vmOs, Integer vmcpu, Integer vmram, Integer vmssd, Integer vmgpu) {
        super(vmType, vmOs, vmcpu, vmram, vmssd);
        this.vmgpu = vmgpu;
    }
    
    @Override
    public void printVmReport() {
        super.printVmReport();
        System.out.println("VM GPUs: "+this.vmgpu+" GB");
    }

    public Integer getVmgpu() {
        return vmgpu;
    }

    public void setVmgpu(Integer vmgpu) {
        this.vmgpu = vmgpu;
    }

}
