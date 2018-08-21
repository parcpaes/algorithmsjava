import java.util.*;

public class Convexhull {

    public static class Point2D implements Comparable<Point2D> {
        public final double x;
        public final double y;
        public static final Comparator<Point2D> Y_ORDER = new YOrder();
        public final Comparator<Point2D> POLAR_ORDER = new PolarOrder();
        public Point2D(double x, double y){
            this.x = x;
            this.y = y;
        }
        public double x(){
            return x;
        }
        public double y(){
            return y;
        }

        public static int ccw(Point2D a, Point2D b, Point2D c){
            double area = (b.x- a.x)*(c.y-a.y) - (b.y-a.y)*(c.x-a.x);
            if(area < 0) return -1;
            if(area > 0) return +1;
            else return 0;
        }

        @Override
        public int compareTo(Point2D that){
            /*if(this.x == that.x){
                if(this.y > that.y) return 1;
                if(this.y < that.y) return -1;
            }else{
                if(this.x > that.x) return 1;
                if(this.x < that.x) return -1;
            }*/
            if(this.y < that.y) return -1;
            if(this.y > that.y) return +1;
            if(this.x < that.x) return -1;
            if(this.x > that.x) return +1;
            return 0;
        }
        public Comparator<Point2D> polarOrder()
        {
            return new Point2D.PolarOrder();
        }

        public static class YOrder implements Comparator<Point2D>{
            public int compare(Point2D p, Point2D q){
                if(p.y < q.y) return -1;
                if(p.y > q.y) return +1;
                if(p.x < q.x) return -1;
                if(p.x > q.x) return +1;
                return 0;
            }
        }

        private class PolarOrder implements Comparator<Point2D> {
            public int compare(Point2D q1, Point2D q2){
                double dx1 = q1.x - x;
                double dy1 = q1.y - y;
                double dx2 = q2.x - x;
                double dy2 = q2.y - y;

                if(dy1 >=0 && dy2 < 0) return -1;
                else if(dy2 >=0 && dy1 < 0)  return +1;
                else if(dy1 == 0 && dy2 ==0){
                    if(dx1 >=0 && dx2 < 0) return -1;
                    else if(dx2 >=0 && dx1 <0) return +1;
                    else return 0;
                }
                else return -ccw(Point2D.this, q1,q2);
            }
        }
    }
    public static void convexhull(Point2D points[]){
        Stack<Point2D> hull = new Stack<>();
        Arrays.sort(points);
        Arrays.sort(points,points[0].POLAR_ORDER);
        hull.push(points[0]);
        hull.push(points[1]);
        for(int i=2;i<points.length;i++){
            Point2D top = hull.pop();
            while(Point2D.ccw(hull.peek(),top,points[i])<0){
                top = hull.pop();
            }
            hull.push(top);
            hull.push(points[i]);
        }
        while(!hull.isEmpty()){
            Point2D p = hull.pop();
            System.out.printf("%f %f\n",p.x, p.y);
        }
    }
    public static void main(String arg[]){
        Convexhull c = new Convexhull();
        Point2D points[] = {
                new Point2D(1,2),
                new Point2D(2,2),
                new Point2D(4,2)
        };
        convexhull(points);
    }
}
