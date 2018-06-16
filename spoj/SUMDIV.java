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
public class SUMDIV {
    public static boolean isPerfectSquare(long num){
        return (long) Math.sqrt(num)* (long) Math.sqrt(num) ==  num;
    }
    
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        int test = ip.nextInt();
        for (int i = 0; i < test; i++){
            long num = ip.nextLong();
            long res = 0;
            for (long j = 1; j < Math.sqrt(num); j++)
                if (num % j == 0)
                    res += j + num/j;
            if (isPerfectSquare(num))
                res += Math.sqrt(num);
            System.out.println(res);
        }
        
                
    }
}
