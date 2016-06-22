package com.mobica.dev.training.learnica.form;

/**
 * Pojo representing a profile form on the client side.
 */
public class ProfileForm {
    /**
     * Any string user wants us to display him/her on this system.
     */
    private String displayName;
    private String position;
    private String phone;
    private String email;
    private String skype;
    private String location;


    private ProfileForm () {}

    /**
     * Constructor for ProfileForm, solely for unit test.
     * @param displayName A String for displaying the user on this system.
     * @param notificationEmail An e-mail address for getting notifications from this system.
     */
    public ProfileForm(String displayName,String position,String phone, String email, String skype, String location) {
        this.displayName = displayName;
        this.position = position;
        this.phone = phone;
        this.email = email;
        this.skype = skype;
        this.location = location;
    }

    public String getDisplayName() {
        return displayName;
    }
    public String getPosition() {
        return position;
    }
    public String getPhone() {
        return phone;
    }
    public String getEmail() {
        return email;
    }
    public String getSkype() {
        return skype;
    }
    public String getLocation() {
        return location;
    }
}
