class Solution {
    public int maxProduct(String[] words) {
        int[][] freqarr=new int[words.length][26];
        int idx=0;
        for(String word:words){
            freqarr[idx]=freq(word);
            idx++;
        }
        int prod=0;

        for(int i=0;i<freqarr.length;i++){
            for(int j=i+1;j<freqarr.length;j++){
                boolean same=false;
                for(int k=0;k<26;k++){
                    if(freqarr[i][k]>0 && freqarr[j][k]>0) same=true;
                }
                if(!same) prod=Math.max(prod,words[i].length()*words[j].length());
            }
        }return prod; 
    }
    public int[] freq(String word){
        int freqarr[]=new int[26];
        for(char ch:word.toCharArray()){
            freqarr[ch-'a']++;
        }return freqarr;
    }
}