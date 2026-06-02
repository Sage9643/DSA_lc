class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int v=colors.length();

        ArrayList<Integer> graph[]=new ArrayList[v];
        for(int i=0;i<v;i++) graph[i]=new ArrayList<>();

        int indegree[]=new int[v];

        for(int e[]:edges){
            indegree[e[1]]++;
            graph[e[0]].add(e[1]);
        }

        int col[][]=new int[v][26];
        int ans=0;
        int cnt=0;

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<v;i++){
            if(indegree[i]==0){
                q.add(i);
                col[i][colors.charAt(i)-'a']=1;
            }
        }while(!q.isEmpty()){
            int curr=q.remove();
            ans=Math.max(ans,col[curr][colors.charAt(curr)-'a']);
            cnt++;

            for(int i=0;i<graph[curr].size();i++){
                int neigh=graph[curr].get(i);
                char color=colors.charAt(neigh);

                for(int j=0;j<26;j++){
                    char ch=(char)('a'+j);
                    col[neigh][j]=Math.max(col[curr][j]+(color==ch?1:0),col[neigh][j]);
                }
                indegree[neigh]--;

                if(indegree[neigh]==0) q.add(neigh);
            }
        }if(cnt!=v) return -1;
        return ans;


    }
}