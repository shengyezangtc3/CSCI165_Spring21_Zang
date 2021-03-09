/**
 * Author: Shengye Zang
 * Date: March 8 2020
 * Assignment: Week 5 Discussion
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.EventQueue;

class MapDrawer extends JPanel {

    private static final long serialVersionUID = 1L;
    private JFrame window = new JFrame();
    final static int rows = 480;
    final static int cols = 844;
    private int[][] elevationMatrix = new int[rows][cols];

    // constructor
    public MapDrawer() {
        window.add(this);
        window.setTitle("2D Drawing");
        window.setSize(500, 500);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    // this paintComponent method gets called automatically by the JRE
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawMap(g);
    }
  
    public static void main(String[] args) {
        // don't worry about this code, unless you want to research
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() { 
                MapDrawer ex = new MapDrawer(); // create an instance of "this" class, calling constructor
                ex.setVisible(true);            // make the frame visible
                ex.readMatrix("Colorado_844x480.dat");// call the readMatrix method. Use the instance, because method is not static
            }
        });
    } // end main

    // TO DO: Implement the following methods
    // You decide how to handle the matrix
    /**
     * This method reads in the data from the targeted file and stores them in a matrix
     * @param fileName
     */
    private void readMatrix(String fileName){
        try{
            File file = new File(fileName);         
            Scanner scanner = new Scanner(file);    
            
            for(int row = 0; row < elevationMatrix.length; row++){ 
                // outer loop deals with the rows
                for(int column = 0; column < elevationMatrix[row].length; ++column){
                    // inner loop deals with the columns in each row
                    int elevation = scanner.nextInt();                    // scan a single int
                    elevationMatrix[row][column] = elevation;                   
                } // end inner loop
            } // end outer loop
            scanner.close(); 
        }catch(FileNotFoundException fnfe){
            System.out.println("No such file");
        } // end catch
    }

    /**
     * This method finds grey scale minimum
     * @return
     */
    private int findMinimum(){
        int min = elevationMatrix[0][0];
        // write the logic yourself. No shortcuts. No API calls
        for(int row=0; row < elevationMatrix.length; row++) {
            for(int column=0; column < elevationMatrix[row].length; ++column) {
                if(min > elevationMatrix[row][column])
                    min = elevationMatrix[row][column];
            }
        }
        return min;
    }

    /**
     * This method finds grey scale maximum
     * @return
     */
    private int findMaximum(){
        int max = elevationMatrix[0][0];
        // write the logic yourself. No shortcuts. No API calls
        for(int row=0; row < elevationMatrix.length; row++) {
            for(int column=0; column < elevationMatrix[row].length; ++column) {
                if(max < elevationMatrix[row][column])
                    max = elevationMatrix[row][column];
            }
        }
        return max;
    }

    private void drawMap(Graphics graphics){
        Graphics2D g2d = (Graphics2D) graphics;
        /*
            RGB Colors:
            ================================================
            Black       => (0, 0, 0)        => low elevation
            Mid Grey    => (128, 128, 128)  => mid elevation
            White       => (255, 255, 255)  => high elevation

            Grey Scale colors are scaled in matching set of 3 numeric values
        */
        int x = 1, y = 1;      
        int min = findMinimum();
        int max = findMaximum();
        int scale = (max - min) / 255;
        int rgb = 0;

        for(int row=0; row<elevationMatrix.length; ++row) {
            for(int column=0; column<elevationMatrix[row].length; ++column) {
                rgb = (elevationMatrix[row][column] - min) / scale; // convert gray scale to rgb
                rgb = rgb > 255? 255: rgb;                          // I got this line from Jianghong's post
                g2d.setColor(new Color(rgb, rgb, rgb));
                g2d.fillRect(x, y, 1, 1);
                x += 1;
            }
            y += 1;
            x = 1;
        }
    }
} // end class