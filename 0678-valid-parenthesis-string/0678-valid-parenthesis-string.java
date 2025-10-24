class Solution {
    public boolean checkValidString(String str) {
        int minOpen=0,maxOpen=0;
        for(Character ch:str.toCharArray()){
            if(ch=='('){
                minOpen++;maxOpen++;
            }else if(ch==')'){
                minOpen--;maxOpen--;
            }else{//ch=='*'
                minOpen--;// * treated as )
                maxOpen++;// * treated as (
            }if(maxOpen<0) return false;//not enough opening brackets
            else if(minOpen<0) minOpen=0;
        }return minOpen==0;
    }
}