class Solution {
    public int findTheWinner(int n, int k) {
        k--;
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=n;i++) q.add(i);

        while(q.size()>1){
            for(int i=0;i<k;i++){
                int el=q.remove();
                q.add(el);
            }q.remove();
        }return q.remove();
    }
}