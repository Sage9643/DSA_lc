class Solution {
    public int[] closestDivisors(int num) {
        int diff=Integer.MAX_VALUE;
        int arr[]=new int[2];

        for(int i=1;i<=(int)Math.sqrt(num+2);i++){
            if((num+2)%i==0){
                int div=(num+2)/i;
                if(Math.abs(div-i)<diff){
                    diff=Math.abs(div-i);
                    arr[0]=div;arr[1]=i;
                }
            }if((num+1)%i==0){
                int div=(num+1)/i;
                if(Math.abs(div-i)<diff){
                    diff=Math.abs(div-i);
                    arr[0]=div;arr[1]=i;
                }
            }
        }return arr;
    }
}