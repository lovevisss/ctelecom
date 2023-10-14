package org.zufedfc.producer;

import org.zufedfc.common.bean.Producer;
import org.zufedfc.producer.bean.LocalFileProducer;
import org.zufedfc.producer.io.LocalFileDataIn;
import org.zufedfc.producer.io.LocalFileDataOut;

import java.io.IOException;

public class Bootstrap {
    public static void main(String[] args) throws IOException {
//        构建一个生产者
        Producer producer = new LocalFileProducer();

        producer.setIn(new LocalFileDataIn());
        producer.setOut(new LocalFileDataOut());

//        构建一个数据输入
        producer.produce();

//        构建一个数据输出
        producer.close();

    }
}
