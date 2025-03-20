package ex2.ex2;
//* ID 315489534

import ex2.geo.*;
import ex2.gui.GUIShape;
import ex2.gui.GUI_Shape;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ShapeCollectionTest {

    @Test
    void addAt() {
        Point_2D p2 = new Point_2D(1, 1);
        Point_2D p1 = new Point_2D(8, 8);
        Rect_2D r1 = new Rect_2D(p1, p2);

        GUIShape guiShape1 = new GUIShape(r1, true, Color.BLACK, 1);

       ShapeCollection p= new ShapeCollection();

       p.addAt(guiShape1,0);
       System.out.println(p.get(0).toString());
       assertEquals(p.get(0).toString(),"GUIShape,0,true,1,Rect_2D,8.0,1.0,8.0,8.0,1.0,8.0,1.0,1.0");


    }

    @Test
    void get() {
        Point_2D p2 = new Point_2D(1, 1);
        Point_2D p1 = new Point_2D(8, 8);
        Rect_2D r1 = new Rect_2D(p1, p2);

        GUIShape guiShape1 = new GUIShape(r1, true, Color.BLACK, 1);

        ShapeCollection p= new ShapeCollection();

        p.add(guiShape1);
        assertEquals(p.get(0).toString(),"GUIShape,0,true,1,Rect_2D,8.0,1.0,8.0,8.0,1.0,8.0,1.0,1.0");
    }

    @Test
    void size() {
        Point_2D p2 = new Point_2D(1, 1);
        Point_2D p1 = new Point_2D(8, 8);
        Rect_2D r1 = new Rect_2D(p1, p2);

        GUIShape guiShape1 = new GUIShape(r1, true, Color.BLACK, 1);

        ShapeCollection p= new ShapeCollection();

        p.add(guiShape1);
        assertEquals(p.size(),1);

    }

    @Test
    void removeElementAt() {
        Point_2D p2 = new Point_2D(1, 1);
        Point_2D p1 = new Point_2D(8, 8);
        Point_2D p3 = new Point_2D(5, 3);
        Rect_2D r1 = new Rect_2D(p1, p2);
        Triangle_2D t1 = new Triangle_2D(p1, p2, p3);

        ShapeCollection shap = new ShapeCollection();
        GUIShape guiShape1 = new GUIShape(r1, true, Color.BLACK, 1);
        GUIShape guiShape2 = new GUIShape(t1, false, Color.GREEN, 2);
        shap.add(guiShape1);
        shap.add(guiShape2);
        shap.removeElementAt(1);
        ShapeCollection shap2 = new ShapeCollection();
        shap2.add(guiShape1);
        System.out.println(shap.toString());
        System.out.println(shap2.toString());

        assertTrue(shap.equal(shap2));
    }



    @Test
    void add() {
        Point_2D p2 = new Point_2D(1, 1);
        Point_2D p1 = new Point_2D(8, 8);
        Rect_2D r1 = new Rect_2D(p1, p2);

        GUIShape guiShape1 = new GUIShape(r1, true, Color.BLACK, 1);

        ShapeCollection p= new ShapeCollection();

        p.add(guiShape1);
        System.out.println(p.get(0).toString());
        assertEquals(p.get(0).toString(),"GUIShape,0,true,1,Rect_2D,8.0,1.0,8.0,8.0,1.0,8.0,1.0,1.0");

    }

    @Test
    void copy() {
        Point_2D p2 = new Point_2D(1, 1);
        Point_2D p1 = new Point_2D(8, 8);
        Point_2D p3 = new Point_2D(5, 3);
        Rect_2D r1 = new Rect_2D(p1, p2);
        Triangle_2D t1 = new Triangle_2D(p1, p2, p3);

        GUI_Shape_Collection shap = new ShapeCollection();
        GUIShape guiShape1 = new GUIShape(r1, true, Color.BLACK, 1);
        GUIShape guiShape2 = new GUIShape(t1, false, Color.GREEN, 2);
        shap.add(guiShape1);
        shap.add(guiShape2);
        GUI_Shape_Collection copyshape= new ShapeCollection();
        copyshape=shap.copy();
        assertTrue(copyshape.toString().equals(shap.toString()));

    }



    @Test
    void sort() {
        Point_2D p2 = new Point_2D(1, 1);
        Point_2D p1 = new Point_2D(8, 8);
        Point_2D p3 = new Point_2D(5, 3);
        Rect_2D r1 = new Rect_2D(p1, p2);
        Triangle_2D t1 = new Triangle_2D(p1, p2, p3);

        ShapeCollection shap = new ShapeCollection();

        GUIShape guiShape1 = new GUIShape(r1, true, Color.BLACK, 1);
        GUIShape guiShape2 = new GUIShape(t1, false, Color.GREEN, 2);

        shap.add(guiShape1);
        shap.add(guiShape2);

        ShapeCollection temp= new ShapeCollection();;

        temp.add(guiShape2);
        temp.add(guiShape1);

        temp.sort(ShapeComp.CompByTag);
        assertTrue(shap.equal(temp));
        temp.sort(ShapeComp.CompByAntiTag);
        assertFalse(shap.equal(temp));

        System.out.println(r1.area());
        System.out.println(t1.area());
        System.out.println(shap.toString());
        System.out.println(temp.toString());

        temp.sort(ShapeComp.CompByArea);
        assertFalse(shap.equal(temp));
        temp.sort(ShapeComp.CompByArea);
        assertFalse(shap.equal(temp));

        temp.sort(ShapeComp.CompByToString);
        assertTrue(shap.equal(temp));
        temp.sort(ShapeComp.CompByAntitoString);
        assertFalse(shap.equal(temp));
    }

    @Test
    void removeAll() {
        Point_2D p2 = new Point_2D(1, 1);
        Point_2D p1 = new Point_2D(8, 8);
        Point_2D p3 = new Point_2D(5, 3);
        Rect_2D r1 = new Rect_2D(p1, p2);
        Triangle_2D t1 = new Triangle_2D(p1, p2, p3);

        ShapeCollection shap = new ShapeCollection();
        GUIShape guiShape1 = new GUIShape(r1, true, Color.BLACK, 1);
        GUIShape guiShape2 = new GUIShape(t1, false, Color.GREEN, 2);
        shap.add(guiShape1);
        shap.add(guiShape2);
        shap.removeAll();
        assertEquals(shap.size(),0);
    }

    @Test
    void save() {
        Point_2D p2 = new Point_2D(1, 1);
        Point_2D p1 = new Point_2D(8, 8);
        Point_2D p3 = new Point_2D(5, 3);
        Rect_2D r1 = new Rect_2D(p1, p2);
        Triangle_2D t1 = new Triangle_2D(p1, p2, p3);

        ShapeCollection shap = new ShapeCollection();
        GUIShape guiShape1 = new GUIShape(r1, true, Color.BLACK, 1);
        GUIShape guiShape2 = new GUIShape(t1, false, Color.GREEN, 2);

        shap.add(guiShape1);
        shap.add(guiShape2);

        ShapeCollection newshap = new ShapeCollection();


        shap.save("PROGECT");

        newshap.load("PROGECT.txt");
        System.out.println(shap.toString());
        System.out.println(newshap.toString());
        assertTrue(shap.equal(newshap));



    }

    @Test
    void load() {
        Point_2D p2 = new Point_2D(1, 1);
        Point_2D p1 = new Point_2D(8, 8);
        Point_2D p3 = new Point_2D(5, 3);
        Rect_2D r1 = new Rect_2D(p1, p2);
        Triangle_2D t1 = new Triangle_2D(p1, p2, p3);


        GUIShape guiShape1 = new GUIShape(r1, true, Color.BLACK, 1);
        GUIShape guiShape2 = new GUIShape(t1, false, Color.GREEN, 2);
        ShapeCollection shape = new ShapeCollection();
        shape.add(guiShape1);
        shape.add(guiShape2);
        ShapeCollection shapeCol = new ShapeCollection();

        shapeCol.load("PROGECT.txt"); // in the file there is the same as r1 r2.

        assertTrue(shapeCol.equal(shape));






    }
    @Test
    void equal() {
        Point_2D p2 = new Point_2D(1, 1);
        Point_2D p1 = new Point_2D(8, 8);
        Point_2D p3 = new Point_2D(5, 3);
        Rect_2D r1 = new Rect_2D(p1, p2);
        Triangle_2D t1 = new Triangle_2D(p1, p2, p3);

        ShapeCollection shap = new ShapeCollection();
        GUIShape guiShape1 = new GUIShape(r1, true, Color.BLACK, 1);
        GUIShape guiShape2 = new GUIShape(t1, false, Color.GREEN, 2);

        shap.add(guiShape1);
        shap.add(guiShape2);

        ShapeCollection shap2 = new ShapeCollection();

        shap2.add(guiShape1);
        shap2.add(guiShape2);
        assertTrue(shap.equal(shap2));

        shap2.add(guiShape2);
        assertFalse(shap.equal(shap2));




    }
    @Test
    void testToString() {
        ShapeCollection t= new ShapeCollection();
        Point_2D p2 = new Point_2D(1, 1);
        Point_2D p1 = new Point_2D(8, 8);
        Rect_2D r1 = new Rect_2D(p1, p2);
        GUIShape guiShape1 = new GUIShape(r1, true, Color.BLACK, 1);
        t.add(guiShape1);
        System.out.println(t.toString());
        assertEquals(t.get(0).toString(),"GUIShape,0,true,1,Rect_2D,8.0,1.0,8.0,8.0,1.0,8.0,1.0,1.0");
    }














/*
    @Test
    void getdata() {
        Point_2D p2 = new Point_2D(1, 1);
        Point_2D p1 = new Point_2D(8, 8);
        Point_2D p3 = new Point_2D(5, 3);
        Rect_2D r1 = new Rect_2D(p1, p2);
        Triangle_2D t1 = new Triangle_2D(p1, p2, p3);
        ShapeCollection shap = new ShapeCollection();
        GUIShape guiShape1 = new GUIShape(r1, true, Color.BLACK, 1);
        GUIShape guiShape2 = new GUIShape(t1, false, Color.GREEN, 2);
        shap.add(guiShape1);
        shap.add(guiShape2);
        String data = "true,";
        String newdata = shap.getdata(data);
        assertEquals("true", newdata);
    }

    @Test
    void cut() {
        Point_2D p2 = new Point_2D(1, 1);
        Point_2D p1 = new Point_2D(8, 8);
        Point_2D p3 = new Point_2D(5, 3);
        Rect_2D r1 = new Rect_2D(p1, p2);
        Triangle_2D t1 = new Triangle_2D(p1, p2, p3);
        ShapeCollection shap = new ShapeCollection();
        GUIShape guiShape1 = new GUIShape(r1, true, Color.BLACK, 1);
        GUIShape guiShape2 = new GUIShape(t1, false, Color.GREEN, 2);
        shap.add(guiShape1);
        shap.add(guiShape2);
        String point = "8.0,8.0,8.0 ,asd";
        System.out.println(shap.cutdata(point));
    }

    @Test
    void getPoint() {
        Point_2D p2 = new Point_2D(1, 1);
        Point_2D p1 = new Point_2D(8, 8);
        Point_2D p3 = new Point_2D(5, 3);
        Rect_2D r1 = new Rect_2D(p1, p2);
        Triangle_2D t1 = new Triangle_2D(p1, p2, p3);
        ShapeCollection shap = new ShapeCollection();
        GUIShape guiShape1 = new GUIShape(r1, true, Color.BLACK, 1);
        GUIShape guiShape2 = new GUIShape(t1, false, Color.GREEN, 2);
        shap.add(guiShape1);
        shap.add(guiShape2);
        String point = "8.0,8.0,8.0 ,asd";
        Point_2D p5 = shap.getPoint(point);
        System.out.println(p5.toString());


    }

    @Test
    void getString() {
        Point_2D p2 = new Point_2D(1, 1);
        Point_2D p1 = new Point_2D(8, 8);
        Point_2D p3 = new Point_2D(5, 3);
        Rect_2D r1 = new Rect_2D(p1, p2);
        Triangle_2D t1 = new Triangle_2D(p1, p2, p3);
        ShapeCollection shap = new ShapeCollection();
        GUIShape guiShape1 = new GUIShape(r1, true, Color.BLACK, 1);
        GUIShape guiShape2 = new GUIShape(t1, false, Color.GREEN, 2);
        shap.add(guiShape1);
        shap.add(guiShape2);
        String point = "8.0,8.0,8.0 ,asd";
        System.out.println(shap.outPoint(point));
    }

 */
}