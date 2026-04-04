class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        char[][] arr=new char[rows][encodedText.length()/rows];
        int idx=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j]=encodedText.charAt(idx);
                idx++;
            }
        }StringBuilder sb=new StringBuilder();
        for(int i=0;i<arr[0].length;i++){
            int r=0,c=i;
            while(r<rows && c<arr[0].length){
                sb.append(arr[r][c]);
                r++;c++;
            }
        }for(int i=sb.length()-1;i>=0;i--){
            if(sb.charAt(i)!=' ')break;
            sb.deleteCharAt(i);
        }
        return sb.toString();
    }
}