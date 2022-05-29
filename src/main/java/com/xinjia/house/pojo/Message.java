package com.xinjia.house.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private int message_id;
    private int user_id;
    private Date message_time;
    private String message_content;
    private int message_state;
}
