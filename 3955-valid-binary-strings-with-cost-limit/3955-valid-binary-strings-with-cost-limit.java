class Solution {
    public List<String> generateValidStrings(int n, int k) {
        List<String> ans=new ArrayList<>();
        dfs(ans,new StringBuilder(),n,k,0);
        return ans;
    }
    public static void dfs(List<String> ans, StringBuilder sb,int n,int k,int cost){
        if(sb.length()==n){
            String str=sb.toString();
            ans.add(str);
            return;
        }
        if(sb.length()==0){
            sb.append('0');
            if(cost<=k) dfs(ans,sb,n,k,cost);
            sb.deleteCharAt(sb.length()-1);

            sb.append('1');
            if(cost+sb.length()-1<=k) dfs(ans,sb,n,k,cost+sb.length()-1);
            sb.deleteCharAt(sb.length()-1);
        }
        else{
            if(sb.charAt(sb.length()-1)=='0'){
                sb.append('0');
                if(cost<=k) dfs(ans,sb,n,k,cost);
                sb.deleteCharAt(sb.length()-1);

                sb.append('1');
                if(cost+sb.length()-1<=k) dfs(ans,sb,n,k,cost+sb.length()-1);
                sb.deleteCharAt(sb.length()-1);
            }else{
                sb.append('0');
                if(cost<=k) dfs(ans,sb,n,k,cost);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}