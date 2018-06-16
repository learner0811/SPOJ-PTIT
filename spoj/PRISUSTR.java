/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spoj;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ns_red
 */
public class PRISUSTR {
    
    
    public static String[] getPrimeNumber(int n) {
        int[] arr = new int[n + 1];

        arr[0] = arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) {
                for (int j = 2 * i; j <= n; j += i) {
                    arr[j] = 1;
                }
            }
        }
        // arr[i] = 1 is not a prime, on the other hand = 0 is a prime
        ArrayList<String> ansList = new ArrayList<>();
        for (int i = 2; i <=n ; i++)
            if (arr[i] == 0)
                ansList.add(i + "");
        String[] ansArr = new String[ansList.size()];
        ansArr = ansList.toArray(ansArr);
        return ansArr;
    }
    
    public static boolean isPrime(int[] arr, int x){
        if (arr[x] == 0)
            return true;
        return false;
    }
    
  
    
    public static void main(String[] args) {
        String line = "-1";
        Scanner ip = new Scanner(System.in);
        
        String[] arr = getPrimeNumber(100000);
        while (line.compareTo("0") != 0){
            line = ip.nextLine();
            if (line.compareTo("0") == 0)
                break;
            String result = "";
            for (int i = arr.length - 1; i >= 0; i--){
                if (line.contains(arr[i])){
                    result = arr[i];
                    break;
                }                    
            }
            if (result.compareTo("") != 0)
                System.out.println(result);
        }
    }
}
