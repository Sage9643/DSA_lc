class Solution {
    public long totalScore(int hp, int[] damage, int[] requirement) {
        int pre[]=new int[damage.length+1];pre[0]=0;
        for(int i=1;i<=damage.length;i++) pre[i]=pre[i-1]+damage[i-1];
        long cnt=0;
        
        for(int i=1;i<=requirement.length;i++){
            int val=requirement[i-1]+pre[i]-hp;
            int idx=bs(val,pre);
            if(idx<=i){
                 cnt+=(i-idx+1);
            }
        }return cnt;
    }public int bs(int val,int[] damage){
        int start=0,end=damage.length-1;
        int idx=damage.length;
        while(start<=end){
            int mid=(end+start)/2;
            if(damage[mid]>=val){
                idx=mid;
                end=mid-1;
            }else start=mid+1;
        }
        return idx+1;
    }
}