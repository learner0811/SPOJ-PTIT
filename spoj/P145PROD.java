/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spoj;

import java.util.Scanner;


/**
 *
 * @author ns_red
 */
public class P145PROD {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        int r = ip.nextInt();
        double Euclidian = r*r*Math.PI;
        double taxiCab = r*r*2;
        System.out.println(Euclidian);
        System.out.println(taxiCab);
    }
}
