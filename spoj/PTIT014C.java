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
public class PTIT014C {
    public static int LargestCommon(StringBuilder a, StringBuilder b){
        int[][] LCS = new int[a.length()+5][b.length()+5];
        
        for (int i = 1; i < a.length(); i++)
            for (int j = 1; j < b.length(); j++)
                if (a.charAt(i) == b.charAt(j))
                    LCS[i][j] = LCS[i-1][j-1] + 1;
                else
                    LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
        return LCS[a.length()-1][b.length()-1];
    }
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        int test = ip.nextInt();
        
        for (int i = 0; i < test; i++){
            int stringNum = ip.nextInt();
            ip.nextLine();
            int res = 0;
            StringBuilder[] arr = new StringBuilder[stringNum];
            for (int j = 0; j < stringNum; j++){
                arr[j] = new StringBuilder(ip.nextLine());
                arr[j].insert(0, '0');
            }
            
            for (int j = 0; j < stringNum - 1; j++){
                for (int k = j+1; k < stringNum; k++){
                    res = Math.max(res, LargestCommon(arr[j], arr[k]));
                }    
            }
            System.out.println(res);
        }
    }
}
