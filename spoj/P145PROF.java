/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spoj;
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author ns_red
 */
public class P145PROF {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        int n = ip.nextInt();
        int[][] mark = new int[24][60];
        
        int res = 1;
        for (int i = 0; i < n; i++){
            int h = ip.nextInt();
            int m = ip.nextInt();
            mark[h][m]++;
            res = Math.max(res, mark[h][m]);
        }
        
        System.out.println(res);
    }
}
