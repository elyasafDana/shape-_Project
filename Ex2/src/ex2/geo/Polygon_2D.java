package ex2.geo;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * This class represents a 2D polygon in the plane. It implements the GeoShape interface.
 * The polygon is defined by an array of Point_2D vertices.
 *
 *
 * * ID 315489534
 */
public class Polygon_2D implements GeoShape{
	Point_2D[] arr;

	/**
	 * Default constructor to initialize an empty Polygon_2D.
	 */
	public Polygon_2D() {

		arr= new Point_2D[0];
	}

	/**
	 * Copy constructor to create a new Polygon_2D with the same vertices as an existing one.
	 *
	 * @param po The Polygon_2D to copy.
	 */
	public Polygon_2D(Polygon_2D po) {

		arr=po.getAllPoints();
	}

	/**
	 * Returns an array containing all vertices (points) of the polygon.
	 *
	 * @return An array of Point_2D representing the vertices of the polygon.
	 */
	public Point_2D[] getAllPoints() {

		return arr; // return the arr with all the pooints of poligon
	}

	/**
	 * Adds a new vertex (point) to the polygon.
	 *
	 * @param p The Point_2D to add as a vertex.
	 */

	public void add(Point_2D p) {
		Point_2D[] temp= new Point_2D[arr.length+1]; // creates new arr with one more place

			for (int i = 0; i < temp.length-1; i++) {
				temp[i] = arr[i]; // addd all the points of this.arr

			}
			temp[arr.length] = p; // add the last point
			arr = temp; // replace this.arr wtih the new arr

	}
	/**
	 * Returns a string representation of the Polygon_2D in the format: "x1,y1,x2,y2,...,xn,yn".
	 *
	 * @return A string representation of the Polygon_2D.
	 */
	@Override
	public String toString()
	{

		String name="";
		for(int i=0;i< arr.length;i++){
			if(i!= arr.length-1)
			name= name+(String) (arr[i].toString()) +",";
			else{
				name= name+(String) (arr[i].toString()); //add the  last one withput the , in the end
			}
		}
		return name;
			}

	/**
	 * Checks if the polygon contains a specified point.
	 *
	 * @param ot The point to check.
	 * @return True if the point is inside the polygon, false otherwise.
	 */
	@Override
	public boolean contains(Point_2D ot) {
		double m=0, x=0;
		int count =0;
		Point_2D p1,p2;
		// Iterate through each edge of the polygon
		for (int i = 0; i < arr.length - 1; i++) {
			p1 = new Point_2D(arr[i]);
			p2 = new Point_2D(arr[i + 1]);

			// Calculate the slope of the edge
			m = (p1.y() - p2.y()) / (p1.x() - p2.x());

			// Calculate the x-coordinate of the intersection point with the ray
			x = (ot.y() - p1.y() + m * p1.x()) / m; // corrected placement of parentheses

			// Check if the intersection point is within the x-bounds of the edge
			if ((p1.x() < x && x < p2.x()) || (p2.x() < x && x < p1.x())) {
				count++;
			}
		}

		// Check the edge connecting the last and first vertices
		p1 = new Point_2D(arr[0]);
		p2 = new Point_2D(arr[arr.length - 1]);
		m = (p1.y() - p2.y()) / (p1.x() - p2.x());
		x = (ot.y() - p1.y() + m * p1.x()) / m; // corrected placement of parentheses

		// Check if the intersection point is within the x-bounds of the edge
		if ((p1.x() < x && x < p2.x()) || (p2.x() < x && x < p1.x())) {
			count++;
		}

		if (count % 2 == 0) { // if the number is even its not inside
			return false;
		}
		return true;



	}


	/**
	 * Checks if two Polygon_2D objects are equal by comparing their vertex arrays.
	 *
	 * @param ot poligon object.
	 * @return True if the objects are equal, false otherwise.
	 */

	public  boolean equals(Object ot){
		if(ot == null || !(ot instanceof Polygon_2D )) return false;
		Point_2D[] arr2=((Polygon_2D) ot).getAllPoints();
		return Arrays.equals(arr,arr2); // if they the same return true
	}

	/**
	 * Calculates the area of the polygon .
	 *
	 * @return The area of the polygon.
	 */
	@Override
	public double area() {

	double area=0;
	for(int i=1;i< arr.length-1;i++){
		area=area+arr[i].x()*(arr[i+1].y()-arr[i-1].y());
	}
	area= area+ arr[0].x()*(arr[1].y()-arr[arr.length-1].y()); // add the first part of the formula
	area= area+ arr[arr.length-1].x()*(arr[0].y()-arr[arr.length-2].y()); // add the last part of the formula
	return Math.abs(area)/2;


	}


	/**
	 * Calculates the perimeter  of the polygon.
	 *
	 * @return The perimeter of the polygon.
	 */
	@Override
	public double perimeter() {

		Point_2D[] temp=this.getAllPoints();
		double sum=0;
		for (int i=0;i<temp.length-1;i++){
				sum=sum+temp[i].distance(temp[i+1]);
		}
		sum=sum + temp[0].distance(temp[temp.length-1]); // add the distance between the first and last point
		return sum;

	}
	/**
	 *  moves all points of the polygon by a vector .
	 *
	 * @param vec The vector by which to translate the polygon.
	 */
	@Override
	public void translate(Point_2D vec) {

		Point_2D[] temp=this.getAllPoints();
		for(int i=0;i<temp.length;i++){
			// move each point
			temp[i].move(vec);
		}


	}

	/**
	 * Creates a copy of the polygon.
	 *
	 * @return A new Polygon_2D with the same vertices as the original.
	 */
	@Override
	public GeoShape copy() {
		Polygon_2D temp= new Polygon_2D(this); // return new poligon same as me
		return temp;

	}

	/**
	 * Scales the polygon with respect to a given center and ratio.
	 *
	 * @param center The center point for scaling.
	 * @param ratio  The scaling ratio.
	 */
	@Override
	public void scale(Point_2D center, double ratio) {


		for(int i=0;i<arr.length;i++){ // scale all the points of the poligon
			arr[i].scale(center,ratio);
		}


	}

	/**
	 * Rotates the polygon around a given center by a specified angle in degrees.
	 *
	 * @param center        The center point for rotation.
	 * @param angleDegrees  The angle of rotation in degrees.
	 */


	@Override
	public void rotate(Point_2D center, double angleDegrees) {


		for(int i=0;i<arr.length;i++){
			arr[i].rotate(center,angleDegrees); // rotate each point of the poligon
		}


	}

}
