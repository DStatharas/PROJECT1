package com.JavaNerds.app;

import java.util.Scanner;

public class Admin{
    private ClusterResources cluster = new ClusterResources(128, 256, 2048, 8, 320);

    Scanner oneScanner = new Scanner(System.in);

    private String inputChecker = null;
    private Integer userVmType = null;
    private Integer userCpu = null;
    private Integer userRam = null;
    private Integer userSsd = null;
    private Integer userGpu = null;
    private Integer userBandwidth = null;
    private Integer userOs = null;
    
    public void createVM() {
        mloop:
        do {
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
                            else if (userCpu > ClusterResources.getClcpu()) {
                                System.out.println("Not enough resources available!");
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
                            else if (userRam > ClusterResources.getClcpu()) {
                                System.out.println("Not enough resources available!");
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
                            else if (userSsd > ClusterResources.getClcpu()) {
                                System.out.println("Not enough resources available!");
                                continue;
                            }
                            break;
                        }

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
        } while (true);
    }

    //hashmap (or something) return type
    private void addResources() {
        
    }

    // public void deleteVm(){

    // }

}
