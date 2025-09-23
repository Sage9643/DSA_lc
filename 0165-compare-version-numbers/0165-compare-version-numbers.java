class Solution {
    public int compareVersion(String version1, String version2) {
        String arr1[]=version1.split("\\.");
        String arr2[]=version2.split("\\.");

        int j=0;
        int i=0;
        for(;i<arr1.length && j<arr2.length;i++,j++){
            if(Integer.valueOf(arr1[i])>Integer.valueOf(arr2[j])) return 1;
            else if(Integer.valueOf(arr1[i])<Integer.valueOf(arr2[j])) return -1;
        }
        while(i<arr1.length){
            if(Integer.valueOf(arr1[i++])!=0) return 1;
        }
        while(j<arr2.length){
            if(Integer.valueOf(arr2[j++])!=0) return -1;
        }
        return 0;

    }
}