package ex2.geo;

import ex2.ex2.Ex2_Const;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//* ID 315489534


class Segment_2DTest {

    @Test
    void contains() {
        Point_2D p1= new Point_2D(0,0);
        Point_2D p2= new Point_2D(4,0);
        Segment_2D s= new Segment_2D(p1,p2);
        Point_2D inside= new Point_2D(2,0);
        Point_2D outside= new Point_2D(6,2);

        assertEquals(true,s.contains(inside));
    }


    @Test
    void primeter(){
        Point_2D p1= new Point_2D(3,4);
        Point_2D p2= new Point_2D(7,1);

        Segment_2D temp=new Segment_2D(p1,p2);
        assertEquals(temp.perimeter(),10);
    }


    @Test
    void translate() {
        Point_2D p1= new Point_2D(1,2);
        Point_2D p2= new Point_2D(8,8);

        Segment_2D temp=new Segment_2D(p1,p2);
        Point_2D vec= new Point_2D(1,2);

        temp.translate(vec);

        assertEquals(temp.p1.x(),9);
        assertEquals(temp.p1.y(),10);
        assertEquals(temp.p2.x(),2);
        assertEquals(temp.p2.y(),4);
    }

    @Test
    void copy() {
        Point_2D p1= new Point_2D(1,2);
        Point_2D p2= new Point_2D(8,8);

        Segment_2D temp=new Segment_2D(p1,p2);
        Segment_2D newone=(Segment_2D) temp.copy();

        assertEquals(newone.p1.x(),1);
        assertEquals(newone.p1.y(),2);
        assertEquals(newone.p2.x(),8);
        assertEquals(newone.p2.y(),8);


    }

    @Test
    void scale() {
        Point_2D p1= new Point_2D(1,2);
        Point_2D p2= new Point_2D(8,8);

        Segment_2D temp=new Segment_2D(p1,p2);
        Point_2D vec= new Point_2D(1,2);

        temp.scale(vec,2);

        assertEquals(temp.p1.x(),15);
        assertEquals(temp.p1.y(),14);
        assertEquals(temp.p2.x(),1);
        assertEquals(temp.p2.y(),2);
    }

    @Test
    void rotate() {
        Point_2D p1= new Point_2D(1,2);
        Point_2D p2= new Point_2D(8,8);

        Segment_2D temp=new Segment_2D(p1,p2);
        Point_2D center= new Point_2D(0,0);
        temp.rotate(center,180);

        assertEquals(temp.p1.x(),-8, Ex2_Const.EPS2);
        assertEquals(temp.p1.y(),-8, Ex2_Const.EPS2);
        assertEquals(temp.p2.x(),-1, Ex2_Const.EPS2);
        assertEquals(temp.p2.y(),-2, Ex2_Const.EPS2);

    }

    @Test
    void testEquals() {
        Point_2D p1= new Point_2D(0,0);
        Point_2D p2= new Point_2D(4,0);
        Segment_2D s= new Segment_2D(p1,p2);
        Segment_2D s2 = new Segment_2D(p1,p2);
        assertTrue(s2.equals(s));
    }
}