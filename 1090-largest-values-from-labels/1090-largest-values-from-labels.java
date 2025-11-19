class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int arr[][]=new int[values.length][2];
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<values.length;i++) {arr[i]=new int[]{values[i],labels[i]};map.put(labels[i],0);}

        Arrays.sort(arr,(a,b)->b[0]-a[0]);
        int sum=0;int cnt=0;

        for(int i=0;i<values.length;i++){
            if(map.get(arr[i][1])<useLimit){
                sum+=arr[i][0];
                map.put(arr[i][1],map.get(arr[i][1])+1);
                cnt++;
            }if(cnt==numWanted) break;

        }return sum;
    }
}