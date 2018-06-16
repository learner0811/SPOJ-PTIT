/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spoj;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ns_red
 */
public class PTIT138E {
    public static int process(int x) {
        int count = 1;
        int carry = 0;
        while (x >= 10) {
            carry = x % 10 + carry >= 5 ? 1 : 0;
            x /= 10;
            count *= 10;
        }
        int res = (x + carry) * count;
        return res;
    }

    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        int test = ip.nextInt();
        for (int i = 0; i < test; i++) {
            int x = ip.nextInt();
            System.out.println(process(x));
        }
    }
}
