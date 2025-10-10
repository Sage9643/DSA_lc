class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);Arrays.sort(heaters);
        HashMap <Integer,Integer> map=new HashMap<>();
        for(int house:houses) map.put(house,Integer.MAX_VALUE);

        int j=0;int k=0;
        for(int i=0;i<heaters.length-1;i++){
            int curr=heaters[i];int next=heaters[i+1];
            while(j<houses.length && houses[j]<next){
                map.put(houses[j],Math.min(Math.abs(curr-houses[j]),map.get(houses[j])));
                if(houses[j]<=curr) k++;
                j++;
            }j=k;
        }int curr=heaters[heaters.length-1];
        while(j<houses.length){
            map.put(houses[j],Math.min(Math.abs(curr-houses[j]),map.get(houses[j])));
            j++;
        }
        int ans=0;
        for(int dist:map.keySet()){
            ans=Math.max(ans,map.get(dist));
        }return ans;
    }
}