class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int ans[]=new int[deck.length];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<deck.length;i++) q.add(i);

        boolean skip=false;int i=0;
        while(!q.isEmpty()){
            int idx=q.remove();
            if(!skip){
                ans[idx]=deck[i++];
            }else q.add(idx);
            skip=!skip;
        }return ans;
    }
}