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
public class P141PROC {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        int num = ip.nextInt();
        ip.nextLine();
        int x = 0;
        for (int i = 0; i < num; i++){
            String line = ip.nextLine();
            if (line.matches("\\+\\+[xX]"))
                ++x;
            else if (line.matches("[xX]\\+\\+"))
                x++;
            else if (line.matches("\\-\\-[xX]"))
                --x;
            else if (line.matches("[xX]\\-\\-"))
                x--;
        }
        System.out.println(x);
    }
}
