package ex2.geo;

import ex2.ex2.Ex2_Const;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//* ID 315489534

class Triangle_2DTest {

    @Test
    void getAllPoints() {
        Point_2D p1= new Point_2D(1,1);
        Point_2D p2=new Point_2D(8,8);
        Point_2D p3=new Point_2D(3,3);
        Triangle_2D temp= new Triangle_2D(p1,p2,p3);
        Point_2D [] arr= temp.getAllPoints();

        assertEquals(temp.p1.x(),arr[0].x());
        assertEquals(temp.p1.y(),arr[0].y());
        assertEquals(temp.p2.x(),arr[1].x());
        assertEquals(temp.p2.y(),arr[1].y());
        assertEquals(temp.p3.x(),arr[2].x());
        assertEquals(temp.p3.y(),arr[2].y());

    }


    @Test
    void contains() {
        Point_2D p1 = new Point_2D(0, 0);
        Point_2D p2 = new Point_2D(4, 0);
        Point_2D p3 = new Point_2D(2, 3);
        Triangle_2D t=new Triangle_2D(p1,p2,p3);
        Point_2D insidePoint = new Point_2D(2, 1);
        Point_2D outsidePoint = new Point_2D(5, 2);
        assertEquals(true,t.contains(outsidePoint));


    }




    @Test
    void translate() {
        Point_2D p1 = new Point_2D(0, 0);
        Point_2D p2 = new Point_2D(4, 0);
        Point_2D p3 = new Point_2D(2, 3);
        Triangle_2D t=new Triangle_2D(p1,p2,p3);
        Point_2D vec = new Point_2D(1, 1);

        t.translate(vec);

        assertEquals(t.p1.x(),1);
        assertEquals(t.p1.y(),1);
        assertEquals(t.p2.x(),5);
        assertEquals(t.p2.y(),1);
        assertEquals(t.p3.x(),3);
        assertEquals(t.p3.y(),4);
    }

    @Test
    void copy() {
        Point_2D p1 = new Point_2D(0, 0);
        Point_2D p2 = new Point_2D(4, 0);
        Point_2D p3 = new Point_2D(2, 3);
        Triangle_2D t=new Triangle_2D(p1,p2,p3);
        Triangle_2D copy= (Triangle_2D) t.copy();
        assertEquals(t.p1.x(),copy.p1.x(),Ex2_Const.EPS2);
        assertEquals(t.p1.y(),copy.p1.y(),Ex2_Const.EPS2);
        assertEquals(t.p2.x(),copy.p2.x(),Ex2_Const.EPS2);
        assertEquals(t.p2.y(),copy.p2.y(),Ex2_Const.EPS2);
        assertEquals(t.p3.x(),copy.p3.x(),Ex2_Const.EPS2);
        assertEquals(t.p3.y(),copy.p3.y(),Ex2_Const.EPS2);

    }

    @Test
    void scale() {
        Point_2D p1 = new Point_2D(0, 0);
        Point_2D p2 = new Point_2D(4, 0);
        Point_2D p3 = new Point_2D(2, 3);
        Triangle_2D t=new Triangle_2D(p1,p2,p3);
        Point_2D center = new Point_2D(0, 0);
        t.scale(center,2);
        assertEquals(t.p1.x(),0);
        assertEquals(t.p1.y(),0);
        assertEquals(t.p2.x(),8);
        assertEquals(t.p2.y(),0);
        assertEquals(t.p3.x(),4);
        assertEquals(t.p3.y(),6);
    }

    @Test
    void rotate() {
        Point_2D p1 = new Point_2D(0, 0);
        Point_2D p2 = new Point_2D(4, 0);
        Point_2D p3 = new Point_2D(2, 3);
        Triangle_2D t=new Triangle_2D(p1,p2,p3);
        Point_2D center = new Point_2D(0, 0);
        t.rotate(center,180);
        assertEquals(t.p1.x(),0,Ex2_Const.EPS2);
        assertEquals(t.p1.y(),0,Ex2_Const.EPS2);
        assertEquals(t.p2.x(),-4,Ex2_Const.EPS2);
        assertEquals(t.p2.y(),0,Ex2_Const.EPS2);
        assertEquals(t.p3.x(),-2,Ex2_Const.EPS2);
        assertEquals(t.p3.y(),-3, Ex2_Const.EPS2);
    }

    @Test
    void testEquals() {
        Point_2D p1 = new Point_2D(0, 0);
        Point_2D p2 = new Point_2D(4, 0);
        Point_2D p3 = new Point_2D(2, 3);
        Triangle_2D t=new Triangle_2D(p1,p2,p3);
        Triangle_2D t2 = new Triangle_2D(p1,p2,p3);
        assertTrue(t.equals(t2));

    }
    @Test
    void area() {
        Point_2D p1 = new Point_2D(1, 2);
        Point_2D p2 = new Point_2D(3, 4);
        Point_2D p3 = new Point_2D(5, 1);
        Triangle_2D t=new Triangle_2D(p1,p2,p3);
        assertEquals(t.area(),5,Ex2_Const.EPS2);
    }
    @Test
    void perimeter() {
        Point_2D p1 = new Point_2D(0, 0);
        Point_2D p2 = new Point_2D(3, 0);
        Point_2D p3 = new Point_2D(0, 4);
        Triangle_2D t=new Triangle_2D(p1,p2,p3);
        assertEquals(t.perimeter(),12,Ex2_Const.EPS2);
    }
}