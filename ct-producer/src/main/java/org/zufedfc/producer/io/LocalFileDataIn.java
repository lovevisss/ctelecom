package org.zufedfc.producer.io;

import org.zufedfc.common.bean.Data;
import org.zufedfc.common.bean.DataIn;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LocalFileDataIn implements DataIn {
    private BufferedReader reader = null;
    public void setPath(String path)  {
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
//        reader = new BufferedReader(new InputStreamReader(Files.newInputStream(Paths.get(path)),"UTF-8"));
    }

    @Override
    public Object read() throws Exception {
        return null;
    }

    /**
     * 读取数据
     * @param clazz
     * @return
     * @param <T>
     * @throws Exception
     */
    @Override
    public <T extends Data> List<T> read(Class<T> clazz) throws Exception {
        List<T> ts = new ArrayList<T>();
//        从文件中读取所有数据
        String line = null;
        while ((line = reader.readLine()) != null){
//            System.out.println(line);
            T t = clazz.newInstance();
            t.setVal(line);
            ts.add(t);

        }
//        reader.readLine();
//        将数据转换为指定类型的对象并返回

        return ts;
    }

    public LocalFileDataIn(String path) {
        setPath(path);
    }

    @Override
    public void close() throws IOException {
        if(reader != null){
            reader.close();
        }

    }
}
