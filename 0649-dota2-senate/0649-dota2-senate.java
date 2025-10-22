class Solution {
    public String predictPartyVictory(String senate) {
        int countR=0,countD=0;
        Queue<Character> q=new LinkedList<>();
        for(int i=0;i<senate.length();i++){
            if(senate.charAt(i)=='R') countR++;
            else countD++;
            q.add(senate.charAt(i));
        }
        int banR=0,banD=0;

        while(countD!=0 && countR!=0){
            Character first=q.remove();
            if(first=='R' && banR==0){
                banD++;countD--;
                q.add(first);
            }else if(first=='D' && banD==0){
                banR++;countR--;
                q.add(first);
            }else{
                if(first=='R') banR--;
                else banD--;
            }
        }if(countR!=0) return "Radiant";
        return "Dire";
    }
}