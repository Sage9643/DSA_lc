class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        HashMap<Character,Integer> weight=new HashMap<>();

        for(int i=0;i<26;i++) weight.put((char)('a'+i),weights[i]);
        HashMap<Integer,Character> map=new HashMap<>();

         for(int i=0;i<26;i++) map.put(i,(char)('z'-i));
         StringBuilder sb=new StringBuilder();

         for(String w:words){
            int sum=0;
            for(char ch:w.toCharArray()){
                sum=(sum+weight.get(ch))%26;
            }sb.append(map.get(sum));
         }
         return sb.toString();


    }
}