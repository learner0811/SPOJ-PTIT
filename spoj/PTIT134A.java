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
public class PTIT134A {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        String line = "";
        while (ip.hasNextLine()){
            line = ip.nextLine();
            int[] count = new int[125];
            
            for (int i = 0; i < line.length(); i++){
                count[line.charAt(i)]++;
            }
            
            int rm = 0;
            
            for (int i = 'a'; i <= 'z'; i++)
                if (count[i] % 2 == 1)
                    rm++;
            
            if (rm % 2 == 1)
                System.out.println("Second");
            else
                System.out.println("First");
        }
    }
}
