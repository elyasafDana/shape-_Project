package ex2.gui;

import ex2.geo.Point_2D;
import ex2.geo.Rect_2D;
import ex2.geo.Triangle_2D;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

//* ID 315489534

class GUIShapeTest {

    /*
    @Test
    void getdata() {
        String point = "8.0,8.0,1.0,1.0";
        point=getdata(point); // idk why it does it
        assertEquals(point,"8.0");

    }

    @Test
    void cutdata() {


        String point = "8.0,8.0,1.0,1.0";
        point=cutdata(point); // idk why it does it
        assertEquals(point,"8.0,1.0,1.0");

    }

    @Test
    void getPoint() {

        Point_2D p1 = new Point_2D(8, 8);

        String point = "8.0,8.0";
        Point_2D p5=getPoint("8.0,8.0");//idk why it does it
        assertTrue(p5.equals(p1));
    }

    @Test
    void outPoint() {
        String point = "8.0,8.0,1.0,1.0";
        point=outPoint(point); // idk why it does it
        assertEquals(point,"1.0,1.0");
    }
*/
    @Test
    void setShape() {
        Point_2D p2 = new Point_2D(1, 1);
        Point_2D p1 = new Point_2D(8, 8);
        Point_2D p3 = new Point_2D(5, 3);
        Rect_2D r1 = new Rect_2D(p1, p2);
        Triangle_2D t1 = new Triangle_2D(p1, p2, p3);

        GUIShape guiShape1 = new GUIShape(r1, true, Color.BLACK, 1);
        guiShape1.setShape(r1);
        assertEquals(r1,guiShape1.getShape());

    }

    @Test
    void setFilled() {
        Point_2D p2 = new Point_2D(1, 1);
        Point_2D p1 = new Point_2D(8, 8);
        Rect_2D r1 = new Rect_2D(p1, p2);

        GUIShape guiShape1 = new GUIShape(r1, true, Color.BLACK, 1);
       assertTrue(guiShape1.isFilled());

    }

    @Test
    void setColor() {
        Point_2D p2 = new Point_2D(1, 1);
        Point_2D p1 = new Point_2D(8, 8);
        Point_2D p3 = new Point_2D(5, 3);
        Rect_2D r1 = new Rect_2D(p1, p2);
        Triangle_2D t1 = new Triangle_2D(p1, p2, p3);

        GUIShape guiShape1 = new GUIShape(r1, true, Color.BLACK, 1);
        guiShape1.setColor(Color.BLUE);
        assertEquals(Color.blue,guiShape1.getColor());
    }

    @Test
    void setTag() {
        Point_2D p2 = new Point_2D(1, 1);
        Point_2D p1 = new Point_2D(8, 8);
        Point_2D p3 = new Point_2D(5, 3);
        Rect_2D r1 = new Rect_2D(p1, p2);


        GUIShape guiShape1 = new GUIShape(r1, true, Color.BLACK, 1);
        guiShape1.setTag(3);
        assertEquals(guiShape1.getTag(),3);
    }

    @Test
    void copy() {
        Point_2D p2 = new Point_2D(1, 1);
        Point_2D p1 = new Point_2D(8, 8);
        Point_2D p3 = new Point_2D(5, 3);
        Rect_2D r1 = new Rect_2D(p1, p2);
        Triangle_2D t1 = new Triangle_2D(p1, p2, p3);

        GUI_Shape guiShape1 = new GUIShape(r1, true, Color.BLACK, 1);
        GUI_Shape guiShape2 = guiShape1.copy();
        System.out.println(guiShape1.toString());
        System.out.println(guiShape2.toString());

        assertEquals(guiShape1.toString(),guiShape2.toString());
    }

    @Test
    void testToString() {
        Point_2D p2 = new Point_2D(1, 1);
        Point_2D p1 = new Point_2D(8, 8);
        Point_2D p3 = new Point_2D(5, 3);
        Rect_2D r1 = new Rect_2D(p1, p2);
        Triangle_2D t1 = new Triangle_2D(p1, p2, p3);

        GUIShape guiShape1 = new GUIShape(r1, false, Color.BLACK, 1);
        System.out.println(guiShape1.toString());
        assertEquals(guiShape1.toString(),"GUIShape,0,false,1,Rect_2D,8.0,1.0,8.0,8.0,1.0,8.0,1.0,1.0");
    }

    @Test
    void isSelected() {
        Point_2D p2 = new Point_2D(1, 1);
        Point_2D p1 = new Point_2D(8, 8);
        Point_2D p3 = new Point_2D(5, 3);
        Rect_2D r1 = new Rect_2D(p1, p2);
        Triangle_2D t1 = new Triangle_2D(p1, p2, p3);

        GUIShape guiShape1 = new GUIShape(r1, false, Color.BLACK, 1);

        assertFalse(guiShape1.isSelected());
    }

    @Test
    void setSelected() {
        Point_2D p2 = new Point_2D(1, 1);
        Point_2D p1 = new Point_2D(8, 8);
        Point_2D p3 = new Point_2D(5, 3);
        Rect_2D r1 = new Rect_2D(p1, p2);
        Triangle_2D t1 = new Triangle_2D(p1, p2, p3);

        GUIShape guiShape1 = new GUIShape(r1, false, Color.BLACK, 1);
        guiShape1.setSelected(true);
        assertTrue(guiShape1.isSelected());
    }

    @Test
    void testEquals() {
        Point_2D p2 = new Point_2D(1, 1);
        Point_2D p1 = new Point_2D(8, 8);
        Point_2D p3 = new Point_2D(5, 3);
        Rect_2D r1 = new Rect_2D(p1, p2);
        Triangle_2D t1 = new Triangle_2D(p1, p2, p3);

        GUIShape guiShape1 = new GUIShape(r1, true, Color.BLACK, 1);
        GUIShape guiShape2 = new GUIShape(t1,false,Color.blue,3);
        GUIShape guiShape3 = new GUIShape(r1, true, Color.BLACK, 1);
        assertFalse(guiShape1.equals(guiShape2));
        assertTrue(guiShape1.equals(guiShape3));
    }
}