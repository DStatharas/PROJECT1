package com.JavaNerds.app;

public class VMNetworkedGPU extends VMGPU{
    private Integer bandwidth;

    public VMNetworkedGPU (Integer vmid, Integer cpu, Integer ram, int os, Integer gpu, Integer bandwidth){
        super(vmid, cpu, ram, os, gpu);
        this.bandwidth = bandwidth;
    }

    public Integer getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(Integer bandwidth) {
        this.bandwidth = bandwidth;
    }

}
