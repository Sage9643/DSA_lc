class Solution {
    public int findTheLongestSubstring(String s) {
        HashMap<String,Integer> map=new HashMap<>();
        map.put("00000",-1);
        int arr[]=new int[5];
        int maxlen=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a'){
                arr[0]++;
                StringBuilder sb=new StringBuilder();
                for(int a:arr) sb.append(Integer.toString(a%2));
                if(!map.containsKey(sb.toString())) map.put(sb.toString(),i);
                else maxlen=Math.max(maxlen,i-map.get(sb.toString()));
            }else if(s.charAt(i)=='e'){
                arr[1]++;
                StringBuilder sb=new StringBuilder();
                for(int a:arr) sb.append(Integer.toString(a%2));
                if(!map.containsKey(sb.toString())) map.put(sb.toString(),i);
                else maxlen=Math.max(maxlen,i-map.get(sb.toString()));
            }else if(s.charAt(i)=='i'){
                arr[2]++;
                StringBuilder sb=new StringBuilder();
                for(int a:arr) sb.append(Integer.toString(a%2));
                if(!map.containsKey(sb.toString())) map.put(sb.toString(),i);
                else maxlen=Math.max(maxlen,i-map.get(sb.toString()));
            }else if(s.charAt(i)=='o'){
                arr[3]++;
                StringBuilder sb=new StringBuilder();
                for(int a:arr) sb.append(Integer.toString(a%2));
                if(!map.containsKey(sb.toString())) map.put(sb.toString(),i);
                else maxlen=Math.max(maxlen,i-map.get(sb.toString()));
            }else if(s.charAt(i)=='u'){
                arr[4]++;
                StringBuilder sb=new StringBuilder();
                for(int a:arr) sb.append(Integer.toString(a%2));
                if(!map.containsKey(sb.toString())) map.put(sb.toString(),i);
                else maxlen=Math.max(maxlen,i-map.get(sb.toString()));
            }else{
                StringBuilder sb=new StringBuilder();
                for(int a:arr) sb.append(Integer.toString(a%2));
                if(!map.containsKey(sb.toString())) map.put(sb.toString(),i);
                else maxlen=Math.max(maxlen,i-map.get(sb.toString()));
            }
        }return maxlen;
    }
}