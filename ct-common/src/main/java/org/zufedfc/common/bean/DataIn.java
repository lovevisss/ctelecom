package org.zufedfc.common.bean;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface DataIn extends Closeable {
    public void setPath(String path) throws IOException;
    public Object read() throws Exception;
    public <T extends Data> List<T> read(Class<T> clazz) throws Exception;
}
