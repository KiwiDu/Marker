package main;

import java.io.InputStream;
import java.util.Scanner;

/**
 * This is Marker,
 * which was created by kiwid on 2017/1/11.
 * All rights reserved.
 */

public class Main {
    private static int i = 0;

    private static void testStr(String s) {
        System.out.println(Parser2.instance.parse(s).toString());
        System.out.printf("------ %d ------\n\n", i++);
    }

    private static void scanTest(InputStream is) {
        try (Scanner in = new Scanner(is)) {
            while (in.hasNext()) {
                testStr(in.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello IntelliJ.");
        scanTest(System.in);
    }
}
