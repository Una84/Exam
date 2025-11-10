/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.salesreport;

/**
 *
 * @author RC_Student_Lab
 */
public class SalesReport {

    public static void main(String[] args) {
        // 2D array for sales data: rows represent years, columns represent quarters
        int[][] salesData = {
            {300, 150, 700},  // Year 1 sales data (Quarter 1, 2, 3)
            {250, 200, 600},   // Year 2 sales data (Quarter 1, 2, 3)
        };

        int totalSales = 0;
        int maxSale = salesData[0][0];
        int minSale = salesData[0][0];
        int numOfEntries = 0;

        // Traverse through the array to calculate total, max, min sales
        for (int year = 0; year < salesData.length; year++) {
            for (int quarter = 0; quarter < salesData[year].length; quarter++) {
                int sale = salesData[year][quarter];
                totalSales += sale;
                numOfEntries++;

                // Check for max sale
                if (sale > maxSale) {
                    maxSale = sale;
                }

                // Check for min sale
                if (sale < minSale) {
                    minSale = sale;
                }
            }
        }

        // Calculate average sales
        double averageSales = (double) totalSales / numOfEntries;

        // Output the sales report
        System.out.println("PRODUCT SALES REPORT - 2025");
        System.out.println("-----------------------------");
        System.out.println("Total sales: " + totalSales);
        System.out.println("Average sales: " + String.format("%.2f", averageSales));
        System.out.println("Maximum sale: " + maxSale);
        System.out.println("Minimum sale: " + minSale);
    }
}

