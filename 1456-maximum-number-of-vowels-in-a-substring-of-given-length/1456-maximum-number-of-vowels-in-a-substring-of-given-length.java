class Solution {
    public int maxVowels(String s, int k) {
        int count=0;
        int i=0;
        for(;i<k;i++){
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u') count++;
        }
        int max=count;
        for(int j=i;j<s.length();j++){
            if(s.charAt(j)=='a' || s.charAt(j)=='e' || s.charAt(j)=='i' || s.charAt(j)=='o' || s.charAt(j)=='u') count++;
            if(s.charAt(j-k)=='a' || s.charAt(j-k)=='e' || s.charAt(j-k)=='i' || s.charAt(j-k)=='o' || s.charAt(j-k)=='u') count--;
            max=Math.max(max,count);
        }return max;
    }
}