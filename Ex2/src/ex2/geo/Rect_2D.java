package ex2.geo;

/**
 /**
 * This class represents a 2D axis-parallel rectangle in the plane.
 * It is defined by two opposite corner points, the right upper and left lower corners. * Ex4: you should implement this class!
 *
 *
 * * ID 315489534
 * @author I2CS
 */
public class Rect_2D implements GeoShape {
    Point_2D rightUp;
    Point_2D rightLow;
    Point_2D leftUp;
    Point_2D leftLow;


    /**
     * Checks if one point is above another point on the y-axis.
     *
     * @param one The first point.
     * @param tow The second point.
     * @return True if the first point is above the second point, false otherwise.
     */
    public boolean above(Point_2D one, Point_2D tow) {
        if (one.y() > one.y()) return true; // if the y of one is bigger then y of tow reutnr true
        return false;
    }

    /**
     * Returns a string representation of the rectangle in the format:
     * "rightUp, rightLow, leftLow, leftUp".
     *
     * @return A string representation of the rectangle.
     */

    public String toString() {
        return rightUp + "," + rightLow + "," + leftLow + "," +leftUp;

    }

    /**
     * Checks if one point is to the right of another point on the x-axis.
     *
     * @param one The first point.
     * @param tow The second point.
     * @return True if the first point is to the right of the second point, false otherwise.
     */
    public boolean right(Point_2D one, Point_2D tow) {
        if (one.x() > tow.x()) return true; // if the x of one is bigger then x of the tow so its righter
        return false;
    }

    /**
     * cheack if the Reck_2D is equal to my recktnagle by cheacking voth as the same points
     * @param ot objeckt of Reck_2D.
     * @return True if the first all the points are equals, false otherwise.
     */
    public  boolean equals(Object ot){
        if(ot == null || !(ot instanceof Rect_2D)) return false;
        Rect_2D p1 = (Rect_2D) ot;
        System.out.println(p1.toString());
        return p1.leftUp.equals(leftUp)&& p1.leftLow.equals(leftLow)&& p1.rightLow.equals(rightLow)&&p1.rightUp.equals(rightUp) ; // if all the points are equal return true
    }

    public Point_2D getRightUp() {
        return rightUp;
    }

    public Point_2D getRightLow() {
        return rightLow;
    }

    public Point_2D getLeftUp() {
        return leftUp;
    }

    public Point_2D getLeftLow() {
        return leftLow;
    }


    public Rect_2D(Point_2D p1, Point_2D p2) {
        if (above(p1, p2) && right(p1, p2)) { // if p1 is above p2 and righter so its the rightup  and p2 is left low
            this.rightUp = new Point_2D(p1);
            this.leftLow = new Point_2D(p2);
            this.rightLow = new Point_2D(p1.x(), p2.y()); // the x of p1 and y of p2
            this.leftUp = new Point_2D(p2.x(), p1.y()); // the x of p2 and y of p1
        }
        if (!above(p1, p2) && right(p1, p2)) {// if p1 is not above p2 and righter so p1 is rightlow and p2 is left up
            this.rightLow = new Point_2D(p1);
            this.leftUp = new Point_2D(p2);
            this.rightUp = new Point_2D(p1.x(), p2.y()); // build the other points in parallel to the pother points
            this.leftLow = new Point_2D(p2.x(), p1.y()); // build the other points in parallel to the pother points
        }
        if (!above(p1, p2) && !right(p1, p2)) {// if p1 is not above p2 and not righter so p1 is leftlow and p2 is rightup
            rightUp = new Point_2D(p2);
            leftLow = new Point_2D(p1);
            rightLow = new Point_2D(p2.x(), p1.y()); // build the other points in parallel to the pother points
            leftUp = new Point_2D(p1.x(), p2.y());// build the other points in parallel to the pother points
        }
        if (above(p1, p2) && !right(p1, p2)) {// if p1 is above p2 and not righter so p1 is leftup and p2 is rightlow
            rightLow = new Point_2D(p2);
            leftUp = new Point_2D(p1);
            rightUp = new Point_2D(p2.x(), p1.y()); // build the other points in parallel to the pother points
            leftLow = new Point_2D(p1.x(), p2.y());// build the other points in parallel to the pother points
        }
    }

    public Rect_2D(Rect_2D t1) {
        rightUp = t1.getRightUp();
        rightLow = t1.getRightLow();
        leftLow = t1.getLeftLow();
        leftUp = t1.getLeftUp();
    }

    /**
     * Checks if the rectangle contains a specified point.
     *
     * @param ot The point to check for containment.
     * @return True if the point is inside the rectangle, false otherwise.
     */
    @Override
    public boolean contains(Point_2D ot) {
        double am = ot.distance(leftUp);
        double ab = rightUp.distance(leftUp);
        double ad = leftLow.distance(leftUp);
        if ((am * ab < ab * ab) && (am * ab > 0) && (0 < am * ad) && (am * ad < ad * ad)) return true; // formula to find if point is inside a reck
        return false;

    }
    /**
     * Calculates the area of the rectangle.
     *
     * @return The area of the rectangle.
     */
    @Override
    public double area() {
        double x = rightUp.distance(rightLow);
        double y = rightUp.distance(leftUp);
        return x * y; // area of point the Perpendicular side * A balanced rib

    }


    /**
     * Calculates the perimeter of the rectangle.
     *
     * @return The perimeter of the rectangle.
     */

    @Override
    public double perimeter() {
        double x = rightUp.distance(rightLow);
        double y = rightUp.distance(leftUp);
        return 2 * x + 2 * y; // known formula
    }

    /**
     * Translates the rectangle by a specified vector.
     *
     * @param vec The vector by which to translate the rectangle.
     */

    @Override
    public void translate(Point_2D vec) {
        rightLow.move(vec); // move each point of reck
        rightUp.move(vec);
        leftUp.move(vec);
        leftLow.move(vec);

    }

    /**
     * Creates a copy of the rectangle.
     *
     * @return A new Rect_2D with the same corner points as the original.
     */
    @Override
    public GeoShape copy() {
        return new Rect_2D(leftLow,rightUp );
    } // return new object with same points as my object

    /**
     * Scales the rectangle with respect to a given center and ratio.
     *
     * @param center The center point for scaling.
     * @param ratio  The scaling ratio.
     */
    @Override
    public void scale(Point_2D center, double ratio) {
        rightLow.scale(center, ratio); // scale each point
        rightUp.scale(center, ratio);
        leftLow.scale(center, ratio);
        leftUp.scale(center, ratio);
    }
    /**
     * Rotates the rectangle around a given center by a specified angle in degrees.
     *
     * @param center        The center point for rotation.
     * @param angleDegrees  The angle of rotation in degrees.
     */

    @Override
    public void rotate(Point_2D center, double angleDegrees) {
        leftUp.rotate(center, angleDegrees); // rotate each point
        leftLow.rotate(center, angleDegrees);
        rightUp.rotate(center, angleDegrees);
        rightLow.rotate(center, angleDegrees);
    }

    /**
     * Gets an array containing all four corner points of the rectangle.
     *
     * @return An array of Point_2D representing the four corner points.
     */
    public Point_2D[] getAllPoints() {
        Point_2D[] allPoints = new Point_2D[4]; // new arr of points
        allPoints[0] = leftUp;
        allPoints[1] = rightUp;
        allPoints[2] = rightLow;
        allPoints[3] = leftLow; // gets each point inside the arr
        return allPoints; // reutn arr
    }
/*
	public void setAllPoints(Point_2D[] allPoints) {
		this.allPoints = allPoints;
	}

 */
}

