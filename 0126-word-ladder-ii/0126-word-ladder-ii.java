class Solution {
    static List<List<String>> ans;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        ans=new ArrayList<>();
        HashSet<String> set=new HashSet<>(wordList);
        if(!set.contains(endWord)) return new ArrayList<>();

        Queue<String> q=new LinkedList<>();
        q.add(beginWord);
        
        HashMap<String,Integer> map=new HashMap<>();
        map.put(beginWord,1);
        set.remove(beginWord);

        while(!q.isEmpty()){
            String curr=q.remove();
            StringBuilder sb=new StringBuilder(curr);
            if(curr.equals(endWord)) break;
            
            for(int i=0;i<sb.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char old=sb.charAt(i);
                    sb.setCharAt(i,ch);

                    if(set.contains(sb.toString())){
                        q.add(sb.toString());
                        map.put(sb.toString(),map.get(curr)+1);
                        set.remove(sb.toString()); 
                    }
                    sb.setCharAt(i,old);
                }
            }
        }for(String s:map.keySet()){
            System.out.println(s+" : "+map.get(s));
        }
        List<String> arr=new ArrayList<>();
        arr.add(endWord);
        dfs(map,endWord,beginWord,arr);

        return ans;
    }
    public static void dfs(HashMap<String,Integer> map,String word,String start,List<String> arr){
        if(word.equals(start)){
            List<String> l=new ArrayList<>(arr);
            Collections.reverse(l);
            ans.add(l);
            return;
        }
        StringBuilder sb=new StringBuilder(word);
        for(int i=0;i<word.length();i++){
            for(char ch='a';ch<='z';ch++){
                char old=sb.charAt(i);
                sb.setCharAt(i,ch);

                if(map.containsKey(sb.toString())){
                    if(map.get(word)>map.get(sb.toString())){
                        arr.add(sb.toString());
                        dfs(map,sb.toString(),start,arr);
                        arr.remove(arr.size()-1);
                    }
                }sb.setCharAt(i,old);
            }
        }
    }
}