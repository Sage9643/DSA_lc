class Solution {
    public boolean uniformArray(int[] nums1) {
        boolean o=true;
        boolean e=true;

        Arrays.sort(nums1);
        if(nums1[0]%2!=0) e=false;
        if(nums1[0]%2==0) o=false;
        int min=nums1[0];
        
        for(int i=1;i<nums1.length;i++){
            if(nums1[i]%2==0){
                if(min%2==0) o=false;   
            }else{
                if(min%2==0){
                    e=false;
                }min=nums1[i];  
                
            }
        }return o || e;
    }
}
    
