class Solution {
    public long flowerGame(int n, int m) {
        int even1=n/2, odd1=n-even1;
        int even2=m/2, odd2=m-even2;
        
        return (long)even1*odd2+(long)odd1*even2;
    }
}