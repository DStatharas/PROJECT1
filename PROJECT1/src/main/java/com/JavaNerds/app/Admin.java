package com.JavaNerds.app;

import java.util.Scanner;

public class Admin{
    private ClusterResources cluster = new ClusterResources(128, 256, 2048, 8, 320);

    Scanner oneScanner = new Scanner(System.in);

    private Integer userVmType;
    private Integer userCpu;
    private Integer userRam;
    private Integer userSsd;
    private Integer userGpu;
    private Integer userBandwidth;
    private String[] userOs = {"WINDOWS", "UBUNTU", "FEDORA"};
    private Boolean loopEnd1;
    private Boolean loopEnd2;
    
    public void createVM() {
        do {
            loopEnd1 = true;  

            while (loopEnd2 == false) {
                try {
                    userVmType = oneScanner.nextInt();
                    oneScanner.nextLine();
                    loopEnd2 = true;
                } catch (Exception e) {
                    System.out.println("ERROR: Input is not a numerical value!");
                    oneScanner.nextLine();
                    loopEnd2 = false;
                }
            }

            switch (userVmType) {
                //REMINDER: VMs also need user input for OS
                case 1:
                    //PlainVM
                    ClusterResources.vmArray.add(new PlainVM(ClusterResources.vmArray.size()+1, userCpu, userRam, userSsd));
                    break;
            
                case 2:
                    //VmGPU
                    ClusterResources.vmArray.add(new VmGPU(ClusterResources.vmArray.size()+1, userCpu, userRam, userSsd, userGpu));
                    break;

                case 3:
                    //VmNetworked
                    ClusterResources.vmArray.add(new VmNetworked(ClusterResources.vmArray.size()+1, userCpu, userRam, userSsd, userBandwidth));
                    break;

                case 4:
                    //VmNetworkedGPU
                    ClusterResources.vmArray.add(new VmNetworkedGPU(ClusterResources.vmArray.size()+1, userCpu, userRam, userSsd, userGpu, userBandwidth));
                    break;
                
                case 0:
                    //exit VM creation
                    break;

                default:
                    //Invalid VM Type
                    loopEnd1 = false;
                    break;
            }
        } while (loopEnd1 == true);
    }


    // public void deleteVm(){

    // }

}
