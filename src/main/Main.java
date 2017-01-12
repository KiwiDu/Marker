package main;
import java.util.Scanner;
/**
 * Created by kiwid on 2017/1/11.
 */
public class Main {
    public static void main(String[] args){
        String s;
        System.out.println("Hello IntelliJ.");
        try(Scanner in=new Scanner(System.in)){
            while (in.hasNext()){
                s=in.nextLine();
                System.out.println(Parser.instance.parse(s).toString());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
