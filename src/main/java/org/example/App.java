package org.example;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        checker();
    }

    public static void checker() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input the string to check:");
        System.out.println("Parentheses validation is: " + validateParentheses(sc.nextLine()));
    }

    public static boolean validateParentheses(String str) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            switch (c) {
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;

                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
            }
        }

        return stack.isEmpty() ? true : false;
    }
}
