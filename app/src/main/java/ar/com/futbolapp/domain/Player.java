package ar.com.futbolapp.domain;

import com.google.gson.annotations.SerializedName;

public class Player extends Entity {

    private String name;
    private String email;

    @SerializedName("profile_picture")
    private String profilePicture;

    public Player(String name, String email, String profilePicture) {
        this.name = name;
        this.email = email;
        this.profilePicture = profilePicture;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getProfilePicture() {
        return profilePicture;
    }
}
