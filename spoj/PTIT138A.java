/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spoj;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author ns_red
 */
public class PTIT138A {
    public static void main(String[] args) {
        int[] arr = new int[3];
        Scanner ip = new Scanner(System.in);
        arr[0] = arr[1] = arr[2] = -1;
        while (arr[0] != 0 && arr[1] != 0 && arr[2]!= 0){
            arr[0] = ip.nextInt();
            arr[1] = ip.nextInt();
            arr[2] = ip.nextInt();
            
            if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0)
                break;
            
            Arrays.sort(arr);
            
            if (arr[0]*arr[0] + arr[1]*arr[1] == arr[2]*arr[2])
                System.out.println("right");
            else
                System.out.println("wrong");
        }
    }
            
}
