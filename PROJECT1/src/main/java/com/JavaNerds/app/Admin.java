package com.JavaNerds.app;

import java.rmi.dgc.VMID;
import java.util.Scanner;

public class Admin{
    
    ClusterResources adminCluster = ClusterResources.getInstance();

    Scanner oneScanner = new Scanner(System.in);

    private String inputChecker = null;
    private Integer userCpu = null;
    private Integer userRam = null;
    private Integer userSsd = null;
    private Integer userGpu = null;
    private Integer userBandwidth = null;
    private Integer userOs = null;
    private Integer tempVmId = null;
    
    public void createVM() {
        Integer userVmType = null;

        while (true) {
            inputChecker = null;
            userVmType = null;
            userCpu = null;
            userRam = null;
            userSsd = null;
            userGpu = null;
            userBandwidth = null;
            userOs = null;

            System.out.println("Please select one of the following numbers to choose the type of Virtual Machine you would like to create, or type Q to cancel VM creation."+"\n"+"1: Plain VM"+"\n"+"2: GPU VM"+"3: Networked VM"+"\n"+"4: Networked GPU VM"+"\n"+"Q: Cancel"+"\n");
            inputChecker = oneScanner.next();
            oneScanner.nextLine();
            if (inputChecker.equalsIgnoreCase("q")) {
                break;
            } else {
                try {
                    userVmType = Integer.parseInt(inputChecker);
                } catch (Exception e) {
                    System.out.println("ERROR: Invalid input!");
                    continue;
                }
            }

            switch (userVmType) {
                case 1:
                    //PlainVM
                    setUserOCRS();
                    
                    adminCluster.setClcpu(adminCluster.getClcpu()-userCpu);
                    adminCluster.setClram(adminCluster.getClram()-userRam);
                    adminCluster.setClssd(adminCluster.getClssd()-userSsd);

                    ClusterResources.vmArray.add(new PlainVM(1, userOs, userCpu, userRam, userSsd));

                    System.out.println("PlainVM created!");
                    break;

                    
                case 2:
                    //VmGPU
                    setUserOCRS();
                    setUserGpu();

                    adminCluster.setClcpu(adminCluster.getClcpu()-userCpu);
                    adminCluster.setClram(adminCluster.getClram()-userRam);
                    adminCluster.setClssd(adminCluster.getClssd()-userSsd);
                    adminCluster.setClgpu(adminCluster.getClssd()-userGpu);

                    ClusterResources.vmArray.add(new VmGPU(2, userOs, userCpu, userRam, userSsd, userGpu));
                    break;

                case 3:
                    //VmNetworked
                    setUserOCRS();
                    setUserBandwidth();

                    adminCluster.setClcpu(adminCluster.getClcpu()-userCpu);
                    adminCluster.setClram(adminCluster.getClram()-userRam);
                    adminCluster.setClssd(adminCluster.getClssd()-userSsd);
                    adminCluster.setClbandwidth(adminCluster.getClbandwidth()-userBandwidth);

                    ClusterResources.vmArray.add(new VmNetworked(3, userOs, userCpu, userRam, userSsd, userBandwidth));
                    break;

                case 4:
                    //VmNetworkedGPU
                    setUserOCRS();
                    setUserGpu();
                    setUserBandwidth();

                    adminCluster.setClcpu(adminCluster.getClcpu()-userCpu);
                    adminCluster.setClram(adminCluster.getClram()-userRam);
                    adminCluster.setClssd(adminCluster.getClssd()-userSsd);
                    adminCluster.setClgpu(adminCluster.getClssd()-userGpu);
                    adminCluster.setClbandwidth(adminCluster.getClbandwidth()-userBandwidth);

                    ClusterResources.vmArray.add(new VmNetworkedGPU(4, userOs, userCpu, userRam, userSsd, userGpu, userBandwidth));
                    break;

                default:
                    //Invalid VM Type
                    System.out.println("Please choose a valid type of Virtual Machine!");
                    continue;
            }
        }
    }
    
    private void updateResources() {
        Integer resourceToUpdate = null;

        while (true) {
                
            inputChecker = null;
            tempVmId = null;
            resourceToUpdate = null;
            
            // ClusterResources.vmArray.get(vmId-1).setVmcpu;

            // if (ClusterResources.vmArray.get(vmId-1) instanceof VmGPU) {
            //     VmGPU vmGpuInstance = (VmGPU) ClusterResources.vmArray.get(vmId-1);
            //     vmGpuInstance.getVmgpu();
            // }

            //     VM instance = ClusterResources.vmArray.get(5);
            //     instance = (VmGPU) instance;
                
            //choosevmId
            while (true) {
                inputChecker = null;
                tempVmId = null;

                System.out.println("Enter the ID of the VM you'd like to update or Q to cancel:");
                inputChecker = oneScanner.next();
                oneScanner.nextLine();

                if (inputChecker.equalsIgnoreCase("q")) {
                    break;
                }
                else {
                    try {
                        tempVmId = Integer.parseInt(inputChecker);
                    } catch (Exception e) {
                        System.out.println("ERROR: Invalid input!");
                        continue;
                    }
                }
                if (tempVmId >= ClusterResources.vmArray.size() || tempVmId < 0) {
                    System.out.println("This VM ID does not exist!");
                    continue;
                }
                else {
                    System.out.println("Selected VM"+ClusterResources.vmArray.get(tempVmId-1).getVmid()+"!");
                }

                break;
            }

            //chooseresource
            
            while (true) {
                resourceToUpdate = null;

                System.out.println("Choose a resource to update:"+"\n"+"1: OS"+"\n"+"2: CPU"+"\n"+"3: RAM"+"\n"+"4: SSD"+"\n"+"5: GPU"+"\n"+"6: Bandwidth"+"\n"+"Q: Cancel");
                inputChecker = oneScanner.next();
                oneScanner.nextLine();
                if (inputChecker.equalsIgnoreCase("q")) {
                    break;
                }
                else {
                    try {
                        resourceToUpdate = Integer.parseInt(inputChecker);
                    } catch (Exception e) {
                        System.out.println("ERROR: Invalid input!");
                        continue;
                    }
                }

                switch (resourceToUpdate) {
                    case 1:
                        //OS
                        while (true) {
                            inputChecker = null;
                            userOs = null;
                            
                            System.out.println("Choose an OS to assign:"+"\n"+"1: Windows"+"\n"+"2: Ubuntu"+"\n"+"3: Fedora"+"\n"+"Q: Cancel");
                            inputChecker = oneScanner.next();
                            oneScanner.nextLine();
                            if (inputChecker.equalsIgnoreCase("q")) {
                                break;
                            }
                            else {
                                try {
                                    userOs = Integer.parseInt(inputChecker);
                                    userOs -= 1;
                                } catch (Exception e) {
                                    System.out.println("ERROR: Invalid input!");
                                    continue;
                                }
                            }
                            if (userOs != 0 || userOs != 1 || userOs != 2) {
                                System.out.println("Please select a valid OS!");
                                continue;
                            }
                            
                            ClusterResources.vmArray.get(tempVmId-1).setVmOs(userOs);

                            break;
                        }
                    
                    case 2:
                        //CPU
                        while (true) {
                            inputChecker = null;
                            userCpu = null;

                            System.out.println("Enter number of CPU cores to assign or Q to cancel:");
                            inputChecker = oneScanner.next();
                            oneScanner.nextLine();

                            if (inputChecker.equalsIgnoreCase("q")) {
                                break;
                            }
                            else {
                                try {
                                    userCpu = Integer.parseInt(inputChecker);
                                } catch (Exception e) {
                                    System.out.println("ERROR: Invalid input!");
                                    continue;
                                }
                            }
                            if (userCpu <= 0) {
                                System.out.println("CPU cores are required!");
                                continue;
                            }
                            else if ((ClusterResources.vmArray.get(tempVmId).getVmcpu()-userCpu)+adminCluster.getClcpu() < 0) {
                                System.out.println("Not enough CPU cores available on the cluster!");
                                continue;
                            }

                            adminCluster.setClcpu(adminCluster.getClcpu()-userCpu);
                            ClusterResources.vmArray.get(tempVmId-1).setVmcpu(userCpu);

                            break;
                        }
                            
                    case 3:
                        //RAM
                        inputChecker = null;
                        userRam = null;

                        while (true) {
                            System.out.println("Enter number of GB of RAM to assign or Q to cancel:");
                            inputChecker = oneScanner.next();
                            oneScanner.nextLine();

                            if (inputChecker.equalsIgnoreCase("q")) {
                                break;
                            }
                            else {
                                try {
                                    userRam = Integer.parseInt(inputChecker);
                                } catch (Exception e) {
                                    System.out.println("ERROR: Invalid input!");
                                    continue;
                                }
                            }
                            if (userRam <= 0) {
                                System.out.println("RAM is required!");
                                continue;
                            }
                            else if ((ClusterResources.vmArray.get(tempVmId-1).getVmram()-userCpu)+adminCluster.getClram() < 0) {
                                System.out.println("Not enough resources available on the cluster!");
                                continue;
                            }

                            adminCluster.setClram(adminCluster.getClram()-userRam);
                            ClusterResources.vmArray.get(tempVmId-1).setVmram(userRam);

                            break;
                        }
                            
                    case 4:
                        //SSD
                        inputChecker = null;
                        userSsd = null;

                        if (ClusterResources.vmArray.get(tempVmId-1) instanceof PlainVM == false) {
                            System.out.println("This type of resource is not available to this VM!");
                            continue;
                        }
                        
                        while (true) {
                            System.out.println("Enter number of GB of SSD storage to assign or Q to cancel:");
                            inputChecker = oneScanner.next();
                            oneScanner.nextLine();

                            if (inputChecker.equalsIgnoreCase("q")) {
                                break;
                            }
                            else {
                                try {
                                    userSsd = Integer.parseInt(inputChecker);
                                } catch (Exception e) {
                                    System.out.println("ERROR: Invalid input!");
                                    continue;
                                }
                            }
                            if (userSsd <= 0) {
                                System.out.println("SSD storage is required!");
                                continue;
                            }
                            else if ((((PlainVM) ClusterResources.vmArray.get(tempVmId-1)).getVmssd()-userSsd)+adminCluster.getClssd() < 0) {
                                System.out.println("Not enough resources available on the cluster!");
                                continue;
                            }

                            adminCluster.setClssd(adminCluster.getClssd()-userSsd);
                            
                            try {
                                ((PlainVM) ClusterResources.vmArray.get(tempVmId-1)).setVmssd(userSsd);
                            } catch (Exception e) {
                                System.out.println("Could not cast to PlainVM!");
                                continue;
                            }

                            break;
                        }

                    case 5:
                        inputChecker = null;
                        userGpu = null;

                        //GPU
                        if (ClusterResources.vmArray.get(tempVmId-1) instanceof VmGPU == false) {
                            System.out.println("This type of resource is not available to this VM!");
                            continue;
                        }
                        
                        while (true) {
                            System.out.println("Enter number of GPUs to assign or Q to cancel:");
                            inputChecker = oneScanner.next();
                            oneScanner.nextLine();

                            if (inputChecker.equalsIgnoreCase("q")) {
                                break;
                            }
                            else {
                                try {
                                    userGpu = Integer.parseInt(inputChecker);
                                } catch (Exception e) {
                                    System.out.println("ERROR: Invalid input!");
                                    continue;
                                }
                            }
                            if (userGpu <= 0) {
                                System.out.println("GPUs are required!");
                                continue;
                            }
                            else if ((((VmGPU) ClusterResources.vmArray.get(tempVmId-1)).getVmgpu()-userGpu)+adminCluster.getClgpu() < 0) {
                                System.out.println("Not enough resources available on the cluster!");
                                continue;
                            }

                            adminCluster.setClgpu(adminCluster.getClgpu()-userGpu);
                            
                            try {
                                ((VmGPU) ClusterResources.vmArray.get(tempVmId-1)).setVmgpu(userGpu);
                            } catch (Exception e) {
                                System.out.println("Could not cast to VMGpu!");
                                continue;
                            }

                            break;
                        }
                    
                    case 6:
                        inputChecker = null;
                        userBandwidth = null;

                        //BANDWIDTH
                        if (ClusterResources.vmArray.get(tempVmId-1) instanceof VmNetworked == false && ClusterResources.vmArray.get(tempVmId-1) instanceof VmNetworkedGPU == false) {
                            System.out.println("This type of resource is not available to this VM!");
                            continue;
                        }
                        
                        while (true) {
                            System.out.println("Enter number of GB of Bandwidth rate to assign or Q to cancel:");
                            inputChecker = oneScanner.next();
                            oneScanner.nextLine();

                            if (inputChecker.equalsIgnoreCase("q")) {
                                break;
                            }
                            else {
                                try {
                                    userBandwidth = Integer.parseInt(inputChecker);
                                } catch (Exception e) {
                                    System.out.println("ERROR: Invalid input!");
                                    continue;
                                }
                            }
                            if (userBandwidth <= 0) {
                                System.out.println("Bandwidth is required in this VM!");
                                continue;
                            }
                            else if ((((VmNetworked) ClusterResources.vmArray.get(tempVmId-1)).getVmbandwidth()-userBandwidth)+adminCluster.getClbandwidth() < 0) {
                                System.out.println("Not enough resources available on the cluster!");
                                continue;
                            }

                            adminCluster.setClbandwidth(adminCluster.getClbandwidth()-userBandwidth);
                            
                            try {
                                ((VmNetworked) ClusterResources.vmArray.get(tempVmId-1)).setVmbandwidth(userBandwidth);
                            } catch (Exception e) {
                                System.out.println("Could not cast to VmNetworked!");
                                continue;
                            }

                            break;
                        }
                    
                    default:
                        System.out.println("Please select a valid option!");
                        continue;
                }
            }
            break;
        }
    }

    public void deleteVm(){
        //method should return resources to cluster
        String inputChecker = null;

        while (true) {
            inputChecker = null;
            tempVmId = null;
            System.out.println("Enter the ID of the VM you want to delete or Q to cancel:");
            inputChecker = oneScanner.next();
            oneScanner.nextLine();

            if (inputChecker.equalsIgnoreCase("q")) {
                break;
            }
            else {
                try {
                    tempVmId = Integer.parseInt(inputChecker);
                } catch (Exception e) {
                    System.out.println("ERROR: Invalid input!");
                    continue;
                }
            }
            
            switch ((ClusterResources.vmArray.get(tempVmId-1)).getVmType()) {
                case "PlainVM":
                    adminCluster.setClcpu(adminCluster.getClcpu()+(ClusterResources.vmArray.get(tempVmId-1).getVmcpu()));
                    adminCluster.setClram(adminCluster.getClram()+(ClusterResources.vmArray.get(tempVmId-1).getVmram()));
                    adminCluster.setClssd(adminCluster.getClssd()+(((PlainVM) ClusterResources.vmArray.get(tempVmId-1)).getVmssd()));
                    System.out.println("Cluster updated!");
                    break;

                case "VmGPU":
                    adminCluster.setClcpu(adminCluster.getClcpu()+(ClusterResources.vmArray.get(tempVmId-1).getVmcpu()));
                    adminCluster.setClram(adminCluster.getClram()+(ClusterResources.vmArray.get(tempVmId-1).getVmram()));
                    adminCluster.setClssd(adminCluster.getClssd()+(((VmGPU) ClusterResources.vmArray.get(tempVmId-1)).getVmssd()));
                    adminCluster.setClgpu(adminCluster.getClgpu()+(((VmGPU) ClusterResources.vmArray.get(tempVmId-1)).getVmgpu()));
                    System.out.println("Cluster updated!");
                    break;

                case "VmNetworked":
                    adminCluster.setClcpu(adminCluster.getClcpu()+(ClusterResources.vmArray.get(tempVmId-1).getVmcpu()));
                    adminCluster.setClram(adminCluster.getClram()+(ClusterResources.vmArray.get(tempVmId-1).getVmram()));
                    adminCluster.setClssd(adminCluster.getClssd()+(((VmNetworked) ClusterResources.vmArray.get(tempVmId-1)).getVmssd()));
                    adminCluster.setClbandwidth(adminCluster.getClbandwidth()+(((VmNetworked) ClusterResources.vmArray.get(tempVmId-1)).getVmbandwidth()));
                    System.out.println("Cluster updated!");
                    break;

                case "VmNetworkedGPU":
                    adminCluster.setClcpu(adminCluster.getClcpu()+(ClusterResources.vmArray.get(tempVmId-1).getVmcpu()));
                    adminCluster.setClram(adminCluster.getClram()+(ClusterResources.vmArray.get(tempVmId-1).getVmram()));
                    adminCluster.setClssd(adminCluster.getClssd()+(((VmNetworkedGPU) ClusterResources.vmArray.get(tempVmId-1)).getVmssd()));
                    adminCluster.setClgpu(adminCluster.getClgpu()+(((VmNetworkedGPU) ClusterResources.vmArray.get(tempVmId-1)).getVmgpu()));
                    adminCluster.setClbandwidth(adminCluster.getClbandwidth()+(((VmNetworkedGPU) ClusterResources.vmArray.get(tempVmId-1)).getVmbandwidth()));
                    System.out.println("Cluster updated!");
                    break;

                default:
                    System.out.println("VM Type not recognized!");
                    continue;
            }

            try {
                ClusterResources.vmArray.remove(tempVmId-1);
                System.out.println("VM deleted!");
            } catch (Exception e) {
                System.out.println("This VM id does not exist!");
                continue;
            }
            break;
        }
    }

    public void setUserOCRS() {
        setUserOS();
        setUserCPU();
        setUserRAM();
        setUserSSD();
    }

    public void setUserOS() {
        //OS
        while (true) {
            inputChecker = null;
            userOs = null;
            
            System.out.println("Choose an OS:"+"\n"+"1: Windows"+"\n"+"2: Ubuntu"+"\n"+"3: Fedora"+"\n"+"Q: Cancel"+"\n");
            inputChecker = oneScanner.next();
            oneScanner.nextLine();
            if (inputChecker.equalsIgnoreCase("q")) {
                break;
            }
            else {
                try {
                    userOs = Integer.parseInt(inputChecker);
                    userOs -= 1;
                } catch (Exception e) {
                    System.out.println("ERROR: Invalid input!");
                    continue;
                }
            }
            if (userOs != 0 || userOs != 1 || userOs != 2) {
                System.out.println("Please select a valid OS!");
                continue;
            }

            break;
        }
    }

    public void setUserCPU() {
        //CPU
        while (true) {
            inputChecker = null;
            userCpu = null;

            System.out.println("Enter number of CPU cores to assign or Q to cancel: ");
            inputChecker = oneScanner.next();
            oneScanner.nextLine();

            if (inputChecker.equalsIgnoreCase("q")) {
                break;
            }
            else {
                try {
                    userCpu = Integer.parseInt(inputChecker);
                } catch (Exception e) {
                    System.out.println("ERROR: Invalid input!");
                    continue;
                }
            }
            if (userCpu <= 0) {
                System.out.println("CPU cores are required!");
                continue;
            }
            //(vmRes-resInput)+clRes>=clRes
            else if (userCpu > adminCluster.getClcpu()) {
                System.out.println("Not enough resources available on the cluster!");
                continue;
            }

            break;
        }
    }

    public void setUserRAM() {
        //RAM
        while (true) {
            inputChecker = null;
            userRam = null;
        
            System.out.println("Enter number of GB of RAM to assign or Q to cancel:");
            inputChecker = oneScanner.next();
            oneScanner.nextLine();

            if (inputChecker.equalsIgnoreCase("q")) {
                break;
            }
            else {
                try {
                    userRam = Integer.parseInt(inputChecker);
                } catch (Exception e) {
                    System.out.println("ERROR: Invalid input!");
                    continue;
                }
            }
            if (userRam <= 0) {
                System.out.println("RAM is required!");
                continue;
            }
            else if (userRam > adminCluster.getClram()) {
                System.out.println("Not enough resources available on the cluster!");
                continue;
            }

            break;
        }
    }

    public void setUserSSD() {
        //SSD
        while (true) {
            inputChecker = null;
            userSsd = null;

            System.out.println("Enter number of GB of SSD storage to assign or Q to cancel:");
            inputChecker = oneScanner.next();
            oneScanner.nextLine();

            if (inputChecker.equalsIgnoreCase("q")) {
                break;
            }
            else {
                try {
                    userSsd = Integer.parseInt(inputChecker);
                } catch (Exception e) {
                    System.out.println("ERROR: Invalid input!");
                    continue;
                }
            }
            if (userSsd <= 0) {
                System.out.println("SSD storage can't be 0 or less in this VM!");
                continue;
            }
            else if (userSsd > adminCluster.getClssd()) {
                System.out.println("Not enough resources available on the cluster!");
                continue;
            }

            break;
        }
    }

    private void setUserGpu() {
        //GPU
        while (true) {
            inputChecker = null;
            userGpu = null;

            System.out.println("Enter number of GPUs to assign or Q to cancel:");
            inputChecker = oneScanner.next();
            oneScanner.nextLine();

            if (inputChecker.equalsIgnoreCase("q")) {
                break;
            }
            else {
                try {
                    userGpu = Integer.parseInt(inputChecker);
                } catch (Exception e) {
                    System.out.println("ERROR: Invalid input!");
                    continue;
                }
            }
            if (userGpu <= 0) {
                System.out.println("GPUs can't be 0 or less in this VM!");
                continue;
            }
            else if (userGpu > adminCluster.getClgpu()) {
                System.out.println("Not enough resources available on the cluster!");
                continue;
            }

            break;
        }
    }

    private void setUserBandwidth() {
        //Bandwidth
        while (true) {
            inputChecker = null;
            userBandwidth = null;

            System.out.println("Enter the amount of bandwidth rate to assign or Q to cancel:");
            inputChecker = oneScanner.next();
            oneScanner.nextLine();

            if (inputChecker.equalsIgnoreCase("q")) {
                break;
            }
            else {
                try {
                    userBandwidth = Integer.parseInt(inputChecker);
                } catch (Exception e) {
                    System.out.println("ERROR: Invalid input!");
                    continue;
                }
            }
            if (userBandwidth <= 0) {
                System.out.println("Bandwidth is required in this VM!");
                continue;
            }
            else if (userBandwidth > adminCluster.getClgpu()) {
                System.out.println("Not enough resources available on the cluster!");
                continue;
            }

            break;
        }
    }

    public void printClusterReport() {
        System.out.println("Cluster Report:"+"\n"+
        "Cluster CPU Cores: "+adminCluster.getClcpu()+"\n"+
        "Cluster RAM: "+adminCluster.getClram()+" GB"+"\n"+
        "Cluster SSD: "+adminCluster.getClssd()+" GB"+"\n"+
        "Cluster GPUs: "+adminCluster.getClgpu()+"\n"+
        "Cluster Bandwidth: "+adminCluster.getClbandwidth()+" Gb/sec");
    }

    public VM findVmById(Integer vmId) {
        for (VM vm : ClusterResources.vmArray) {
            if (vm.getVmid().equals(vmId)) {
                return vm;
            }
        }
        return null;
    }
}
