class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<26;i++) {
            Character ch=(char)('a'+i);
            set.add(ch);
        }List<Boolean> ans=new ArrayList<>();

        for(String query:queries){
            int i=0,j=0; boolean valid=true;
            while(i<query.length() && j<pattern.length()){
                if(pattern.charAt(j)==query.charAt(i)) j++;
                else if((pattern.charAt(j)!=query.charAt(i)) && !set.contains(query.charAt(i))){
                    ans.add(false);valid=false;break;
                }i++;
            }while(valid && i<query.length()){
                if(!set.contains(query.charAt(i))){
                    ans.add(false);valid=false;break;
                }i++;
            }if(valid && j>=pattern.length()) ans.add(true);
            else if(valid && j<pattern.length()) ans.add(false);
        }
        return ans;
    }
}