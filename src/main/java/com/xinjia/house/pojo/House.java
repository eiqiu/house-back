package com.xinjia.house.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class House {
    private int owner_id;
    private int category_id;
    private String        house_title;
    private String        house_address;
    private double        house_price;
    private boolean        bargain;
    private Date        publish_time;
    private double        house_area;
    private String        house_type;
    private String        house_structure;
    private String        building_type;
    private String        building_structure;
    private String        house_towards;
    private String        house_decoration;
    private String        house_ladder;
    private String        heating_mode;
    private boolean        elevator;
    private String        viewing_time;
    private String        transportation;
    private String        surrounding_facilities;
    private String        house_description;
    private boolean        house_state;
    private String[]        house_tags;

}
