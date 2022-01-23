package acnh_backend.duomaoj.model;

import org.bson.types.ObjectId;

public class AuthData {
    private ObjectId userId;
    private String token;
    private int tokenExpiration;

    public int getTokenExpiration() {
        return tokenExpiration;
    }

    public ObjectId getUserId() {
        return userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setTokenExpiration(int tokenExpiration) {
        this.tokenExpiration = tokenExpiration;
    }

    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }
}
