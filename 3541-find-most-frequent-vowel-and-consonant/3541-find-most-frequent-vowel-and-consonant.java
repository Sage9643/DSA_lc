class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character,Integer> mapCon=new HashMap<>();
        HashMap<Character,Integer> mapVow=new HashMap<>();

        int consonant=0;int vowel=0;

        for(char ch:s.toCharArray()){
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                mapVow.put(ch,mapVow.getOrDefault(ch,0)+1);
            }else mapCon.put(ch,mapCon.getOrDefault(ch,0)+1);
        }
        for(Character consonants:mapCon.keySet()){
            if(mapCon.get(consonants)>consonant) consonant=mapCon.get(consonants);
        }
        for(Character vowels:mapVow.keySet()){
            if(mapVow.get(vowels)>vowel) vowel=mapVow.get(vowels);
        }
        return vowel+consonant;
    }
}