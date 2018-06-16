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

class Point{
    public int UpperCase;
    public int DownCase;
    public int Number;
    public boolean qualify;
    
   public Point(){
       UpperCase = 0;
       DownCase = 0;
       Number = 0;
   }  
}

public class P145PROI {
    
    public static int Character(char c){
        if (c >= 'a' && c <= 'z')
            return 1;
        if (c >= 'A' && c <= 'Z')
            return 2;
        return 0;
    }
    
    public static boolean isSafe(int begin, int end, Point[] point){
        int Up = point[end].UpperCase - point[begin-1].UpperCase;
        int Down = point[end].DownCase - point[begin-1].DownCase;
        int num = point[end].Number - point[begin-1].Number;
        
        
        if (Up >= 1 && Down >= 1 && num >= 1 && (end - begin + 1 >= 6))
            return true;
        return false;
    }
    
    public static int binarySearch(int begin, int left, int right, Point[] point){
        int pos = -1;
        while (left <= right && right - begin >= 5){
            int middle = (left + right)/2;
            //still have to check from begin 
            if (isSafe(begin, middle, point)){
                right = middle - 1;
                pos = middle;
            }
            else
                left = middle + 1;     
        }
        return pos;
    }
    
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        String temp = ip.nextLine();
        StringBuilder s = new StringBuilder(temp);
        s.insert(0, '0');
        int res = 0;
        int size = s.length();
        
        Point[] point = new Point[size];
        
        for (int i = 0 ; i < size; i++)
            point[i] = new Point();
        
        for (int i = 1 ; i < size; i++){
            point[i].UpperCase = point[i-1].UpperCase;
            point[i].DownCase = point[i-1].DownCase;
            point[i].Number = point[i-1].Number;
            
            char current = s.charAt(i);
            
            if (Character(current) == 0)
                point[i].Number++;
            else if (Character(current) == 1)
                point[i].DownCase++;
            else
                point[i].UpperCase++;
        }
        
        for (int i = 1; i < s.length() - 5; i++){
            int pos = binarySearch(i, i, s.length()-1, point);
            if (pos != -1)
                res += s.length() - pos;
            else
                break;
        }
        
        System.out.println(res);
       
    }
}
