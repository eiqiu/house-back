package com.xinjia.house.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Collection {
    private int collection_id;
    private int user_id;
    private int houser_id;
    private Date collection_time;
}
