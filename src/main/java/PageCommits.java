import org.kohsuke.github.GHOrganization;
import org.kohsuke.github.GHTeam;
import org.kohsuke.github.GHUser;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.util.Map;
import java.util.Set;


public class PageCommits {

    /**
     * Print commit authors and dates paged in blocks of 25
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        GHOrganization organization = GitHub.connectUsingPassword("Barracudapff","1pendospendos")
                .getOrganization("apmath-web");

        System.out.println(organization);
        System.out.println(organization.getLogin());
        Map<String, GHTeam> teams = organization.getTeams();
        System.out.println(teams);
        for (String name : teams.keySet()) {
            GHTeam team = teams.get(name);
            System.out.println(name);
            Set<GHUser> users = team.getMembers();
            for (GHUser user : users) {
                System.out.println(user.getLogin());
            }
            System.out.println("DSADSDASDASDASDAS");
        }
    }
}
