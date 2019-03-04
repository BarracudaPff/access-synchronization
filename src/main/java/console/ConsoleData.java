package console;

import connection.Connector;
import org.kohsuke.github.GHTeam;
import org.kohsuke.github.GHUser;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import static console.Console.ConsoleStrings.*;

public class ConsoleData extends Console{
    String organization;

    public ConsoleData(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void runCommands() {
        if (!Connector.getInstance().checkConnect()) {
            System.out.println(NOT_CONNECTED);
            return;
        }

        System.out.println(CONNECT_DATA_HELLO);
        while (true) {
            if (organization == null)
                System.out.println("No organisation selected");
            else
                System.out.println("Organisation selected: " + organization);
            String command = scanner.nextLine();
            try {
                switch (command) {
                    case "help":
                        dataHelp();
                        break;
                    case "organisation":
                        organisation();
                        break;
                    case "teams":
                        teams();
                        break;
                    case "team members":
                        teamMembers();
                        break;
                    case "all members":
                        allMembers();
                        break;
                    case "back":
                        System.out.println(BACK);
                        return;
                    default:
                        wrongCommand();
                }
            } catch (Exception e) {
                errorCommand("Error happened while connecting :(\n" +
                        "Try again or type back.");
                e.printStackTrace();
            }
        }
    }

    private void dataHelp() {
        System.out.println(COMMAND_DATA_HELP);
    }

    private void organisation() throws Exception {
        System.out.println("Enter Organization name");
        String organizationName = scanner.nextLine();
        organization = Connector.getInstance().connect().getOrganization(organizationName).getLogin();
    }

    private void teams() throws Exception {
        checkOrganisation();
        Map<String, GHTeam> teams = Connector.getInstance().connect().getOrganization(organization).getTeams();
        System.out.println(TEAMS_PREVIEW);
        for (String name : teams.keySet()) {
            System.out.println("\t- " + name);
        }
    }

    private void teamMembers() throws Exception {
        checkOrganisation();
        Map<String, GHTeam> teams = Connector.getInstance().connect().getOrganization(organization).getTeams();
        System.out.println("Enter team name");
        String team = scanner.nextLine();
        System.out.println(TEAM_MEMBERS_PREVIEW + team);
        for (GHUser member : teams.get(team).getMembers()) {
            System.out.println("\t- " + member.getLogin());
        }
    }

    private void allMembers() throws Exception {
        checkOrganisation();
        Map<String, GHTeam> teams = Connector.getInstance().connect().getOrganization(organization).getTeams();
        System.out.println(TEAM_ALL_PREVIEW);
        for (String name : teams.keySet()) {
            System.out.println("\t- Team " + name);
            GHTeam team = teams.get(name);
            Set<GHUser> users = team.getMembers();
            for (GHUser user : users) {
                System.out.println("\t\t- " + user.getLogin());
            }
        }
    }

    private void checkOrganisation() throws Exception {
        if (organization == null)
            throw new Exception();
    }
}
