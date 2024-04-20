package com.uw.cs506.team03.smartstock.dto;

public class LoginDTO {

    private String username;
    private String password;
    private String role;
    private int storeId;

    public LoginDTO() {
    }

    public LoginDTO(String username, String password, String role, int storeId) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.storeId = storeId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", storeId=" + storeId +
                '}';
    }
}
