package com.example;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class GreenDaoGenerate {

    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1,"com.snslib");
        addPerson(schema);
        new DaoGenerator().generateAll(schema,"../SnsLibrary/app/src/main/java-gen");
    }

    private static void addPerson(Schema schema) {
        // 一个实体类对应一张数据库表，此处表名为 PERSON （即类名）
        Entity person = schema.addEntity("Person");
        person.setDbName("People");
        // 定义一个主键
        person.addIdProperty().primaryKey();
        // 定义一个非空的列，列名为 NAME
        person.addShortProperty("name").notNull();
        // 可以使用此方法定义实体类的属性名和数据库的列名不同，如下实体类名为 sex，列名为_SEX
        person.addStringProperty("sex").columnName("_sex");
    }
}
