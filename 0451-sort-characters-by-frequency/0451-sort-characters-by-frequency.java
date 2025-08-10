class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        PriorityQueue<Info> heap=new PriorityQueue<>((info1,info2)->info2.freq-info1.freq);
        for(Character key:map.keySet()){
            heap.add(new Info(key,map.get(key)));
        }
        StringBuilder sb=new StringBuilder();
        while(!heap.isEmpty()){
            Info el=heap.remove();
            while(el.freq!=0){
                sb.append(el.ch);
                el.freq--;
            }
        }return sb.toString();
    }
}class Info{
    Character ch;
    Integer freq;
    public Info(Character ch,Integer freq){
        this.ch=ch;
        this.freq=freq;
    }
}