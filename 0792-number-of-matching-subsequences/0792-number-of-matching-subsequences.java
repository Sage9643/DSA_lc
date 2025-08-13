class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        List<Queue<String>> buckets=new ArrayList<>();
        for(int i=0;i<26;i++) buckets.add(new LinkedList<>());//bucket sort approach
        
        for(String word:words) {
            buckets.get(word.charAt(0)-'a').add(word);
        }
        int count=0;
        for(char ch:s.toCharArray()) {
            Queue<String> queue=buckets.get(ch-'a');
            int size=queue.size();
            for(int i=0;i<size;i++) {
                String word=queue.remove();
                if(word.length()==1) {
                    count++;
                } else buckets.get(word.charAt(1) - 'a').add(word.substring(1));
                
            }
        }
        return count;
    }
}
