class Solution {
    public double angleClock(int hour, int minutes) {
        hour%=12;
        double hrangle=(hour*30)+(minutes*0.5);
        double minangle=minutes*6;

        return Math.min(Math.abs(hrangle-minangle),360-Math.abs(hrangle-minangle));
    }
}