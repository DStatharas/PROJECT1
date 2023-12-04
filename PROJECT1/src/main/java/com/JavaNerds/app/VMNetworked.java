package com.JavaNerds.app;

public class VmNetworked extends PlainVM{
    private Integer vmbandwidth;

    public VmNetworked(Integer vmOs, Integer vmcpu, Integer vmram, Integer vmssd, Integer vmbandwidth) {
        super(vmOs, vmcpu, vmram, vmssd);
        this.vmbandwidth = vmbandwidth;
    }

    public Integer getVmbandwidth() {
        return vmbandwidth;
    }

    public void setVmbandwidth(Integer vmbandwidth) {
        this.vmbandwidth = vmbandwidth;
    }

}
