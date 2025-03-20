package ex2.geo;

import ex2.ex2.Ex2_Const;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//* ID 315489534
class Circle_2DTest {

    @Test
    void testEquals() {
        Point_2D p1= new Point_2D(1,1);
        Circle_2D c= new Circle_2D(p1,3);
        Point_2D p2= new Point_2D(1,1);
        Circle_2D c2 = new Circle_2D(p1,4);
        assertFalse(c.equals(c2));

    }

    @Test
    void contains() {
        Point_2D p1= new Point_2D(1,1);
        Circle_2D c= new Circle_2D(p1,3);
        Point_2D inside= new Point_2D(2,2);
        assertTrue(c.contains(inside));
    }

    @Test
    void translate() {
        Point_2D p1= new Point_2D(1,1);
        Circle_2D c= new Circle_2D(p1,3);
        Point_2D vec= new Point_2D(1,1);
        c.translate(vec);
        Point_2D aftervec= new Point_2D(2,2);
        assertEquals(c.getCenter(),aftervec);
        assertEquals(c.getRadius(),3);


    }

    @Test
    void copy() {
        Point_2D p1= new Point_2D(1,1);
        Circle_2D c= new Circle_2D(p1,3);
        Circle_2D newc=(Circle_2D) c.copy();
        assertEquals(c.getRadius(),newc.getRadius());
        assertEquals(c.getCenter(),newc.getCenter());
    }

    @Test
    void area() {
        Point_2D p1= new Point_2D(0,0);
        Circle_2D c= new Circle_2D(p1,3);
        Circle_2D newc=(Circle_2D) c.copy();
        assertEquals( Math.PI*3*3,newc.area());

    }

    @Test
    void perimeter() {
        Point_2D p1= new Point_2D(0,0);
        Circle_2D c= new Circle_2D(p1,3);
        Circle_2D newc=(Circle_2D) c.copy();
        assertEquals(2* Math.PI*3,newc.perimeter());

    }

    @Test
    void scale() {
        Point_2D p1= new Point_2D(1,1);
        Circle_2D c= new Circle_2D(p1,3);
        double ratio= 2;
        Point_2D center= new Point_2D(0,0);
        c.scale(center,ratio);
        Point_2D afterscale= new Point_2D(2,2);
        assertEquals(c.getCenter(),afterscale);
        assertEquals(c.getRadius(),6);

    }

    @Test
    void rotate() {
        Point_2D p1= new Point_2D(1,1);
        Circle_2D c= new Circle_2D(p1,3);
        double center= 180;
        c.rotate(p1,center);
        Point_2D newp1= new Point_2D(1,1);
        assertEquals(newp1,p1);
        assertEquals(3,c.getRadius());
    }
}