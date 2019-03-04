package connection;

import exceptions.ConnectWithLoginException;
import exceptions.ConnectWithTokenException;
import exceptions.NotConnectedException;
import org.kohsuke.github.GitHub;

import java.io.IOException;

public class Connector {
    public String login;
    public String password;
    private String tocken;
    private boolean isLogin = false;
    private boolean isToken = false;

    private static Connector instance;

    public static Connector getInstance() {
        if (instance == null) {
            instance = new Connector();
        }
        return instance;
    }

    public void connectWithToken(String token) throws Exception {
        try {
            GitHub.connectUsingOAuth(token).checkApiUrlValidity();
            this.tocken = token;
            isToken = true;
        } catch (IOException e) {
            throw new ConnectWithTokenException(token);
        }
    }

    public void connectWithLogin(String login, String password) throws Exception {
        try {
            GitHub.connectUsingPassword(login, password).checkApiUrlValidity();
            this.login = login;
            this.password = password;
            isLogin = true;
        } catch (IOException e) {
            throw new ConnectWithLoginException(login, password);
        }
    }

    public boolean checkConnect() {
        return isLogin || isToken;
    }

    public GitHub connect() throws Exception {
        if (isLogin)
            return GitHub.connectUsingPassword(login, password);
        else if (isToken)
            return GitHub.connectUsingOAuth(tocken);
        else throw new NotConnectedException();
    }
}
