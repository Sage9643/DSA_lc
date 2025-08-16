class Solution {
    public int maximum69Number (int num) {
        String str=Integer.toString(num);
        StringBuilder sb=new StringBuilder();
        boolean changed=false;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='6' && !changed){
                sb.append("9");
                changed=true;
            }else sb.append(str.charAt(i));
        }return Integer.parseInt(sb.toString());

    }
}