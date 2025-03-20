package ex2.geo;

import ex2.ex2.Ex2_Const;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Rect_2DTest {


//* ID 315489534


    @Test
    void contains() {
        Point_2D rightup= new Point_2D(2,5);
        Point_2D rightdown= new Point_2D(8,5);
        Point_2D leftup= new Point_2D(2,1);
        Point_2D leftdown= new Point_2D(8,1);
        Rect_2D r= new Rect_2D(rightup,leftdown);
        Point_2D inside= new Point_2D(4,3);
        Point_2D outside= new Point_2D(9,2);
        assertEquals(false,r.contains(outside));
    }

    @Test
    void area() {
        Point_2D p1= new Point_2D(2,1);
        Point_2D p2=new Point_2D(8,8);
        Rect_2D rec=new Rect_2D(p1,p2);
        assertEquals(rec.area(),42);
    }

    @Test
    void perimeter() {
        Point_2D p1= new Point_2D(2,1);
        Point_2D p2=new Point_2D(8,8);
        Rect_2D rec=new Rect_2D(p1,p2);
        assertEquals(rec.perimeter(),26);
    }

    @Test
    void translate() {
        Point_2D p1= new Point_2D(1,1);
        Point_2D p2= new Point_2D(8,8);
        Point_2D vector= new Point_2D(1,1);

        Rect_2D r= new Rect_2D(p1, p2);
        r.translate(vector);
        Point_2D ru= new Point_2D(9,9);
        Point_2D rl= new Point_2D(9,2);
        Point_2D ll= new Point_2D(2,2);
        Point_2D lu= new Point_2D(2,9);

        assertEquals(r.rightUp,ru);
        assertEquals(r.rightLow,rl);
        assertEquals(r.leftLow,ll);
        assertEquals(r.leftUp,lu);

    }

    @Test
    void copy() {
        Point_2D p1= new Point_2D(1,1);
        Point_2D p2= new Point_2D(8,8);

        Rect_2D r= new Rect_2D(p1, p2);
        Rect_2D newr= (Rect_2D) r.copy();
        assertEquals(r,newr);



    }


    @Test
    void rotate() {
        Point_2D p1 = new Point_2D(1, 1);
        Point_2D p2 = new Point_2D(8, 8);
        Rect_2D r = new Rect_2D(p1, p2);

        Point_2D center = new Point_2D(0, 0);
        double angleDegrees = 180;

        r.rotate(center, angleDegrees);

        assertEquals(-1, r.leftLow.x(), Ex2_Const.EPS);
        assertEquals(-1, r.leftLow.y(), Ex2_Const.EPS);
        assertEquals(-8, r.rightUp.x(), Ex2_Const.EPS);
        assertEquals(-8, r.rightUp.y(), Ex2_Const.EPS);

        assertEquals(-8, r.rightLow.x(), Ex2_Const.EPS);
        assertEquals(-1, r.rightLow.y(), Ex2_Const.EPS);
        assertEquals(-1, r.leftUp.x(), Ex2_Const.EPS);
        assertEquals(-8, r.leftUp.y(), Ex2_Const.EPS);

    }


    @Test
    void testScale() {
        Point_2D p1 = new Point_2D(1, 1);
        Point_2D p2 = new Point_2D(8, 8);
        Rect_2D r = new Rect_2D(p1, p2);

        Point_2D center = new Point_2D(4, 4);
        double ratio = 2;

        r.scale(center, ratio);
        assertEquals(-2, r.leftUp.x(), 0.01);
        assertEquals(12,  r.leftUp.y(), 0.01);
        assertEquals(12,  r.rightLow.x(), 0.01);
        assertEquals(-2, r.rightLow.y(), 0.01);


    }



    @Test
    void testEquals() {
        Point_2D p1= new Point_2D(2,1);
        Point_2D p2=new Point_2D(8,8);
        Rect_2D rec=new Rect_2D(p1,p2);

        Rect_2D rec2= new Rect_2D(p1,p2);

        assertTrue(rec2.equals(rec));
    }
}