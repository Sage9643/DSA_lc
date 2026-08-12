class Solution {
    public int threeSumMulti(int[] arr, int target) {

        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        int idx=0;

        for(int a:arr){
            if(!map.containsKey(a)) map.put(a,new ArrayList<>());
            map.get(a).add(idx++);
        }
        long cnt=0;

        for(int i=0;i<arr.length;i++){
            int el1=arr[i];

            for(int j=i+1;j<arr.length;j++){
                int el2=arr[j];
                int el3=target-el1-el2;

                if(map.containsKey(el3)){
                    long f=bs(map.get(el3),j);
                    cnt+=f;
                }

            }
        }return (int)(cnt%1000000007);

    }
    public static long bs(ArrayList<Integer> arr,int i){

        int start=0; int end=arr.size()-1;
        long ans=arr.size();

        while(start<=end){
            int mid=(start+end)/2;

            if(arr.get(mid)>i){
                ans=mid;
                end=mid-1;
            }
            else start=mid+1;
        }
        return arr.size()-ans;
    }
}