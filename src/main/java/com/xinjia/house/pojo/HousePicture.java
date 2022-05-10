package com.xinjia.house.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HousePicture {
    private int picture_id;
    private int house_id;
    private String src;
}
