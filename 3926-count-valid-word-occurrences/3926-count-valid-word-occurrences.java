class Solution {
    public int[] countWordOccurrences(String[] chunks, String[] queries) {
        StringBuilder sb=new StringBuilder();
        HashMap<String,Integer> map=new HashMap<>();
        StringBuilder word=new StringBuilder();

        for(String s:chunks) sb.append(s);
        
        int i=0;
        while(i<sb.length()){
            char ch=sb.charAt(i);

            if(ch>='a' && ch<='z') word.append(ch);
            else{
                if(ch=='-'){
                    if((i-1)>-1 && (i+1)<sb.length() && (sb.charAt(i-1)>='a' && sb.charAt(i-1)<='z') && (sb.charAt(i+1)>='a' && sb.charAt(i+1)<='z')) word.append('-');

                    else{
                        if(word.length()>0) map.put(word.toString(),map.getOrDefault(word.toString(),0)+1);
                        word.setLength(0);
                    }
                }else{
                    if(word.length()>0) map.put(word.toString(),map.getOrDefault(word.toString(),0)+1);
                    word.setLength(0);
                }
                
            }i++;
        }if(word.length()>0) map.put(word.toString(),map.getOrDefault(word.toString(),0)+1);

        int ans[]=new int[queries.length];
        int idx=0;
        for(String q:queries){
            if(map.containsKey(q)) ans[idx++]=map.get(q);
            else ans[idx++]=0;
        }
        return ans;
    }
}