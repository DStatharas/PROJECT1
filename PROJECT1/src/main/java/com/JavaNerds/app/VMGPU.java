package com.JavaNerds.app;

public class VMGPU extends PlainVM{
    protected Integer gpu;

    public VMGPU (Integer cpu, Integer ram, int os, Integer gpu){
        super(cpu, ram, os);
        this.gpu = gpu;
    }

    public Integer getGpu() {
        return gpu;
    }

    public void setGpu(Integer gpu) {
        this.gpu = gpu;
    }
    
    
}
