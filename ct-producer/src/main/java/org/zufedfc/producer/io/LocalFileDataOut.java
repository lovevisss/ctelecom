package org.zufedfc.producer.io;

import org.zufedfc.common.bean.DataOut;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LocalFileDataOut implements DataOut {
    private PrintWriter writer = null;
    public void setPath(String path) {
        try {
            writer = new PrintWriter(new OutputStreamWriter(Files.newOutputStream(Paths.get(path)), StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void write(Object data) throws Exception {
        write(data.toString());
    }

    @Override
    public void write(String data) throws Exception {
        writer.println(data);
        writer.flush();
    }

    public LocalFileDataOut(String path) {
        setPath(path);
    }

    @Override
    public void close() throws IOException {
        if(writer != null){
            writer.close();
        }
    }
}
