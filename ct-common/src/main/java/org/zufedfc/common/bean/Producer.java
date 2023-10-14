package org.zufedfc.common.bean;

public interface Producer {

    public void setIn(DataIn in);
    public void setOut(DataOut out);
    public void produce();
}
