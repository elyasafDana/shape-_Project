package ex2.geo;

/**
 * This class represents a 2D segment on the plane, 
 * Ex2: you should implement this class!
 * @author I2CS
 *
 * * ID 315489534
 *
 */
public class Segment_2D implements GeoShape{
	Point_2D p1;
	Point_2D p2;
	public Segment_2D(Point_2D a, Point_2D b) {
		p1=b;
		p2=a;
	}
	public Segment_2D(Segment_2D t1) {
		p1=t1.get_p1();
		p2=t1.get_p2();
	}
	/**
	 * Returns a string representation of the segment in the format:
	 * "p1, p2".
	 *
	 * @return A string representation of the segment.
	 */
	public String toString(){
		return p1.toString()+" ,"+p2.toString();
	}

	/**
	 * Checks if two segments are equal by comparing their endpoints.
	 *
	 * @param ot The object to compare with.
	 * @return True if the segments are equal, false otherwise.
	 */
	public  boolean equals(Object ot){
		if(ot == null || !(ot instanceof Segment_2D)) return false;
		Segment_2D seg = (Segment_2D) ot;

		return  seg.p1.equals(p1) && seg.p2.equals(p2);
	}

	public Point_2D get_p1() {
		return p1;
	}
	public Point_2D get_p2() {
		return p2;

	}

	/**
	 * Checks if a given point is on the segment.
	 *
	 * @param ot The point to check for containment.
	 * @return True if the point is on the segment, false otherwise.
	 */

	@Override
	public boolean contains(Point_2D ot) {
		double m=0;
		m=(p1.y()-p2.y())/(p1.x()- p2.x());
		System.out.println( m*ot.x()-m*p1.x()+p1.y()==ot.y());
		if(m*ot.x()-m*p1.x()+p1.y()==ot.y())return true;
		return false;
	}
	/**
	 * Returns the length of the segment.
	 *
	 * @return The length of the segment.
	 */

	@Override
	public double area() {
		return 0;
	}

	/**
	 * Returns the perimeter of the segment.
	 *
	 * @return The perimeter of the segment.
	 */
	@Override
	public double perimeter() {
		return Math.abs(p1.distance(p2))*2;
	}

	/**
	 * Translates the segment by a specified vector.
	 *
	 * @param vec The vector by which to translate the segment.
	 */
	@Override
	public void translate(Point_2D vec) {
		p1.move(vec);
		p2.move(vec);

	}
	/**
	 * Creates a copy of the segment.
	 *
	 * @return A new Segment_2D with the same endpoints as the original.
	 */

	@Override
	public GeoShape copy() {
		return new Segment_2D(p1,p2);
	}

	/**
	 * Scales the segment with respect to a given center and ratio.
	 *
	 * @param center The center point for scaling.
	 * @param ratio  The scaling ratio.
	 */
	@Override
	public void scale(Point_2D center, double ratio) {
		p1.scale(center,ratio);
		p2.scale(center,ratio);
	}

	/**
	 * Rotates the segment around a given center by a specified angle in degrees.
	 *
	 * @param center        The center point for rotation.
	 * @param angleDegrees  The angle of rotation in degrees.
	 */

	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		p1.rotate(center,angleDegrees);
		p2.rotate(center,angleDegrees);


	}
}