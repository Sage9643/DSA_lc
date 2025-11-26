class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int q[]=freq(queries);
        int w[]=freq(words);
        int max=0;
        for(int num:w) max=Math.max(num,max);

        int ans[]=new int[queries.length];
        int psum[]=new int[max+1];
        for(int num:w) psum[num]++;
        int next1=0,next2=psum[psum.length-1];psum[psum.length-1]=0;

        for(int i=psum.length-2;i>=0;i--){
            int prev=psum[i];
            psum[i]=next1+next2;
            next1=prev;
            next2=psum[i];
        }int idx=0;
        for(int qry:q){
            if(qry<psum.length)ans[idx++]=psum[qry];
            else ans[idx++]=0;
        }return ans;    
    }
    public int[] freq(String arr[]){
        int ans[]=new int[arr.length];
        int idx=0;

        for(String s:arr){
            int freq[]=new int[26];
            for(char ch:s.toCharArray()) freq[ch-'a']++;
            for(int i=0;i<26;i++){
                if(freq[i]>0){ 
                    ans[idx++]=freq[i];
                    break;
                }
            }
        }return ans;
    }
}