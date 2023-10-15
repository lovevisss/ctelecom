package org.zufedfc.common.bean;

public abstract class Data implements Val{

    public String content;

    public void setContent(String content) {
        this.content = content;
    }
    @Override
    public String getVal() {
        return content;
    }

    @Override
    public void setVal(Object val) {
        content = (String)val;
    }
}
