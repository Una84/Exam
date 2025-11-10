/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.salesreport;

/**
 *
 * @author RC_Student_Lab
 */
public class ProductSales2 implements IProduct {
    @Override
    public int TotalSales(int[][] productSales) {
        int total = 0;
        for (int[] year : productSales)
            for (int sale : year)
                total += sale;
        return total;
    }

    @Override
    public double AverageSales(int[][] productSales) {
        int total = TotalSales(productSales);
        int entries = productSales.length * productSales[0].length;
        return (double) total / entries;
    }

    @Override
    public int MaxSale(int[][] productSales) {
        int max = productSales[0][0];
        for (int[] year : productSales)
            for (int sale : year)
                if (sale > max) max = sale;
        return max;
    }

    @Override
    public int MinSale(int[][] productSales) {
        int min = productSales[0][0];
        for (int[] year : productSales)
            for (int sale : year)
                if (sale < min) min = sale;
        return min;
    }
}
