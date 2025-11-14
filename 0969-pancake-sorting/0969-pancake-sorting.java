class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        boolean sorted=true;int idx[]=new int[arr.length];Arrays.fill(idx,-1);
        List<Integer> ans=new ArrayList<>();

        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                sorted=false;break;
            }
        }if(sorted) return ans;
        int boundary=arr.length-1;
        
        int max=arr.length;
        while(boundary!=0){
            int end=0;
            for(int i=0;i<=boundary;i++){
                if(arr[i]==max) {max--;end=i;break;}
            }
            reverse(arr,end);reverse(arr,boundary);
            ans.add(end+1);ans.add(boundary+1);
            boundary--;
        }return ans;
    }
    public void reverse(int[] arr,int end){
        for(int i=0;i<=end/2;i++){
            int temp=arr[i];
            arr[i]=arr[end-i];
            arr[end-i]=temp;
        }
    }
}