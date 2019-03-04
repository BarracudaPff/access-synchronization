package console;

import connection.Connector;
import exceptions.ConnectWithLoginException;
import exceptions.ConnectWithTokenException;
import exceptions.NotConnectedException;

import java.io.IOException;
import java.util.Scanner;

import static console.Console.ConsoleStrings.*;

public class ConsoleConnect extends Console {
    public ConsoleConnect(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void runCommands() {
        System.out.println(CONNECT_HELLO);
        while (true) {
            System.out.println("Connect status: " + Connector.getInstance().checkConnect());
            String command = scanner.nextLine();
            try {
                switch (command) {
                    case "help":
                        connectHelp();
                        break;
                    case "token":
                        connectWithToken();
                        System.out.println(CONNECTED);
                        return;
                    case "login":
                        connectWithLogin();
                        System.out.println(CONNECTED);
                        return;
                    case "back":
                        System.out.println(BACK);
                        return;
                    default:
                        wrongCommand();
                }
            } catch (ConnectWithLoginException e) {
                errorCommand("Error happened while connecting  with login: "
                        + e.getLogin() + " and password " + e.getPass() + " :(\n" +
                        "Try again or type back.");
            } catch (ConnectWithTokenException e) {
                errorCommand("Error happened while connecting  with token: "
                        + e.getToken() + ":(\n" +
                        "Try again or type back.");
            } catch (NotConnectedException e) {
                errorCommand("You are not connected :(\n" +
                        "Back to main commands. Type connect to connect.");
            } catch (Exception e) {
                errorCommand("Error happened while connecting :(\n" +
                        "Try again or type back.");
                //e.printStackTrace();
            }
        }
    }

    private void connectHelp() {
        System.out.println(COMMAND_CONNECT_HELP);
    }

    private void connectWithToken() throws Exception {
        System.out.println("Enter token");
        Connector.getInstance().connectWithToken(scanner.nextLine());
    }

    private void connectWithLogin() throws Exception {
        System.out.println("Enter login");
        String login = scanner.nextLine();
        System.out.println("Enter password");
        String password = scanner.nextLine();
        Connector.getInstance().connectWithLogin(login, password);
    }
}
