class Trie {
    private Trie[] children=new Trie[26];
    private boolean endOfWord;

    public Trie() {
        
    }
    public void insert(String word) {
        Trie curr=this;
        for(int i=0;i<word.length();i++){
            if(curr.children[word.charAt(i)-'a']==null) curr.children[word.charAt(i)-'a']=new Trie();
            curr=curr.children[word.charAt(i)-'a'];
        }curr.endOfWord=true;
    }
    
    public boolean search(String word){
        Trie curr=this;
        for(int i=0;i<word.length();i++){
            if(curr.children[word.charAt(i)-'a']==null) return false;
            curr=curr.children[word.charAt(i)-'a'];
        }return curr.endOfWord==true;
        
    }
    
    public boolean startsWith(String prefix) {
        Trie curr=this;
        for(int i=0;i<prefix.length();i++){
            if(curr.children[prefix.charAt(i)-'a']==null) return false;
            curr=curr.children[prefix.charAt(i)-'a'];
        }return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */