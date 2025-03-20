package ex2.gui;
/**
 * This class implements the GUI_shape.
 * Ex2: you should implement this class!
 * @author I2CS
 *
 * * ID 315489534
 */
import ex2.geo.*;
import java.awt.*;
import java.util.ArrayList;


public class GUIShape implements GUI_Shape {
	private GeoShape _g = null;
	private boolean _fill;
	private Color _color;
	private int _tag;
	private boolean _isSelected;

	public GUIShape(GeoShape g, boolean f, Color c, int t) {
		_g = null;
		if (g != null) {
			_g = g.copy();
		}
		_fill = f;
		_color = c;
		_tag = t;
		_isSelected = f;
	}

	public GUIShape(GUIShape ot) {
		this(ot._g, ot._fill, ot._color, ot._tag);
	}
	/**
	 *  method extracts characters up to the ',' from data.
	 * @param data Input data string
	 * @return Substring up to the first ','
	 */
	public static String getdata(String data) { // give me the chars upto ','
		int index = data.indexOf(","); // gets the place of , i nthe string
		if (index == -1) return data; // if you dont find you in the end of the string do nothing
		else {
			String mydata = data.substring(0, index); // cut the string up to the , which represents the data i need.

			return mydata;
		}
	}

	/**
	 * Static utility method cuts the data that has been used.
	 * @param data Input data string
	 * @return Remaining substring after the first ','
	 */
	public static String cutdata(String data) { // cutdata the data that i used
		int index = data.indexOf(","); // find the index of , in the string
		String mydata = data.substring(index + 1); // cut all the string until , we stay with the string without the data that we already got
		return mydata;
	}

	/**
	 *  method extracts a Point_2D from the data.
	 * @param data Input data string containing point coordinates
	 * @return Point_2D created from the extracted coordinates
	 */
	public static Point_2D getPoint(String data) {  // instract a point out of the data
		String mydata = "";
		mydata = getdata(data); // gets the frist x
		double x = Double.parseDouble(mydata); // parse the string that represent number to int
		data = cutdata(data); // cut the string that represent the x
		mydata = getdata(data); // gets the y
		double y = Double.parseDouble(mydata);// parse the string that represent number to int
		Point_2D p1 = new Point_2D(x, y); // creates point
		return p1;
	}
	/**
	 *  method provides a string without the used point.
	 * @param data Input data string
	 * @return Remaining substring after extracting point coordinates
	 */
	public static String outPoint(String data) {  // give me the string without the point that i used
		data = cutdata(data); // cuts the x
		data = cutdata(data); // cuts the y
		return data;
	}
	/**
	 * Constructor parses a string representation to create a GUIShape.
	 * @param data String representation of a GUIShape
	 */
	public GUIShape(String data) {


		boolean flag = true;

		data = data.replace("GUIShape,", ""); // cut the unnessery string
		int datacolor = Integer.parseInt(getdata(data));
		int r, g, b;
		b = datacolor % 256; // gets the b out of the number
		g = ((datacolor - b) / 256) % 256; // gets the g out of the number
		r = (datacolor - (256 * g + b)) / (256 * 256); // gets the r out of the number

		ArrayList<GUI_Shape> _shapes= new ArrayList<GUI_Shape>();


		 _color = new Color(r, g, b); // create color
		data = cutdata(data);  // cut the data that i used


		if (getdata(data).equals("true"))
			_fill = true; // if the string contain true in the place of fill fill is true
		else _fill = false;
		data = cutdata(data); // cut the data i used
		 _tag = 0;
		_tag = Integer.parseInt(getdata(data)); // get the number of tag in the string and put inside int tag
		data = cutdata(data); // cut the data i used

		if (getdata(data).equals("Circle_2D")) { // if the data that i got is "Circle_2D"
			data = cutdata(data); // cut the ""Circle_2D"" from string
			Point_2D p = new Point_2D(getPoint(data)); // create new point with the point that i have inside the string
			data = outPoint(data); //delete point from string
			Double center = Double.parseDouble(getdata(data)); // get the int center out of the string
			data = cutdata(data); // cut the int center of the string
			Circle_2D c = new Circle_2D(p, center);
			_g=c;
			GUI_Shape gui = new GUIShape(c, _fill, _color, _tag);
			_shapes.add(gui);
			flag = false;
		}
		if (flag && getdata(data).equals("Rect_2D")) { //if the data that i got is "Rect_2D"
			data = cutdata(data); // cut the "Rect_2D" from string
			Point_2D p1 = new Point_2D(getPoint(data));// create point of the first point in the string
			data = outPoint(data);// delte the point the you created from the string
			data = outPoint(data);// delete the next point becuse i need just 2 slant point
			Point_2D p2 = new Point_2D(getPoint(data)); // create second point from the string
			data = outPoint(data);// delete point from string
			Rect_2D rect = new Rect_2D(p2, p1);
			_g=rect;
			GUI_Shape gui = new GUIShape(rect, _fill, _color, _tag);
			_shapes.add(gui);
			flag = false;
		}
		if (flag && getdata(data).equals("Point_2D")) { //if the data that i got is "Point_2D"
			data = cutdata(data);// cut "Point_2D" from the string
			Point_2D p1 = new Point_2D(getPoint(data));// create point out of the string
			data = cutdata(data);
			_g=(GeoShape) p1;
			GUI_Shape gui = new GUIShape((GeoShape) (p1), _fill, _color, _tag);
			_shapes.add(gui);
			flag = false;
		}
		if (flag && getdata(data).equals("Segment_2D")) { //if the data that i got is "Segment_2D"
			data = cutdata(data); // delete "Segment_2D" from string
			Point_2D p1 = new Point_2D(getPoint(data)); // create a point from data
			data = outPoint(data);
			Point_2D p2 = new Point_2D(getPoint(data));
			data = cutdata(data);
			Segment_2D seg = new Segment_2D(p1, p2);
			_g=seg;
			GUI_Shape gui = new GUIShape(seg, _fill, _color, _tag);
			_shapes.add(gui);
			flag = false;
		}
		if (flag && getdata(data).equals("Triangle_2D")) { //if the data that i got is "Triangle_2D"
			data = cutdata(data); // delete "Triangle_2D" from string
			Point_2D p1 = new Point_2D(getPoint(data)); // get point
			data = outPoint(data);
			Point_2D p2 = new Point_2D(getPoint(data)); // get point
			data = outPoint(data);
			Point_2D p3 = new Point_2D(getPoint(data)); // get point
			data = outPoint(data);
			Triangle_2D t = new Triangle_2D(p1, p2, p3);
			_g=t;
			GUI_Shape gui = new GUIShape(t, _fill, _color, _tag);
			_shapes.add(gui);
			flag = false;
		}
		if (flag && getdata(data).equals("Polygon_2D")) {
			data = cutdata(data); // remove "Polygon_2D"
			Polygon_2D pol = new Polygon_2D();
			while (data.length() > 1) { // while we have data
				Point_2D p1 = new Point_2D(getPoint(data)); // get a point from the string
				data = outPoint(data);// delete point that you created from data from data
				pol.add(p1); // add the point to pol
				if (data.indexOf(",") == -1)
					data = ""; // if you got to the last point(which has no ",") get out
			}
			_g=pol;
		}
	}

	@Override
	public GeoShape getShape() {
		return _g;
	}

	@Override
	public void setShape(GeoShape g) {
		_g = g;
	}

	@Override
	public boolean isFilled() {
		return _fill;
	}

	@Override
	public void setFilled(boolean filled) {
		_fill = filled;
	}

	/**
	 *  method for encoding Color to an integer representation.
	 * @param c Color object to be encoded
	 * @return Integer representation of the color
	 */
	public static int colorEncoding(Color c) {
		int r = c.getRed();
		int b = c.getBlue();
		int g = c.getGreen();
		int ce = r*256*256 + g*256 + b;
		return ce;
	}


	@Override
	public Color getColor() {
		return _color;
	}

	@Override
	public void setColor(Color cl) {
		_color = cl;
	}

	@Override
	public int getTag() {
		return _tag;
	}

	@Override
	public void setTag(int tag) {
		_tag = tag;
		
	}

	@Override
	public GUI_Shape copy() {
		GUI_Shape cp = new GUIShape(this);
		return cp;
	}
	@Override
	public String toString() {
		String ans = ""+this.getClass().getSimpleName()+","+colorEncoding(_color)+","+_fill+","+_tag+","+this._g.getClass().getSimpleName()+","+_g.toString();
		return ans;
	}
	@Override
	public boolean isSelected() {
		return this._isSelected;
	}
	@Override

	public void setSelected(boolean s) {
		this._isSelected = s;
	}


	/**
	 * Compare two GUIShape objects for equality based on their properties.
	 * @param t Another GUIShape for comparison
	 * @return True if the objects are equal, false otherwise
	 */
	public boolean equals(GUIShape t){
		if(t.getShape().equals(this.getShape()) && t.getTag()==this._tag && t.getColor()==_color) return true;
		return false;
	}
}
