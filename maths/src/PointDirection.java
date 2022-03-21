public class PointDirection {
    private static class Point{
        private double x;
        private double y;

        public Point(double x, double y){
            this.x = x;
            this.y = y;
        }
    }
  // This function will give direction of point p from line connecting point a and b
    public static void findDirection(Point a, Point b, Point p){
        b = subtract(b, a);  //After translation a becomes origin
        p = subtract(p, a);
        double cp = crossProduct(b, p);
        if(cp >0)
            System.out.println("LEFT");
        else if(cp < 0)
            System.out.println("RIGHT");
        else
            System.out.println("ON THE LINE");
    }
    private static double crossProduct(Point a, Point b){
        return a.x*b.y-b.x*a.y;
    }

    private static Point subtract(Point b, Point a) {
        Point result= new Point(b.x-a.x,  b.y-a.y);
        return result;
    }

    public static void main(String[] args) {
        Point a = new Point(1, 6);
        Point b = new Point(8, 4);
        Point p = new Point(6, 12);
        findDirection(a, b, p);
    }
}
