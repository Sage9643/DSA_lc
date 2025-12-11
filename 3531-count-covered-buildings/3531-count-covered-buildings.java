class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Arrays.sort(buildings,(a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];});
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();

        for(int arr[]:buildings){
            if(!map.containsKey(arr[1])) map.put(arr[1],new ArrayList<>());
            map.get(arr[1]).add(arr[0]);
        }
        int cnt=0;
        for(int i=1;i<buildings.length-1;i++){
            if(buildings[i-1][0]==buildings[i][0] && buildings[i+1][0]==buildings[i][0] && buildings[i-1][1]<buildings[i][1] && buildings[i+1][1]>buildings[i][1]){
                ArrayList<Integer> y=map.get(buildings[i][1]);
                int idx=bs(y,buildings[i][0]);
                if(idx>0 && idx<y.size()-1) cnt++;
            }
        }return cnt;
    }public int bs(ArrayList<Integer> arr,int el){
        int start=0,end=arr.size()-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr.get(mid)==el) return mid;
            else if(arr.get(mid)<el) start=mid+1;
            else end=mid-1;
        }return -1;
    }
}