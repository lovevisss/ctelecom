package org.zufedfc.producer.io;

import org.zufedfc.common.bean.DataOut;

import java.io.IOException;

public class LocalFileDataOut implements DataOut {
    public void setPath(String path) {
    }

    public LocalFileDataOut(String path) {
        setPath(path);
    }

    @Override
    public void close() throws IOException {

    }
}
