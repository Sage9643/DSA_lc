class Solution {
    public double minAreaFreeRect(int[][] points) {
        if (points.length < 4) return 0;

        HashSet<String> seen = new HashSet<>();
        double minArea = Double.MAX_VALUE;
        double EPS = 1e-9;

        for (int[] p1 : points) {
            for (String str1 : seen) {
                String[] parts1 = str1.split(",");
                int[] p2 = new int[]{Integer.parseInt(parts1[0]), Integer.parseInt(parts1[1])};

                if (p1[0] != p2[0] || p1[1] != p2[1]) {
                    for (String str2 : seen) {
                        String[] parts2 = str2.split(",");
                        int[] p3 = new int[]{Integer.parseInt(parts2[0]), Integer.parseInt(parts2[1])};

                        if (isRightAngle(p1, p2, p3)) {
                            int x4 = p1[0] + p3[0] - p2[0];
                            int y4 = p1[1] + p3[1] - p2[1];

                            String p4str = x4 + "," + y4;
                            if (seen.contains(p4str)) {
                                double area = dist(p1, p2) * dist(p2, p3);
                                if (area > EPS)
                                    minArea = Math.min(minArea, area);
                            }
                        }
                    }
                }
            }seen.add(p1[0] + "," + p1[1]);
        }
        return (minArea == Double.MAX_VALUE) ? 0 : minArea;
    }

    // perpendicular if dot product = 0
    private boolean isRightAngle(int[] p1, int[] p2, int[] p3) {
        int x1 = p1[0] - p2[0], y1 = p1[1] - p2[1];
        int x2 = p3[0] - p2[0], y2 = p3[1] - p2[1];
        return (x1 * x2 + y1 * y2) == 0;
    }
    private double dist(int[] p1, int[] p2) {
        double dx = p1[0] - p2[0];
        double dy = p1[1] - p2[1];
        return Math.sqrt(dx * dx + dy * dy);
    }
}

