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
public class P141PROJ {
    public static boolean isBlack(char x){
        return x == '#';
    }
    
    public static boolean isQualify(int x, int y, String[] arr){
        int white = 0;
        int black = 0;
        
        for (int i = x; i < x + 2; i++)
            for (int j = y; j < y + 2; j++)
                if (isBlack(arr[i].charAt(j)))
                    black++;
                else
                    white++;
        
        if (white == 4 || black == 4)
            return true;
        if (white == 3 || black == 3)
            return true;
        return false;
    }
    
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        String[] line = new String[4];
        for (int i = 0; i < 4; i++)
            line[i] = ip.nextLine();
        
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                if (isQualify(j, j, line)){
                    System.out.println("YES");
                    return;
                }
        
        System.out.println("NO");
        
    }
}
