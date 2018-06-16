/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spoj;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PTIT123A {
    
    public static boolean containNumber(String a){
        return a.matches(".*[0-9]+.*");
    }
    
    public static boolean containChar(String a){
        return a.matches(".*[a-z]+.*");
    }
    
    public static boolean isNumber(String a){
        try{
            Integer.parseInt(a);
        } catch (NumberFormatException ex){
            return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        String target = "";
        while (true){
            target = ip.nextLine();
            if (target.equals("."))
                break;
            
            if (containNumber(target) && containChar(target)){
                ArrayList<Integer> intArray = new ArrayList<>();
                ArrayList<String> strArray = new ArrayList<>();
                String[] mapping = target.split(", ");
                
                int size = mapping[mapping.length - 1].length();
                mapping[mapping.length - 1] = mapping[mapping.length - 1].substring(0, size-1);
                for (String a : mapping)
                    if (isNumber(a))
                        intArray.add(Integer.parseInt(a));
                    else
                        strArray.add(a);
                
                Collections.sort(intArray);
                Collections.sort(strArray);
                
                ArrayList<String> ans = new ArrayList<>();
                
                for (int i = 0; i < mapping.length; i++){
                    if (isNumber(mapping[i])){
                        ans.add(intArray.get(0).toString());
                        intArray.remove(0);
                    }
                    else{
                        ans.add(strArray.get(0));
                        strArray.remove(0);
                    }
                }
                
                for (int i = 0; i < ans.size(); i++)
                    if (i != ans.size() - 1)
                        System.out.print(ans.get(i) + ", ");
                    else
                        System.out.print(ans.get(i) + ".");
            }
            else if (containNumber(target)){
                ArrayList<Integer> intArray = new ArrayList<>();
                String pattern = "(-*[0-9]+)";
                Pattern p = Pattern.compile(pattern);
                Matcher m = p.matcher(target);
                
                while (m.find()){
                    intArray.add(Integer.parseInt(m.group()));
                }
                
                Collections.sort(intArray);
                
                for (int i = 0; i < intArray.size(); i++)
                    if (i != intArray.size() - 1)
                        System.out.print(intArray.get(i) + ", ");
                    else
                        System.out.print(intArray.get(i) + ".");
            }
            else{
                ArrayList<String> strArray = new ArrayList<>();
                
                String pattern = "([a-z]+)";
                Pattern p = Pattern.compile(pattern);
                Matcher m = p.matcher(target);
                
                while (m.find()){
                    strArray.add(m.group());
                }
                
                Collections.sort(strArray);
                
                for (int i = 0; i < strArray.size(); i++)
                    if (i != strArray.size() - 1)
                        System.out.print(strArray.get(i) + ", ");
                    else
                        System.out.print(strArray.get(i) + ".");
            }
            System.out.println();
        }
        
        
        ip.close();
    }
    
}
