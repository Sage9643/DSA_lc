class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int barcode:barcodes) map.put(barcode,map.getOrDefault(barcode,0)+1);

        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->b[1]-a[1]);

        for(int barcode:map.keySet()) q.add(new int[]{barcode,map.get(barcode)});

        Arrays.fill(barcodes,0);int idx=0;

        while(!q.isEmpty()){
            int first[]=q.remove();
            if((idx==0)||(idx>0 && barcodes[idx-1]!=first[0])){
                barcodes[idx++]=first[0];
                first[1]--;
            }
            if(!q.isEmpty()){
                int second[]=q.remove();
                barcodes[idx++]=second[0];
                second[1]--;
                if(second[1]>0) q.add(second);
            }
            
            if(first[1]>0) q.add(first);
        }return barcodes;
    }
}