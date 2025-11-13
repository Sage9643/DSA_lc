class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        int days=0;boolean hascycle=false;
        HashSet<String> uniq=new HashSet<>();

        for(int i=0;i<n;i++){
            int next[]=getNext(cells);
            String pattern=Arrays.toString(next);
            if(!uniq.contains(pattern)){
                uniq.add(pattern);days++;
            }else{
                hascycle=true;break;
            }cells=next;
        }if(hascycle){
            int N=n%days;
            for(int i=0;i<N;i++){
                int next[]=getNext(cells);
                cells=next;
            }
        }return cells;
    }
    public static int[] getNext(int[] cells){
        int next[]=new int[cells.length];
        for(int i=0;i<cells.length;i++){
            if(i==0 || i==cells.length-1) next[i]=0;
            else next[i]=cells[i-1]==cells[i+1]?1:0;
        }return next;
    }
}