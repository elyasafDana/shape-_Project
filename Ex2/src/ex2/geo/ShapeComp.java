package ex2.geo;

import java.util.Comparator;

import ex2.ex2.Ex2_Const;
import ex2.gui.GUI_Shape;

/**
 * This class represents a Comparator over GUI_Shapes - 
 * as a linear order over GUI_Shapes.
 * Ex2: you should implement this class!
 * @author I2CS
 *
 *
 * * ID 315489534
 */
public class ShapeComp implements Comparator<GUI_Shape>{

	public static final ShapeComp CompByArea = new ShapeComp(Ex2_Const.Sort_By_Area);
	public static final ShapeComp CompByAntiArea = new ShapeComp(Ex2_Const.Sort_By_Area);

	public static final ShapeComp CompByAntitoString = new ShapeComp(Ex2_Const.Sort_By_Anti_toString);
	public static final ShapeComp CompByToString = new ShapeComp(Ex2_Const.Sort_By_toString);
	public static final ShapeComp CompByPerimeter = new ShapeComp(Ex2_Const.Sort_By_Perimeter);
	public static final ShapeComp CompByAntiPerimeter = new ShapeComp(Ex2_Const.Sort_By_Anti_Perimeter);
	public static final ShapeComp CompByTag = new ShapeComp(Ex2_Const.Sort_By_Tag);
	public static final ShapeComp CompByAntiTag = new ShapeComp(Ex2_Const.Sort_By_Anti_Tag);

	private int _flag;
	public ShapeComp(int flag) {
		_flag = flag;
	}

	/**
	 * Make sure you implement the basic code below
	 * @param o1 the first object to be compared.
	 * @param o2 the second object to be compared.
	 * @return 1 iff o1 is grater than o1, -1 iff o1 is smaller than o2,
	 * and 0 iff o1 and o2 are equals.
	 */

	@Override
	public int compare(GUI_Shape o1, GUI_Shape o2) {
		double a1=-1, a2 = -1;
		GeoShape s1 = o1.getShape(), s2 = o2.getShape();
		int ans =0;

		if(_flag == Ex2_Const.Sort_By_Area) { // if the chosen one is by area
			a1 = s1.area();
			a2 = s2.area();
			if(a1>a2) {ans=1;}
			if(a1<a2) {ans=-1;}
		}
		if(_flag == Ex2_Const.Sort_By_Anti_Area) { // if the chosen one is by anti area
			a1 = s1.area();
			a2 = s2.area();
			if(a1<a2) {ans=1;}
			if(a1>a2) {ans=-1;}
		}
		if(_flag == Ex2_Const.Sort_By_toString) { // if the chosen one is by string
			ans = o1.toString().compareTo(o2.toString());//if o2 comes before it will return 1 if its after -1 and they equal 0
		}
		if(_flag == Ex2_Const.Sort_By_Anti_toString) {// if the chosen one is by anti string
			ans = o2.toString().compareTo(o1.toString()); // if o1 comes before it will return 1 if its after -1 and they equal 0
		}

		if(_flag == Ex2_Const.Sort_By_Tag){ // if the chosen one is by tag
			if (o1.getTag()> o2.getTag())return 1;// if the tag of o1 is greater return 1
			if (o1.getTag()< o2.getTag()) return -1;// if the tag of o2 is greater return -1
			return 0;
		}
		if(_flag == Ex2_Const.Sort_By_Anti_Tag){ // if the chosen one is by antitag
			if (o1.getTag()< o2.getTag())return 1; // if the tag of o2 is greater return 1
			if (o1.getTag()> o2.getTag()) return -1;// if the tag of o1 is greater return -1
			return 0;
		}
		if(_flag == Ex2_Const.Sort_By_Perimeter){ // if the chosen one is by perimeter
			if(o1.getShape().perimeter()>o2.getShape().perimeter()) return 1;// if the perimeter of o1 is greater return 1
			if(o1.getShape().perimeter()<o2.getShape().perimeter()) return -1; // if the perimeter of o2 is greater return -1
			return 0;
		}

		if(_flag == Ex2_Const.Sort_By_Anti_Perimeter){ // if the chosen one is by antiperimeter
			if(o1.getShape().perimeter()<o2.getShape().perimeter()) return 1; // if the perimeter of o1 is greater return 1
			if(o1.getShape().perimeter()>o2.getShape().perimeter()) return -1;// if the perimeter of o2 is greater return -1
			return 0;
		}


		return ans;
	}
}
