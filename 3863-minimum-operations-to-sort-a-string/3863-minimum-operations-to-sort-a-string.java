class Solution {
    public int minOperations(String s) {
        int n=s.length();

        boolean sorted=true;
        char minchar=s.charAt(0);
        char maxchar=s.charAt(0);

        for(int i=1;i<n;i++){
            if(s.charAt(i-1)>s.charAt(i)) sorted=false;

            if(minchar>s.charAt(i)) minchar=s.charAt(i);
            if (maxchar<s.charAt(i)) maxchar=s.charAt(i);
        }

        if(sorted) return 0;
        if(n==2) return -1;

        if(s.charAt(0)==minchar || s.charAt(n-1)==maxchar) return 1;

        for(int i=1;i<n-1;i++){
            if(s.charAt(i)==minchar || s.charAt(i)==maxchar) return 2;
        }
        return 3;
    }
}