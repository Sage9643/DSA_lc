class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int count=0;
        for(String op:operations){
            if(op.charAt(0)=='-' || op.charAt(2)=='-') count--;
            else count++;
        }return count;
    }
}