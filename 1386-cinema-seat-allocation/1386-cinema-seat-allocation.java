class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int a[]:reservedSeats){
            if(a[1]>1 && a[1]<10) map.put(a[0],map.getOrDefault(a[0],0)|(1<<a[1]));
        }
        int count=2*(n-map.size());

        for(int v:map.values()){
            boolean first=(v&((1<<2)|(1<<3)|(1<<4)|(1<<5)))==0;
            boolean sec=(v&((1<<4)|(1<<5)|(1<<6)|(1<<7)))==0;
            boolean third=(v&((1<<6)|(1<<7)|(1<<8)|(1<<9)))==0;

            if(first){
                count++;if(third) count++;
            }else if(sec) count++;
            else if(third) count++;
        }return count;
    }
}