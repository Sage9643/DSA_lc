class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long mincost=0;
        if(costBoth<=cost1 && costBoth<=cost2) return (long)costBoth*Math.max(need1,need2);
        long comb=cost1+cost2;

        if(cost1<=costBoth && cost2>=costBoth && comb>costBoth){
            if(need1>need2){
                return ((long)need2*costBoth)+((long)(need1-need2)*cost1);
            }else return ((long)need2*costBoth);
        }
        if(cost1>=costBoth && cost2<=costBoth && comb>costBoth){
            if(need2>need1){
                return ((long)need1*costBoth)+((long)(need2-need1)*cost2);
            }else return ((long)need1*costBoth);
        }
        if(comb>=costBoth && cost1<=costBoth && cost2<costBoth){
            mincost+=(long)Math.min(need1,need2)*costBoth;
            if(Math.max(need1,need2)==need2) mincost+=((long)(need2-need1)*cost2);
            else mincost+=((long)(need1-need2)*cost1);
            return mincost;
        }
        
        
        if(comb<=costBoth){
            return ((long)cost1*need1)+((long)cost2*need2);
        }return mincost;
    }
}