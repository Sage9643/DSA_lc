class Solution {
    public int numTilePossibilities(String tiles) {
        HashSet<String> set=new HashSet<>();
        boolean vis[]=new boolean[tiles.length()];
        permutation(set,tiles,new StringBuilder(),vis);
        return set.size();
    }public static void permutation(HashSet<String> set,String tiles,StringBuilder sb,boolean[] vis){
        if(sb.length()>0) set.add(sb.toString());

        for(int i=0;i<tiles.length();i++){
            if(vis[i]) continue;
            else{
                vis[i]=true;
                permutation(set,tiles,sb.append(tiles.charAt(i)),vis);
                sb.deleteCharAt(sb.length()-1);
                vis[i]=false;
            }
        }
    }
}