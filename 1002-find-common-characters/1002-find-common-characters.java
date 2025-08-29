class Solution {
    public List<String> commonChars(String[] words) {
        int[] minfreq=new int[26];
        List<String> ans=new ArrayList<>();
        Arrays.fill(minfreq,Integer.MAX_VALUE);

        String initial=words[0];
        
        for(String word:words){
            int freq[]=new int[26];
            for(char ch:word.toCharArray()) freq[ch-'a']++;
            
            for(int i=0;i<26;i++){
                minfreq[i]=Math.min(minfreq[i],freq[i]);
            }
        }for(int i=0;i<26;i++){
            for(int j=0;j<minfreq[i];j++) ans.add(Character.toString('a'+i));
        }return ans;
    }
}