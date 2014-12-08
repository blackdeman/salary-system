package by.dreamteam.businessservices.entities;

/**
 * @author Andrew
 * @version 1.0
 * @created 06-Dec-2014 3:35:03 PM
 * User version generated from EA
 */
public class UserEA {

    private String name;
    private String password;
    private String role;
    private String department;

    public UserEA() {
    }

    /**
     *
     * @param password
     * @param name
     */
    public UserEA(String password, String name) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}//end User
