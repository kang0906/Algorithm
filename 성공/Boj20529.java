import java.util.*;

public class Main {
    public static void main(String[] args) {

        /**
         * boj 20529 - 가장 가까운 세 사람의 심리적 거리
         * https://www.acmicpc.net/problem/20529
         * 미해결
         */

        /*
        반례
        1
        4
        INFP INFP INTP INFP
         */
        Scanner sc = new Scanner(System.in);

        //data input
        int t = sc.nextInt();
        List<Integer> resultList = new ArrayList<>();

        for(int tNum = 0;tNum<t; tNum++) {
            int MBTILength = 100;
            int n = sc.nextInt();
            sc.nextLine();
            //algorithm
            if (n > 50) {
//                System.out.println(0);
                resultList.add(0);
                sc.nextLine();
                continue;
            }

            Map<String, Integer> map = new HashMap();
            List<Integer> list = new ArrayList<>();
            String inputString = sc.nextLine();
            String[] s3 = inputString.split(" ");
            for (int i = 0; i < n; i++) {
                if (map.containsKey(s3[i])) {
                    Integer c = map.get(s3[i]);
                    map.put(s3[i], c + 1);
                } else {
                    map.put(s3[i], 1);
                }
            }

            List<String> tempList = new ArrayList<>();

            for (String s : map.keySet()) {
                Integer integer = map.get(s);
//                System.out.println("s count = " + integer);
//                System.out.println("s = " + s);
                for (int i = 0; i < integer; i++) {
                    tempList.add(s);
                }
            }
//            System.out.println("size : " + tempList.size());
//            for (String s : tempList) {
//                System.out.println("s = " + s);
//            }
            for (int i = 0; i < tempList.size(); i++) {
                for (int j = i; j < tempList.size(); j++) {
                    if (i == j) {
                        continue;
                    }
                    for(int u = j; u <tempList.size(); u++) {
                        if(j==u){
                            continue;
                        }
                        int tmp = 0;
                        String m1 = tempList.get(i);
                        String m2 = tempList.get(j);
                        String m3 = tempList.get(u);
                        tmp += checkMBTI(m1 , m2);
                        tmp += checkMBTI(m3 , m2);
                        tmp += checkMBTI(m1 , m3);
                        if(MBTILength > tmp){
                            MBTILength = tmp;
                        }
                    }
                }
            }

            resultList.add(MBTILength);
        }

        for (Integer integer : resultList) {
            System.out.println(integer);
        }
    }

    static int checkMBTI(String s1,String s2){
        Set<Character> checkMBTI = new HashSet<>();
        checkMBTI.add(s1.charAt(0));
        checkMBTI.add(s1.charAt(1));
        checkMBTI.add(s1.charAt(2));
        checkMBTI.add(s1.charAt(3));

        checkMBTI.add(s2.charAt(0));
        checkMBTI.add(s2.charAt(1));
        checkMBTI.add(s2.charAt(2));
        checkMBTI.add(s2.charAt(3));

        return checkMBTI.size() - 4;
    }
}
