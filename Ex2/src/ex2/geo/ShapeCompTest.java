package ex2.geo;

import ex2.ex2.Ex2_Const;
import ex2.ex2.ShapeCollection;
import ex2.gui.GUIShape;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

//* ID 315489534

class ShapeCompTest {

    @Test
    void compare() {
        Point_2D p= new Point_2D(1,1);
        Circle_2D c= new Circle_2D(p,3);
        Circle_2D c1= new Circle_2D(p,5);
        ShapeCollection t= new ShapeCollection();
        GUIShape g1= new GUIShape(c,true, Color.BLACK,0);
        GUIShape g2= new GUIShape(c1,true, Color.BLACK,1);
        t.add(g1);
        t.add(g2);



    }

    @Test
    void testCompare() {
        Point_2D p= new Point_2D(1,1);
        Circle_2D c= new Circle_2D(p,3);
        Circle_2D c1= new Circle_2D(p,5);
        ShapeCollection t= new ShapeCollection();
        GUIShape g1= new GUIShape(c,true, Color.BLACK,0);
        GUIShape g2= new GUIShape(c1,true, Color.BLACK,1);
        t.add(g1);
        t.add(g2);
        ShapeComp CompByArea = new ShapeComp(Ex2_Const.Sort_By_Area);

    }
}