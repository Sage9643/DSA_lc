class Solution {
    public int maxFreqSum(String s) {
        int arr[]=new int[26];
        for(char ch:s.toCharArray()){
            arr[ch-'a']++;
        }
        int con=0;int vow=0;

        for(int i=0;i<arr.length;i++){
            if(i==0||i==4||i==8||i==14||i==20){
                if(arr[i]>vow) vow=arr[i];
            }else{
                if(arr[i]>con) con=arr[i];
            }
        }return con+vow;
    }
}