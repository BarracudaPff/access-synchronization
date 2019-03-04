package console;

import java.util.Scanner;

import static console.Console.ConsoleStrings.COMMAND_HELP;
import static console.Console.ConsoleStrings.HELLO;

public class ConsoleMain extends Console{
    ConsoleConnect consoleConnect;
    ConsoleData consoleData;

    public ConsoleMain(Scanner scanner) {
        super(scanner);
        consoleConnect = new ConsoleConnect(scanner);
        consoleData = new ConsoleData(scanner);
    }

    @Override
    public void runCommands() {
        System.out.println(HELLO);
        while (true) {
            String command = scanner.nextLine();
            switch (command) {
                case "help":
                    help();
                    break;
                case "connect":
                    consoleConnect.runCommands();
                    break;
                case "data":
                    consoleData.runCommands();
                    break;
                case "exit":
                    return;
                default:
                    wrongCommand();
            }
        }
    }



    private void help() {
        System.out.println(COMMAND_HELP);
    }
}
