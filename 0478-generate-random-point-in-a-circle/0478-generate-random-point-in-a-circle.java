class Solution {
    double details[]=new double[3];
    Random rand=new Random();
    public Solution(double radius, double x_center, double y_center) {
        details[0]=radius;
        details[1]=x_center;
        details[2]=y_center;
    }
    
    public double[] randPoint() {
        double theta=2*Math.PI*rand.nextDouble();
        double r=details[0]*Math.sqrt(rand.nextDouble());

        double X=details[1]+r*Math.cos(theta);
        double Y=details[2]+r*Math.sin(theta);

        return new double[]{X,Y};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */