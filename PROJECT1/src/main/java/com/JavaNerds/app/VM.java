package com.JavaNerds.app;

import java.util.ArrayList;

abstract class VM{

    static Integer vmIdGen = 1;
    protected Integer vmid;
    protected String vmType;
    
    protected String[] vmTypeArray = {"VM", "PlainVM", "VmGPU", "VmNetworked", "VmNetworkedGPU"};
    protected Integer vmcpu;
    protected Integer vmram;
    protected String vmOs;

    protected String[] vmOsOptions = {"WINDOWS", "UBUNTU", "FEDORA"};

    protected Integer allocvmcpu = 0;
    protected Integer allocvmram = 0;

    protected ArrayList<String> vmReportAvailableArray = new ArrayList<>();
    protected ArrayList<String> vmReportAllocatedArray = new ArrayList<>();

    protected double vmLoad = 0.00;

    protected ArrayList<Program> programAssignArray = new ArrayList<Program>();

    public VM(Integer vmType, Integer vmOs, Integer vmcpu, Integer vmram) {
        this.vmid = vmIdGen;
        VM.vmIdGen+=1;
        this.vmType = vmTypeArray[vmType];
        this.vmOs = vmOsOptions[vmOs];
        this.vmcpu = vmcpu;
        this.vmram = vmram;
    }

    protected void vmReportArrayAdder() {
        vmReportAvailableArray.clear();
        vmReportAllocatedArray.clear();
        vmReportAvailableArray.add("CPU Cores: "+this.vmcpu+"\n");
        vmReportAvailableArray.add("RAM: "+this.vmram+" GB"+"\n");

        vmReportAllocatedArray.add("CPU Cores: "+this.allocvmcpu+"\n");
        vmReportAllocatedArray.add("RAM: "+this.allocvmram+" GB"+"\n");
    }

    public void printVmReport() {
        vmReportArrayAdder();
        ConsoleColors.setColor(ConsoleColors.CYAN);
        System.out.print("----- ~/VM"+this.vmid+"\\~ -----"+"\n");
        System.out.print("VM Type: "+this.vmType+"\n");
        System.out.print("VM OS: "+this.vmOs+"\n");
        System.out.print("--- |Available| ---"+"\n");
        for (String e : vmReportAvailableArray) {
            System.out.print(e);
        }
        System.out.print("--- |Allocated| ---"+"\n");
        for (String e : vmReportAllocatedArray) {
            System.out.print(e);
        }
        printLoad();
        System.out.print("-------------------");
        ConsoleColors.reset();
    }

    public void calculateVmLoad() {
        double a;
        double b;
        double cpuDiv;
        double ramDiv;

        a = ((double)this.vmcpu);
        b = ((double)this.allocvmcpu);
        if (a != 0) {
            cpuDiv = b/a;
        }else{
            cpuDiv = 0;
        }
        

        a = ((double)this.vmram);
        b = ((double)this.allocvmram);
        if (a != 0) {
            ramDiv = b/a;
        }else{
            ramDiv = 0;
        }

        this.vmLoad = (cpuDiv+ramDiv)/2;
    }

    public void printLoad() {
        System.out.print("VM load: ");
        System.out.format("%.0f%%",100 * this.vmLoad);
        System.out.print("\n");
    }

    //Getters/Setters
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

    public String getVmOs() {
        return vmOs;
    }

    public void setVmOs(String vmOs) {
        this.vmOs = vmOs;
    }

    public Integer getAllocvmcpu() {
        return allocvmcpu;
    }

    public void setAllocvmcpu(Integer allocvmcpu) {
        this.allocvmcpu = allocvmcpu;
    }

    public Integer getAllocvmram() {
        return allocvmram;
    }

    public void setAllocvmram(Integer allocvmram) {
        this.allocvmram = allocvmram;
    }

    public Double getVmLoad() {
        return vmLoad;
    }

    public void setVmLoad(Double vmLoad) {
        this.vmLoad = vmLoad;
    }
}