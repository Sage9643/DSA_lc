class Solution {
    public List<String> letterCombinations(String digits) {
        String map[]={"","", "abc" ,"def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> combinations=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        keypadCombination(digits,map,combinations,0,sb);
        return combinations;

    }public static void keypadCombination(String digits,String[] map,List<String> combinations,int idx,StringBuilder sb){
        if(idx==digits.length()){
            if(sb.length()>0){
                combinations.add(sb.toString());
            }
            return;
        }int digit = digits.charAt(idx) - '0';
        String letters = map[digit];
        for(int i=0;i<letters.length();i++){
            keypadCombination(digits,map,combinations,idx+1,sb.append(letters.charAt(i)));
            sb.deleteCharAt(sb.length()-1);
        }
    }
}