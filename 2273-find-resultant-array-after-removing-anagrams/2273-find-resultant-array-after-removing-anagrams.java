class Solution {
    public List<String> removeAnagrams(String[] words) {
        int i=0;int j=1;
        for(;j<words.length;j++){
            if(Arrays.equals(freq(words[i]),freq(words[j]))) words[j]="";
            else{
                i++;
                if(words[i]==""){
                    while(words[i]=="" && i<j) i++;
                }
            }
        }List<String> ans= new ArrayList<>();
        for(String word:words){
            if(word!="") ans.add(word);
        }return ans;
    }public static int [] freq(String word){
        int[] arr=new int[26];
        for(int i=0;i<word.length();i++){
            arr[word.charAt(i)-'a']++;
        }return arr;
    }
}