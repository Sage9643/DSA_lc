class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int[][] psum=new int[s.length()][26];
        psum[0][s.charAt(0)-'a']++;
        int idx=1;
        while(idx<s.length()){
            int[] prev=psum[idx-1].clone();
            prev[s.charAt(idx)-'a']++;
            psum[idx]=prev;
            idx++;
        }
        List<Boolean> ans=new ArrayList<>();
        idx=0;
        for(int[] q:queries){
            int res[]=new int[26];
            if(q[0]==0) res=psum[q[1]];
            else{
                int prev[]=psum[q[0]-1];
                int next[]=psum[q[1]];

                for(int i=0;i<26;i++){
                    res[i]=next[i]-prev[i];
                }
            }int countodd=0;
            for(int r:res){
                if(r%2!=0) countodd++;
            }if(q[2]>=(countodd/2)) ans.add(true);
            else ans.add(false);
            idx++;
        }return ans;
    }
}