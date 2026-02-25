class Solution {
    static List<String> ans;
    public List<String> letterCasePermutation(String s) {
        ans=new ArrayList<>();
        dfs(0,s,new StringBuilder());
        return ans;
        
    }public static void dfs(int i,String s,StringBuilder sb){
        if(i==s.length()){
            ans.add(new String(sb));
            return;
        }

        if(s.charAt(i)=='0' || s.charAt(i)=='1' || s.charAt(i)=='2' || s.charAt(i)=='3' || s.charAt(i)=='4' || s.charAt(i)=='5' || s.charAt(i)=='6' || s.charAt(i)=='7' || s.charAt(i)=='8' || s.charAt(i)=='9'){
            sb.append(s.charAt(i));
            dfs(i+1,s,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        else{
            char ch=s.charAt(i);
            sb.append(ch);
            dfs(i+1,s,sb);
            sb.deleteCharAt(sb.length()-1);
            sb.append((char)(ch^' '));
            dfs(i+1,s,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}