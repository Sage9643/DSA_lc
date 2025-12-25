class Solution {
    public int[] getStrongest(int[] arr, int k) {
        int f[][]=new int[arr.length][2];
        Arrays.sort(arr);
        int m=arr[(arr.length-1)/2];
        int diff[]=new int[arr.length];

        HashMap<Integer,Integer> map=new HashMap<>();

        int i=0;
        for(int a:arr){
            map.put(a,map.getOrDefault(a,0)+1);
            diff[i++]=Math.abs(a-m);
        }Arrays.sort(diff);

        i=0;
        for(int a:arr){
            int ans=Math.abs(a-m);
            int idx=bs(diff,ans)+1;
            idx-=map.get(a);

            if(map.containsKey(ans+m) && (ans+m)!=a && (ans+m)>a) idx-=map.get(ans+m);

            f[i][0]=a;f[i++][1]=idx;
        }
        Arrays.sort(f,(a,b)->{
            return b[1]-a[1];
        });

        int res[]=new int[k];
        for(int j=0;j<k;j++){
            res[j]=f[j][0];
        }
        return res;

    }public static int bs(int[] diff,int ans){
        int start=0,end=diff.length-1;
        int idx=-1;

        while(start<=end){
            int mid=(start+end)/2;

            if(diff[mid]<=ans){
                idx=mid;
                start=mid+1;
            }else end=mid-1;
        }
        return idx;
    }
}