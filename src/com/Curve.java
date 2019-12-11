package com;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Curve extends JPanel {
    static final int SCALEFACTOR = 20;
    int cycles;
    int points;
    double[] sines;
    int[] pts;

    public Curve() {

    }
    public double[] getsines(){
        return sines;
    }
    public void setsines(double[] sines){
        this.sines=sines;
    }

    public  void setCycles(int newCycles) {
        cycles = newCycles;
        points = SCALEFACTOR * cycles * 2;
        sines = new double[points];
        for (int i = 0; i < points; i++) {
            double radians = (Math.PI / SCALEFACTOR) * i;
            sines[i] = Math.sin(radians);
        }
        repaint();
    }
    /*public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int maxWidth = getWidth();
        double hstep = (double) maxWidth / (double) points;
        int maxHeight = getHeight();
        pts = new int[points];
        for (int i = 0; i < points; i++){
            pts[i] = (int) (sines[i] * maxHeight / 2 * .95 + maxHeight / 2);
        }
        g.setColor(Color.BLUE);
        for (int i = 1; i < points; i++) {
            int x1 = (int) ((i - 1) * hstep);
            int x2 = (int) (i * hstep);
            int y1 = pts[i - 1];
            int y2 = pts[i];
            g.drawLine(x1,y1,x2,y2);

        }
    }*/

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 200);
        Curve sines = new Curve();
        sines.setCycles(2);
        frame.getContentPane().add(sines);
        frame.setVisible(true);
        double[]total_points=sines.getsines();
        int no_segments_step=total_points.length/10;
        System.out.println(no_segments_step);
        double[] segment_arr = new double[10*2];
        for(int i=0,j=0;i<total_points.length;i=i+no_segments_step,j=j+2){
            segment_arr[j]=total_points[i];
            segment_arr[j+1]=total_points[i+no_segments_step-1];
        }
        for(int i=0;i<segment_arr.length;i++){
            System.out.println(segment_arr[i]);
        }
        double maxima=segment_arr[0];
        double minima=segment_arr[0];
        for(int i=0;i<segment_arr.length;i=i+1){
            if(maxima<=segment_arr[i]){
                maxima=segment_arr[i];
            }
            if(minima>=segment_arr[i]){
                minima=segment_arr[i];
            }
        }
        System.out.println("maxima is "+maxima);
        System.out.println("minima is "+minima);
    }

}

