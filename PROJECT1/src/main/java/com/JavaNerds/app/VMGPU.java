package com.JavaNerds.app;

public class VmGPU extends PlainVM{
    protected Integer vmgpu;

    public VmGPU (Integer vmOs, Integer vmcpu, Integer vmram, Integer vmssd, Integer vmgpu) {
        super(vmOs, vmcpu, vmram, vmssd);
        this.vmgpu = vmgpu;
    }
    
    public Integer getVmgpu() {
        return vmgpu;
    }

    public void setVmgpu(Integer vmgpu) {
        this.vmgpu = vmgpu;
    }

}
