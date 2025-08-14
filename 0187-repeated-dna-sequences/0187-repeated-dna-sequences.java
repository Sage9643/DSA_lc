class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String,Integer> DNACount=new HashMap<>();
        int i=0;
        while(i<=s.length()-10){
            String DNASeq=s.substring(i,i+10);
            DNACount.put(DNASeq,DNACount.getOrDefault(DNASeq,0)+1);
            i++;
        }
        HashSet<String> repeatingDNA=new HashSet<>();
        i=0;
        while(i<=s.length()-10){
            String DNASeq=s.substring(i,i+10);
            if(DNACount.get(DNASeq)>1)repeatingDNA.add(DNASeq);
            i++;
        }List<String> DNA=new ArrayList<>();
        for(String dna:repeatingDNA) DNA.add(dna);

        return DNA;
    }
}