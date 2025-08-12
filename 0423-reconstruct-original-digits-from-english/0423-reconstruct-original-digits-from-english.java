class Solution {
    public String originalDigits(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for (char c:s.toCharArray()) {
            count.put(c,count.getOrDefault(c,0)+1);
        }
        String[] words={"zero","one","two","three","four","five","six","seven","eight","nine"};
        int[] digitCount=new int[10];
        // Creating array based on unique character in each number
        int[] order={0, 2, 4, 6, 8, 3, 5, 7, 1, 9};
        char[] unique={'z', 'w', 'u', 'x', 'g', 'h', 'f', 's', 'o', 'i'};

        for (int i=0;i<order.length;i++) {
            int digit=order[i];
            char uniq=unique[i];
            int cnt=count.getOrDefault(uniq, 0);
            digitCount[digit]=cnt;
            if (cnt>0){
                for(char c:words[digit].toCharArray()) {
                    count.put(c, count.getOrDefault(c, 0) - cnt);
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<10;i++) {
            for(int j=0;j<digitCount[i];j++) {
                sb.append(i);
            }
        }return sb.toString();
    }
}
