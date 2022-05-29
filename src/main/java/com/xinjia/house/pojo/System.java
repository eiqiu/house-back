package com.xinjia.house.pojo;

import lombok.Getter;

public enum System {
    /**待审核**/
    TO_BE_REVIEWED(1,"待审核"),
    /**审核**/
    NOT_SOLD(2,"未出售");
    @Getter
    private int statusCode;
    @Getter
    private String msg;

    System(int statusCode, String msg) {
        this.statusCode = statusCode;
        this.msg = msg;
    }
}
