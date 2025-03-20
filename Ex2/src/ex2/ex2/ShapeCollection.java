package ex2.ex2;

import java.awt.*;
import java.io.*;
import java.util.*;

import ex2.geo.*;
import ex2.gui.GUIShape;
import ex2.gui.GUI_Shape;

import java.io.FileWriter;
import java.io.BufferedReader;

import java.util.Comparator;

/**
 * This class represents a collection of GUI_Shape.
 * Ex2: you should implement this class!
 * ID 315489534
 * @author I2CS
 */
public class ShapeCollection implements GUI_Shape_Collection {
    private ArrayList<GUI_Shape> _shapes;

    public ShapeCollection() {
        _shapes = new ArrayList<GUI_Shape>();
    }

    /**
     * Gets the GUI_Shape at the specified index.
     *
     * @param i Index of the GUI_Shape to retrieve.
     * @return GUI_Shape at the specified index.
     */
    @Override
    public GUI_Shape get(int i) {
        return _shapes.get(i);
    }

    /**
     * Gets the size of the ShapeCollection.
     *
     * @return The number of elements in the collection.
     */
    @Override
    public int size() {
        return _shapes.size();
    }

    /**
     * Removes the element at the specified index and returns it.
     *
     * @param i Index of the element to remove.
     * @return The removed GUI_Shape.
     */
    @Override
    public GUI_Shape removeElementAt(int i) {
        GUI_Shape save = _shapes.get(i);
        _shapes.remove(i);
        for (int j = i; i < _shapes.size() - 1; i++) {
            _shapes.add(i, _shapes.get(i + 1));
        }
        _shapes.trimToSize();
        return save;
    }

    /**
     * Adds the specified GUI_Shape at the specified index.
     *
     * @param s The GUI_Shape to add.
     * @param i Index at which to add the GUI_Shape.
     */
    @Override
    public void addAt(GUI_Shape s, int i) {
        ArrayList<GUI_Shape> temp = new ArrayList<GUI_Shape>();
        for (int j = 0; j < i; j++) { // keeps all the points in the upper index  and remove them from the original arr
            temp.add(j, _shapes.get(j));
            _shapes.remove(j);
        }
        temp.add(s); // add the point that you get
        for (int j = i; i < _shapes.size(); j++) {
            temp.add(_shapes.get(j)); // return all the upper index points
        }
        _shapes = temp;
    }

    /**
     * Adds the specified GUI_Shape to the collection.
     *
     * @param s The GUI_Shape to add.
     */

    @Override
    public void add(GUI_Shape s) {
        if (s != null && s.getShape() != null) {
            _shapes.add(s); // add new shap
        }
    }

    /**
     * Creates a deep copy of the ShapeCollection.
     *
     * @return A copy of the ShapeCollection.
     */

    @Override
    public GUI_Shape_Collection copy() {
        GUI_Shape_Collection temp = new ShapeCollection();
        for (int i = 0; i < _shapes.size(); i++) {
            temp.add(_shapes.get(i));
        }
        return temp;
    }

    /**
     * Sorts the collection using the specified comparator.
     *
     * @param comp The comparator used for sorting.
     */
    @Override
    public void sort(Comparator<GUI_Shape> comp) {

        _shapes.sort(comp); // use the method sort
    }

    /**
     * Removes all elements from the collection.
     */

    @Override
    public void removeAll() {
        _shapes.clear();
    }


    /**
     * Saves the collection to a file with the specified name.
     *
     * @param file The name of the file to save to.
     */
    @Override
    public void save(String file) {
        try {
            FileWriter writer = new FileWriter(file + ".txt");
            writer.write(this.toString() + "\n"); //wite the collection inside the file

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    /**
     * Loads a collection from a file with the specified name.
     *
     * @param file The name of the file to load from.
     */
    @Override
    public void load(String file) {

        try {
            BufferedReader buf = new BufferedReader(new FileReader(file));
            while (true) {
                String data = buf.readLine();
                if (data == null || data.isEmpty()) // if there is no data break
                    break;
                _shapes.add(new GUIShape(data)); // buld a new guishape by the string
            }
            buf.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }



    /**
     * Returns a string representation of the collection.
     *
     * @return String representation of the collection.
     */
    @Override
    public String toString() {
        String ans = "";
        for (int i = 0; i < size(); i = i + 1) {
            ans += this.get(i) + "\n";
        }
        return ans;
    }
    /**
     * Checks if two ShapeCollections are equal.
     *
     * @param o The other ShapeCollection to compare.
     * @return True if the ShapeCollections are equal, false otherwise.
     */

    public boolean equal(ShapeCollection o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (_shapes.size() != o.size()) return false;
        for (int i = 0; i < _shapes.size(); i++) {
            if (!(_shapes.get(i).isFilled() == o.get(i).isFilled() && _shapes.get(i).getTag() == o.get(i).getTag() && _shapes.get(i).getColor().equals(o.get(i).getColor())  && _shapes.get(i).getShape().equals(o.get(i).getShape()))) // if the color the tage the shape and theis filled equal return true.
                return false;
        }
        return true;
    }


}
