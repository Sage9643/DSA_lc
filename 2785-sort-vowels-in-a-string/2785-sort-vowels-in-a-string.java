class Solution {
    public String sortVowels(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        char arr[]={'A','E','I','O','U','a','e','i','o','u'};
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }

        int count[]=new int[10];
        for(char ch:s.toCharArray()){
            if(map.containsKey(ch)) count[map.get(ch)]++;
        }

        StringBuilder sb=new StringBuilder();
        int idx=0;

        for(char ch:s.toCharArray()){
            if(map.containsKey(ch)){
                while(count[idx]==0) idx++;
                sb.append(arr[idx]);
                count[idx]--;
            }else sb.append(ch);
        }
        return sb.toString();
    }
}