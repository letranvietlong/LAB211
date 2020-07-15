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
public class Tetrahedron extends ThreeDimensionalShape{
    private double r;

    public Tetrahedron() {
    }

    public Tetrahedron(double r) {
        this.r = r;
    }

    @Override
    double getArea() {
        double result = 4 * r * r * Math.PI;
        return result;
    }

    @Override
    double getVolume() {
        double result = 4 * r * r * r * Math.PI / 3;
        return result;
    }
}
