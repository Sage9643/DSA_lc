class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int ans[]=new int[n];
        for(int booking[]:bookings){
            ans[booking[1]-1]+=booking[2];
            if(booking[0]>1) ans[booking[0]-2]-=booking[2];
        }int sum=ans[n-1];
        for(int i=ans.length-2;i>=0;i--){
            sum+=ans[i]; 
            ans[i]=sum; 
             
        }return ans;
    }
}