package org.zufedfc.common.constant;

import org.zufedfc.common.bean.Val;

public enum Names implements Val {
    NAMESPACE("ct");

    private String name;
    private Names(String name) {
        this.name = name;
    }

    @Override
    public Object getVal() {
        return name;
    }
}
