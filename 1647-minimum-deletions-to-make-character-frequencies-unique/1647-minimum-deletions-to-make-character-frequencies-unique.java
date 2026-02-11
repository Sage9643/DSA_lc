class Solution {
    public int minDeletions(String s) {
        int freq[]=new int[26];
        for(char ch:s.toCharArray()) freq[ch-'a']++;

        Arrays.sort(freq);

        HashSet<Integer> set=new HashSet<>();
        for(int i:freq){
            if(i!=0) set.add(i);
        }
        
        int cnt=0;

        for(int i=1;i<freq.length;i++){
            if((freq[i]!=0 && freq[i-1]!=0) && freq[i-1]==freq[i]){
                int f=freq[i];
                while(set.contains(f)){
                    if(f==0) break;
                    cnt++;
                    f--;
                }set.add(f);
            }

        }return cnt;
    }
}