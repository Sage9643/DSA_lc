class Solution {
    static int count[];

    public List<Integer> countSmaller(int[] nums) {
        int n=nums.length;
        int arr[][]=new int[n][2];

        for(int i=0;i<n;i++){
            arr[i][0]=nums[i];
            arr[i][1]=i;
        }
        count=new int[n];

        mergeSort(arr,0,n-1);

        List<Integer> counts=new ArrayList<>();
        for(int c:count) counts.add(c);

        return counts; 
    }

    public static void mergeSort(int arr[][],int si,int ei){
        if(si>=ei) return;
        int mid=(si+ei)/2;

        mergeSort(arr,si,mid);
        mergeSort(arr,mid+1,ei);

        merge(arr,si,mid,ei);
    }
    public static void merge(int arr[][],int si,int mid,int ei){

        int temp[][]=new int[ei-si+1][2];

        int i=si,j=mid+1;
        int k=0;

        while(i<=mid && j<=ei){
            if(arr[i][0]<=arr[j][0]){
                temp[k++]=arr[j++];
            }else{
                count[arr[i][1]]+=(ei-j+1);
                temp[k++]=arr[i++];
            }
        }
        while(j<=ei){
            temp[k++]=arr[j++];
        }
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        k=0;

        for(int s=si;s<=ei;s++){
            arr[s]=temp[k++];
        }
    }
    
}