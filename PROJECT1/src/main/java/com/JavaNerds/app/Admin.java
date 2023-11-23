package com.JavaNerds.app;

public class Admin{
    private ClusterResources cluster = new ClusterResources(128, 256, 2048, 8, 320);

    public void createVM(Integer vmType){
        switch (vmType) {
            case 1:
                //PlainVM

                break;
        
            case 2:
                //VmGPU

                break;

            case 3:
                //VmNetworked

                break;

            case 4:
                //VmNetworkedGPU

                break;

            default:
                //Invalid VM Type
                
                break;
        }
    }


    public void deleteVm(){

    }

}
