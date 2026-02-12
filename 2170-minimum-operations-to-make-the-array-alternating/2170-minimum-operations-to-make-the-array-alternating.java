class Solution {
    public int minimumOperations(int[] nums) {
        HashMap<Integer,Integer> even = new HashMap<>();
        HashMap<Integer,Integer> odd = new HashMap<>();

        for(int i=0; i<nums.length;i++){
            if(i%2==0) even.put(nums[i],even.getOrDefault(nums[i],0)+1);
            
            else odd.put(nums[i],odd.getOrDefault(nums[i],0)+1);
        }
        int evenmax1=0,evenmax2=0;
        int evenval1=-1,evenval2=-1;

        for (int key:even.keySet()) {
            int val=key;
            int freq=even.get(key);

            if(freq>evenmax1){
                evenmax2=evenmax1;
                evenval2=evenval1;

                evenmax1=freq;
                evenval1=val;
            }else if(freq>evenmax2){
                evenmax2=freq;
                evenval2=val;
            }
        }
        int oddmax1=0,oddmax2=0;
        int oddval1=-1,oddval2=-1;

        for (int key:odd.keySet()){
            int val=key;
            int freq=odd.get(key);

            if(freq>oddmax1){
                oddmax2=oddmax1;
                oddval2=oddval1;

                oddmax1=freq;
                oddval1=val;
            }else if(freq>oddmax2){
                oddmax2=freq;
                oddval2=val;
            }
        }
        int n=nums.length;
        int evencnt=(n+1)/2;
        int oddcnt=n/2;

        if(evenval1!=oddval1) {
            return (evencnt-evenmax1)+(oddcnt-oddmax1);
        } 
        return Math.min((evencnt-evenmax1)+(oddcnt-oddmax2),(evencnt-evenmax2)+(oddcnt-oddmax1));
        
    }
}
