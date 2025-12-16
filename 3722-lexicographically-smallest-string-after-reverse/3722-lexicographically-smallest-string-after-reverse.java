class Solution {
    public String lexSmallest(String s) {
        StringBuilder sb=new StringBuilder();
        char arr[]=s.toCharArray();
        String min=s;
        for(int i=0;i<arr.length;i++){    
            String rev=reverse(arr.clone(),0,i);
            if(min.compareTo(rev)>0) min=rev;        
        }for(int i=0;i<arr.length;i++){    
            String rev=reverse(arr.clone(),i,arr.length-1);
            if(min.compareTo(rev)>0) min=rev;        
        }
        return min;
    }public String reverse(char[] arr,int i,int j){
        StringBuilder sb=new StringBuilder();
        int k=0;
        while(k<arr.length && k!=i){
            sb.append(arr[k++]);
        }for(int m=j;m>=i;m--) sb.append(arr[m]);
        k=j+1;
        while(k<arr.length){
            sb.append(arr[k++]);
        }return sb.toString();
        
    }
}