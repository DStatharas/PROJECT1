package com.JavaNerds.app;

import java.util.Scanner;

public class Admin{
    
    ClusterResources adminCluster = ClusterResources.getInstance();

    Scanner oneScanner = new Scanner(System.in);

    private Boolean exitCheck = false;
    private String inputChecker = null;
    private Integer userCpu = null;
    private Integer userRam = null;
    private Integer userSsd = null;
    private Integer userGpu = null;
    private Integer userBandwidth = null;
    private Integer userOs = null;
    private Integer tempVmId = null;
    
    public void createVM() throws InterruptedException {
        Integer userVmType = null;

        while (true) {
            inputChecker = null;
            userVmType = null;
            exitCheck = false;

            userCpu = null;
            userRam = null;
            userSsd = null;
            userGpu = null;
            userBandwidth = null;
            userOs = null;

            projectTools.clearConsole();

            System.out.print("Please select one of the following numbers to choose the type of Virtual Machine you would like to create, or enter Q to cancel VM creation."+"\n\n"+"1: Plain VM"+"\n"+"2: GPU VM"+"\n"+"3: Networked VM"+"\n"+"4: Networked GPU VM"+"\n"+"Q: Cancel"+"\n\n"+"Select option: ");
            inputChecker = oneScanner.next();
            oneScanner.nextLine();
            if (inputChecker.equalsIgnoreCase("q")) {
                break;
            } else {
                try {
                    userVmType = Integer.parseInt(inputChecker);
                } catch (Exception e) {
                    projectTools.clearConsole();
                    System.out.println("ERROR: Invalid input!");
                    Thread.sleep(3000);
                    continue;
                }
            }

            switch (userVmType) {
                case 1:
                    //PlainVM
                    setUserOCRS();
                    if (exitCheck == true) {
                        continue;
                    }
                    adminCluster.setClcpu(adminCluster.getClcpu()-userCpu);
                    adminCluster.setClram(adminCluster.getClram()-userRam);
                    adminCluster.setClssd(adminCluster.getClssd()-userSsd);

                    try {
                        projectTools.propellerLoading("Creating VM...", 5);
                        ClusterResources.vmArray.add(new PlainVM(1, userOs, userCpu, userRam, userSsd));
                        System.out.println("VM created!");
                        Thread.sleep(3000);
                    } catch (Exception e) {
                        projectTools.clearConsole();
                        System.out.println("ERROR: VM could not be created!");
                        Thread.sleep(3000);
                        continue;
                    }
                    
                    break;

                    
                case 2:
                    //VmGPU
                    setUserOCRS();
                    if (exitCheck == true) {
                        continue;
                    }
                    setUserGpu();
                    if (exitCheck == true) {
                        continue;
                    }

                    adminCluster.setClcpu(adminCluster.getClcpu()-userCpu);
                    adminCluster.setClram(adminCluster.getClram()-userRam);
                    adminCluster.setClssd(adminCluster.getClssd()-userSsd);
                    adminCluster.setClgpu(adminCluster.getClgpu()-userGpu);

                    try {
                        projectTools.propellerLoading("Creating VM...", 5);
                        ClusterResources.vmArray.add(new VmGPU(2, userOs, userCpu, userRam, userSsd, userGpu));
                        System.out.println("VM created!");
                        Thread.sleep(3000);
                    } catch (Exception e) {
                        projectTools.clearConsole();
                        System.out.println("ERROR: VM could not be created!");
                        Thread.sleep(3000);
                        continue;
                    }
                    break;

                case 3:
                    //VmNetworked
                    setUserOCRS();
                    if (exitCheck == true) {
                        continue;
                    }
                    setUserBandwidth();
                    if (exitCheck == true) {
                        continue;
                    }

                    adminCluster.setClcpu(adminCluster.getClcpu()-userCpu);
                    adminCluster.setClram(adminCluster.getClram()-userRam);
                    adminCluster.setClssd(adminCluster.getClssd()-userSsd);
                    adminCluster.setClbandwidth(adminCluster.getClbandwidth()-userBandwidth);

                    try {
                        projectTools.propellerLoading("Creating VM...", 5);
                        ClusterResources.vmArray.add(new VmNetworked(3, userOs, userCpu, userRam, userSsd, userBandwidth));
                        System.out.println("VM created!");
                        Thread.sleep(3000);
                    } catch (Exception e) {
                        projectTools.clearConsole();
                        System.out.println("ERROR: VM could not be created!");
                        Thread.sleep(3000);
                        continue;
                    }
                    break;

                case 4:
                    //VmNetworkedGPU
                    setUserOCRS();
                    if (exitCheck == true) {
                        continue;
                    }
                    setUserGpu();
                    if (exitCheck == true) {
                        continue;
                    }
                    setUserBandwidth();
                    if (exitCheck == true) {
                        continue;
                    }

                    adminCluster.setClcpu(adminCluster.getClcpu()-userCpu);
                    adminCluster.setClram(adminCluster.getClram()-userRam);
                    adminCluster.setClssd(adminCluster.getClssd()-userSsd);
                    adminCluster.setClgpu(adminCluster.getClgpu()-userGpu);
                    adminCluster.setClbandwidth(adminCluster.getClbandwidth()-userBandwidth);

                    try {
                        projectTools.propellerLoading("Creating VM...", 5);
                        ClusterResources.vmArray.add(new VmNetworkedGPU(4, userOs, userCpu, userRam, userSsd, userGpu, userBandwidth));
                        System.out.println("VM created!");
                        Thread.sleep(3000);
                    } catch (Exception e) {
                        projectTools.clearConsole();
                        System.out.println("ERROR: VM could not be created!");
                        Thread.sleep(3000);
                        continue;
                    }
                    break;

                default:
                    //Invalid VM Type
                    projectTools.clearConsole();
                    System.out.println("ERROR: Please choose a valid type of Virtual Machine!");
                    Thread.sleep(3000);
                    continue;
            }
        }
    }
    
    public void updateResources() throws InterruptedException {
        Integer resourceToUpdate = null;

        uloop:
        while (true) {
                
            inputChecker = null;
            tempVmId = null;
            resourceToUpdate = null;
                
            projectTools.clearConsole();

            //choosevmId
            while (true) {
                inputChecker = null;
                tempVmId = null;

                projectTools.clearConsole();

                System.out.print("Enter the ID of the VM you'd like to update or Q to cancel: ");
                inputChecker = oneScanner.next();
                oneScanner.nextLine();

                if (inputChecker.equalsIgnoreCase("q")) {
                    break uloop;
                }
                else {
                    try {
                        tempVmId = Integer.parseInt(inputChecker);
                    } catch (Exception e) {
                        projectTools.clearConsole();
                        System.out.println("ERROR: Invalid input!");
                        Thread.sleep(3000);
                        continue;
                    }
                }
                if (findVmById(tempVmId)==null) {
                    projectTools.clearConsole();
                    System.out.println("This VM ID does not exist!");
                    Thread.sleep(3000);
                    continue;
                }
                else {
                    projectTools.clearConsole();
                    System.out.println("Selected VM"+findVmById(tempVmId).getVmid()+"!");
                    Thread.sleep(3000);
                }

                break;
            }

            //chooseresource
            while (true) {
                resourceToUpdate = null;

                projectTools.clearConsole();
                System.out.print("Please select a resource to update:\n"+"\n"+"1: OS"+"\n"+"2: CPU"+"\n"+"3: RAM"+"\n"+"4: SSD"+"\n"+"5: GPU"+"\n"+"6: Bandwidth"+"\n"+"Q: Cancel\n\n");
                System.out.print("Select option: ");
                inputChecker = oneScanner.next();
                oneScanner.nextLine();
                if (inputChecker.equalsIgnoreCase("q")) {
                    break;
                }
                else {
                    try {
                        resourceToUpdate = Integer.parseInt(inputChecker);
                    } catch (Exception e) {
                        projectTools.clearConsole();
                        System.out.println("ERROR: Invalid input!");
                        Thread.sleep(3000);
                        continue;
                    }
                }

                switch (resourceToUpdate) {
                    case 1:
                        //OS
                        while (true) {
                            inputChecker = null;
                            userOs = null;
                            
                            projectTools.clearConsole();

                            System.out.print("Please select an OS:"+"\n"+"1: Windows"+"\n"+"2: Ubuntu"+"\n"+"3: Fedora"+"\n"+"Q: Cancel\n\n"+"Select option: ");
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
                                    projectTools.clearConsole();
                                    System.out.println("ERROR: Invalid input!");
                                    Thread.sleep(3000);
                                    continue;
                                }
                            }
                            if (userOs != 0 && userOs != 1 && userOs != 2) {
                                projectTools.clearConsole();
                                System.out.println("Please select a valid OS!");
                                Thread.sleep(3000);
                                continue;
                            }
                            
                            try {
                                projectTools.propellerLoading("Updating VM with the chosen specifications...", 5);
                                findVmById(tempVmId).setVmOs(userOs);
                                System.out.println("VM updated!");
                                Thread.sleep(3000);
                            } catch (Exception e) {
                                projectTools.clearConsole();
                                System.out.println("Could not update VM!");
                                Thread.sleep(3000);
                                continue;
                            }
                            
                            break;
                        }

                        break;
                    
                    case 2:
                        //CPU
                        while (true) {
                            inputChecker = null;
                            userCpu = null;

                            projectTools.clearConsole();

                            System.out.print("Enter number of CPU cores to assign or Q to cancel: ");
                            inputChecker = oneScanner.next();
                            oneScanner.nextLine();

                            if (inputChecker.equalsIgnoreCase("q")) {
                                break;
                            }
                            else {
                                try {
                                    userCpu = Integer.parseInt(inputChecker);
                                } catch (Exception e) {
                                    projectTools.clearConsole();
                                    System.out.println("ERROR: Invalid input!");
                                    Thread.sleep(3000);
                                    continue;
                                }
                            }
                            if (userCpu <= 0) {
                                projectTools.clearConsole();
                                System.out.println("CPU cores are required!");
                                Thread.sleep(3000);
                                continue;
                            }
                            else if ((findVmById(tempVmId).getVmcpu()-userCpu)+adminCluster.getClcpu() < 0) {
                                projectTools.clearConsole();
                                System.out.println("Not enough resources available on the cluster!");
                                Thread.sleep(3000);
                                continue;
                            }

                            try {
                                projectTools.propellerLoading("Updating Cluster...", 5);
                                adminCluster.setClcpu(adminCluster.getClcpu()+(((PlainVM) findVmById(tempVmId)).getVmcpu()-userCpu));
                                System.out.println("Cluster updated!");
                                Thread.sleep(3000);
                            } catch (Exception e) {
                                projectTools.clearConsole();
                                System.out.println("ERROR: Could not update Cluster!");
                                Thread.sleep(3000);
                                continue;
                            }

                            try {
                                projectTools.propellerLoading("Updating VM with the assigned specifications....", 5);
                                ((PlainVM) findVmById(tempVmId)).setVmcpu(userCpu);
                                System.out.println("VM updated!");
                                Thread.sleep(3000);
                            } catch (Exception e) {
                                projectTools.clearConsole();
                                System.out.println("ERROR: Could not update VM!");
                                Thread.sleep(3000);
                                adminCluster.setClcpu(adminCluster.getClcpu()-(((PlainVM) findVmById(resourceToUpdate)).getVmcpu()-userCpu));
                                continue;
                            }

                            break;
                        }

                        break;
                            
                    case 3:
                        //RAM
                        inputChecker = null;
                        userRam = null;

                        projectTools.clearConsole();

                        while (true) {
                            projectTools.clearConsole();
                            System.out.print("Enter number of GB of RAM to assign or Q to cancel: ");
                            inputChecker = oneScanner.next();
                            oneScanner.nextLine();

                            if (inputChecker.equalsIgnoreCase("q")) {
                                break;
                            }
                            else {
                                try {
                                    userRam = Integer.parseInt(inputChecker);
                                } catch (Exception e) {
                                    projectTools.clearConsole();
                                    System.out.println("ERROR: Invalid input!");
                                    Thread.sleep(3000);
                                    continue;
                                }
                            }
                            if (userRam <= 0) {
                                projectTools.clearConsole();
                                System.out.println("RAM is required!");
                                Thread.sleep(3000);
                                continue;
                            }
                            else if ((findVmById(tempVmId).getVmram()-userCpu)+adminCluster.getClram() < 0) {
                                projectTools.clearConsole();
                                System.out.println("Not enough resources available on the cluster!");
                                Thread.sleep(3000);
                                continue;
                            }

                            try {
                                projectTools.propellerLoading("Updating Cluster...", 5);
                                adminCluster.setClram(adminCluster.getClram()+(((PlainVM) findVmById(tempVmId)).getVmram()-userRam));
                                System.out.println("Cluster updated!");
                                Thread.sleep(3000);
                            } catch (Exception e) {
                                projectTools.clearConsole();
                                System.out.println("ERROR: Could not update Cluster!");
                                Thread.sleep(3000);
                                continue;
                            }

                            try {
                                projectTools.propellerLoading("Updating VM with the assigned specifications...", resourceToUpdate);
                                ((PlainVM) findVmById(tempVmId)).setVmram(userRam);
                                System.out.println("VM updated!");
                                Thread.sleep(3000);
                            } catch (Exception e) {
                                projectTools.clearConsole();
                                System.out.println("ERROR: Could not update VM!");
                                Thread.sleep(3000);
                                adminCluster.setClram(adminCluster.getClram()-(((PlainVM) findVmById(tempVmId)).getVmram()-userRam));
                                continue;
                            }

                            break;
                        }

                        break;
                            
                    case 4:
                        //SSD
                        inputChecker = null;
                        userSsd = null;

                        projectTools.clearConsole();

                        if (findVmById(tempVmId) instanceof PlainVM == false) {
                            projectTools.clearConsole();
                            System.out.println("This type of resource is not available to this VM!");
                            Thread.sleep(3000);
                            continue;
                        }
                        
                        while (true) {
                            projectTools.clearConsole();
                            System.out.print("Enter number of GB of SSD storage to assign or Q to cancel: ");
                            inputChecker = oneScanner.next();
                            oneScanner.nextLine();

                            if (inputChecker.equalsIgnoreCase("q")) {
                                break;
                            }
                            else {
                                try {
                                    userSsd = Integer.parseInt(inputChecker);
                                } catch (Exception e) {
                                    projectTools.clearConsole();
                                    System.out.println("ERROR: Invalid input!");
                                    Thread.sleep(3000);
                                    continue;
                                }
                            }
                            if (userSsd <= 0) {
                                projectTools.clearConsole();
                                System.out.println("SSD storage is required!");
                                Thread.sleep(3000);
                                continue;
                            }
                            else if ((((PlainVM) findVmById(tempVmId)).getVmssd()-userSsd)+adminCluster.getClssd() < 0) {
                                projectTools.clearConsole();
                                System.out.println("Not enough resources available on the cluster!");
                                Thread.sleep(3000);
                                continue;
                            }

                            try {
                                projectTools.propellerLoading("Updating Cluster...", 5);
                                adminCluster.setClssd(adminCluster.getClssd()+(((PlainVM) findVmById(tempVmId)).getVmssd()-userSsd));
                                System.out.println("Cluster updated!");
                                Thread.sleep(3000);
                            } catch (Exception e) {
                                projectTools.clearConsole();
                                System.out.println("ERROR: Could not update Cluster!");
                                Thread.sleep(3000);
                                continue;
                            }
                            
                            
                            
                            try {
                                projectTools.propellerLoading("Updating VM with the assigned specifications...", 5);
                                ((PlainVM) findVmById(tempVmId)).setVmssd(userSsd);
                                System.out.println("VM updated!");
                                Thread.sleep(3000);
                            } catch (Exception e) {
                                projectTools.clearConsole();
                                System.out.println("ERROR: Could not update VM!");
                                Thread.sleep(3000);
                                adminCluster.setClssd(adminCluster.getClssd()-(((PlainVM) findVmById(tempVmId)).getVmssd()-userSsd));
                                continue;
                            }

                            break;
                        }

                        break;

                    case 5:
                        inputChecker = null;
                        userGpu = null;

                        projectTools.clearConsole();

                        //GPU
                        if (findVmById(tempVmId) instanceof VmGPU == false) {
                            projectTools.clearConsole();
                            System.out.println("This type of resource is not available to this VM!");
                            Thread.sleep(3000);
                            continue;
                        }
                        
                        while (true) {
                            projectTools.clearConsole();
                            System.out.print("Enter number of GPUs to assign or Q to cancel: ");
                            inputChecker = oneScanner.next();
                            oneScanner.nextLine();

                            if (inputChecker.equalsIgnoreCase("q")) {
                                break;
                            }
                            else {
                                try {
                                    userGpu = Integer.parseInt(inputChecker);
                                } catch (Exception e) {
                                    projectTools.clearConsole();
                                    System.out.println("ERROR: Invalid input!");
                                    Thread.sleep(3000);
                                    continue;
                                }
                            }
                            if (userGpu <= 0) {
                                projectTools.clearConsole();
                                System.out.println("GPUs are required!");
                                Thread.sleep(3000);
                                continue;
                            }
                            else if ((((VmGPU) findVmById(tempVmId)).getVmgpu()-userGpu)+adminCluster.getClgpu() < 0) {
                                projectTools.clearConsole();
                                System.out.println("Not enough resources available on the cluster!");
                                Thread.sleep(3000);
                                continue;
                            }

                            
                            try {
                                projectTools.propellerLoading("Updating Cluster...", 5);
                                adminCluster.setClgpu(adminCluster.getClgpu()+(((VmGPU) findVmById(tempVmId)).getVmgpu()-userGpu));
                                System.out.println("Cluster Updated!");
                                Thread.sleep(3000);
                            } catch (Exception e) {
                                System.out.println("ERROR: Could not update Cluster!");
                                Thread.sleep(3000);
                                continue;
                            }

                            try {
                                projectTools.propellerLoading("Updating VM with the assigned specifications... ", 5);
                                ((VmGPU) findVmById(tempVmId)).setVmgpu(userGpu);
                                System.out.println("VM Updated!");
                                Thread.sleep(3000);
                            } catch (Exception e) {
                                projectTools.clearConsole();
                                System.out.println("ERROR: Could not update VM!");
                                Thread.sleep(3000);
                                adminCluster.setClgpu(adminCluster.getClgpu()-(((VmGPU) findVmById(tempVmId)).getVmgpu()-userGpu));
                                continue;
                            }

                            break;
                        }

                        break;
                    
                    case 6:
                        inputChecker = null;
                        userBandwidth = null;

                        projectTools.clearConsole();

                        //BANDWIDTH
                        if (findVmById(tempVmId) instanceof VmNetworked == false && findVmById(tempVmId) instanceof VmNetworkedGPU == false) {
                            projectTools.clearConsole();
                            System.out.println("This type of resource is not available to this VM!");
                            Thread.sleep(3000);
                            continue;
                        }
                        
                        while (true) {
                            projectTools.clearConsole();
                            System.out.print("Enter number of GB of Bandwidth rate to assign or Q to cancel: ");
                            inputChecker = oneScanner.next();
                            oneScanner.nextLine();

                            if (inputChecker.equalsIgnoreCase("q")) {
                                break;
                            }
                            else {
                                try {
                                    userBandwidth = Integer.parseInt(inputChecker);
                                } catch (Exception e) {
                                    projectTools.clearConsole();
                                    System.out.println("ERROR: Invalid input!");
                                    Thread.sleep(3000);
                                    continue;
                                }
                            }

                            if (findVmById(tempVmId) instanceof VmNetworked) {
                                if (userBandwidth <= 0) {
                                    projectTools.clearConsole();
                                    System.out.println("Bandwidth is required in this VM!");
                                    Thread.sleep(3000);
                                    continue;
                                }
                                else if ((((VmNetworked) findVmById(tempVmId)).getVmbandwidth()-userBandwidth)+adminCluster.getClbandwidth() < 0) {
                                    projectTools.clearConsole();
                                    System.out.println("Not enough resources available on the cluster!");
                                    Thread.sleep(3000);
                                    continue;
                                }

                                try {
                                    projectTools.propellerLoading("Updating Cluster...", 5);
                                    adminCluster.setClbandwidth(adminCluster.getClbandwidth()+(((VmNetworked) findVmById(tempVmId)).getVmbandwidth()-userBandwidth));
                                    System.out.println("Cluster Updated!");
                                    Thread.sleep(3000);
                                } catch (Exception e) {
                                    projectTools.clearConsole();
                                    System.out.println("ERROR: Could not update Cluster!");
                                    Thread.sleep(3000);
                                    continue;
                                }

                                try {
                                    projectTools.propellerLoading("Updating VM with the assigned specifications...", 5);
                                    ((VmNetworked) findVmById(tempVmId)).setVmbandwidth(userBandwidth);
                                    System.out.println("VM Updated!");
                                    Thread.sleep(3000);
                                } catch (Exception e) {
                                    projectTools.clearConsole();
                                    System.out.println("ERROR: Could not update VM!");
                                    Thread.sleep(3000);
                                    adminCluster.setClbandwidth(adminCluster.getClbandwidth()-(((VmNetworked) findVmById(tempVmId)).getVmbandwidth()-userBandwidth));
                                    continue;
                                }
                            }
                            else if (findVmById(tempVmId) instanceof VmNetworkedGPU) {
                                if (userBandwidth <= 0) {
                                projectTools.clearConsole();
                                System.out.println("Bandwidth is required in this VM!");
                                Thread.sleep(3000);
                                continue;
                            }
                                else if ((((VmNetworkedGPU) findVmById(tempVmId)).getVmbandwidth()-userBandwidth)+adminCluster.getClbandwidth() < 0) {
                                    projectTools.clearConsole();
                                    System.out.println("Not enough resources available on the cluster!");
                                    Thread.sleep(3000);
                                    continue;
                                }

                                try {
                                    projectTools.propellerLoading("Updating Cluster...", 5);
                                    adminCluster.setClbandwidth(adminCluster.getClbandwidth()+(((VmNetworkedGPU) findVmById(tempVmId)).getVmbandwidth()-userBandwidth));
                                    System.out.println("Cluster Updated!");
                                    Thread.sleep(3000);
                                } catch (Exception e) {
                                    projectTools.clearConsole();
                                    System.out.println("ERROR: Could not update Cluster!");
                                    Thread.sleep(3000);
                                    continue;
                                }

                                try {
                                    projectTools.propellerLoading("Updating VM with the assigned specifications...", 5);
                                    ((VmNetworkedGPU) findVmById(tempVmId)).setVmbandwidth(userBandwidth);
                                    System.out.println("VM Updated!");
                                    Thread.sleep(3000);
                                } catch (Exception e) {
                                    projectTools.clearConsole();
                                    System.out.println("ERROR: Could not update VM!");
                                    Thread.sleep(3000);
                                    adminCluster.setClbandwidth(adminCluster.getClbandwidth()-(((VmNetworkedGPU) findVmById(tempVmId)).getVmbandwidth()-userBandwidth));
                                    continue;
                                }
                            }
                            
                            break;
                        }

                        break;
                    
                    default:
                        projectTools.clearConsole();
                        System.out.println("ERROR: Please select a valid option!");
                        Thread.sleep(3000);
                        continue;
                }
            }
            break;
        }
    }

    public void deleteVm() throws InterruptedException{
        String inputChecker = null;

        while (true) {
            inputChecker = null;
            tempVmId = null;

            projectTools.clearConsole();
            System.out.print("Enter the ID of the VM you want to delete or Q to cancel: ");
            inputChecker = oneScanner.next();
            oneScanner.nextLine();

            if (inputChecker.equalsIgnoreCase("q")) {
                break;
            }
            else {
                try {
                    tempVmId = Integer.parseInt(inputChecker);
                } catch (Exception e) {
                    projectTools.clearConsole();
                    System.out.println("ERROR: Invalid input!");
                    Thread.sleep(3000);
                    continue;
                }
            }
            
            switch ((findVmById(tempVmId)).getVmType()) {
                case "PlainVM":
                    adminCluster.setClcpu(adminCluster.getClcpu()+(findVmById(tempVmId).getVmcpu()));
                    adminCluster.setClram(adminCluster.getClram()+(findVmById(tempVmId).getVmram()));
                    adminCluster.setClssd(adminCluster.getClssd()+(((PlainVM) findVmById(tempVmId)).getVmssd()));

                    projectTools.propellerLoading("Updating Cluster...", 5);
                    System.out.println("Cluster updated!");
                    Thread.sleep(3000);
                    break;

                case "VmGPU":
                    adminCluster.setClcpu(adminCluster.getClcpu()+(findVmById(tempVmId).getVmcpu()));
                    adminCluster.setClram(adminCluster.getClram()+(findVmById(tempVmId).getVmram()));
                    adminCluster.setClssd(adminCluster.getClssd()+(((VmGPU) findVmById(tempVmId)).getVmssd()));
                    adminCluster.setClgpu(adminCluster.getClgpu()+(((VmGPU) findVmById(tempVmId)).getVmgpu()));

                    projectTools.propellerLoading("Updating Cluster...", 5);
                    System.out.println("Cluster updated!");
                    Thread.sleep(3000);
                    break;

                case "VmNetworked":
                    adminCluster.setClcpu(adminCluster.getClcpu()+(findVmById(tempVmId).getVmcpu()));
                    adminCluster.setClram(adminCluster.getClram()+(findVmById(tempVmId).getVmram()));
                    adminCluster.setClssd(adminCluster.getClssd()+(((VmNetworked) findVmById(tempVmId)).getVmssd()));
                    adminCluster.setClbandwidth(adminCluster.getClbandwidth()+(((VmNetworked) findVmById(tempVmId)).getVmbandwidth()));

                    projectTools.propellerLoading("Updating Cluster...", 5);
                    System.out.println("Cluster updated!");
                    Thread.sleep(3000);
                    break;

                case "VmNetworkedGPU":
                    adminCluster.setClcpu(adminCluster.getClcpu()+(findVmById(tempVmId).getVmcpu()));
                    adminCluster.setClram(adminCluster.getClram()+(findVmById(tempVmId).getVmram()));
                    adminCluster.setClssd(adminCluster.getClssd()+(((VmNetworkedGPU) findVmById(tempVmId)).getVmssd()));
                    adminCluster.setClgpu(adminCluster.getClgpu()+(((VmNetworkedGPU) findVmById(tempVmId)).getVmgpu()));
                    adminCluster.setClbandwidth(adminCluster.getClbandwidth()+(((VmNetworkedGPU) findVmById(tempVmId)).getVmbandwidth()));

                    projectTools.propellerLoading("Updating Cluster...", 5);
                    System.out.println("Cluster updated!");
                    Thread.sleep(3000);
                    break;

                default:
                    System.out.println("VM Type not recognized!");
                    Thread.sleep(3000);
                    continue;
            }

            try {
                ClusterResources.vmArray.remove(tempVmId-1);
                projectTools.propellerLoading("Deleting VM...", 5);
                System.out.println("VM deleted!");
                Thread.sleep(3000);
            } catch (Exception e) {
                projectTools.clearConsole();
                System.out.println("This VM id does not exist!");
                Thread.sleep(3000);
                continue;
            }
            break;
        }
    }

    public void setUserOCRS() throws InterruptedException {
        if (exitCheck == false) {
            setUserOS();
        }
        if (exitCheck == false) {
            setUserCPU();
        }
        if (exitCheck == false) {
            setUserRAM();
        }
        if (exitCheck == false) {
            setUserSSD();
        }
    }

    public void setUserOS() throws InterruptedException {
        //OS
        while (true) {
            inputChecker = null;
            userOs = null;
            exitCheck = false;

            projectTools.clearConsole();
            System.out.print("Please select an OS:"+"\n\n"+"1: Windows"+"\n"+"2: Ubuntu"+"\n"+"3: Fedora"+"\n"+"Q: Cancel\n"+"\n"+"Select option: ");
            inputChecker = oneScanner.next();
            oneScanner.nextLine();
            if (inputChecker.equalsIgnoreCase("q")) {
                exitCheck = true;
                break;
            }
            else {
                try {
                    userOs = Integer.parseInt(inputChecker);
                    userOs -= 1;
                } catch (Exception e) {
                    projectTools.clearConsole();
                    System.out.println("ERROR: Invalid input!");
                    Thread.sleep(3000);
                    continue;
                }
            }
            if (userOs != 0 && userOs != 1 && userOs != 2) {
                projectTools.clearConsole();
                System.out.println("ERROR: Please select a valid OS!");
                Thread.sleep(3000);
                continue;
            }

            break;
        }
    }

    public void setUserCPU() throws InterruptedException {
        //CPU
        while (true) {
            inputChecker = null;
            userCpu = null;
            exitCheck = false;

            projectTools.clearConsole();
            System.out.print("Enter number of CPU cores to assign or Q to cancel: ");
            inputChecker = oneScanner.next();
            oneScanner.nextLine();

            if (inputChecker.equalsIgnoreCase("q")) {
                exitCheck = true;
                break;
            }
            else {
                try {
                    userCpu = Integer.parseInt(inputChecker);
                } catch (Exception e) {
                    projectTools.clearConsole();
                    System.out.println("ERROR: Invalid input!");
                    Thread.sleep(3000);
                    continue;
                }
            }
            if (userCpu <= 0) {
                projectTools.clearConsole();
                System.out.println("ERROR: CPU cores are required!");
                Thread.sleep(3000);
                continue;
            }
            
            else if (userCpu > adminCluster.getClcpu()) {
                projectTools.clearConsole();
                System.out.println("ERROR: Not enough resources available on the cluster!");
                Thread.sleep(3000);
                continue;
            }

            break;
        }
    }

    public void setUserRAM() throws InterruptedException {
        //RAM
        while (true) {
            inputChecker = null;
            userRam = null;
            exitCheck = false;
        
            projectTools.clearConsole();
            System.out.print("Enter number of GB of RAM to assign or Q to cancel: ");
            inputChecker = oneScanner.next();
            oneScanner.nextLine();

            if (inputChecker.equalsIgnoreCase("q")) {
                exitCheck = true;
                break;
            }
            else {
                try {
                    userRam = Integer.parseInt(inputChecker);
                } catch (Exception e) {
                    projectTools.clearConsole();
                    System.out.println("ERROR: Invalid input!");
                    Thread.sleep(3000);
                    continue;
                }
            }
            if (userRam <= 0) {
                projectTools.clearConsole();
                System.out.println("ERROR: RAM is required!");
                Thread.sleep(3000);
                continue;
            }
            else if (userRam > adminCluster.getClram()) {
                projectTools.clearConsole();
                System.out.println("ERROR: Not enough resources available on the cluster!");
                Thread.sleep(3000);
                continue;
            }

            break;
        }
    }

    public void setUserSSD() throws InterruptedException {
        //SSD
        while (true) {
            inputChecker = null;
            userSsd = null;
            exitCheck = false;

            projectTools.clearConsole();
            System.out.print("Enter number of GB of SSD storage to assign or Q to cancel: ");
            inputChecker = oneScanner.next();
            oneScanner.nextLine();

            if (inputChecker.equalsIgnoreCase("q")) {
                exitCheck = true;
                break;
            }
            else {
                try {
                    userSsd = Integer.parseInt(inputChecker);
                } catch (Exception e) {
                    projectTools.clearConsole();
                    System.out.println("ERROR: Invalid input!");
                    Thread.sleep(3000);
                    continue;
                }
            }
            if (userSsd <= 0) {
                projectTools.clearConsole();
                System.out.println("ERROR: SSD storage is required!");
                Thread.sleep(3000);
                continue;
            }
            else if (userSsd > adminCluster.getClssd()) {
                projectTools.clearConsole();
                System.out.println("ERROR: Not enough resources available on the cluster!");
                Thread.sleep(3000);
                continue;
            }

            break;
        }
    }

    private void setUserGpu() throws InterruptedException {
        //GPU
        while (true) {
            inputChecker = null;
            userGpu = null;
            exitCheck = false;

            projectTools.clearConsole();
            System.out.print("Enter number of GPUs to assign or Q to cancel: ");
            inputChecker = oneScanner.next();
            oneScanner.nextLine();

            if (inputChecker.equalsIgnoreCase("q")) {
                exitCheck = true;
                break;
            }
            else {
                try {
                    userGpu = Integer.parseInt(inputChecker);
                } catch (Exception e) {
                    projectTools.clearConsole();
                    System.out.println("ERROR: Invalid input!");
                    Thread.sleep(3000);
                    continue;
                }
            }
            if (userGpu <= 0) {
                projectTools.clearConsole();
                System.out.println("ERROR: GPUs are required!");
                Thread.sleep(3000);
                continue;
            }
            else if (userGpu > adminCluster.getClgpu()) {
                projectTools.clearConsole();
                System.out.println("ERROR: Not enough resources available on the cluster!");
                Thread.sleep(3000);
                continue;
            }

            break;
        }
    }

    private void setUserBandwidth() throws InterruptedException {
        //Bandwidth
        while (true) {
            inputChecker = null;
            userBandwidth = null;
            exitCheck = false;

            projectTools.clearConsole();
            System.out.print("Enter the amount of bandwidth rate to assign or Q to cancel: ");
            inputChecker = oneScanner.next();
            oneScanner.nextLine();

            if (inputChecker.equalsIgnoreCase("q")) {
                exitCheck = true;
                break;
            }
            else {
                try {
                    userBandwidth = Integer.parseInt(inputChecker);
                } catch (Exception e) {
                    projectTools.clearConsole();
                    System.out.println("ERROR: Invalid input!");
                    Thread.sleep(3000);
                    continue;
                }
            }
            if (userBandwidth <= 0) {
                projectTools.clearConsole();
                System.out.println("ERROR: Bandwidth is required!");
                Thread.sleep(3000);
                continue;
            }
            else if (userBandwidth > adminCluster.getClbandwidth()) {
                projectTools.clearConsole();
                System.out.println("ERROR: Not enough resources available on the cluster!");
                Thread.sleep(3000);
                continue;
            }

            break;
        }
    }

    public String reportCluster() {
        String report = "------- ~Cluster~ -------"+"\n"+
        "\u001B[34m"+" CPU Cores: "+adminCluster.getClcpu()+"\n"+
        " RAM: "+adminCluster.getClram()+" GB"+"\n"+
        " SSD: "+adminCluster.getClssd()+" GB"+"\n"+
        " GPUs: "+adminCluster.getClgpu()+"\n"+
        " Bandwidth: "+adminCluster.getClbandwidth()+" Gb/sec"+"\u001B[0m\n"+
        "-------------------------\n";
        return report;
    }

    public VM findVmById(Integer vmId) {
        for (VM vm : ClusterResources.vmArray) {
            if (vm.getVmid().equals(vmId)) {
                return vm;
            }
        }
        return null;
    }

    public void reportVm() throws InterruptedException {
        while (true) {
                inputChecker = null;
                tempVmId = null;

                projectTools.clearConsole();
                System.out.print("Enter the ID of the VM you'd like to report, enter A to report all VMs or Q to cancel: ");
                inputChecker = oneScanner.next();
                oneScanner.nextLine();

                if (inputChecker.equalsIgnoreCase("a")) {
                    projectTools.clearConsole();
                    System.out.println("-----------------\n Total VM Report\n-----------------\n\n");
                    for (VM element : ClusterResources.vmArray) {
                        try {
                            element.printVmReport();
                            System.out.println("---------------");
                            System.out.println("\n");
                        } catch (Exception e) {
                            System.out.println("ERROR: Cannot print VM(s)!");
                            Thread.sleep(3000);
                            break;
                        }
                    }
                    
                    System.out.print("Press Enter to continue...");
                    oneScanner.nextLine();
                    continue;
                }
                else if (inputChecker.equalsIgnoreCase("q")) {
                    break;
                }
                else {
                    try {
                        tempVmId = Integer.parseInt(inputChecker);
                    } catch (Exception e) {
                        projectTools.clearConsole();
                        System.out.println("ERROR: Invalid input!");
                        Thread.sleep(3000);
                        continue;
                    }
                }
                if (findVmById(tempVmId) == null) {
                    projectTools.clearConsole();
                    System.out.println("This VM ID does not exist!");
                    Thread.sleep(3000);
                    continue;
                }
                else {
                    switch (findVmById(tempVmId).getVmType()) {
                        case "PlainVM":
                            projectTools.clearConsole();
                            ((PlainVM) findVmById(tempVmId)).printVmReport();
                            System.out.println("---------------");
                            System.out.print("\nPress Enter to continue...\n");
                            oneScanner.nextLine();
                            continue;
                        
                        case "VmGPU":
                            projectTools.clearConsole();
                            ((VmGPU) findVmById(tempVmId)).printVmReport();
                            System.out.println("---------------");
                            System.out.print("\nPress Enter to continue...\n");
                            oneScanner.nextLine();
                            continue;

                        case "VmNetworked":
                            projectTools.clearConsole();
                            ((VmNetworked) findVmById(tempVmId)).printVmReport();
                            System.out.println("---------------");
                            System.out.print("\nPress Enter to continue...\n");
                            oneScanner.nextLine();
                            continue;

                        case "VmNetworkedGPU":
                            projectTools.clearConsole();
                            ((VmNetworkedGPU) findVmById(tempVmId)).printVmReport();
                            System.out.println("---------------\n");
                            System.out.print("\nPress Enter to continue...");
                            oneScanner.nextLine();
                            continue;

                        default:
                            projectTools.clearConsole();
                            System.out.println("Invalid VM type!");
                            Thread.sleep(3000);
                            continue;
                    }
                }
            }
    }

    public void displayVmArray() {
        System.out.println("-- ~Currently active Virtual Machines~ --");
        if (ClusterResources.vmArray.isEmpty()) {
            System.out.print(" No Virtual Machines have been created! ");
        }else{ 
            for (VM element : ClusterResources.vmArray) {
                System.out.print(" |VM"+element.getVmid()+"| ");
            }
        }
    }
}
