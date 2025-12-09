class Solution {
    public int maxDiff(int num) {
        String n=Integer.toString(num);
        char start=n.charAt(0);

        HashSet<Character> set=new HashSet<>();
        for(char ch:n.toCharArray()) set.add(ch);

        int maxdiff=Integer.MIN_VALUE;
        for(char ch:set){
            for(int i=0;i<10;i++){
                if(ch!=start || i!=0){
                    StringBuilder sb=new StringBuilder();
                    for(char c:n.toCharArray()){
                        if(ch==c) sb.append((char)(i+'0'));
                        else sb.append(c);
                    }int a=Integer.parseInt(sb.toString());
                    for(char cn:set){
                        for(int j=0;j<10;j++){
                            if(cn!=start || j!=0){
                                StringBuilder sb1=new StringBuilder();
                                for(char c:n.toCharArray()){
                                    if(cn==c) sb1.append((char)(j+'0'));
                                    else sb1.append(c);
                                }int b=Integer.parseInt(sb1.toString());
                                maxdiff=Math.max(maxdiff,Math.abs(a-b));
                            }
                        
                        }
                    }
                }
                
            }
        }return maxdiff;
    }
}