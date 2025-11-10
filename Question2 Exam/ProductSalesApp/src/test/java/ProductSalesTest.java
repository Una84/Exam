/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.productsalesapp.ProductSales;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_Lab
 */
import org.junit.jupiter.api.Test;

public class ProductSalesTest {

    // Create an instance of ProductSales to test
    ProductSales ps = new ProductSales();

    // Sample sales data
    int[][] sampleData = {
        {300, 150, 700},
        {250, 200, 600}
    };

    // Test 1: Total sales calculation
    @Test
    public void CalculateTotalSales_ReturnsTotalSales() {
        int expectedTotal = 2200; // 300 + 150 + 700 + 250 + 200 + 600
        int actualTotal = ps.TotalSales(sampleData);
        assertEquals(expectedTotal, actualTotal, "Total sales should equal 2200");
    }

    // Test 2: Average sales calculation
    @Test
    public void AverageSales_ReturnsAverageProductSales() {
        double expectedAverage = 2200.0 / 6; // = 366.67
        double actualAverage = ps.AverageSales(sampleData);
        assertEquals(expectedAverage, actualAverage, 0.01, "Average sales should be about 366.67");
    }

    // Test 3: Maximum sale value
    @Test
    public void MaxSale_ReturnsHighestSale() {
        int expectedMax = 700;
        int actualMax = ps.MaxSale(sampleData);
        assertEquals(expectedMax, actualMax, "Max sale should be 700");
    }

    // Test 4: Minimum sale value
    @Test
    public void MinSale_ReturnsLowestSale() {
        int expectedMin = 150;
        int actualMin = ps.MinSale(sampleData);
        assertEquals(expectedMin, actualMin, "Min sale should be 150");
    }
}
