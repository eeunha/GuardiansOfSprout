package com.example.myapplication;


import com.google.gson.annotations.SerializedName;

public class UserDTO {
    @SerializedName("id")
    String id;
    @SerializedName("password")
    String password;
    @SerializedName("name")
    String name;
    @SerializedName("nickname")
    String nickname;
    @SerializedName("email")
    String email;
    @SerializedName("phone")
    String phone;
    @SerializedName("userType")
    String userType;

    public UserDTO() {

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", phone'" + phone + '\'' +
                ", userType'" + userType + '\'' +
                '}';
    }
}



