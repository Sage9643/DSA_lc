class Solution {
    public int bestClosingTime(String customers) {
        int totyes=0,totno=0;
        for(char ch:customers.toCharArray()){
            if(ch=='Y') totyes++;
            else totno++;
        }
        int curryes=0,currno=0;int i=0;
        int mintime=Integer.MAX_VALUE,minpen=Integer.MAX_VALUE;

        for(char ch:customers.toCharArray()){
            int currpen=0;
            if(ch=='Y') {curryes++;currpen++;}
            currpen+=currno+(totyes-curryes);

            if(currpen<minpen){
                minpen=currpen;mintime=i;
                System.out.println(mintime);
            }i++;
            if(ch=='N') currno++;
        }
        if(minpen>currno){
            minpen=currno;
            mintime=customers.length();
        }
        return mintime;
    }
}