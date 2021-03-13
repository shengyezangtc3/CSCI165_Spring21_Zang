/**
 * Author: Shengye Zang
 * Date: March 12 2020
 * Assignment: Week 6 Lab
 * Is it fine to draw all the paths with the same color?
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.EventQueue;
import java.lang.Math;

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
        drawLowestElevPath(g, 479);
        indexOfLowestElevPath(g);
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

    /**
     * This method draws the path with lowest elevation for the row given, and calculates and returns the total 
     * elevation change on that path.
     * @param graphics
     * @param startRow
     * @return
     */
    private int drawLowestElevPath(Graphics graphics, int startRow) {
        int total_elevation_change = 0;
        Graphics2D g2d = (Graphics2D) graphics;
        int x = 1, y = startRow + 1;
        g2d.setColor(new Color(0, 128, 0));
        g2d.fillRect(x, y, 1, 1);
        int start = elevationMatrix[startRow][0];
        int fwd;
        int fwd_up;
        int fwd_down;
        int current_row = startRow;
        int current = start;
        int difference; // difference in elevation between current step and next step
        int temp;
        for(int i=1; i<elevationMatrix[0].length; i++) {
            fwd = elevationMatrix[current_row][i];
            temp = current;
            // When the current step stands on the border of the map, one of fwd_up and fwd_down will be set to fwd 
            // based on which border the current step stands on. 
            if(current_row-1 < 0)
                fwd_up = fwd;
            else
                fwd_up = elevationMatrix[current_row-1][i];

            if(current_row+1 > elevationMatrix.length-1)
                fwd_down = fwd;
            else
                fwd_down = elevationMatrix[current_row+1][i];

            // Below is a mess of all possible situations for next step. Setting fwd_up or fwd_down to fwd really 
            // complicates the problem.
            if(Math.abs(fwd_up-current) < Math.abs(fwd-current) && Math.abs(fwd_up-current) < Math.abs(fwd_down-current)) {
                temp = fwd_up;
                current_row -= 1;
            }   
            if(Math.abs(fwd_up-current) < Math.abs(fwd-current) && Math.abs(fwd_up-current) == Math.abs(fwd_down-current)) {
                Random rand = new Random();
                int choice = rand.nextInt(2);
                if(choice == 0) {
                    temp = fwd_up;
                    current_row -= 1;
                }
                else {
                    temp = fwd_down;
                    current_row += 1;
                }
            }
            if((Math.abs(fwd-current) < Math.abs(fwd_up-current) && Math.abs(fwd-current) < Math.abs(fwd_down-current)) ||
                (Math.abs(fwd-current) < Math.abs(fwd_up-current) && fwd == fwd_down) ||
                (Math.abs(fwd-current) < Math.abs(fwd_down-current) && fwd == fwd_up)) {
                temp = fwd_up;
            }  
            if(fwd != fwd_down && Math.abs(fwd-current) < Math.abs(fwd_up-current) && Math.abs(fwd-current) == Math.abs(fwd_down-current)) {
                Random rand = new Random();
                int choice = rand.nextInt(2);
                if(choice == 0) 
                    temp = fwd;
                else {
                    temp = fwd_down;
                    current_row += 1;
                }
            }
            if(fwd != fwd_up && Math.abs(fwd-current) < Math.abs(fwd_down-current) && Math.abs(fwd-current) == Math.abs(fwd_up-current)) {
                Random rand = new Random();
                int choice = rand.nextInt(2);
                if(choice == 0) 
                    temp = fwd;
                else {
                    temp = fwd_up;
                    current_row -= 1;
                }
            }
            if(Math.abs(fwd-current) == Math.abs(fwd_up-current) && Math.abs(fwd-current) == Math.abs(fwd_down-current)) {
                Random rand = new Random();
                int choice = rand.nextInt(3);
                if(choice == 0)
                    temp = fwd;
                if(choice == 1 && fwd_down == fwd)
                    temp = fwd;
                else if(choice == 1) {
                    temp = fwd_down;
                    current_row += 1;
                }
                if(choice == 2 && fwd_up == fwd)
                    temp = fwd;
                else if(choice == 2) {
                    temp = fwd_up;
                    current_row -= 1;
                }
            }
            if(Math.abs(fwd_down-current) < Math.abs(fwd-current) && Math.abs(fwd_down-current) < Math.abs(fwd_up-current)) {
                temp = fwd_down;
                current_row += 1;
            }
            
            // The code below does the drawing and incrementation.
            y = current_row + 1;
            difference = temp - current;
            total_elevation_change += difference;
            g2d.setColor(new Color(0, 128, 0));
            g2d.fillRect(x, y, 1, 1);
            x++;
            current = temp;
        }

        return total_elevation_change;
    }

    /**
     * This method finds the lowest elevation path for the whole map and returns the index of the starting row.
     * @param graphics
     * @return
     */
    private int indexOfLowestElevPath(Graphics graphics) {
        int index = 0;
        int temp = drawLowestElevPath(graphics, 0);
        int lowest = drawLowestElevPath(graphics, 0);
        for(int i=0; i<elevationMatrix.length; i++) {
            temp = drawLowestElevPath(graphics, i);
            if(temp < lowest) {
                index = i;
                lowest = temp;
            }
        }
        return index;
    }
} // end class