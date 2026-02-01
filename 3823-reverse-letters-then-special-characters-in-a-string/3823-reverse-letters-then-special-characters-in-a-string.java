class Solution {
    public String reverseByType(String s) {
        HashSet<Character> set=new HashSet<>();
        char ch='a';
        for(int i=0;i<26;i++) set.add((char)(ch+i));

        ArrayList<Character> l=new ArrayList<>();
        ArrayList<Character> st=new ArrayList<>();

        for(char c:s.toCharArray()){
            if(set.contains(c))l.add(c);
            else st.add(c);
        }
        StringBuilder sb=new StringBuilder();

        int k=l.size()-1;
        int j=st.size()-1;
        for(char c:s.toCharArray()){
            if(set.contains(c)) {sb.append(l.get(k));k--;}
            else {sb.append(st.get(j));j--;}
        }return sb.toString();
        

        
    }
}