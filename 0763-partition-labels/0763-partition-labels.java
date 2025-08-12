class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> freqMap=new HashMap<>();
        List<Integer> size=new ArrayList<>();

        int freq[]=new int[26];
        for(char ch:s.toCharArray())freq[ch-'a']++;
        for(int i=0;i<s.length();i++){
            freqMap.put(s.charAt(i),freq[s.charAt(i)-'a']-1);
            int length=1;   
            while(i<s.length()-1 && !freqMap.isEmpty()){
                if(freqMap.containsKey(s.charAt(i)) && freqMap.get(s.charAt(i))==0) {
                    freqMap.remove(s.charAt(i));
                    size.add(length);
                    length=0;
                }
                i++;
                if(!freqMap.containsKey(s.charAt(i))){
                    freqMap.put(s.charAt(i),freq[s.charAt(i)-'a']-1);
                }else{
                    freqMap.put(s.charAt(i),freqMap.get(s.charAt(i))-1);
                
                }length++;
                if(freqMap.get(s.charAt(i))==0) freqMap.remove(s.charAt(i));
            }size.add(length);
        }return size;
    }
}