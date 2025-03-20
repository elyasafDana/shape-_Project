package ex2.geo;

/**
 * This class represents a 2D Triangle in the plane.
 * Ex2: you should implement this class!
 * @author I2CS
 *
 *
 * * ID 315489534
 */
public class Triangle_2D implements GeoShape{
	Point_2D p1;
	Point_2D p2;
	Point_2D p3;
	public Triangle_2D(Point_2D p1, Point_2D p2, Point_2D p3) {
		this.p1= p1;
		this.p2=p2;
		this.p3=p3;
	}
	public String toString(){
		return p1.toString()+" , "+p2.toString()+" , " +p3.toString();
	}
	public Triangle_2D(Triangle_2D t1) {
		Point_2D[] arr= new Point_2D[3];
		arr=t1.getAllPoints();
		p1=arr[0];
		p2=arr[1];
		p3=arr[2];
	}
	/**
	 * Checks if two triangles are equal by comparing their vertices.
	 * @param ot The object to compare.
	 * @return True if the triangles are equal, false otherwise.
	 */

	public  boolean equals(Object ot){
		if(ot == null || !(ot instanceof Triangle_2D)) return false;
		Triangle_2D t = (Triangle_2D) ot;

		return  t.p1.equals(p1) && t.p2.equals(p2) && t.p3.equals(p3) ; // if the point are equal the tringle is equal return true
	}

	/**
	 * Retrieves an array of all three vertices of the triangle.
	 * @return An array containing the three vertices.
	 */

	public Point_2D[] getAllPoints() {
		Point_2D[]arr=new Point_2D[3];
		arr[0]=p1;
		arr[1]=p2;
		arr[2]=p3;
		return arr;
	}

	/**
	 * Checks if a given point is inside the triangle.
	 * @param ot The point to check.
	 * @return True if the point is inside the triangle, false otherwise.
	 */
	@Override
	public boolean contains(Point_2D ot) {
		Triangle_2D t1= new Triangle_2D(ot,p1,p2);
		Triangle_2D t2= new Triangle_2D(ot,p1,p3);
		Triangle_2D t3= new Triangle_2D(ot,p2,p3);
		if(Math.abs(this.area())== Math.abs(t1.area())+Math.abs(t2.area())+Math.abs(t3.area()))return true;     // Check if the sum of sub-triangle areas equals the area of the original triangle

		return false;


	}
	/**
	 * Calculates the area of the triangle using Heron's formula.
	 * @return The area of the triangle.
	 */
	@Override
	public double area() {
		double a=0,b=0,c=0,s;
		a= p1.distance(p2);
		b=p2.distance(p3);
		c= p3.distance(p1);
		s=(a+b+c)/2;
		return Math.sqrt(s*(s-a)*(s-b)*(s-c)); // return the area by formula

	}
	/**
	 * Calculates the perimeter of the triangle.
	 * @return The perimeter of the triangle.
	 */
	@Override
	public double perimeter() {

		double a=p1.distance(p2);
		double b=p2.distance(p3);
		double c= p3.distance(p1);
		return a+b+c; //return the perimeter by known formula
	}

	/**
	 * Translates the triangle by the given vector.
	 * @param vec The translation vector.
	 */

	@Override
	public void translate(Point_2D vec) {
		p1.move(vec); // move each point
		p2.move(vec);
		p3.move(vec);
	}

	/**
	 * Creates a copy of the triangle.
	 * @return A new Triangle_2D object with the same vertices.
	 */
	@Override
	public GeoShape copy() {

		return new Triangle_2D(p1,p2,p3); // return new tringle object same as my object
	}

	/**
	 * Scales the triangle relative to a given center point and a scaling ratio.
	 * @param center The center point for scaling.
	 * @param ratio The scaling ratio.
	 */
	@Override
	public void scale(Point_2D center, double ratio) {
		p1.scale(center,ratio); // sacle each point
		p2.scale(center,ratio);
		p3.scale(center,ratio);

	}

	/**
	 * Rotates the triangle around a given center point by a specified angle in degrees.
	 * @param center The center point for rotation.
	 * @param angleDegrees The angle of rotation in degrees.
	 */
	@Override
	public void rotate(Point_2D center, double angleDegrees) {
		p1.rotate(center,angleDegrees); // rotate each point
		p2.rotate(center,angleDegrees);
		p3.rotate(center,angleDegrees);
	}
}
