/**
 * @author Vladimir Egorov
 *
 * Класс точки 
 * 
 */

package convex;

import java.io.Serializable;

public class Point implements Comparable<Point>, Serializable, Cloneable {
    
    private static final long serialVersionUID = -3516560417871036951L;

    public Point(Float x, Float y) {
            super();
            if (x==null || y==null){
                    throw new IllegalArgumentException();
            }
            this.x = x;
            this.y = y;
    }

    private Float x;
    private Float y;

    public Float getX() {
            return x;
    }

    public void setX(Float x) {
            if (x==null){
                    throw new IllegalArgumentException();
            }
            this.x = x;
    }

    public Float getY() {
            return y;
    }

    public void setY(Float y) {
            if (y==null){
                    throw new IllegalArgumentException();
            }
            this.y = y;
    }
    
    public static Point minus(Point p1, Point p2){
            Point p = new Point(p1.getX() - p2.getX(), p1.getY() - p2.getY());
            return p;
    }

    public static Point plus(Point p1, Point p2){
            Point p = new Point(p1.getX() + p2.getX(), p1.getY() + p2.getY());
            return p;
    }

    public static Float det(Point c1, Point c2) {
            return c1.getX() * c2.getY() - c1.getY() * c2.getX();
    }
    
    private static Float geo(Point c) {
            return c.getX() * c.getX() + c.getY() * c.getY();  
    }

    @Override
    public int compareTo(Point o) {

            Float detPoints = Point.det(this, o);
            if (detPoints > 0){
                    return -1;
            } else if (detPoints < 0){
                    return 1;
            }
            return Point.geo(this).compareTo(Point.geo(o));

    }
    
    @Override
    public String toString() {
            return "(" + String.valueOf(x) + ", " + String.valueOf(y) + ")";
    }
    
    @Override
    public boolean equals(Object o){
            if (o instanceof Point){
                    return this.getX().equals(((Point) o).getX()) && this.getY().equals(((Point) o).getY());
            }
            return false;
    }
    
    @Override
    public int hashCode(){
            return x.hashCode() * y.hashCode();
    }

}