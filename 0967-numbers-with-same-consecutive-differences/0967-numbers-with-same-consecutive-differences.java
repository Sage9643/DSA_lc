class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=1;i<10;i++){
            valid(n,1,ans,i,k);
        }int res[]=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            res[i]=ans.get(i);
        }return res;
    }
    public static void valid(int n,int dig,ArrayList<Integer> ans,int num,int k){
        if(n==dig){
            ans.add(num);
            return;
        }
        if(((num%10)+k)<=9){
            valid(n,dig+1,ans,(num*10)+((num%10)+k),k);
        }if(k!=0 && ((num%10)-k)>=0){
            valid(n,dig+1,ans,(num*10)+((num%10)-k),k);
        }
    }
}