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
public class Square extends TwoDimensionalShape{
    private double a;

    public Square() {
    }

    public Square(double a) {
        this.a = a;
    }

    @Override
    double getArea() {
        return a * a;
    }
    
}
