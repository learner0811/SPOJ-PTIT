/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spoj;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 *
 * @author ns_red
 */
public class PTIT123J {
    
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        String target = "";
        
        while (true){
            target = ip.nextLine();
            
            if (target.equals("."))
                break;
            
            Deque<Integer> stack = new ArrayDeque<>();
            boolean check = true;
            int com = 0;
            for (int i = 0; i < target.length(); i++){
                if (target.charAt(i) == '(')
                    stack.push(1);
                else if (target.charAt(i) == '[')
                    stack.push(2);
                else if (target.charAt(i) == ')'){
                    if (stack.size() == 0){
                        check = false;
                        break;
                    }
                    com = stack.pop();
                    if (com != 1){
                        check = false;
                        break;
                    }
                }
                else if (target.charAt(i) == ']'){
                    if (stack.size() == 0){
                        check = false;
                        break;
                    }
                    com = stack.pop();
                    if (com != 2){
                        check = false;
                        break;
                    }
                }                    
            }
            
            if (stack.size() != 0){
                System.out.println("no");
                continue;
            }
            
            if (!check){
                System.out.println("no");
                continue;
            }
            System.out.println("yes"); 
        }
    }
}
