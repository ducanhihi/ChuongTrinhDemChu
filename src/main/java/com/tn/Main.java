package com.tn;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Input: ");
        String input = sc.nextLine();
         List<String> telex = Arrays.asList("aw", "aa", "dd", "ee", "oo", "ow", "w");

        Map<Character, List<String>> map = new HashMap<>();
        for (String t : telex) {
            map.computeIfAbsent(t.charAt(0), k -> new ArrayList<>()).add(t);
        }

        int count = 0;
        int i = 0;
        while (i < input.length()) {
            char c = input.charAt(i);
            boolean matched = false;
            if (map.containsKey(c)) {
                for (String t : map.get(c)) {
                    if (i + t.length() <= input.length() && input.startsWith(t, i)) {
                        count++;
                        i += t.length();
                        matched = true;
                        break;
                    }
                }
            }
            if (!matched) i++;
        }
        System.out.println("Output: " + count);
    }
}
