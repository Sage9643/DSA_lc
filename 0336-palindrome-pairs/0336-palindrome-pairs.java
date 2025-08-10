class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans=new ArrayList<>();
        HashMap<String,Integer> map=new HashMap<>();
        
        for(int i=0;i<words.length;i++) map.put(words[i],i);
        for(int i=0;i<words.length;i++){
            String word=words[i];
            for(int cut=0;cut<=word.length();cut++){
                String left=word.substring(0,cut);
                String right=word.substring(cut);
                if(isPalindrome(left)){
                    String revright=new StringBuilder(right).reverse().toString();
                    Integer idx=map.get(revright);
                    if((idx!=null) && idx!=i) ans.add(Arrays.asList(idx,i));
                }if(isPalindrome(right) && cut!=word.length()){
                    String revleft=new StringBuilder(left).reverse().toString();
                    Integer idx=map.get(revleft);
                    if((idx!=null) && idx!=i) ans.add(Arrays.asList(i,idx));
                }
            }
        }return ans;
    }
    private boolean isPalindrome(String str){
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i)!=str.charAt(str.length()-1-i)) return false;
        }return true;
    }
}