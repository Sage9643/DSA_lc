class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n=intervals.size(); 
        int arr[][]=new int[n][4]; 
 
        for(int i=0;i<n;i++){ 
            arr[i][0]=intervals.get(i).get(0); 
            arr[i][1]=intervals.get(i).get(1); 
            arr[i][2]=intervals.get(i).get(2); 
            arr[i][3]=i; 
        } 
        Arrays.sort(arr,(a,b)->a[0]-b[0]); 
        int next[]=new int[n]; 
 
        for(int i=0;i<n;i++){ 
            int start=i+1,end=n; 
 
            while (start<end) { 
                int mid=(start+end)/2; 
                if (arr[mid][0]>arr[i][1]) end=mid; 
                else start=mid+1; 
            } 
            next[i]=start; 
        } 
        long dp[][]=new long[n+1][5]; 
        int best[][][]=new int[n+1][5][]; 
 
        for(int i=n-1;i>=0;i--){ 
            for(int k=1;k<=4;k++){ 
                
                long skip=dp[i+1][k]; 
                int takeArr[]=add(best[next[i]][k-1],arr[i][3]); 
                long take=arr[i][2]+dp[next[i]][k-1]; 
 
                if(take>skip || (take==skip && smaller(takeArr,best[i+1][k]))){ 
                    dp[i][k]=take; 
                    best[i][k]=takeArr; 
                }else{ 
                    dp[i][k]=skip; 
                    best[i][k]=best[i+1][k]; 
                } 
            } 
        }
        return best[0][4]; 
    } 
    public static int[] add(int a[],int x){ 
        if(a==null) return new int[]{x}; 
 
        int res[]=new int[a.length+1]; 
        int i=0; 
 
        while(i<a.length && a[i]<x){ 
            res[i]=a[i]; 
            i++; 
        } 
        res[i]=x; 
        while(i<a.length){ 
            res[i+1]=a[i]; 
            i++; 
        } 
        return res; 
    } 
    public static boolean smaller(int a[],int b[]){ 
        if(b==null) return true; 
 
        for(int i=0;i<Math.min(a.length,b.length);i++){ 
            if(a[i]!=b[i]) return a[i]<b[i]; 
        } 
        return a.length<b.length; 
    }
}