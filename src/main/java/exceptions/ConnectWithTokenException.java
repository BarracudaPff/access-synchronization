package exceptions;

public class ConnectWithTokenException extends Exception {
    private String token;

    public ConnectWithTokenException(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
