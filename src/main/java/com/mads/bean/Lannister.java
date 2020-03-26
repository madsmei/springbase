package com.mads.bean;

import org.springframework.stereotype.Component;

/*****
 * 兰尼斯特家族
 */
@Component
public class Lannister {

    private String name = "泰温";

    private String sex = "男";

    @Override
    public String toString() {
        return "Lannister{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
