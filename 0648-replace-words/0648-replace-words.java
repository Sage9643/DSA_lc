class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String words[]=sentence.split("\\s+");
        String ans[]=new String[words.length];
        Trie prefix=new Trie();
        for(String word:dictionary) prefix.insert(word);

        for (int w = 0; w < words.length; w++) {
            String word = words[w];
            StringBuilder pref = new StringBuilder();
            TrieNode curr = prefix.root;
            boolean replaced = false;

            for (int i=0;i<word.length();i++) {
                int idx=word.charAt(i)-'a';
                if(curr.children[idx]==null) break;

                pref.append(word.charAt(i));
                curr=curr.children[idx];
                if(curr.endOfWord){
                    ans[w]=pref.toString();
                    replaced=true;
                    break;
                }
            }if (!replaced) ans[w]=word;
        }return String.join(" ",ans);
    }
}
class TrieNode{
    TrieNode[] children=new TrieNode[26];
    boolean endOfWord;
}class Trie{
    TrieNode root=new TrieNode();
    public Trie(){

    }public void insert(String word){
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            if(curr.children[word.charAt(i)-'a']==null) curr.children[word.charAt(i)-'a']=new TrieNode();
            curr=curr.children[word.charAt(i)-'a'];
        }curr.endOfWord=true;    
    } 
}