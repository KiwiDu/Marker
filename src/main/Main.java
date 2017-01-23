package main;

import BasicNode.Node;
import Rendering.DefaultRenderEngine;
import Rendering.RenderEngine;

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
        Node parsed=Parser.instance.parse(s);
        System.out.println(parsed.toString());
        RenderEngine re=new DefaultRenderEngine();
        System.out.println(re.accept(parsed).render());
        System.out.printf("------ %d ------\n\n", i++);
    }

    private static void scanTest(String[] is) {
        for (String s : is)
            testStr(s);
    }

    private static void scanTest(InputStream is) {
        scanTest(is, Integer.MAX_VALUE);
    }

    private static void scanTest(InputStream is, int limit) {
        try (Scanner in = new Scanner(is)) {
            while (in.hasNext() && --limit > 0) {
                testStr(in.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello IntelliJ.");
        scanTest(args);
        scanTest(System.in);
    }
}
