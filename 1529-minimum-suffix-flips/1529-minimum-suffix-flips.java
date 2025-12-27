class Solution {
    public int minFlips(String target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int curr=0,flips=0;

        for(char ch:target.toCharArray()) {
            if(ch=='0')map.put(0,map.getOrDefault(0,0)+1);
            else map.put(1,map.getOrDefault(1,0)+1);
        }

        for(int i=0;i<target.length();i++){
            if(curr!=target.charAt(i)-'0') {
                flips++;
                curr=1-curr;
            }
            map.put(curr,map.get(curr)-1);
            if(map.get(curr)==0) map.remove(curr);

            if(map.size()==1){
                if(map.containsKey(0)){
                    if(curr==0) return flips;
                    else return flips+1;
                }else{
                    if(curr==1) return flips;
                    else return flips+1;
                }

            }
        }return 0;
    
    }
}