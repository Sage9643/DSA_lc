class Solution {
    public List<Integer> partitionLabels(String s) {
        int lastIdx[]=new int[26];
        List<Integer> partitions=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            lastIdx[s.charAt(i)-'a']=i;
        }
        int maxLast=0;int start=0;
        for(int i=0;i<s.length();i++){
            maxLast=Math.max(maxLast,lastIdx[s.charAt(i)-'a']);
            if(i==maxLast){
                partitions.add(maxLast-start+1);
                start=i+1;
            }
        }return partitions;
    }
}