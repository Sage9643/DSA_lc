class Solution {
    public int maxSumDivThree(int[] nums) {
        ArrayList<Integer> rem1=new ArrayList<>();
        ArrayList<Integer> rem2=new ArrayList<>();

        int sum=0;
        for(int num:nums){
            sum+=num;

            if(num%3==1) rem1.add(num);
            else if(num%3==2) rem2.add(num);
        }
        int rem=sum%3;

        if(rem==0) return sum;
        Collections.sort(rem1);
        Collections.sort(rem2);
        

        if(rem==1){
            int el1=rem1.size()>=1?rem1.get(0):Integer.MAX_VALUE;
            int el2=rem2.size()>=2?(rem2.get(0)+rem2.get(1)):Integer.MAX_VALUE;

            sum=sum-Math.min(el1,el2);
        }if(rem==2){
            int el3=rem2.size()>=1?rem2.get(0):Integer.MAX_VALUE;
            int el4=rem1.size()>=2?(rem1.get(0)+rem1.get(1)):Integer.MAX_VALUE;

            sum=sum-Math.min(el3,el4);
        }return sum;
    }
}