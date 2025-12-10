class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        
        int arr1[]=new int[26];
        int arr2[]=new int[26];

        for(char ch:s1.toCharArray())arr1[ch-'a']++;
        for(char ch:s2.toCharArray())arr2[ch-'a']++;

        int i=0,j=0;
        boolean v1=true,v2=true;
        //s1 stronger than s2
        int arr3[]=arr1.clone();
        int arr4[]=arr2.clone();
        while(i<26 && j<26){
            while(i<26 && arr1[i]==0)i++;
            while(j<26 && arr2[j]==0)j++;
            if(i<26 && j<26 && i<j ) {
                v1=false;break;
            }else if(i<26 && j<26 && i>=j ){
                if(arr2[j]>=arr1[i]){arr2[j]-=arr1[i]; arr1[i]=0;}
                else {arr1[i]-=arr2[j];arr2[j]=0;}
            }
        }i=0;j=0;
        //s2 stronger than s1
        while(i<26 && j<26){
            while(i<26 && arr3[i]==0)i++;
            while(j<26 && arr4[j]==0)j++;
            if(i<26 && j<26 && i>j) {
                v2=false;break;
            }else if(i<26 && j<26 && i<=j){
                if(arr4[j]>=arr3[i]){arr4[j]-=arr3[i]; arr3[i]=0;}
                else {arr3[i]-=arr4[j];arr4[j]=0;}
            }

        }
        return v1||v2;
    }
}