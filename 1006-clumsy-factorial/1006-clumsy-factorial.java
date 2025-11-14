class Solution {
    public int clumsy(int n) {
        /*operations denotion:
        0=multiply,1=divide,2=add,3=subtract*/
        int op=0;
        Stack<Integer> s=new Stack<>();
        s.push(n);

        for(int i=n-1;i>0;i--){
            if(op==0){
                int el=s.pop();
                s.push(el*i);
            }else if(op==1){
                int el=s.pop();
                s.push(el/i);
            }else if(op==2){
                s.push(i);
            }else s.push(-i);
            op=(op+1)%4;
        }
        int ans=0;
        
        while(!s.isEmpty()) ans+=s.pop();
        return ans;

    }
}