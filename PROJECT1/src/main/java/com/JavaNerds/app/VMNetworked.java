package com.JavaNerds.app;

public class VMNetworked extends PlainVM{
    private Integer bandwidth;

    public VMNetworked (Integer vmid, Integer cpu, Integer ram, int os, Integer bandwidth){
        super(vmid, cpu, ram, os);
        this.bandwidth = bandwidth;
    }

    public Integer getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(Integer bandwidth) {
        this.bandwidth = bandwidth;
    }

}
