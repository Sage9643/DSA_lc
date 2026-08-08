class Solution {
    public int[] validSequence(String word1, String word2) {

        int suf[]=new int[word2.length()];

        Arrays.fill(suf,-1);

        int i=word1.length()-1;
        int j=word2.length()-1;

        while(j>=0 && i>=0){
            while(i>=0 && word1.charAt(i)!=word2.charAt(j)) i--;

            if(i<0) break;

            suf[j]=i--;
            j--;
        }

        int ans[]=new int[word2.length()];
        int idx=0;
        boolean rep=true;

        for(i=0,j=0;i<word1.length() && j<word2.length() ;i++){

            if(word1.charAt(i)==word2.charAt(j)){
                ans[idx++]=i;
                j++;
            }
            else{

                boolean possible=false;

                if(rep){
                    if(j==word2.length()-1 || (suf[j+1]!=-1 && suf[j+1]>i)){
                        possible=true;
                    }
                }
                if(possible){
                    rep=false;
                    ans[idx++]=i;
                    j++;
                }

            }
            
        }if(idx<=word2.length()-1) return new int[0];
        
        return ans;


        
    }
}