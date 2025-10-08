class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int pairs[]=new int[spells.length];
        int idx=0;

        for(int spell:spells){
            int el=potions.length;
            int start=0,end=potions.length-1;
            while(start<=end){
                int mid=(start+end)/2;
                if(((long)potions[mid]*spell)>=success){
                    el=mid;
                    end=mid-1;
                }else start=mid+1;
            }pairs[idx++]=potions.length-el;
        }return pairs;
    }
}