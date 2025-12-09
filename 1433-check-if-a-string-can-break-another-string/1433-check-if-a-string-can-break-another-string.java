class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] arr1=s1.toCharArray();
        char[] arr2=s2.toCharArray();
        Arrays.sort(arr1);Arrays.sort(arr2);

        boolean v1=true;boolean v2=true;
        //if s1 stronger than s2
        for(int i=0;i<s1.length();i++){
            if(arr1[i]<arr2[i]){
                v1=false;break;
            }
        }
        //if s2 stronger than s1
        for(int i=0;i<s1.length();i++){
            if(arr1[i]>arr2[i]){
                v2=false;break;
            }
        }return v1||v2;

    }
}