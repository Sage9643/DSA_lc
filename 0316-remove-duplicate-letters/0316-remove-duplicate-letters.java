class Solution {
    public String removeDuplicateLetters(String s) {
        int letterCount[]=new int[26];//maintaining count for each letter in given string
       
        for(int i=0;i<s.length();i++){
            letterCount[s.charAt(i)-'a']++;
        }
        boolean occurence[]=new boolean[26];
        Stack<Character> stack=new Stack<>();

        for(int i=0;i<s.length();i++){
            while(!stack.isEmpty() && s.charAt(i) < stack.peek() && letterCount[stack.peek() -'a']>0 && !occurence[s.charAt(i) - 'a']){
                occurence[stack.peek() - 'a']=false;
                stack.pop();
                
            }
            if(!occurence[s.charAt(i) - 'a']){
                stack.push(s.charAt(i));
                occurence[s.charAt(i) - 'a']=true;
                letterCount[s.charAt(i) - 'a']--;
            }else{
                letterCount[s.charAt(i) - 'a']--;
            }
        }StringBuilder unique=new StringBuilder();
        while(!stack.isEmpty()){
            unique.append(stack.pop());
        }return unique.reverse().toString();
    }
}