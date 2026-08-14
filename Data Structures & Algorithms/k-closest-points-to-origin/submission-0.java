class Solution {
    public int[][] kClosest(int[][] points, int k) {
        points = quickSort(points, 0, points.length - 1);
        int[][] res = new int[k][];
        for (int i = 0; i < k; i++) {
            res[i] = points[i];
        }

        return res;
    }

    private int[][] quickSort(int[][] points, int s, int e) {
        if (s >= e) {
            return points;
        }

        int[] pivot = points[e];
        int left = s;

        for (int i = s; i <= e; i++) {
            if (len(points[i]) < len(pivot)) {
                int[] temp = points[left];
                points[left] = points[i];
                points[i] = temp;
                left++;
            }
        }

        points[e] = points[left];
        points[left] = pivot;

        quickSort(points, s, left - 1);
        quickSort(points, left + 1, e);

        return points;
    }

    private double len(int[] p) {
        return Math.sqrt(p[0] * p[0] + p[1] * p[1]);
    }
}
