/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spoj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ns_red
 */

class numCompare implements Comparator<String>{
    @Override
    public int compare(String a, String b) {
        if (a.length() == b.length())
            for (int i = 0 ; i < a.length(); i++)
                if (a.charAt(i) != b.charAt(i))
                    return a.charAt(i) - b.charAt(i);
        return a.length() - b.length();                    
    }
    
}

public class PTIT127G {
    public static String nomalize(String target){
        String result = "";
        if (target.matches("0+"))
            return "0";
        int index = 0;
        while (index < target.length()){
            if (target.charAt(index) != '0')
                break;
            index++;
        }
        for (int i = index; i < target.length(); i++)
            result += target.charAt(i);     
        return result;
    }
    
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        int test = ip.nextInt();
        ip.nextLine();
        ArrayList<String> list = new ArrayList<>();
        String[] line = new String[test];
        for (int i = 0; i < test; i++){
            line[i] = ip.nextLine();
            Pattern pattern = Pattern.compile("[0-9]+");
            Matcher m = pattern.matcher(line[i]);
            
            while (m.find()){
                String target = m.group();
                target = nomalize(target);
                list.add(target);
            }
        }
        
        Collections.sort(list, new numCompare());
        
        for (String a : list)
            System.out.println(a);
       
    }
}
