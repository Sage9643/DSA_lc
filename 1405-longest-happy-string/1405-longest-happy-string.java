class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<pair> pq=new PriorityQueue<>((x,y)->y.freq-x.freq);
        if(a!=0)pq.add(new pair('a',a));
        if(b!=0)pq.add(new pair('b',b));
        if(c!=0)pq.add(new pair('c',c));

        StringBuilder sb=new StringBuilder();
        int curr=1;
        while(!pq.isEmpty()){
            pair p=pq.remove();
            if(curr==2 && sb.charAt(sb.length()-1)==p.ch){
                if(pq.isEmpty()) break;
                else{
                    pair p2=pq.remove();
                    sb.append(p2.ch);
                    if(p2.freq>1)pq.add(new pair(p2.ch,p2.freq-1));
                }
            }if(sb.length()>0){
                if(sb.charAt(sb.length()-1)==p.ch) curr++;
                else curr=1;
            }sb.append(p.ch);
            if(p.freq>1) pq.add(new pair(p.ch,p.freq-1));

        }return sb.toString();
    }
}class pair{
    char ch;
    int freq;
    public pair(char ch,int freq){
        this.ch=ch;
        this.freq=freq;
    }
}