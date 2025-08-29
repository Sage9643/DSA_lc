class Solution {
    public List<String> commonChars(String[] words) {
        HashMap<String,Integer> map=new HashMap<>();
        List<String> ans=new ArrayList<>();

        String initial=words[0];
        int freqs[]=new int[26];
        for(char ch:initial.toCharArray()){
            freqs[ch-'a']++;
        }for(int i=0;i<26;i++){
            if(freqs[i]!=0) map.put(Character.toString('a'+i),freqs[i]);
        }
        for(String word:words){
            int freq[]=new int[26];
            for(char ch:word.toCharArray()) freq[ch-'a']++;
            
            for(int i=0;i<26;i++){
                String ltr=Character.toString('a'+i);
                if(freq[i]==0){
                    if(map.containsKey(ltr)) map.remove(ltr);
                }else{
                    if(map.containsKey(ltr)){
                        if(map.get(ltr)>freq[i]) map.put(ltr,freq[i]);
                    }
                }       
            }
        }for(String letter:map.keySet()){
            for(int i=0;i<map.get(letter);i++) ans.add(letter);
        }return ans;
    }
}