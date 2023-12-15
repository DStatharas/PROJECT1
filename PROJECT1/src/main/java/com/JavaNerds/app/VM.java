package com.JavaNerds.app;

abstract class VM{

    static Integer vmIdGen = 1;
    protected Integer vmid;
    protected String vmType;
    
    protected String[] vmTypeArray = {"VM", "PlainVM", "VmGPU", "VmNetworked", "VmNetworkedGPU"};
    protected Integer vmcpu;
    protected Integer vmram;
    protected String vmOs;
    protected String[] vmOsOptions = {"WINDOWS", "UBUNTU", "FEDORA"};
    

    public VM(Integer vmType, Integer vmOs, Integer vmcpu, Integer vmram) {
        this.vmid = vmIdGen;
        VM.vmIdGen+=1;
        this.vmType = vmTypeArray[vmType];
        this.vmOs = vmOsOptions[vmOs];
        this.vmcpu = vmcpu;
        this.vmram = vmram;
    }

    public void printVmReport() {
        System.out.println("VM"+this.vmid+"Report:"+"\n"+
        "VM Type: "+this.vmType+"\n"+
        "OS: "+this.vmOs+"\n"+
        "CPU Cores: "+this.vmcpu+"\n"+
        "RAM: "+this.vmram+" GB");
    }


    public String getVmType() {
        return vmType;
    }

    public void setVmType(Integer vmType) {
        this.vmType = vmTypeArray[vmType];
    }
    public Integer getVmid() {
        return vmid;
    }
    public void setVmid(Integer vmid) {
        this.vmid = vmid;
    }
    public Integer getVmcpu() {
        return vmcpu;
    }
    public void setVmcpu(Integer vmcpu) {
        this.vmcpu = vmcpu;
    }
    public Integer getVmram() {
        return vmram;
    }
    public void setVmram(Integer vmram) {
        this.vmram = vmram;
    }
    public void setVmOs(Integer vmOs) {
        this.vmOs = vmOsOptions[vmOs];
    }

}