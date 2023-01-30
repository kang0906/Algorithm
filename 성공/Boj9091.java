import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int testCaseCount;

        Scanner sc = new Scanner(System.in);
        testCaseCount = Integer.parseInt(sc.next());

        for (int i = 0; i < testCaseCount; i++) {
//            System.out.println("i = " + i);
            String[] table = new String[10000];
            Queue<Integer> queue = new LinkedList<>();
            int start = Integer.parseInt(sc.next());
            int target = Integer.parseInt(sc.next());
//            System.out.println(start + " " + target);

            queue.add(start);
            table[start] = "";
            while (true){
                int poll = queue.poll();
                int temp;
                if(poll==target){
//                    System.out.println("target = " + target);
                    System.out.println(table[poll]);
                    break;
                }
                String now = table[poll];

                //d == *2
                temp = poll * 2;
                if(temp > 9999){
                    temp = temp % 10000;
                }

                String calculateResult;
                calculateResult = table[temp];
                if(calculateResult==null || table[poll] == null || calculateResult.length() > table[poll].length()+1){
                    table[temp] = table[poll] + "D";
//                    System.out.println("table["+temp+"] = " + table[temp]);
                    queue.add(temp);
                }

                //s == --n
                temp = poll - 1;
                if(temp < 0){
                    temp = 9999;
                }
                calculateResult = table[temp];
                if(calculateResult==null || table[poll] == null || calculateResult.length() > table[poll].length()+1){
                    table[temp] = table[poll] + "S";
//                    System.out.println("table["+temp+"] = " + table[temp]);
                    queue.add(temp);
                }

                //l
                temp = (poll % 1000) * 10 + poll / 1000;

                calculateResult = table[temp];
                if(calculateResult==null || table[poll] == null || calculateResult.length() > table[poll].length()+1){
                    table[temp] = table[poll] + "L";
//                    System.out.println("table["+temp+"] = " + table[temp]);
                    queue.add(temp);
                }

                //r
                temp = poll / 10 + (poll % 10) * 1000;

                calculateResult = table[temp];
                if(calculateResult==null || table[poll] == null || calculateResult.length() > table[poll].length()+1){
                    table[temp] = table[poll] + "R";
//                    System.out.println("table["+temp+"] = " + table[temp]);
                    queue.add(temp);
                }

            }
        }

    }
}
