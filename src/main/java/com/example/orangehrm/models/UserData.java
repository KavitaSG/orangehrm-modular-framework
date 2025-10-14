package com.example.orangehrm.models;

public class UserData {
    private String username;
    private String password;
    private boolean expectedSuccess;
    private String notes;

    public UserData() {}

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public boolean isExpectedSuccess() { return expectedSuccess; }
    public void setExpectedSuccess(boolean expectedSuccess) { this.expectedSuccess = expectedSuccess; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
