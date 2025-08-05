class Solution {
    public String getHint(String secret, String guess) {
        HashMap<Character,Integer> map=new HashMap<>();
        int bulls=0,cows=0;

        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)) bulls++;
            else if(!map.containsKey(secret.charAt(i))){
                map.put(secret.charAt(i),1);
            }else map.put(secret.charAt(i),map.get(secret.charAt(i))+1);
        }for(int i=0;i<guess.length();i++){
            if(secret.charAt(i)!=guess.charAt(i)){
                if(map.containsKey(guess.charAt(i))){
                    cows++;
                    map.put(guess.charAt(i),map.get(guess.charAt(i))-1);
                    if(map.get(guess.charAt(i))==0){
                        map.remove(guess.charAt(i));
                    }
                }
            }
        }return Integer.toString(bulls)+"A"+Integer.toString(cows)+"B";
    }
}