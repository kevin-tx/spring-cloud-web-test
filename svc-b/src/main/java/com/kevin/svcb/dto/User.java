package com.kevin.svcb.dto;

import lombok.Data;

/**
 * @author TX
 * @date 2021/11/29 14:11
 */
@Data
public class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
