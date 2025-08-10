class Solution {
    public boolean reorderedPowerOf2(int n) {
        String num=Integer.toString(n);
        return permutation(num,"",num.length());
    }
    public static boolean permutation(String num,String permutation,int len){

        if(num.length()==0){
            int number=Integer.parseInt(permutation);
            if(len==Integer.toString(number).length()){  
                return (number & (number-1))==0;
            }
        }
        for(int i=0;i<num.length();i++){
            char ch=num.charAt(i);
            String rem=num.substring(0,i)+num.substring(i+1);
            if(permutation(rem,permutation+ch,len)){
                return true;
            }
        }return false;
    }
}