package leetcode;

import java.util.*;

public class Fence587 {
    static class Point{
        int x;
        int y;
        public Point(){ x = 0; y =0;}
        public Point(int a, int b){
            this.x = a;
            this.y = b;
        }
    }
    public int dist(Point p1, Point p2){
        return (int)Math.hypot(p2.x-p1.x, p2.y -p2.y);
    }
    public int ccw(Point O, Point A, Point B){
        return (A.x -O.x)*(B.y-O.y) - (A.y - O.y)*(B.x-O.x);
    }
    public Point[] sortPolar(Point points[]){
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.y == o2.y) return o1.x - o2.x;
                else  return o1.y - o2.y;
            }
        });
        Point p0 = points[0];
        Comparator<Point> polar = new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                double angle1 = Math.atan2((o1.y - p0.y),(o1.x - p0.x));
                double angle2 = Math.atan2((o2.y - p0.y),(o2.x - p0.x));
                if(angle1<angle2) return -1;
                else if(angle1 > angle2) return 1;
                else return dist(p0,o1) - dist(p0,o2);
            }
        };
        Arrays.sort(points,1,points.length,polar);
        return points;
    }
    public List<Point> outerTrees(Point[] points){
        if (points.length <= 1)  return Arrays.asList(points);
        Stack<Point> hull = new Stack<>();
        points = sortPolar(points);

        int i = points.length-1;
        while(i>=0 && ccw(points[0],points[points.length-1], points[i]) == 0) i--;

        for(int l = i+1, h=points.length-1; l<h; l++, h--){
            Point temp = points[l];
            points[l] = points[h];
            points[h] = temp;
        }
        System.out.println(points[0].x+" - "+points[0].y);
        hull.push(points[0]);
        hull.push(points[1]);
        for(i=2;i<points.length;i++){
            Point top = hull.pop();
            while(ccw(hull.peek(),top, points[i]) < 0){
                top = hull.pop();
            }
            hull.push(top);
            hull.push(points[i]);
        }
        return new ArrayList<>(hull);
    }
    public static void main(String arg[]){
        Fence587 fence = new Fence587();
        Point points[] = {
                new Point(3,0),
                new Point(4,0),
                new Point(5,0),
                new Point(6,1),
                new Point(7,2),
                new Point(7,3),
                new Point(7,4),
                new Point(6,5),
                new Point(5,5),
                new Point(4,5),
                new Point(3,5),
                new Point(2,5),
                new Point(1,4),
                new Point(1,3),
                new Point(1,2),
                new Point(2,1),
                new Point(4,2),
                new Point(0,3)
        };
        List<Point> result = fence.outerTrees(points);
        for(Point p: result){
            System.out.printf("[%d %d],",p.x,p.y);
        }
    }
}
