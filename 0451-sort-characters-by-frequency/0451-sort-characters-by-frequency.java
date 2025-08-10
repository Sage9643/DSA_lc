class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        ArrayList<Info> arr=new ArrayList<>();
        for(Character key:map.keySet()){
            arr.add(new Info(key,map.get(key)));
        }
        Collections.sort(arr,(info1,info2)-> info2.freq-info1.freq);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<arr.size();i++){
            while(arr.get(i).freq!=0){
                sb.append(arr.get(i).ch);
                arr.get(i).freq--;
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