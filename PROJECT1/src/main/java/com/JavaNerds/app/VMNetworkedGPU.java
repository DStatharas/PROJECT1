package com.JavaNerds.app;

public class VmNetworkedGPU extends VmGPU{
    private Integer vmbandwidth;

    public VmNetworkedGPU(Integer vmType, Integer vmOs, Integer vmcpu, Integer vmram, Integer vmssd, Integer vmgpu, Integer vmbandwidth) {
        super(vmType, vmOs, vmcpu, vmram, vmssd, vmgpu);
        this.vmbandwidth = vmbandwidth;
    }

    @Override
    public void printVmReport() {
        super.printVmReport();
        System.out.println("Bandwidth: "+this.vmbandwidth+" Gb/sec");
    }
    
    public Integer getVmbandwidth() {
        return vmbandwidth;
    }

    public void setVmbandwidth(Integer vmbandwidth) {
        this.vmbandwidth = vmbandwidth;
    }

}
