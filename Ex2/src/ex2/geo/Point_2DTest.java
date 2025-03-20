package ex2.geo;

import ex2.ex2.Ex2_Const;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

//* ID 315489534


class Point_2DTest {

    @org.junit.jupiter.api.Test
    void moveTest() {
        Point_2D p1=new Point_2D(3,4);
        Point_2D vec= new Point_2D(1,1);
        p1.move(vec);

    }

    @Test
    void add() {
        Point_2D p1=new Point_2D(3,4);
        Point_2D vec= new Point_2D(1,1);
        p1=p1.add(vec);
        assertEquals(p1.x(),4);
        assertEquals(p1.y(),5);


    }

    @Test
    void testToString() {
        Point_2D p1=new Point_2D(3,4);

        assertEquals(p1.toString(),"3.0,4.0");

    }

    @Test
    void distance() {
        Point_2D p1=new Point_2D(3,4);
        Point_2D p2= new Point_2D(7,1);
        double distance=p1.distance(p2);
        assertEquals(distance,5);
    }



    @Test
    void testEquals() {
        Point_2D p1=new Point_2D(3,4);
        Point_2D p2= new Point_2D(3,4);
        assertTrue(p1.equals(p2));
    }

    @Test
    void close2equals() {
        Point_2D p1=new Point_2D(3,4);
        Point_2D p2= new Point_2D(7,1);
        assertFalse(p1.close2equals(p2, Ex2_Const.EPS2));
        p2=new Point_2D (3,4);
        assertTrue(p1.close2equals(p2,Ex2_Const.EPS2));
    }

    @Test
    void vector() {
        Point_2D p1=new Point_2D(3,4);
        Point_2D target= new Point_2D(7,1);
        Point_2D temp= p1.vector(target);
        Point_2D aftertarget=new Point_2D(4,-3);
        assertTrue(aftertarget.equals(temp));
    }

    @Test
    void move() {
        Point_2D p1=new Point_2D(3,4);
        Point_2D p2= new Point_2D(7,1);
        p1.move(p2);
        assertEquals(p1.x(),10);
        assertEquals(p1.y(),5);

    }

    @Test
    void scale() {
        Point_2D p1=new Point_2D(3,4);
        Point_2D vector= new Point_2D(0,0);
        p1.scale(vector,2);
        assertEquals(p1.x(),6);
        assertEquals(p1.y(),8);
    }

    @Test
    void rotate() {
        Point_2D p1=new Point_2D(3,4);
        Point_2D vector= new Point_2D(0,0);
        p1.rotate(vector,180);
        assertEquals(p1.x(),-3,Ex2_Const.EPS2);
        assertEquals(p1.y(),-4,Ex2_Const.EPS2);

    }
}