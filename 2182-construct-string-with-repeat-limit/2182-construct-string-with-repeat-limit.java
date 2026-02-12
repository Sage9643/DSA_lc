class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            return b[0]-a[0];
        });
        int freq[]=new int[26];

        for(char ch:s.toCharArray()) freq[ch-'a']++;

        int i=0;

        for(int f:freq){
            if(f>0){
                pq.add(new int[]{i,f});
            }i++;
        }
        StringBuilder sb=new StringBuilder();

        while(!pq.isEmpty()){
            int info[]=pq.remove();
            char ch=(char)('a'+info[0]);
            int f=info[1];

            if(sb.length()!=0 && sb.charAt(sb.length()-1)==ch){
                if(!pq.isEmpty()){
                    int info2[]=pq.remove();
                    char ch2=(char)('a'+info2[0]);
                    int f2=info2[1];

                    sb.append(ch2);
                    f2--;

                    if(f2!=0) pq.add(new int[]{info2[0],f2});    
                }
                else break;
            }
            int lim=Math.min(repeatLimit,f);
            for(int j=0;j<lim;j++){
                sb.append(ch);
                f--;
            }
            if(f!=0) pq.add(new int[]{info[0],f});
        }return sb.toString();
    }
}