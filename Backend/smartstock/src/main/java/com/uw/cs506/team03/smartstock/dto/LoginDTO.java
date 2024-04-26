package com.uw.cs506.team03.smartstock.dto;

/**
 * This class is the data transfer object for the login table
 */
public class LoginDTO {

    private String username;
    private String password;
    private String role;
    private int storeId;

    public LoginDTO() {
    }

    /**
     * This is the constructor for the LoginDTO class
     * @param username the username
     * @param password the password
     * @param role the role
     * @param storeId the id of the store
     */
    public LoginDTO(String username, String password, String role, int storeId) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.storeId = storeId;
    }

    /**
     * This method is used to get the username
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method is used to set the username
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method is used to get the password
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method is used to set the password
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method is used to get the role
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * This method is used to set the role
     * @param role the role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * This method is used to get the id of the store
     * @return the id of the store
     */
    public int getStoreId() {
        return storeId;
    }

    /**
     * This method is used to set the id of the store
     * @param storeId the id of the store
     */
    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }
    

    /**
     * This method is used to get the string representation of the LoginDTO object
     * @return the string representation of the LoginDTO object
     */
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
