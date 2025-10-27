class Solution {
    public int numberOfBeams(String[] bank) {
        int countcurr=0,countnext=0;
        int beams=0;
        for(int i=0;i<bank[0].length();i++){
            if(bank[0].charAt(i)=='1') countcurr++;
        }
        for(int i=1;i<bank.length;i++){
            while(countnext==0 && i<bank.length){
                for(int j=0;j<bank[i].length();j++){
                    if(bank[i].charAt(j)=='1') countnext++;
                }if(countnext==0) i++;
            }beams+=countcurr*countnext;
            countcurr=countnext;countnext=0;   
        }return beams;
    }
}