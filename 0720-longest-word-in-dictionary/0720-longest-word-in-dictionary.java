class Solution {
    public Trie prefix=new Trie();
    public TrieNode root=prefix.getRoot();
    public String longestWord(String[] words){
        for(String word:words) prefix.insert(word);
        String ans="";
        for(String word:words){
            TrieNode curr=root;
            boolean status=true;
            for(int i=0;i<word.length();i++){
                if(!curr.children.get(word.charAt(i)).endOfWord){
                    status=false;
                    break;
                }curr=curr.children.get(word.charAt(i));
            }if(status){
                if(ans.length()==word.length()) ans=ans.compareTo(word)>0?word:ans;
                else ans=ans.length()>word.length()?ans:word;
            }
        }return ans; 
    }
}class TrieNode{
    HashMap<Character,TrieNode> children=new HashMap<>();
    boolean endOfWord;
}class Trie{
    public TrieNode root=new TrieNode();
    public void insert(String word){
        TrieNode curr=root;
        for(char ch:word.toCharArray()){
            curr=curr.children.computeIfAbsent(ch,c->new TrieNode());
        }curr.endOfWord=true;
    }public TrieNode getRoot(){
        return root;
    }
}