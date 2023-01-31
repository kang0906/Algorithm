import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        //Boj14500
        Scanner sc = new Scanner(System.in);
        int max = 0;

        //input
        int x = sc.nextInt();
        int y = sc.nextInt();

        int[][] map = new int[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        //algorithm

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                int tmp = checkCase1(map, i, j);
                if (max < tmp) {
                    max = tmp;
                }
                tmp = checkCase2(map, i, j);
                if (max < tmp) {
                    max = tmp;
                }
                tmp = checkCase3(map, i, j);
                if (max < tmp) {
                    max = tmp;
                }
                tmp = checkCase4(map, i, j);
                if (max < tmp) {
                    max = tmp;
                }
                tmp = checkCase5(map, i, j);
                if (max < tmp) {
                    max = tmp;
                }

            }
        }

        //output

        System.out.println(max);
        //=========test output============
        System.out.print((p + 1) + "====");
//        int i = checkCase3(map, 2, 2);
//        System.out.println("i = " + i);
//        for(int i=0;i<x;i++){
//            for(int j=0;j<y;j++){
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

    }

    public static int checkCase1(int[][] map, int x, int y) {
        int result1 = map[x][y];
        for (int i = 1; i < 4; i++) {
            if (y + i < map[1].length) {
                result1 += map[x][y + i];
            } else {
                break;
            }
        }
        int result2 = map[x][y];
        for (int i = 1; i < 4; i++) {
            if (x + i < map.length) {
                result2 += map[x + i][y];
            } else {
                break;
            }
        }
        if (result1 < result2) {
            return result2;
        } else {
            return result1;
        }
    }

    public static int checkCase2(int[][] map, int x, int y) {
        int result = map[x][y];

        if (x + 1 < map.length && y + 1 < map[1].length) {
            result += map[x + 1][y];
            result += map[x][y + 1];
            result += map[x + 1][y + 1];
        } else {
            return 0;
        }
        return result;
    }

    public static int checkCase3(int[][] map, int x, int y) {
        int result = 0;
        int tmp = 0;

        //case1
        if (y + 1 < map[1].length && x + 2 < map.length) {
            tmp = map[x][y];
            tmp += map[x + 2][y + 1];
            tmp += map[x + 1][y];
            tmp += map[x + 2][y];
            if (tmp > result) {
                result = tmp;
            }
        }
        //case2
        if (y + 2 < map[1].length && x + 1 < map.length) {
            tmp = map[x][y];
            tmp += map[x][y + 1];
            tmp += map[x][y + 2];
            tmp += map[x + 1][y];
            if (tmp > result) {
                result = tmp;
            }
        }
        //case3
        if (y - 1 >= 0 && x + 2 < map.length) {
            tmp = map[x][y];
            tmp += map[x][y - 1];
            tmp += map[x + 1][y];
            tmp += map[x + 2][y];
            if (tmp > result) {
                result = tmp;
            }
        }
        //case4
        if (y - 2 >= 0 && x - 1 >= 0) {
            tmp = map[x][y];
            tmp += map[x][y - 1];
            tmp += map[x][y - 2];
            tmp += map[x - 1][y];
            if (tmp > result) {
                result = tmp;
            }
        }

        // ======= 대칭 ==========
        //case1
        if (y - 1 >= 0 && x + 2 < map.length) {
            tmp = map[x][y];
            tmp += map[x + 2][y - 1];
            tmp += map[x + 1][y];
            tmp += map[x + 2][y];
            if (tmp > result) {
                result = tmp;
            }
        }
        //case2
        if (y + 2 < map[1].length && x + 1 < map.length) {
            tmp = map[x][y];
            tmp += map[x][y + 1];
            tmp += map[x][y + 2];
            tmp += map[x + 1][y + 2];
            if (tmp > result) {
                result = tmp;
            }
        }
        //case3
        if (y + 1 < map[1].length && x + 2 < map.length) {
            tmp = map[x][y];
            tmp += map[x][y + 1];
            tmp += map[x + 1][y];
            tmp += map[x + 2][y];
            if (tmp > result) {
                result = tmp;
            }
        }
        //case4
        if (y + 2 < map[1].length && x + 1 < map.length) {
            tmp = map[x][y];
            tmp += map[x + 1][y];
            tmp += map[x + 1][y + 1];
            tmp += map[x + 1][y + 2];
            if (tmp > result) {
                result = tmp;
            }
        }
        return result;
    }

    public static int checkCase4(int[][] map, int x, int y) {
        int result = 0;
        int tmp = 0;

        if (y + 1 < map[1].length && x + 2 < map.length) {
            tmp = map[x][y];
            tmp += map[x + 1][y];
            tmp += map[x + 1][y + 1];
            tmp += map[x + 2][y + 1];
            if (tmp > result) {
                result = tmp;
            }
        }

        if (y + 2 < map[1].length && x - 1 >= 0) {
            tmp = map[x][y];
            tmp += map[x][y + 1];
            tmp += map[x - 1][y + 1];
            tmp += map[x - 1][y + 2];
            if (tmp > result) {
                result = tmp;
            }
        }

        // ======= 대칭 =========

        if (y - 1 >= 0 && x + 2 < map.length) {
            tmp = map[x][y];
            tmp += map[x + 1][y];
            tmp += map[x + 1][y - 1];
            tmp += map[x + 2][y - 1];
            if (tmp > result) {
                result = tmp;
            }
        }

        if (y + 2 < map[1].length && x + 1 < map.length) {
            tmp = map[x][y];
            tmp += map[x][y + 1];
            tmp += map[x + 1][y + 1];
            tmp += map[x + 1][y + 2];
            if (tmp > result) {
                result = tmp;
            }
        }

        return result;
    }

    public static int checkCase5(int[][] map, int x, int y) {
        int result = 0;
        int tmp = 0;

        if (y + 2 < map[1].length && x + 1 < map.length) {
            tmp = map[x][y];
            tmp += map[x + 1][y + 1];
            tmp += map[x][y + 1];
            tmp += map[x][y + 2];
            if (tmp > result) {
                result = tmp;
            }
        }

        if (x + 2 < map.length && y - 1 >= 0) {
            tmp = map[x][y];
            tmp += map[x + 1][y - 1];
            tmp += map[x + 1][y];
            tmp += map[x + 2][y];
            if (tmp > result) {
                result = tmp;
            }
        }

        if (y + 2 < map[1].length && x - 1 >= 0) {
            tmp = map[x][y];
            tmp += map[x - 1][y + 1];
            tmp += map[x][y + 1];
            tmp += map[x][y + 2];
            if (tmp > result) {
                result = tmp;
            }
        }

        if (y + 1 < map[1].length && x + 2 < map.length) {
            tmp = map[x][y];
            tmp += map[x + 1][y + 1];
            tmp += map[x + 1][y];
            tmp += map[x + 2][y];
            if (tmp > result) {
                result = tmp;
            }
        }

        return result;
    }
}
