package org.zufedfc.producer.bean;

import org.zufedfc.common.bean.DataIn;
import org.zufedfc.common.bean.DataOut;
import org.zufedfc.common.bean.Producer;

import java.io.IOException;
import java.util.List;

public class LocalFileProducer implements Producer {
    private DataIn in;
    private DataOut out;
    private volatile boolean flag = true;
    @Override
    public void setIn(DataIn in) {
        this.in = in;
    }

    @Override
    public void setOut(DataOut out) {
        this.out = out;
    }

    @Override
    public void produce() throws Exception {
        try {
//        读取数据
            List<Contact> contacts = in.read(Contact.class);
//            System.out.println(contacts.size());
            for (Contact contact : contacts) {
                System.out.println(contact);

            }
//            while (flag){
////        从读取数据中随机取两个电话号码(主叫,被叫)
////        生成随机通话时间
////        生成随机通话时长
////        生成通话记录
////        将通话记录输出到指定文件中
////            try {
////                String line = in.readLine();
////                if (line == null){
////                    break;
////                }
////                System.out.println(line);
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
//            }
        }catch (Exception e){
            e.printStackTrace();
        }



//        try {
//            out.write(in.read());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void close() throws IOException {
        if(in != null){
            in.close();
        }
        if(out != null){
            out.close();
        }
    }
}
