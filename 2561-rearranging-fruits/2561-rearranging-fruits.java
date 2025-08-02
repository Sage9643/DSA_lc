class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        HashMap<Integer,Integer> bask1=new HashMap<>();
        HashMap<Integer,Integer> bask2=new HashMap<>();

        //created hashmap with elements and their freq;
        int minVal=Integer.MAX_VALUE;//for storing global maximum from both baskets
        for(int i=0;i<basket1.length;i++){
            if(!bask1.containsKey(basket1[i])){
                bask1.put(basket1[i],1);
                minVal=Math.min(minVal,basket1[i]);
            }else{
                bask1.put(basket1[i],bask1.get(basket1[i])+1);
            }
            if(!bask2.containsKey(basket2[i])){
                bask2.put(basket2[i],1);
                minVal=Math.min(minVal,basket2[i]);
            }else{
                bask2.put(basket2[i],bask2.get(basket2[i])+1);
            }
        }
        //creating an ArrayList that will store all the swappable elements
        ArrayList<Integer> arr1=new ArrayList<>();
        ArrayList<Integer> arr2=new ArrayList<>();


        for(Integer key:bask1.keySet()){
            if(!bask2.containsKey(key)){
                if(bask1.get(key)%2==0){
                    for(int i=0;i<bask1.get(key)/2;i++){
                        arr1.add(key);
                    }
                }else{
                    return -1;
                }
            }else{
                int diff=(int)Math.abs(bask1.get(key)-bask2.get(key));
                if(Math.abs(diff%2)==0){
                    for(int i=0;i<diff/2;i++){
                        if(bask1.get(key)>bask2.get(key)){
                            arr1.add(key);
                        }else{
                            arr2.add(key);
                        }
                        
                    }
                }else{
                    return -1;
                }
            }
        }for(Integer key:bask2.keySet()){
            if(!bask1.containsKey(key)){
                if(bask2.get(key)%2==0){
                    for(int i=0;i<bask2.get(key)/2;i++){
                        arr2.add(key);
                    }
                }else{
                    return -1;
                }
            }
        }Collections.sort(arr1);
        Collections.sort(arr2,Collections.reverseOrder());

        long minCost=0;
        if((arr1.size()+arr2.size())%2!=0){
            return -1;
        }else{
            for(int i=0;i<arr1.size();i++){
                minCost+=Math.min(Math.min(arr1.get(i),arr2.get(i)),2*minVal);
            }
        }return minCost;

    }
}