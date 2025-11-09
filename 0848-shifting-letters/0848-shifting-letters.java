class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        char arr[]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        shifts[shifts.length-1]=shifts[shifts.length-1]%26;
        for(int i=shifts.length-2;i>=0;i--){
            shifts[i]=shifts[i]%26+shifts[i+1];
        } 
        StringBuilder sb=new StringBuilder();
        int i=0;

        for(char ch:s.toCharArray()){
            int increment=((ch-97)+shifts[i])%26;
            sb.append(arr[increment]);i++;
        }return sb.toString();
    }
}