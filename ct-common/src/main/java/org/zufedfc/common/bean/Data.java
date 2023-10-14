package org.zufedfc.common.bean;

public class Data implements Val{

    public String content;

    public void setContent(String content) {
        this.content = content;
    }
    @Override
    public Object getVal() {
        return null;
    }
}
