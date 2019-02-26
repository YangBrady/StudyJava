package me.yangjun.modules.frame.spring.demo.mvc.dto;

import java.util.Date;

public class Food {
    private String username;

    private String season;

    private Date productDate;

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

    public Date getProductDate() {
        return productDate;
    }

    public void setProductDate(Date productDate) {
        this.productDate = productDate;
    }

    @Override
    public String toString() {
        return "Food{" +
                "username='" + username + '\'' +
                ", season='" + season + '\'' +
                ", productDate=" + productDate +
                '}';
    }
}
