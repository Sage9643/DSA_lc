class Solution {
    public String majorityFrequencyGroup(String s) {
        HashMap<Integer,ArrayList<Character>> map=new HashMap<>();
        int arr[]=new int[26];
        for(char ch:s.toCharArray())arr[ch-'a']++;

        for(int i=0;i<26;i++){
            if(!map.containsKey(arr[i]) && arr[i]>0) {map.put(arr[i],new ArrayList<>());map.get(arr[i]).add((char)('a'+i));}
            else if(arr[i]>0){
                map.get(arr[i]).add((char)('a'+i));
            }
            
        }
        StringBuilder sb=new StringBuilder();
        int max=0;int maxel=0;

        for(int key:map.keySet()){
            if(map.get(key).size()>=max){
                max=map.get(key).size();
                if(maxel<key) maxel=key;
            }
        }ArrayList<Character> a=map.get(maxel);
        for(char ch:a) sb.append(ch);
        return sb.toString();
        
    }
}