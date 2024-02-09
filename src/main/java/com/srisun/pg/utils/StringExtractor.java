package com.srisun.pg.utils;

import java.util.Stack;

public class StringExtractor {

    public static String extractString(String inString, char openChar, char endChar) {

        if (inString == null) {
            return null;
        }

        Stack<Character> stack = new Stack<>();
        int start = -1;

        for (int i = 0; i < inString.length(); i++) {
            char currentChar = inString.charAt(i);

            if (currentChar == openChar) {
                if (start == -1) {
                    start = i;
                }
                stack.push(currentChar);
            } else if (currentChar == endChar) {
                if (stack.isEmpty()) {
                    return null; // Unmatched closing brace
                }
                stack.pop();
                if (stack.isEmpty()) {
                    return inString.substring(start + 1, i);
                }
            }
        }

        return null; // No matching pair found
    }

    public static void main(String[] args) {
        char openChar = '{';
        char endChar = '}';
        String text = "{a{b{c}}d}";
        String extractedString = extractString(text, openChar, endChar);
        System.out.println("Extracted string: " + extractedString);

        extractedString = extractString(extractedString, openChar, endChar);
        System.out.println("Extracted string: " + extractedString);

        extractedString = extractString(extractedString, openChar, endChar);
        System.out.println("Extracted string: " + extractedString);

        extractedString = extractString(extractedString, openChar, endChar);
        System.out.println("Extracted string: " + extractedString);

        extractedString = extractString(extractedString, openChar, endChar);
        System.out.println("Extracted string: " + extractedString);
    }
}
