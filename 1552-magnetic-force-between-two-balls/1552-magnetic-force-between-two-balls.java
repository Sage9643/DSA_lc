class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int minf=1;
        int maxf=position[position.length-1]-position[0];
        int pos=0;

        while(minf<=maxf){
            int midf=(minf+maxf)/2;

            if(ispossible(position,midf,m)){
                pos=midf;minf=midf+1;
            }else maxf=midf-1;
        }
        return pos;
    }public static boolean ispossible(int[] position,int midf,int m){
        int cnt=1;int prev=position[0];

        for(int i=1;i<position.length;i++){
            if(position[i]-prev>=midf){
                cnt++;prev=position[i];
            }
            if(cnt==m) break;
        }
        if(cnt>=m) return true;
        return false;
    }
}