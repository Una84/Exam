/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.productsalesapp;

/**
 *
 * @author RC_Student_Lab
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ProductSalesApp extends JFrame {

    private JTextArea txtDisplay;
    private JLabel lblYears;
    private int[][] salesData;
    private final int SALES_LIMIT = 500;

    public ProductSalesApp() {
        setTitle("Product Sales Application");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ===== TEXT AREA =====
        txtDisplay = new JTextArea();
        txtDisplay.setEditable(false);
        add(new JScrollPane(txtDisplay), BorderLayout.CENTER);

        // ===== LABEL =====
        lblYears = new JLabel("Years Processed: ");
        add(lblYears, BorderLayout.SOUTH);

        // ===== BUTTON PANEL =====
        JPanel panelButtons = new JPanel();
        JButton btnLoad = new JButton("Load Product Data");
        JButton btnSave = new JButton("Save Product Data");

        panelButtons.add(btnLoad);
        panelButtons.add(btnSave);
        add(panelButtons, BorderLayout.NORTH);

        // ===== BUTTON ACTIONS =====
        btnLoad.addActionListener(e -> loadProductData());
        btnSave.addActionListener(e -> saveProductData());

        // ===== MENU BAR =====
        JMenuBar menuBar = new JMenuBar();

        // File Menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        // Tools Menu
        JMenu toolsMenu = new JMenu("Tools");

        JMenuItem loadItem = new JMenuItem("Load Product Data");
        loadItem.addActionListener(e -> loadProductData());

        JMenuItem saveItem = new JMenuItem("Save Product Data");
        saveItem.addActionListener(e -> saveProductData());

        JMenuItem clearItem = new JMenuItem("Clear");
        clearItem.addActionListener(e -> {
            txtDisplay.setText("");
            lblYears.setText("Years Processed: ");
        });

        toolsMenu.add(loadItem);
        toolsMenu.add(saveItem);
        toolsMenu.add(clearItem);

        // Add Menus to MenuBar
        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        //  SHOW WINDOW 
        setVisible(true);
    }

    // 
    // Load Product Data (Q2.2)
    // 
    private void loadProductData() {
        salesData = new int[][] {
            {300, 150, 700},
            {250, 200, 600}
        };

        ProductSales ps = new ProductSales();

        int totalSales = ps.TotalSales(salesData);
        double averageSales = ps.AverageSales(salesData);
        int overLimit = 0;
        int underLimit = 0;

        for (int[] year : salesData) {
            for (int sale : year) {
                if (sale > SALES_LIMIT)
                    overLimit++;
                else
                    underLimit++;
            }
        }

        txtDisplay.setText("DATA LOG\n" +
                "============================\n" +
                "Total Sales: " + totalSales + "\n" +
                "Average Sales: " + String.format("%.0f", averageSales) + "\n" +
                "Sales over limit: " + overLimit + "\n" +
                "Sales under limit: " + underLimit + "\n" +
                "============================");

        lblYears.setText("Years Processed: " + salesData.length);
    }

    //
    // Save Product Data (Q2.2)
    //
    private void saveProductData() {
        if (txtDisplay.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No data to save!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter("data.txt"))) {
            writer.println(txtDisplay.getText());
            JOptionPane.showMessageDialog(this, "Data saved successfully to data.txt");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // 
    // MAIN METHOD
    // 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductSalesApp());
    }
}
