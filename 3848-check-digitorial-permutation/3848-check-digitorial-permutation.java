class Solution {
    public boolean isDigitorialPermutation(int n) {
        int fact=1;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);

        for(int i=1;i<=9;i++){
            fact*=i;
            map.put(i,fact);
        }int sum=0;
        int num=n;

        HashMap<Integer,Integer> dig=new HashMap<>();

        while(num!=0){
            int rem=num%10;
            sum+=map.get(rem);
            dig.put(rem,dig.getOrDefault(rem,0)+1);
            num/=10;
        }if(sum==n) return true;
        while(sum!=0){
            int rem=sum%10;
            if(!dig.containsKey(rem)) return false;
            dig.put(rem,dig.get(rem)-1);
            if(dig.get(rem)==0) dig.remove(rem);
            sum/=10;
        }if(dig.isEmpty()) return true;


        return false;
    }
}