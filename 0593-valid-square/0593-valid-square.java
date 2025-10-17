class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if(Arrays.equals(p1,p2)||Arrays.equals(p1,p3)||Arrays.equals(p1,p4)||Arrays.equals(p2,p3)||Arrays.equals(p3,p4)||p3.equals(p4)) return false;
        HashSet<Double> set=new HashSet<>();
        //for p1 and p2
        set.add(Math.pow(Math.abs(p1[0]-p2[0]),2)+Math.pow(Math.abs(p1[1]-p2[1]),2));
        //p1 and p3
        set.add(Math.pow(Math.abs(p1[0]-p3[0]),2)+Math.pow(Math.abs(p1[1]-p3[1]),2));
        //p1 and p4
        set.add(Math.pow(Math.abs(p1[0]-p4[0]),2)+Math.pow(Math.abs(p1[1]-p4[1]),2));
        //p2 and p3
        set.add(Math.pow(Math.abs(p2[0]-p3[0]),2)+Math.pow(Math.abs(p2[1]-p3[1]),2));
        //p2 and p4
        set.add(Math.pow(Math.abs(p2[0]-p4[0]),2)+Math.pow(Math.abs(p2[1]-p4[1]),2));
        //p4 and p3
        set.add(Math.pow(Math.abs(p4[0]-p3[0]),2)+Math.pow(Math.abs(p4[1]-p3[1]),2));
        
        if(set.size()==2) return true;
        return false;
    }
}