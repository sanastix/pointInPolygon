package org.example;

import java.util.Scanner;

class Point {
    long x, y;

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        long px = scanner.nextLong();
        long py = scanner.nextLong();

        Point[] polygon = new Point[N];
        for (int i = 0; i < N; i++) {
            long x = scanner.nextLong();
            long y = scanner.nextLong();
            polygon[i] = new Point(x, y);
        }

        boolean inside = isPointInPolygon(px, py, polygon);

        if (inside) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        scanner.close();
    }

    public static boolean isPointInPolygon(long px, long py, Point[] polygon) {
        int n = polygon.length;
        boolean inside = false;

        for (int i = 0, j = n - 1; i < n; j = i++) {
            long xi = polygon[i].x;
            long yi = polygon[i].y;
            long xj = polygon[j].x;
            long yj = polygon[j].y;

            if ((yi > py) != (yj > py) &&
                    px < xi + (xj - xi) * (py - yi) / (yj - yi)) {
                inside = !inside;
            }
        }

        return inside;

    }

}
