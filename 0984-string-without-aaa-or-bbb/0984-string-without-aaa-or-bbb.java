class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb=new StringBuilder();
        int max=a>b?a:b;
        int min=a>=b?b:a;
        String maxl="",minl="";
        if(max==a){
            maxl="a";minl="b";
        }else{
            maxl="b";minl="a";
        }
        while(max>min && max>1 && min>0){
            sb.append(maxl);sb.append(maxl);sb.append(minl);
            max-=2;min--;
        }while(max>0 || min>0){
            if(min>0){
                sb.append(minl);min--;
            }if(max>0){
                sb.append(maxl);max--;
            }
        }return sb.toString();
    }
}