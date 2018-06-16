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
public class PTIT125E {
    
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        int n = ip.nextInt();
        int arr[] = new int[n+1];
        
        int sum = 0;
        for (int i = 1; i <= n; i++){
            arr[i] = ip.nextInt();
            sum += arr[i];
        }
        
        int[][] L = new int[2020][2020];
        L[0][0] = 1;
        
        for (int i = 1; i <= n; i++)
            for (int j = sum; j >= 0; j--)
                for (int k = sum; k >= 0; k--)
                    if (L[j][k] == 1){
                        L[j+arr[i]][k] = 1;
                        L[j][k+arr[i]] = 1;
                    }
        int ans = sum;
        
        for (int i = 0; i <= sum; i++)
            for (int j = 0; j <= sum; j++)
                if (L[i][j] == 1){
                    int k = sum - i - j;
                    int max = Math.max(i, Math.max(j, k));
                    ans = Math.min(ans, max);
                }
        System.out.println(ans);
    }
}
