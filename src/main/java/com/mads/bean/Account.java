package com.mads.bean;

import com.mads.annotation.MyComponent;
import lombok.Data;

@Data
@MyComponent
public class Account {
    private String accountId = "123";
}
