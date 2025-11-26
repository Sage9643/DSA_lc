class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        String [][] info=new String[transactions.length][4];
        int idx=0;
        for(String transaction:transactions){
            String t[]=transaction.split(",");
            info[idx++]=t;
        }
        List<String> invalid=new ArrayList<>();
        boolean vis[]=new boolean[transactions.length];

        for(int i=0;i<transactions.length;i++){
            if(Integer.parseInt(info[i][2])>1000) {
                if(!vis[i]){
                    invalid.add(transactions[i]);
                    vis[i]=true;
                }
            }for(int j=i+1;j<transactions.length;j++){
                if((info[i][0].equals(info[j][0])) && !(info[i][3].equals(info[j][3])) && Math.abs(Integer.parseInt(info[i][1])-Integer.parseInt(info[j][1]))<=60) {
                    if(!vis[j]){
                        invalid.add(transactions[j]);
                        vis[j]=true;
                    }if(!vis[i]){
                        invalid.add(transactions[i]);
                        vis[i]=true;
                    }
                }
            }
        }
         
        return invalid; 
    }
}