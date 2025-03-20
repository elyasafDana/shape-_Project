
package ex2.geo;


/**
 *
 * * ID 315489534
 * This class represents a 2D point in the plane.
 * Do NOT change this class! It would be used as is for testing.
 * Ex2: you should NOT change this class!
 * @author boaz.benmoshe
 */


public class Point_2D {
    //public static final double EPS1 = 0.001, EPS2 = Math.pow(EPS1,2), EPS=EPS2;
    public static final Point_2D ORIGIN = new Point_2D(0,0);
    private double _x,_y;
    /**
     * Constructs a Point_2D with specified x and y coordinates.
     *
     * @param x The x-coordinate of the point.
     * @param y The y-coordinate of the point.
     */
    public Point_2D(double x, double y) {
    	_x=x; _y=y;
    }
    /**
     * Copy constructor to create a new Point_2D with the same coordinates as an existing one.
     *
     * @param p The Point_2D to copy.
     */
    public Point_2D(Point_2D p) {
       this(p.x(), p.y());
    }
    /**
     * Constructs a Point_2D from a string in the format "x,y".
     *
     * @param s The string representing the coordinates.
     * @throws IllegalArgumentException If the string format is incorrect.
     */
    public Point_2D(String s) {
        try {
            String[] a = s.split(",");
            _x = Double.parseDouble(a[0]);
            _y = Double.parseDouble(a[1]);
        }
        catch(IllegalArgumentException e) {
            System.err.println("ERR: got wrong format string for Point2D init, got:"+s+"  should be of format: x,y");
            throw(e);
        }
    }
    /**
     * Gets the x-coordinate of the point.
     *
     * @return The x-coordinate of the point.
     */
    public double x() {return _x;}
    /**
     * Gets the y-coordinate of the point.
     *
     * @return The y-coordinate of the point.
     */
    public double y() {return _y;}

    /**
     * Gets the integer representation of the x-coordinate.
     *
     * @return The integer representation of the x-coordinate.
     */
    public int ix() {return (int)_x;}
    /**
     * Gets the integer representation of the y-coordinate.
     *
     * @return The integer representation of the y-coordinate.
     */
    public int iy() {return (int)_y;}
    /**
     * Adds another Point_2D to this point and returns the result as a new Point_2D.
     *
     * @param p The Point_2D to add.
     * @return A new Point_2D representing the sum of this point and the given point.
     */

    public Point_2D add(Point_2D p) {
    	Point_2D a = new Point_2D(p.x()+x(),p.y()+y());
    	return a;
    }
    /**
     * Returns a string representation of the Point_2D in the format: "x, y".
     *
     * @return A string representation of the Point_2D.
     */
    public String toString()
    {
        return _x+","+_y;
    }

    /**
     * Calculates the distance between this point and the origin (0,0).
     *
     * @return The distance between this point and the origin.
     */
    public double distance()
    {
        return this.distance(ORIGIN);
    }
    /**
     * Calculates the distance between this point and another Point_2D.
     *
     * @param p2 The target point.
     * @return The distance between this point and the target point.
     */
    public double distance(Point_2D p2)
    {
        double dx = this.x() - p2.x();
        double dy = this.y() - p2.y();
        double t = (dx*dx+dy*dy);
        return Math.sqrt(t);
    }

    /**
     * Checks if two Point_2D objects are equal.
     *
     * @param p The object to compare.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object p)
    {
        if(p==null || !(p instanceof Point_2D)) {return false;}
        Point_2D p2 = (Point_2D)p;
        return ( (_x==p2._x) && (_y==p2._y));
    }
    public boolean close2equals(Point_2D p2, double eps)
    {
        return ( this.distance(p2) < eps );
    }

    /**
     * This method returns the vector between this point and the target point. The vector is represented as a Point2D.
     * @param target
     * @return
     */
    public Point_2D vector(Point_2D target) {
    	double dx = target.x() - this.x();
    	double dy = target.y() - this.y();
    	return new Point_2D(dx,dy);
    }

    /**
     * Moves the point by a vector defined by another Point_2D.
     *
     * @param vec The vector by which to move the point.
     */

	public void move(Point_2D vec) {
		this._x += vec.x();
		this._y += vec.y();
	}


    /**
     * Scales the point with respect to a given center and ratio.
     *
     * @param cen   The center point for scaling.
     * @param ratio The scaling ratio.
     */
	/////////////////////// You should implement the methods below ///////////////////////////
	public void scale(Point_2D cen, double ratio) {
		double dx = x()-cen.x();
		double dy = y()-cen.y();
		dx *= ratio;
		dy *= ratio;
		_x = dx+cen.x();
		_y = dy+cen.y();
		/////////////////////////////////////
	}

    /**
     * Rotates the point around a given center by a specified angle in degrees.
     *
     * @param cen           The center point for rotation.
     * @param angleDegrees  The angle of rotation in degrees.
     */

	public void rotate(Point_2D cen, double angleDegrees) {
		double angRad = Math.toRadians(angleDegrees);
		double dx = x()-cen.x();
		double dy = y()-cen.y();
		double ang = Math.atan2(dy, dx);
		double d = Math.sqrt(dx*dx+dy*dy);
		ang += angRad;
		dx = d*Math.cos(ang);
		dy = d*Math.sin(ang);
		_x = cen.x() + dx;
		_y = cen.y() + dy;
	}

}
