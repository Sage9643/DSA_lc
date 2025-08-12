class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        List<List<String>> ans=new ArrayList<>();
        for(String str:strs){
            String frString=freqString(str);
            if(!map.containsKey(frString)){
                List<String> list=new ArrayList<>();
                list.add(str);
                map.put(frString,list);
            }else map.get(frString).add(str);
        }for(String str:map.keySet()) ans.add(map.get(str));
        return ans;
    }
    public static String freqString(String str){
        int freq[]=new int[26];
        for(int i=0;i<str.length();i++){
            freq[str.charAt(i)-'a']++;
        }
        StringBuilder sb=new StringBuilder();
        char ch='a';
        for(int frq:freq){
            if(frq>0){
                sb.append(ch);sb.append(Integer.toString(frq));
            }ch++;
        }return sb.toString();
    }
}