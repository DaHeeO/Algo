package baekjoon.gold4;

import java.io.BufferedReader;
import java.util.Scanner;

public class Stars_2448 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        int step = (int) (Math.log(N/3) / Math.log(2));

        System.out.println(step);
    }
}
