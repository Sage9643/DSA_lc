class Solution {
    public int sumFourDivisors(int[] nums) {
        HashMap<Integer,info> map=new HashMap<>();
        for(int num:nums){
            if(!map.containsKey(num)){
                info i=div(num);
                map.put(num,i);
            }
        }int sum=0;

        for(int num:nums){
            int noOfDiv=map.get(num).div;
            if(noOfDiv==4) sum+=map.get(num).sum;
        }return sum;
        
    }
    public static info div(int num){
        HashSet<Integer> set=new HashSet<>();
        int div=0;
        int sum=0;

        for(int i=1;i<=(int)Math.sqrt(num);i++){
            if(num%i==0){
                if(!set.contains(i)) {sum+=i;div++;}
                set.add(i);
            }
        }
        for(int i:set){
            int d=num/i;
            if(!set.contains(d)) {div++;sum+=d;}
        }
        return new info(div,sum);
    }
}class info{
    int div;
    int sum;
    info(int div,int sum){
        this.div=div;
        this.sum=sum;
    } 
}