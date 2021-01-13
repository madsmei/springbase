package com.mads.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*****
 * 吧该类 交给我们自己的自定义作用于来管理 {@link com.mads.beans.CustomScope}
 */
@Component
@Scope("madsScope")
public class ScopeBean {

    private String scopeName;

    public String getScopeName() {
        return scopeName;
    }

    public void setScopeName(String scopeName) {
        this.scopeName = scopeName;
    }
}
