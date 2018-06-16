/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spoj;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ns_red
 */
public class Spoj {
    
    public static ArrayList<Integer> convert(int n){
        ArrayList<Integer> ans = new ArrayList<>();
        while (n > 0){
            ans.add(n % 10);
            n /= 10;
        }
        return ans;
    }
    
    public static ArrayList<Integer> sum(ArrayList<Integer> a, ArrayList<Integer> b){
        ArrayList<Integer> c = new ArrayList<>();
        int carry = 0;
        int base = 10;
        int maxLen = 0;
        if (a.size() > b.size()){
            maxLen = a.size();
            int n = maxLen - b.size();
            for (int i = 0; i < n; i++)
                b.add(0);
        }
        else{
            maxLen = b.size();
            int n = maxLen - a.size();
            for (int i = 0; i < n; i++)
                a.add(0);
        }
        for (int i = 0; i < maxLen; i++){
            int temp = a.get(i) + b.get(i) + carry;
            carry = temp / base;
            c.add(temp % base);
        }
        if (carry != 0)
            c.add(carry);
        return c;
    }
    
    public static ArrayList mul(ArrayList<Integer> a,ArrayList<Integer> b){
        ArrayList<Integer> ans = new ArrayList<>();
        int count = -1;
        int carry = 0;
        int base = 10;
        
        for (int i = 0; i < b.size(); i++){
            count++;
            ArrayList<Integer> temp = new ArrayList<>();
            for (int k = 0; k < count; k++)
                temp.add(0);
            for (int j = 0; j < a.size(); j++){
                int n = b.get(i) * a.get(j) + carry;
                carry = n / base;
                n = n % base;
                temp.add(n);
            }
            if (carry > 0){
                temp.add(carry);
                carry = 0;
            }
            ans = sum(ans, temp);
        }
        return ans;
    }
    
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        
        int loop = 0;
        loop = ip.nextInt();
        
        while (loop != 0){
            int n, x;
            n = ip.nextInt();
            x = ip.nextInt();
            int count = 0;
            
            if (n == 0){
                if (x == 0)
                    count++;
                System.out.println(count);
                loop--;
                continue;
            }
            
            if (n < 20){
                long factorial = 1;
                for (int i = 2; i <= n; i++)
                    factorial *= i;
                String target = String.valueOf(factorial);
                
                for (int i = 0; i < target.length(); i++)
                    if (target.charAt(i) == x + '0')
                        count++;
                System.out.println(count);
            }
            else{
                //covert to bignum
                BigInteger num = new BigInteger("12164510040882000");
                for (int i = 20; i <= n; i++){
                    BigInteger second = new BigInteger(String.valueOf(i));
                    num = num.multiply(second);
                }
                String target = num.toString();
                System.out.println(target);
                for (int i = 0; i < target.length(); i++)
                    if (target.charAt(i) == x + '0')
                        count++;
                System.out.println(count);
            }
            loop--;
        }
    }    
}
