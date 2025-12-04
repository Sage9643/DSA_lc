class Solution {
    public String rankTeams(String[] votes) {
        int n=votes[0].length();
        HashMap<Character,int[]> map=new HashMap<>();
        
        for (String v:votes){
            for(int i=0;i<v.length();i++){
                char ch=v.charAt(i);
                if(!map.containsKey(ch)) map.put(ch,new int[n]);
                map.get(ch)[i]++;
            }
        }
        List<Character> teams=new ArrayList<>(map.keySet());

        Collections.sort(teams,(a,b)->{
            int[] A=map.get(a);
            int[] B=map.get(b);
            
            for (int i=0;i<n;i++){
                if(A[i]!=B[i]) return B[i] - A[i];
            }
            return a-b;
        });
        StringBuilder sb=new StringBuilder();
        for(char c:teams) sb.append(c);
        
        return sb.toString();
    }
}
