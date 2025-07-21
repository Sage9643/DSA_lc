class Solution {
    public String largestNumber(int[] nums) {
        Comparator<String> com=new Comparator<String>(){
            public int compare(String a,String b){
                String ord1=a+b;
                String ord2=b+a;
                return ord2.compareTo(ord1);
            }
        };
        int count0=0;
        List<String> num=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                count0++;
            }num.add(Integer.toString(nums[i]));
                
        }Collections.sort(num,com);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<num.size();i++){
            sb.append(num.get(i));
        }return sb.length()==count0? "0":sb.toString();
    }
}