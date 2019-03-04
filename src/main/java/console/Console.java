package console;

import java.util.Scanner;

import static console.Console.ConsoleStrings.WRONG_COMMAND;

public abstract class Console {
    Scanner scanner;

    protected Console(Scanner scanner) {
        this.scanner = scanner;
    }

    abstract void runCommands();

    protected void wrongCommand() {
        System.out.println(WRONG_COMMAND);
    }

    protected void errorCommand(String s) {
        System.out.println(s);
    }

    static class ConsoleStrings {
        static final String COMMAND_HELP = "Main commands:\n" +
                "help       - to get help in commands\n" +
                "connect    - to connect to Github\n" +
                "data       - to get data from Github\n" +
                "exit       - to exit";
        static final String COMMAND_CONNECT_HELP = "Connect commands:\n" +
                "help       - to get help in connect commands\n" +
                "token      - connect with token oAuth\n" +
                "login      - connect with login and password\n" +
                "back       - back to main commands";
        static final String COMMAND_DATA_HELP = "Data commands:\n" +
                "help           - to get help in connect commands\n" +
                "organisation   - connect to organisation\n" +
                "teams          - show all teams\n" +
                "team members   - show all members in team\n" +
                "all members    - show all members in all teams\n" +
                "back           - back to main commands";

        static final String HELLO = "CLT for Github access from BarracudaPff\n" +
                "You can always type help for help :)";
        static final String CONNECT_HELLO = "Connecting to Github";
        static final String CONNECT_DATA_HELLO = "Ready to collect data";

        static final String WRONG_COMMAND = "No command exist. Type help for help :)";
        static final String BACK = "Back to main commands. Type help for help :)";

        static final String CONNECTED = "Successfully connected!. Back to main commands.";
        static final String NOT_CONNECTED = "You are not connected. type connect";

        static final String TEAMS_PREVIEW = "We found these teams:";
        static final String TEAM_MEMBERS_PREVIEW = "All members in team ";
        static final String TEAM_ALL_PREVIEW = "All teams:";
    }
}
