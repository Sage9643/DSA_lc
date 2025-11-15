class Solution {
    public boolean queryString(String s, int n) {
        HashSet<String> set=new HashSet<>();


        for(int i=0;i<s.length();i++){
            StringBuilder sb=new StringBuilder();
            for(int j=i;j<s.length();j++){
                sb.append(s.charAt(j));
                set.add(sb.toString());
            }
        }for(int i=1;i<=n;i++){
            if(!set.contains(Integer.toBinaryString(i))) return false;
        }return true;
    }
}