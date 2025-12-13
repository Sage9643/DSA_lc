class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        ArrayList<ArrayList<String>> bline=new ArrayList<>();
        for(int i=0;i<4;i++) bline.add(new ArrayList<>());

        HashSet<Character> set=new HashSet<>();
        set.add('_');
        for(int i=0;i<26;i++){
            if(i<10) set.add((char)('0'+i));
            set.add((char)('a'+i)); 
            set.add((char)('A'+i)); 
        }

        List<String> ans=new ArrayList<>();

        for(int i=0;i<isActive.length;i++){
            if(isActive[i]){
                boolean valid=true;
                for(char ch:code[i].toCharArray()){
                    if(!set.contains(ch)) valid=false;
                }if(code[i].length()>0 && valid && (businessLine[i].equals("electronics") || businessLine[i].equals("pharmacy") || businessLine[i].equals("restaurant") || businessLine[i].equals("grocery"))){
                    if(businessLine[i].equals("electronics"))bline.get(0).add(code[i]);
                    else if(businessLine[i].equals("grocery"))bline.get(1).add(code[i]);
                    else if(businessLine[i].equals("pharmacy"))bline.get(2).add(code[i]);
                    else bline.get(3).add(code[i]);
                }
            }
        }for(ArrayList<String> s:bline){
            Collections.sort(s);
            for(int i=0;i<s.size();i++) ans.add(s.get(i));
        }
        return ans;
    }
}