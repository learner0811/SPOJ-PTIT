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


public class PTIT138C {
    
    public static int getNum(char target){
        if (Character.isLowerCase(target))
            target -= 32;
        
        String[] pattern = new String[12];
        pattern[2] = "ABC";
        pattern[3] = "DEF";
        pattern[4] = "GHI";
        pattern[5] = "JKL";
        pattern[6] = "MNO";
        pattern[7] = "PQRS";
        pattern[8] = "TUV";
        pattern[9] = "WXYZ";
        
        for (int i = 2; i <= 9; i++)
            if (pattern[i].contains(target+""))
                return i;        
        return 0;
    }
    public static void main(String[] args) {
        int n = 0;
        Scanner ip = new Scanner(System.in);
        
        n = ip.nextInt();
        ip.nextLine();
        for (int i = 1; i <= n; i++){
            String target = ip.nextLine();
            String result = "";
            for (int j = 0; j < target.length(); j++)
                result += String.valueOf(getNum(target.charAt(j)));
            
            String revese = "";
            for (int j = result.length()-1; j >= 0; j--)
                revese += result.charAt(j);
            
            if (result.compareTo(revese) == 0)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        
    }
    
}
