class Solution {
    public int[] plusOne(int[] digits) {
        int carry=1;
        ArrayList<Integer> arr=new ArrayList<>();

        for(int i=digits.length-1;i>=0;i--){
            int sum=digits[i]+carry;
            arr.add(sum%10);
            carry=sum/10;
        }if(carry>0) arr.add(carry);
        int ans[]=new int[arr.size()];

        for(int i=0;i<ans.length;i++){
            ans[i]=arr.get(arr.size()-1-i);
        }return ans;

    }
}