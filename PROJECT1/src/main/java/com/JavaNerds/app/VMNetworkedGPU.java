package com.JavaNerds.app;

public class VmNetworkedGPU extends VmGPU{
    private Integer vmbandwidth;

    public VmNetworkedGPU(Integer vmOs, Integer vmcpu, Integer vmram, Integer vmssd, Integer vmgpu, Integer vmbandwidth) {
        super(vmOs, vmcpu, vmram, vmssd, vmgpu);
        this.vmbandwidth = vmbandwidth;
    }

    public Integer getVmbandwidth() {
        return vmbandwidth;
    }

    public void setVmbandwidth(Integer vmbandwidth) {
        this.vmbandwidth = vmbandwidth;
    }

}
