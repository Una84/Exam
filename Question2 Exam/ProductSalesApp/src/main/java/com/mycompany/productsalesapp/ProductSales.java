/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productsalesapp;

/**
 *
 * @author RC_Student_Lab
 */
public class ProductSales implements IProduct {
    
    // Method to calculate the total sales
    @Override
    public int TotalSales(int[][] productSales) {
        int total = 0;
        for (int year = 0; year < productSales.length; year++) {
            for (int quarter = 0; quarter < productSales[year].length; quarter++) {
                total += productSales[year][quarter];
            }
        }
        return total;
    }

    // Method to calculate the average sales
    @Override
    public double AverageSales(int[][] productSales) {
        int total = TotalSales(productSales); // Reuse TotalSales method
        int numEntries = productSales.length * productSales[0].length; // Total number of sales entries
        return (double) total / numEntries;
    }

    // Method to find the maximum sale
    @Override
    public int MaxSale(int[][] productSales) {
        int max = productSales[0][0]; // Start with the first sale as the max
        for (int year = 0; year < productSales.length; year++) {
            for (int quarter = 0; quarter < productSales[year].length; quarter++) {
                if (productSales[year][quarter] > max) {
                    max = productSales[year][quarter];
                }
            }
        }
        return max;
    }

    // Method to find the minimum sale
    public int MinSale(int[][] productSales) {
        int min = productSales[0][0]; // Start with the first sale as the min
        for (int year = 0; year < productSales.length; year++) {
            for (int quarter = 0; quarter < productSales[year].length; quarter++) {
                if (productSales[year][quarter] < min) {
                    min = productSales[year][quarter];
                }
            }
        }
        return min;
    }
}


