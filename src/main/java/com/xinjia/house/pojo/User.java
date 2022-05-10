package com.xinjia.house.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int user_id;
    private String user_name;
    private String user_tel;
    private String user_sex;
    private int user_age;
    private String user_address;
    private String user_password;
    private String user_account;
}
