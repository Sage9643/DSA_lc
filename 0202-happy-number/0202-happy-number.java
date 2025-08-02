class Solution {
    public boolean isHappy(int n) {
        if(n==1)return true;

        HashSet<Integer> set=new HashSet<>();
        while(n!=1){
            if(set.contains(n))return false;
            else{
                set.add(n);
                int num=0;
                while(n!=0){
                    num+=(n%10)*(n%10);
                    n=n/10;
                }n=num;
            }
        }return true;
    }
}