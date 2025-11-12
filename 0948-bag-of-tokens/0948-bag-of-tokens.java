class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);int score=0;int maxscore=0;

        int i=0,j=tokens.length-1;
        while(i<=j){
            if(power>=tokens[i]){
                score++;power-=tokens[i];i++;
                maxscore=Math.max(maxscore,score);
            }else if(score>0){
                score--;power+=tokens[j];j--;
            }else break;
        }return maxscore;
        
    }
}