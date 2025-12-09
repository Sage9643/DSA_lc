class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int arr[]=new int[5];
        boolean vis[]=new boolean[croakOfFrogs.length()];

        for(char ch:croakOfFrogs.toCharArray()){
            if(ch=='c')arr[0]++;
            else if(ch=='r') {
                if(arr[0]>arr[1])arr[1]++;
                else return -1;}
            else if(ch=='o') {
                if(arr[0]>arr[2] && arr[1]>arr[2])arr[2]++;
                else return -1;}
            else if(ch=='a') {
                if(arr[0]>arr[3] && arr[1]>arr[3] && arr[2]>arr[3])arr[3]++;
                else return -1;}
            else if(ch=='k') {
                if(arr[0]>arr[4] && arr[1]>arr[4] && arr[2]>arr[4] && arr[3]>arr[4])arr[4]++;
                else return -1;}
        }
        int tot=arr[0];
        for(int f:arr){
            if(f!=tot) return -1;
        }
        int active=0;int ans=0;

        for(int i=0;i<croakOfFrogs.length();i++){
            if(croakOfFrogs.charAt(i)=='c') active++;
            if(croakOfFrogs.charAt(i)=='k'){
                ans=Math.max(ans,active);active--;
            }    
        }
        return ans;
    }
}