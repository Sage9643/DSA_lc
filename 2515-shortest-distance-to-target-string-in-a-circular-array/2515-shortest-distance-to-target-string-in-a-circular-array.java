class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int ans=Integer.MAX_VALUE;
        int n=words.length;
        for(int i=0;i<n;i++){
            int left=((startIndex-i)+n)%n;
            int right=(startIndex+i)%n;

            if(words[left].equals(target) || words[right].equals(target)) ans=Math.min(ans,i);
            
        }if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
}