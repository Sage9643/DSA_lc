class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans=new ArrayList<>();
        
        for(int i=1;i<10;i++){
            int num=i;
            int last=i+1;
            while(num<=high && last!=10){
                num=(num*10)+last;
                if(num>=low && num<=high) ans.add(num);
                last++;
            }
        }Collections.sort(ans);
        return ans;
    }
}