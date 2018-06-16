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
public class QBSTR {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        StringBuilder a = new StringBuilder(ip.nextLine());
        StringBuilder b = new StringBuilder(ip.nextLine());
        a.insert(0, '0');
        b.insert(0, '0');
        
        int[][] LCS = new int[a.length()+5][b.length()+5];
        
        LCS[0][0] = 0;
        int res = -1;
        
        for (int i = 1; i < a.length(); i++)
            for (int j = 1; j < b.length(); j++)
                if (a.charAt(i) == b.charAt(j))
                    LCS[i][j] = LCS[i-1][j-1] + 1;
                else
                    LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
        
        for (int i = 1; i < a.length(); i++)
            for (int j = 0; j < b.length(); j++)
                if (LCS[i][j] != 0 && LCS[i][j] > res)
                    res = LCS[i][j];
        
        System.out.println(res);
    }
}
