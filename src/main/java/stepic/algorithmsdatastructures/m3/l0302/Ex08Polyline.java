/*
    Задано N точек на плоскости. Указать (N-1)-звенную несамопересекающуюся 
    незамкнутую ломаную, проходящую через все эти точки.
    Стройте ломаную в порядке возрастания x-координаты. 
    Если имеются две точки с одинаковой x-координатой, 
    то расположите раньше ту точку, у которой y-координата меньше.
    Для сортировки точек реализуйте пирамидальную сортировку.
    Sample Input:
        4
        0 0
        1 1
        1 0
        0 1
    Sample Output:
        0 0
        0 1
        1 0
        1 1
 */
package stepic.algorithmsdatastructures.m3.l0302;

public class Ex08Polyline {
    public static void main(String[] args) {
        java.util.Scanner in = new java.util.Scanner(System.in);
        int n = in.nextInt();
        Point[] data = new Point[n];
        int x, y;
        for (int i = 0; i < n; ++i) {
            x = in.nextInt();
            y = in.nextInt();
            data[i] = new Point(x, y);
        }
        in.close();
        
        sort(data);
        
        for (int i = 0; i < data.length; ++i) {
            System.out.println(data[i]);
        }
        
    }

    /** Implements heap sorting. */
    private static void sort(Point[] data) {
        buildHeap(data);
        
        int heapSize = data.length;
        while (heapSize > 1) {
            swap(data, 0, --heapSize);
            siftDown(0, data, heapSize);
        }
    }
    
    private static class Point implements Comparable<Point> {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point p2) {
            if (x < p2.x) {
                return -1;
            } else if (x > p2.x) {
                return 1;
            } else {
                if (y < p2.y) {
                    return -1;
                } else if (y > p2.y) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    private static void buildHeap(Point[] data) {
        int heapSize = data.length;
        int lastParent = (data.length - 2) / 2;
        for (int p = lastParent; p >= 0; p--) {
            siftDown(p, data, heapSize);
        }
    }

    private static void siftDown(int parent, Point[] data, int heapSize) {
        int left = parent * 2 + 1;
        if (left < heapSize) {
            int greater = left;
            int right = parent * 2 + 2;
            if (right < heapSize 
                    && data[right].compareTo(data[left]) > 0) {
                greater = right;
            }
            if (data[greater].compareTo(data[parent]) > 0) {
                swap(data, parent, greater);
                siftDown(greater, data, heapSize);
            }
        }
    }

    private static void swap(Point[] data, int i, int j) {
        Point tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

}
