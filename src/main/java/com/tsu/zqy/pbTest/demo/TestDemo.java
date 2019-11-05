package com.tsu.zqy.pbTest.demo;

import com.alibaba.fastjson.JSON;
import com.google.protobuf.InvalidProtocolBufferException;
import com.tsu.zqy.pbTest.javaEntry.StudentByJ;
import com.tsu.zqy.pbTest.pbEntry.Student;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author zhuQiYun
 * @create 2019/10/8
 * @description :
 */
public class TestDemo {

    private static byte[] serialize(Student.StudentMsg student){
        return student.toByteArray();
    }

    private static Student.StudentMsg deSerialize(byte[] data){
        Student.StudentMsg student = null;
        try {
           student = Student.StudentMsg.parseFrom(data);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        return student;
    }

    public static void main(String[] args) {

        // pb
        Student.StudentMsg.Builder builder = Student.StudentMsg.newBuilder();
        Student.StudentMsg tom = builder.setName("tom").setAge(1).setId(1).setState(1).build();
        byte[] serialize = serialize(tom);
        System.out.println("字节数组长度:" + serialize.length);
        Student.StudentMsg studentMsg = deSerialize(serialize);
        System.out.println(studentMsg);


        // java
        StudentByJ studentByJ = new StudentByJ();
        studentByJ.setAge(1);
        studentByJ.setId(1);
        studentByJ.setName("tom");
        studentByJ.setState(1);
        byte[] bytes = serializeForJ(studentByJ);
        System.out.println("字节数组长度:" + bytes.length);

        String s = JSON.toJSONString(studentByJ);
        byte[] bytesByJson = s.getBytes();
        System.out.println("字节数组长度:" + bytesByJson.length);
        System.out.println("字节数组长度:" + s);
    }


    public static byte[] serializeForJ(StudentByJ student){
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(student);
            byte[] bytes = byteArrayOutputStream.toByteArray();
            return bytes;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
