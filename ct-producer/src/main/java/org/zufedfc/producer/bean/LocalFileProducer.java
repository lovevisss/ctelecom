package org.zufedfc.producer.bean;

import org.zufedfc.common.bean.DataIn;
import org.zufedfc.common.bean.DataOut;
import org.zufedfc.common.bean.Producer;
import org.zufedfc.common.util.DateUtil;
import org.zufedfc.common.util.NumberUtil;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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

            while (flag){
//        从读取数据中随机取两个电话号码(主叫,被叫)
                int call1Index = (int)(Math.random() * contacts.size());
                int call2Index = (int)(Math.random() * contacts.size());
                while (call1Index == call2Index){
                    call2Index = (int)(Math.random() * contacts.size());
                }
                Contact call1 = contacts.get(call1Index);
                Contact call2 = contacts.get(call2Index);
                System.out.println(call1.getName() + "正在给" + call2.getName() + "打电话");
//        生成随机通话时间
                String startDate = "20180101000000";
                String endDate = "20190101000000";
                long startTime = Objects.requireNonNull(DateUtil.parseDate(startDate, "yyyyMMddHHmmss")).getTime();
                long endTime = Objects.requireNonNull(DateUtil.parseDate(endDate, "yyyyMMddHHmmss")).getTime();
                long callTime = startTime + (long)((endTime - startTime) * Math.random());

                String callTimeString = DateUtil.formatDate(new Date(callTime),"yyyyMMddHHmmss");


                System.out.println("通话时间:" + callTimeString);
//        生成随机通话时长
                long duration = (long)(Math.random() * 3600);
                String durationString = NumberUtil.formatNumber(duration,4);
                System.out.println("通话时长:" + durationString + "秒");
                flag = false;
//        生成通话记录
                Calllog callLog = new Calllog(call1.getTel(),call2.getTel(),callTimeString,durationString);
                System.out.println(callLog);
//        将通话记录输出到指定文件中
//            try {
//                String line = in.readLine();
//                if (line == null){
//                    break;
//                }
//                System.out.println(line);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            }
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
