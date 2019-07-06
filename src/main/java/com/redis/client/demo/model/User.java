package com.redis.client.demo.model;


import java.io.Serializable;

public class User implements Serializable {

    private int id;

    private String username;

    private String password;

    private String rediskey;


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setRediskey(String rediskey) {
        this.rediskey = rediskey;
    }

    public String getRediskey() {
        return rediskey;
    }
}
