class Solution {
    static HashSet<String> set;
    public List<Integer> grayCode(int n) {
        set=new HashSet<>();
        List<Integer> ans=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++) sb.append('0');
        backtrack(sb,ans,n);

        return ans;
    }
    public static void backtrack(StringBuilder sb,List<Integer> ans,int n){
        int num=Integer.parseInt(sb.toString(),2);
        set.add(sb.toString());
        ans.add(num);

        for(int i=0;i<n;i++){
            char ch=sb.charAt(i);
            if(ch=='0') sb.setCharAt(i,'1');
            else sb.setCharAt(i,'0');
            if(!set.contains(sb.toString())) backtrack(sb,ans,n);

            sb.setCharAt(i,ch);
        }
    }
}