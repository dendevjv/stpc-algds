package stepic.algorithmsdatastructures.m3.l0302;

public class Ex09Segments {

    public static void main(String[] args) {
        java.util.Scanner in = new java.util.Scanner(System.in);

        int n = in.nextInt();
        java.util.List<SegmentPoint> points = new java.util.ArrayList<>(n * 2);
        int start, end;
        for (int i = 0; i < n; i++) {
            start = in.nextInt();
            end = in.nextInt();
            points.add(new SegmentPoint(start, true));
            points.add(new SegmentPoint(end, false));
        }
        in.close();

        int result = calculateOneLayerLength(points);
        System.out.println(result);
    }

    static int calculateOneLayerLength(java.util.List<SegmentPoint> points) {
        mergeSort(points, 0, points.size());

        int result = 0;
        int count = 0;
        SegmentPoint prev, current;
        for (int i = 0; i < points.size(); i++) {
            current = points.get(i);
            if (i > 0 && count == 1) {
                prev = points.get(i - 1);
                result += current.x - prev.x;
            }
            if (current.isStart()) {
                count++;
            } else {
                count--;
            }
        }
        return result;
    }

    private static void mergeSort(java.util.List<SegmentPoint> points, int from, int to) {
        int length = to - from;
        if (length < 2) {
            return;
        }
        int from2 = from + length / 2;
        mergeSort(points, from, from2);
        mergeSort(points, from2, to);

        merge(points, from, from2, to);
    }

    private static void merge(java.util.List<SegmentPoint> points, int from, int from2, int to) {
        java.util.List<SegmentPoint> buffer = new java.util.ArrayList<>(to - from);
        int i = from;
        int j = from2;
        while (i < from2 && j < to) {
            SegmentPoint p1 = points.get(i);
            SegmentPoint p2 = points.get(j);
            if (p1.compareTo(p2) < 0) {
                buffer.add(p1);
                i++;
            } else {
                buffer.add(p2);
                j++;
            }
        }
        while (i < from2) {
            buffer.add(points.get(i++));
        }
        while (j < to) {
            buffer.add(points.get(j++));
        }
        for (int dest = from, k = 0; k < buffer.size(); k++, dest++) {
            points.set(dest, buffer.get(k));
        }
    }

    static class SegmentPoint implements Comparable<SegmentPoint> {
        int x;
        boolean start;

        SegmentPoint(int x, boolean start) {
            this.x = x;
            this.start = start;
        }

        boolean isStart() {
            return start;
        }

        @Override
        public int compareTo(SegmentPoint o) {
            return Integer.compare(x, o.x);
        }

        @Override
        public String toString() {
            return "SegmentPoint {x=" + x + ", " + (start ? "start" : "end") + "}";
        }
    }
}
