class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> nums=new ArrayList<>();
        for(int i=1;i<=n;i++)nums.add(i);
        Collections.sort(nums,(a,b)->{
            String num1=Integer.toString(a);
            String num2=Integer.toString(b);
            return num1.compareTo(num2);
        });      
        return nums; 
    }
} 
