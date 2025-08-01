class Solution {
    public int compareVersion(String version1, String version2) {
        String ver1[]=version1.split("\\.");
        String ver2[]=version2.split("\\.");

        int smallest=ver1.length>ver2.length? ver2.length:ver1.length;

        for(int i=0;i<smallest;i++){
            if((Integer.parseInt(ver1[i]))>(Integer.parseInt(ver2[i]))){
                return 1;
            }else if((Integer.parseInt(ver1[i]))<(Integer.parseInt(ver2[i]))){
                return -1;
            }
        }while(smallest<ver1.length){
            if(Integer.parseInt(ver1[smallest])>0){
                return 1;
                
            }smallest++;
        }
        while(smallest<ver2.length){
            if(Integer.parseInt(ver2[smallest])>0){
                return -1;
                
            }smallest++;
        }
        return 0;
        
    }
}