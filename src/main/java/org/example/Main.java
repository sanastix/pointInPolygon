package org.example;

import java.util.Scanner;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int px = scanner.nextInt();
        int py = scanner.nextInt();

        Point[] polygon = new Point[N];
        for (int i = 0; i < N; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
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

    public static boolean isPointInPolygon(int px, int py, Point[] polygon) {
        int n = polygon.length;
        boolean inside = false;

        for (int i = 0, j = n - 1; i < n; j = i++) {
            if ((polygon[i].y > py) != (polygon[j].y > py) &&
                    px < (polygon[j].x - polygon[i].x) * (py - polygon[i].y) / (polygon[j].y - polygon[i].y) + polygon[i].x) {
                inside = !inside;
            }
        }

        return inside;
    }

}