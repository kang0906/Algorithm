import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Boj1932 정수 삼각형
        Scanner sc = new Scanner(System.in);
        int result = 0;

        //data input
        int input = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(sc.nextInt());

        for (int i = 1; i < input; i++) {
            ArrayList<Integer> newList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                int tmp = sc.nextInt();
                if (j == 0) {
                    newList.add(tmp + list.get(0));
                } else if (j == i) {
                    newList.add(tmp + list.get(i - 1));
                } else {
                    if (tmp + list.get(j) > tmp + list.get(j - 1)) {
                        newList.add(tmp + list.get(j));
                    } else {
                        newList.add(tmp + list.get(j - 1));
                    }
                }
            }
            list = newList;
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > result) {
                result = list.get(i);
            }
        }
        System.out.println(result);
    }
}
