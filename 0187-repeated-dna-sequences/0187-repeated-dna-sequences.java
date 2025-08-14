class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> seenDNA=new HashSet<>();
        HashSet<String> repeatingDNA=new HashSet<>();

        int i=0;

        while(i<=s.length()-10){
            String DNASeq=s.substring(i,i+10);
            if(!seenDNA.contains(DNASeq)) seenDNA.add(DNASeq);
            else repeatingDNA.add(DNASeq);
            i++;
        }
        return new ArrayList<>(repeatingDNA);

    }
}