import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Boj1654 랜선자르기
        Scanner sc = new Scanner(System.in);

        //data input
        int input = sc.nextInt();
        long target = sc.nextInt();
        long[] inputList = new long[input];
        long min = 1;
        long max = 0;

        for (int i = 0; i < input; i++) {
            inputList[i] = sc.nextInt();
            if (inputList[i] > max) {
                max = inputList[i];
            }
        }
        max++;
        //algorithm

        for(int j=0 ;j<10000;j++) {
            long mid = (max + min) / 2;
            //==================
            if(min + 1 == max){
                int countMax = 0;
                for(int i=0;i<inputList.length;i++){
                    countMax += inputList[i]/max;
                }
                if(countMax==target){
                    System.out.println(max);
                    return;
                }else{
                    System.out.println(min);
                    return;
                }
//                int countMin = 0;
//                for(int i=0;i<inputList.length;i++){
//                    countMin += inputList[i]/min;
//                }
            }
            //=====================
            long count=0;
            for(int i=0;i<inputList.length;i++){
                count += inputList[i]/mid;
            }
            if(count<target){
                max = mid;
                System.out.println("max = " + max);
                System.out.println("count = " + count);
            }else if(count>target){
                min = mid;
                System.out.println("min = " + min);
                System.out.println("count = " + count);
            }else{
                long tmpMid = mid+1;
                long tmpCount = 0;
                for(int i=0;i<inputList.length;i++){
                    tmpCount += inputList[i]/tmpMid;
                }
                System.out.println("tmpCount = " + tmpCount);
                System.out.println("count = " + count);
                if(tmpCount<count){
                    System.out.println("result : mid = " + mid);
                    System.out.println("count = " + count);
                    break;
                }else{
                    min = mid;
                    System.out.println("min = " + min);
                    System.out.println("count = " + count);
                }
            }
        }

    }
}
