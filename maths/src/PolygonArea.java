public class PolygonArea {
    private static class Point{
        private double x;
        private double y;

        public Point(double x, double y){
            this.x = x;
            this.y = y;
        }
    }
    private static double crossProduct(Point a, Point b){
        return a.x*b.y-b.x*a.y;
    }
    public static double areaOfTriangle(Point a, Point b, Point c){
        return Math.abs(crossProduct(a , b)+crossProduct(b , c)+crossProduct(c , a))/2.0;
    }

    public static double areaPolygon(Point[] vertices, int noOfSides){
        double sum = 0.0;
        for(int i=0; i<noOfSides; i++){
            sum += crossProduct(vertices[i], vertices[(i+1)%noOfSides]);
        }
        return Math.abs(sum)/2.0;
    }

    public static void main(String[] args) {
        Point a = new Point(1, 4);
        Point  b = new Point(8, 4);
        Point c = new Point(6, 12);
        Point [] vertices = {a, b, c};
        System.out.println(areaPolygon(vertices, 3));
        System.out.println(areaOfTriangle(a, b, c));
    }

}
