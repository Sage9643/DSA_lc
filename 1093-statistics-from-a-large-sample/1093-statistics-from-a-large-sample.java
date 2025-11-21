class Solution {
    public double[] sampleStats(int[] count) {
        double min=256,max=0,mean=0,median=0,mode=0,cnt=0,high=0;

        for(int c:count) cnt+=c;

        for(int i=0;i<256;i++){
            if(count[i]>0){
                min=Math.min(min,i);
                max=i;
                mean+=((double)(count[i]/cnt)*i);
                if(high<count[i]) {mode=i;high=count[i];}
            }
        }if(cnt%2==0){
            double occ=cnt/2;
            int sum=0;
            for(int i=0;i<256;i++){
                sum+=count[i];
                if(sum==occ){
                    median+=i;i++;
                    while(i<count.length && count[i]==0) i++;
                    median+=i;
                    median=(double)median/2;
                    break;
                    
                }else if(sum>occ) {median=i;break;}
            }
        }else{
            double occ=Math.ceil(cnt/2);
            int sum=0;
            for(int i=0;i<256;i++){
                sum+=count[i];
                if(sum>=occ){
                    median=i;
                    break;
                }
            }
        }return new double[] {min,max,mean,median,mode};


    }
}