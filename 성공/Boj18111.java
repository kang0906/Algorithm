package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Boj18111 마인크래프트
        // https://www.acmicpc.net/problem/18111

        // data input
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();   // 가로
//        int m = sc.nextInt();   // 세로
//        int b = sc.nextInt();   // 남은 블럭
//        int t = 0;              // 시간
//        TreeMap<Integer, Integer> map = new TreeMap<>();
//
//        for (int i = 0; i < n * m; i++) {
//            int nextInt = sc.nextInt();
//            Integer l = map.get(nextInt);
//            if(l != null){
//                map.put(nextInt, l + 1);
//            }else{
//                map.put(nextInt, 1);
//            }
//        }

        // data input buffer
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] s2 = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(s2[0]);   // 가로
        int m = Integer.parseInt(s2[1]);   // 세로
        int b = Integer.parseInt(s2[2]);   // 남은 블럭
        int t = 0;              // 시간
        TreeMap<Integer, Integer> map = new TreeMap<>();
//        System.out.println(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            String[] s = bufferedReader.readLine().split(" ");
            for (String s1 : s) {
                int nextInt = Integer.parseInt(s1);
                Integer l = map.get(nextInt);
                if(l != null){
                    map.put(nextInt, l + 1);
                }else{
                    map.put(nextInt, 1);
                }
            }

        }

        // algorithm
        while (map.size() > 1) {
            int h = map.get(map.lastKey()) * 2;
            int l = map.get(map.firstKey());

            if (map.get(map.firstKey()) > b || h < l) {
                Integer lastKey = map.lastKey();
                Integer addSize = map.get(lastKey);

                Integer integer = map.get(lastKey - 1);
                if(integer != null){
                    map.put(lastKey - 1, integer + addSize);
                }else{
                    map.put(lastKey - 1, addSize);
                }
                map.remove(lastKey);
                t += addSize * 2;
                b += addSize;
            } else {
                Integer firstKey = map.firstKey();
                Integer addSize = map.get(firstKey);

                Integer integer = map.get(firstKey + 1);
                if(integer != null){
                    map.put(firstKey + 1, integer + addSize);
                }else{
                    map.put(firstKey + 1, addSize);
                }
                map.remove(firstKey);
                t += addSize;
                b -= addSize;
            }
        }

        // data output
        System.out.print(t + " " + map.lastKey());

        // debug output
//        Iterator<Integer> iterator = map.keySet().iterator();
//        for (Integer key : map.keySet()) {
//            System.out.println(key + ":" + map.get(key));
//        }
//        System.out.println("map.lastKey = " + map.lastKey());   // 큰수
//        System.out.println("map.firstKey = " + map.firstKey()); // 작은수
    }
}