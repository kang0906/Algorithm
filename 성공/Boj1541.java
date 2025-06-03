package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Boj1541 잃어버린 괄호
        // https://www.acmicpc.net/problem/1541

        // data input
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] splitByMinus = s.split("-");
        int result = 0;

        // algorithm
        String[] startNum = splitByMinus[0].split("\\+");
        for (String s1 : startNum) {
            result += Integer.parseInt(s1);
        }
        result += result;

        for (String s1 : splitByMinus) {
            for (String s2 : s1.split("\\+")) {
                result -= Integer.parseInt(s2);
            }
        }

        // data output
        System.out.print(result);

    }
}