package exceptions;

public class ConnectWithLoginException extends Exception {
    private String login;
    private String pass;

    public ConnectWithLoginException(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }

    public String getLogin() {
        return login;
    }
}
