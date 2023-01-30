import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        int testCase;

        Scanner sc = new Scanner(System.in);

        testCase = sc.nextInt();

        for (int c = 0; c<testCase;c++){
            int count = sc.nextInt();
            SortedMap<Integer, Integer> map = new TreeMap<>();
            sc.nextLine();
            for (int i=0;i<count;i++){
                String s = sc.nextLine();
                int inputNum = Integer.parseInt(s.substring(2));

                if(s.charAt(0)=='I'){
                    if(map.containsKey(inputNum)){
                        map.put(inputNum, map.get(inputNum)+1);
                    }else{
                        map.put(inputNum, 1);
                    }
                }else{
                    if(map.size()==0){
                        continue;
                    }
                    if(inputNum==1){
                        if(map.get(map.lastKey())==1){
                            map.remove(map.lastKey());
                        }else{
                            map.put(map.lastKey(), map.get(map.lastKey())-1);
                        }
                    }else{
                        if(map.get(map.firstKey())==1){
                            map.remove(map.firstKey());
                        }else{
                            map.put(map.firstKey(), map.get(map.firstKey())-1);
                        }
                    }
                }
            }

            if(map.size()==0){
                System.out.println("EMPTY");
            }else{
                System.out.println(map.lastKey()+" "+map.firstKey());
            }
        }
    }
}
