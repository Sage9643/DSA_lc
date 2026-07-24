class NumArray {
    static int segtree[];
    static int n;
    static int num[];

    public NumArray(int[] nums) {
        n=nums.length;
        num=nums;
        segtree=new int[4*n];

        createSegTree(0,0,n-1);
        
    }public static void createSegTree(int i,int si,int ei){
        if(si==ei){
            segtree[i]=num[si];
            return;
        }
        int mid=(si+ei)/2;
        createSegTree(2*i+1,si,mid);
        createSegTree(2*i+2,mid+1,ei);

        segtree[i]=segtree[2*i+1]+segtree[2*i+2];
    }
    
    public static void update(int index, int val){
        int diff=val-num[index];
        num[index]=val;
        updateUtil(0,0,n-1,diff,index);
    }
    public static void updateUtil(int i,int si,int ei,int diff,int index){ 

        if(si>index || ei<index) return;
        if(si==ei){
            segtree[i]+=diff;
            return;
        }
        if(si<=index && ei>=index){
            segtree[i]+=diff;
            int mid=(si+ei)/2;
            updateUtil(2*i+1,si,mid,diff,index);
            updateUtil(2*i+2,mid+1,ei,diff,index);
        }    
    }
    public int sumRange(int left, int right) {
        return sumRangeUtil(0,0,n-1,left,right);    
    }
    public static int sumRangeUtil(int i,int si,int ei,int qi,int qj){
        if(qi>ei || qj<si) return 0;

        else if(qi<=si && qj>=ei){
            return segtree[i];
        }
        else{
            int mid=(si+ei)/2;
            int left=sumRangeUtil(2*i+1,si,mid,qi,qj);
            int right=sumRangeUtil(2*i+2,mid+1,ei,qi,qj);

            return left+right;
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */