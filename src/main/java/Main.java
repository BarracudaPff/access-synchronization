import console.ConsoleMain;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConsoleMain consoleMain = new ConsoleMain(new Scanner(System.in));
        consoleMain.runCommands();
    }
}
