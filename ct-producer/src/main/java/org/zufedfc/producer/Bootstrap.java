package org.zufedfc.producer;

import org.zufedfc.common.bean.Producer;
import org.zufedfc.producer.bean.LocalFileProducer;

import java.io.IOException;

public class Bootstrap {
    public static void main(String[] args) throws IOException {
//        构建一个生产者
        Producer producer = new LocalFileProducer();

//        构建一个数据输入
        producer.produce();

//        构建一个数据输出
        producer.close();

    }
}
