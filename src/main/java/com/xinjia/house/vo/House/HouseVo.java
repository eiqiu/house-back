package com.xinjia.house.vo.House;

import com.xinjia.house.pojo.HousePicture;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseVo {
    private int             house_id;
    private int             owner_id;
    private int             category_id;
    private String          house_title;
    private String          house_address;
    private double          house_price;
    private boolean         bargain;
    private Date            publish_time;
    private double          house_area;
    private String          house_type;
    private String          house_structure;
    private String          building_type;
    private String          building_structure;
    private String          house_towards;
    private String          house_decoration;
    private String          house_ladder;
    private String          heating_mode;
    private boolean         elevator;
    private String          viewing_time;
    private String          transportation;
    private String          surrounding_facilities;
    private String          house_description;
    private int             house_state;
    private String          user_name;
    private String          user_tel;
    private String          user_address;
    private int             click_num;
    private int             user_age;
    private String          user_sex;
    private List<HousePicture> pictures;
}
