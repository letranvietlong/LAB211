/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsp0080;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author macbook
 */

public class Circle extends TwoDimensionalShape {

    private double r;

    public Circle() {
    }

    public Circle(double r) {
        this.r = r;
    }

    @Override
    double getArea() {      
        return r * r * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle{" + "r=" + r + getArea() +'}';
    }
    
}
