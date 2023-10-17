package org.zufedfc.producer.bean;

import org.zufedfc.common.bean.Data;

/**
 * 联系人
 */
public class Contact extends Data {
    private String tel;
    private String name;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setVal(Object val) {
        content = (String)val;
//        System.out.println(content);
        if(content == null) {
            return;
        }
        String[] values = content.split(",");
//        System.out.println(values[0]+ "++"+values[1]);
        setName(values[0]);
        setTel(values[1]);
//        super.setVal(val);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "tel='" + tel + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
