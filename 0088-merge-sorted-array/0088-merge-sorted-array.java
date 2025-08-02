class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int arr[]=new int[m+n];
        int i=0,j=0;

        while(i<m && j<n){
            if(nums1[i]>nums2[j]){
                arr[i+j]=nums2[j];
                j++;
            }else{
                arr[i+j]=nums1[i];
                i++;
            }
        }while(j<n){
            arr[i+j]=nums2[j];
            j++;
        }while(i<m){
            arr[i+j]=nums1[i];
            i++;
        }for(int k=0;k<m+n;k++){
            nums1[k]=arr[k];
        }
    }
}