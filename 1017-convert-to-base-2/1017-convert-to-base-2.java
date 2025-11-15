class Solution {
    public String baseNeg2(int n) {
        if(n==0) return "0";
        StringBuilder sb=new StringBuilder();

        if(n%2!=0){
            
            while(n!=1 && n!=-1){
                int rem=n%-2;
                if(rem==-1){
                    sb.append("1");
                    n=(n/-2)+1;
                }else if(rem==0){
                    sb.append("0");
                    n/=-2;
                }else {
                    sb.append("1");
                    n/=-2;
                }
            }if(n==-1) sb.append("11");
            else sb.append("1");
        }else{
            int details[]=pow2(n);
            //power of 2
            if(details[0]==1){
                for(int i=0;i<details[1];i++) sb.append("0");
                sb.append("1");
                //odd pow of 2
                if(details[1]%2!=0){
                    sb.append("1");
                }
            }//not a pow of 2
            else{
                while(n!=-1 && n!=1){
                    int rem=n%-2;
                    if(rem==-1){
                        sb.append("1");
                        n=(n/-2)+1;
                    }else if(rem==0){
                        sb.append("0");
                        n/=-2;
                    }else {
                        sb.append("1");
                        n/=-2;
                    }
                }if(n==-1) sb.append("11");
                else sb.append("1");
            }
        }return sb.reverse().toString();
    }
    public static int[] pow2(int n){
        int idx=-1;
        int setbit=0;
        for(int i=0;i<32;i++){
            if(((n & (1<<i)))!=0){ setbit++;idx=i;}
        }return new int[]{setbit,idx};
    }

}