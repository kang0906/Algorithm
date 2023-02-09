import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int index=0;
    public static ArrayList<Integer>list;
    public static void main(String[] args) {


        //Boj5639


        Scanner sc = new Scanner(System.in);
        list = new ArrayList<>();

        //input
        InputStreamReader fileInputStream = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(fileInputStream);
        try {
            list.add(Integer.parseInt(bufferedReader.readLine()));
            while (bufferedReader.ready()) {
                list.add(Integer.parseInt(bufferedReader.readLine()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        node root = new node();
        root.value=list.get(0);

        //Algorithm
        for(int i=1;i<list.size();i++){
            makeTree(i,root);
        }

        //output
        postOrder(root);

    }

    /**
     * 굳이 input 을 인덱스로 받아야 하나?
     * 그냥 값 자체를 받아도 괜찮을거같다
     * 그러면 list 를 전역변수로 받을 필요도 없고 코드가 훨씬 깔끔해 질것 같다.
     */
    public static void makeTree(int input, node top){
        if(list.get(input)<top.value){
            if(top.left==null){
                top.left = new node();
                top.left.value=list.get(input);
            }else{
                makeTree(input,top.left);
            }
        }else{
            if(top.right==null){
                top.right = new node();
                top.right.value=list.get(input);
            }else{
                makeTree(input,top.right);
            }
        }
    }

    public static void postOrder(node top) {
        if(top.left!=null){
            postOrder(top.left);
        }
        if(top.right!=null){
            postOrder(top.right);
        }
        System.out.println(top.value);
    }

}
class node{
    public int value;
    public node left;
    public node right;
}
