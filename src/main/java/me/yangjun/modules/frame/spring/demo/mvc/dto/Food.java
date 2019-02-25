package me.yangjun.modules.frame.spring.demo.mvc.dto;

public class Food {
    private String username;

    private String season;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    @Override
    public String toString() {
        return "Food{" +
                "username='" + username + '\'' +
                ", season='" + season + '\'' +
                '}';
    }
}
