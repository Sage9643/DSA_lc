class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>(wordList);
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(beginWord,1));

        while(!q.isEmpty()){
            pair p=q.remove();
            if(p.word.equals(endWord)) return p.level;

            StringBuilder sb=new StringBuilder(p.word);

            for(int i=0;i<p.word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char old=sb.charAt(i);
                    sb.setCharAt(i,ch);
                    if(set.contains(sb.toString())){
                        q.add(new pair(sb.toString(),p.level+1));
                        set.remove(sb.toString());
                    }
                    sb.setCharAt(i,old);
                }
            }

        }return 0;
    }
}class pair{
    String word;
    int level;

    pair(String word,int level){
        this.word=word;
        this.level=level;
    }
}