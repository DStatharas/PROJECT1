package com.JavaNerds.app;

import java.util.Scanner;

public class Admin{
    
    ClusterResources adminCluster = ClusterResources.getInstance();

    Scanner oneScanner = new Scanner(System.in);

    private String inputChecker = null;
    private Integer userVmType = null;
    private Integer userCpu = null;
    private Integer userRam = null;
    private Integer userSsd = null;
    private Integer userGpu = null;
    private Integer userBandwidth = null;
    private Integer userOs = null;
    private Integer tempVmId = null;
    
    public void createVM() {
        mloop:
        while (true) {
            inputChecker = null;
            userVmType = null;
            userCpu = null;
            userRam = null;
            userSsd = null;
            userGpu = null;
            userBandwidth = null;
            userOs = null;

            //add more verbose requirements for the user
            System.out.println("Please select one of the following numbers to choose the type of Virtual Machine you would like to create, or type Q to cancel VM creation."+"\n"+"1: Plain VM"+"\n"+"2: GPU VM"+"3: Networked VM"+"\n"+"4: Networked GPU VM"+"\n"+"Q: Cancel");
            inputChecker = oneScanner.next();
            oneScanner.nextLine();
            if (inputChecker.equalsIgnoreCase("q")) {
                break mloop;
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
                    ploop:
                    while (true) {

                        //OS
                        while (true) {
                            System.out.println("Choose an OS:"+"\n"+"1: Windows"+"\n"+"2: Ubuntu"+"\n"+"3: Fedora"+"\n"+"Q: Cancel");
                            inputChecker = oneScanner.next();
                            oneScanner.nextLine();
                            if (inputChecker.equalsIgnoreCase("q")) {
                                break ploop;
                            }
                            else {
                                try {
                                    userOs = Integer.parseInt(inputChecker);
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
                        
                        //CPU
                        while (true) {
                            System.out.println("Enter number of desired CPU cores or Q to cancel:");
                            inputChecker = oneScanner.next();
                            oneScanner.nextLine();

                            if (inputChecker.equalsIgnoreCase("q")) {
                                break ploop;
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
                            else if (userCpu > adminCluster.getClcpu()) {
                                System.out.println("Not enough resources available on the cluster!");
                                continue;
                            }

                            break;
                        }

                        //RAM
                        while (true) {
                            System.out.println("Enter number of desired GB of RAM or Q to cancel:");
                            inputChecker = oneScanner.next();
                            oneScanner.nextLine();

                            if (inputChecker.equalsIgnoreCase("q")) {
                                break ploop;
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

                        //SSD
                        while (true) {
                            System.out.println("Enter number of desired GB of SSD storage or Q to cancel:");
                            inputChecker = oneScanner.next();
                            oneScanner.nextLine();

                            if (inputChecker.equalsIgnoreCase("q")) {
                                break ploop;
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
                            else if (userSsd > adminCluster.getClssd()) {
                                System.out.println("Not enough resources available on the cluster!");
                                continue;
                            }

                            break;
                        }

                        adminCluster.setClcpu(adminCluster.getClcpu()-userCpu);
                        adminCluster.setClram(adminCluster.getClram()-userRam);
                        adminCluster.setClssd(adminCluster.getClssd()-userSsd);                        

                        ClusterResources.vmArray.add(new PlainVM(userOs, userCpu, userRam, userSsd));
                        break;
                    }
            
                case 2:
                    //VmGPU
                    ClusterResources.vmArray.add(new VmGPU(userOs, userCpu, userRam, userSsd, userGpu));
                    break;

                case 3:
                    //VmNetwork ed
                    ClusterResources.vmArray.add(new VmNetworked(userOs, userCpu, userRam, userSsd, userBandwidth));
                    break;

                case 4:
                    //VmNetworkedGPU
                    ClusterResources.vmArray.add(new VmNetworkedGPU(userOs, userCpu, userRam, userSsd, userGpu, userBandwidth));
                    break;

                default:
                    //Invalid VM Type
                    System.out.println("Please choose a valid type of Virtual Machine!");
                    continue;
            }
        }
    }

    //hashmap (or something) return type
    private void addResources() {
                
    }

    public void deleteVm(){
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
            
            try {
                ClusterResources.vmArray.remove(tempVmId-1);
            } catch (Exception e) {
                System.out.println("This VM id does not exist!");
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

}
