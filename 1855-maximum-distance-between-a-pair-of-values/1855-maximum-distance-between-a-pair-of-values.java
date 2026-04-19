class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
    //     int ans=0;
    //     for(int i=0;i<nums1.length;i++){
    //         int idx=bs(nums1[i],nums2);
    //         ans=Math.max(ans,idx-i);
    //     }return ans;
    // }public static int bs(int num,int arr[]){
    //     int start=0,end=arr.length-1;
    //     int idx=-1;
    //     while(start<=end){
    //         int mid=start+(end-start)/2;
    //         if(arr[mid]>=num){
    //             idx=mid;
    //             start=mid+1;
    //         }else end=mid-1;
    //     }return idx;

        int i=0,j=0;
        int ans=0;
        while(i<nums1.length && j<nums2.length){
            while(j<nums2.length && nums1[i]<=nums2[j]){
                ans=Math.max(ans,j-i);
                j++;
            }i++;
        }return ans;

    }
}