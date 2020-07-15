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
public class Cube extends ThreeDimensionalShape {

    private double a;

    public Cube() {
    }

    public Cube(double a) {
        this.a = a;
    }

    @Override
    double getArea() {
        double result = 6 * a * a;
        return result;
    }

    @Override
    double getVolume() {
        double result = a * a * a;
        return result;
    }
}
