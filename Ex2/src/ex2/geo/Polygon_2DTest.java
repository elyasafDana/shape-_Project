package ex2.geo;

import ex2.ex2.Ex2_Const;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


//* ID 315489534


class Polygon_2DTest {

    @Test
    void testToString() {
        Point_2D p1=new Point_2D(1,1);
        Point_2D p2=new Point_2D(2,2);
        Point_2D p3=new Point_2D(3,3);
        Point_2D p4=new Point_2D(4,4);
        Polygon_2D Poliarr= new Polygon_2D();
        Poliarr.add(p1);
        Poliarr.add(p2);
        Poliarr.add(p3);
        Poliarr.add(p4);
        assertEquals(Poliarr.toString(),"1.0,1.0,2.0,2.0,3.0,3.0,4.0,4.0");

    }

    @Test
    void getAllPoints(){
        Point_2D p1=new Point_2D(1,1);
        Point_2D p2=new Point_2D(2,2);
        Point_2D p3=new Point_2D(3,3);
        Point_2D p4=new Point_2D(4,4);
        Polygon_2D po= new Polygon_2D();
        po.add(p1);
        po.add(p2);
        po.add(p3);
        po.add(p4);
        Point_2D[] arr;
        arr= po.getAllPoints();
        assertEquals(arr[0],p1);
        assertEquals(arr[1],p2);
        assertEquals(arr[2],p3);
        assertEquals(arr[3],p4);
    }

    @Test
    void testEquals() {
        Point_2D p1=new Point_2D(1,1);
        Point_2D p2=new Point_2D(2,2);
        Point_2D p3=new Point_2D(3,3);
        Point_2D p4=new Point_2D(4,4);
        Polygon_2D po= new Polygon_2D();
        po.add(p1);
        po.add(p2);
        po.add(p3);
        po.add(p4);
        Polygon_2D po2= new Polygon_2D();
        po2.add(p1);
        po2.add(p2);
        po2.add(p3);
        po2.add(p4);
        assertTrue(po.equals(po2));
    }

    @Test
    void contains() {
        Point_2D p1=new Point_2D(2,4);
        Point_2D p2=new Point_2D(2,2);
        Point_2D p3=new Point_2D(9,2);
        Point_2D p4=new Point_2D(5,4);
        Polygon_2D po= new Polygon_2D();
        po.add(p1);
        po.add(p2);
        po.add(p3);
        po.add(p4);
        Point_2D inside= new Point_2D(5,3);
        Point_2D outside= new Point_2D(5,3);
        assertTrue(po.contains(inside));
        assertFalse(po.contains(outside));

    }

    @Test
    void area() {
        Point_2D p1=new Point_2D(3,4);
        Point_2D p2=new Point_2D(5,11);
        Point_2D p3=new Point_2D(12,8);

        Polygon_2D po= new Polygon_2D();
        po.add(p1);
        po.add(p2);
        po.add(p3);

       assertEquals(po.area(),27.5);

    }

    @Test
    void perimeter() {
        Point_2D p1=new Point_2D(0,0);
        Point_2D p2=new Point_2D(0,4);
        Point_2D p3=new Point_2D(6,4);
        Point_2D p4=new Point_2D(6,0);
        Polygon_2D po= new Polygon_2D();
        po.add(p1);
        po.add(p2);
        po.add(p3);
        po.add(p4);
        assertEquals(po.perimeter(),20);
    }

    @Test
    void scale() {
        Point_2D p2=new Point_2D(0,5);
        Point_2D p3=new Point_2D(5,5);
        Polygon_2D po= new Polygon_2D();
        po.add(p2);
        po.add(p3);
        Point_2D center= new Point_2D(0,0);
        po.scale(center,2);
        assertEquals(0,p2.x());
        assertEquals(10,p2.y());
        assertEquals(10,p3.x());
        assertEquals(10,p3.y());

    }

    @Test
    void rotate() {
        Point_2D p2=new Point_2D(0,5);
        Point_2D p3=new Point_2D(5,5);
        Polygon_2D po= new Polygon_2D();
        po.add(p2);
        po.add(p3);
        Point_2D center= new Point_2D(0,0);
        po.rotate(center,180);
        System.out.println(po.toString());
        assertEquals(0,p2.x(),Ex2_Const.EPS2);
        assertEquals(-5,p2.y(),Ex2_Const.EPS2);
        assertEquals(-5,p3.x(),Ex2_Const.EPS2);
        assertEquals(-5,p3.y(),Ex2_Const.EPS2);
    }
}