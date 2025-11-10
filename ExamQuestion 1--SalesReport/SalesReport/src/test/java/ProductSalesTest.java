/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.salesreport.ProductSales;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_Lab
 */
public class ProductSalesTest {


    private final ProductSales productSales = new ProductSales();

    int[][] salesData = {
        {300, 150, 700},  // Year 1
        {250, 200, 600}   // Year 2
    };

    @Test
    public void CalculateTotalSales_ReturnsTotalSales() {
        int expected = 2200; // 300+150+700+250+200+600
        int actual = productSales.TotalSales(salesData);
        assertEquals(expected, actual, "Total sales should be 2200");
    }

    @Test
    public void AverageSales_ReturnsAverageProductSales() {
        double expected = 2200.0 / 6; // Total / number of entries
        double actual = productSales.AverageSales(salesData);
        assertEquals(expected, actual, 0.001, "Average sales should be correct");
    }

    @Test
    public void MaxSale_ReturnsHighestValue() {
        int expected = 700;
        int actual = productSales.MaxSale(salesData);
        assertEquals(expected, actual, "Max sale should be 700");
    }

    @Test
    public void MinSale_ReturnsLowestValue() {
        int expected = 150;
        int actual = productSales.MinSale(salesData);
        assertEquals(expected, actual, "Min sale should be 150");
    }
}
