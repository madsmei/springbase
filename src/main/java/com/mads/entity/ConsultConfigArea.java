package com.mads.entity;

import java.io.Serializable;

/*****
 * 对应数据库
 */
public class ConsultConfigArea implements Serializable {

    public String areaCode;

    public String areaName;

    public String state;

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
