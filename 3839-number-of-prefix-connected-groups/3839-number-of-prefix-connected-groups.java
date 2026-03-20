class Solution {
    public int prefixConnected(String[] words, int k) {
        Arrays.sort(words);

        String s="";
        if(words[0].length()>=k) s=words[0].substring(0,k);

        int cnt=1;
        int ans=0;

        for(int i=1;i<words.length;i++){
            if(words[i].length()<k) continue;
            String sub=words[i].substring(0,k);
        
            if(!s.equals(sub)){
                if(cnt>1) ans++;
                s=sub;
                cnt=0;
            }
            cnt++;
        
        }if(cnt>1) ans++;

        return ans;
    }
}