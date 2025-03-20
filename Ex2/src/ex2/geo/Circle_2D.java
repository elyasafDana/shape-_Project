package ex2.geo;

/**
 * This class represents a 2D circle in the plane. It implements the GeoShape interface.
 * The circle is defined by its center point and radius.
 *
 ** ID 315489534
 * @author boaz.benmoshe
 */
public class Circle_2D implements GeoShape {
    private Point_2D _center;
    private double _radius;
    /**
     * Constructs a Circle_2D with a specified center point and radius.
     *
     * @param cen   The center point of the circle.
     * @param rad   The radius of the circle.
     */
    public Circle_2D(Point_2D cen, double rad) {
        this._center = new Point_2D(cen);
        this._radius = rad;
    }

    public Circle_2D(Circle_2D c) {
        this(c.getCenter(), c.getRadius());
    }
    /**
     * Gets the radius of the circle.
     *
     * @return The radius of the circle.
     */
    public double getRadius() {
        return this._radius;
    }

    /**
     * Gets the center point of the circle.
     *
     * @return The center point of the circle.
     */
    public Point_2D getCenter() {
        return _center;
    }
/**
        * Returns a string representation of the Circle_2D in the format: "(center_x, center_y), radius".
            *
            * @return A string representation of the Circle_2D.
            */
    @Override
    public String toString() {
        return _center.toString() + ", " + _radius; //return string of the details

    }
    /**
     * Checks if two Circle_2D objects are equal.
     *
     * @param ot    The object to compare.
     * @return      True if the objects are equal, false otherwise.
     */

    public  boolean equals(Object ot){
        if(ot == null || !(ot instanceof Circle_2D)) return false;
        Circle_2D p1=(Circle_2D) ot;
        return (p1._center== this._center )&&( p1._radius == this._radius); // if the radius and the center  is equal
    }
    /**
     * Checks if the circle contains a specified point.
     *
     * @param ot    The point to check.
     * @return      True if the point is within or on the boundary of the circle, false otherwise.
     */

    @Override
    public boolean contains(Point_2D ot) {
        if (ot.distance(_center) <= _radius) return true;  // if the point inside return true
        return false;
    }
    /**
     * Calculates the area of the circle.
     *
     * @return The area of the circle.
     */
    @Override
    public double area() {

        return Math.PI * Math.pow(_radius, 2); // return the area by the formula
    }
    /**
     * Calculates the perimeter (circumference) of the circle.
     *
     * @return The perimeter of the circle.
     */

    @Override
    public double perimeter() {
        return 2 * Math.PI * _radius; // return the perimeter by the furmula
    }
    /**
     * Translates the circle by a vector defined by a point.
     *
     * @param vec   The vector to translate the circle.
     */
    @Override
    public void translate(Point_2D vec) {
        _center.move(vec); // move the center

    }
    /**
     * Creates a copy of the circle.
     *
     * @return A new Circle_2D with the same properties.
     */
    @Override
    public GeoShape copy() {

        return  new Circle_2D(_center,_radius); // return new object of the same circle
    }
    /**
     * Scales the circle with respect to a given center and ratio.
     *
     * @param givencenter   The center point for scaling.
     * @param ratio         The scaling ratio.
     */
    @Override
    public void scale(Point_2D givencenter, double ratio) {
       _center.scale(givencenter,ratio); // scale the center
       _radius=_radius*ratio; // change the radius by the ratio
    }
    /**
     * Rotates the circle around a given center by a specified angle in degrees.
     *
     * @param givencenter       The center point for rotation.
     * @param angleDegrees      The angle of rotation in degrees.
     */

    @Override
    public void rotate(Point_2D givencenter, double angleDegrees) {
        _center.rotate(givencenter,angleDegrees); // rotate the center
    }

}
