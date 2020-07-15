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
public class Triangle extends TwoDimensionalShape{
    private double a;
    private double b;
    private double c;
    
    public Triangle() {
    }
    
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    double getArea() {
        double p = (a + b + c) / 2;
        double result;
        if (a + b < 0 || a + c < 0 || b + c < 0) {
            result = 0;
        } else {
            result = p * (p - a) * (p - b) * (p - c);
        }
        return result;
    }
}
