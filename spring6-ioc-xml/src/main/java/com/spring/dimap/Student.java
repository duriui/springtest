package com.spring.dimap;

import java.util.List;
import java.util.Map;

/**
 * @author DR
 * @version 1.0
 * @creates in 2023-06-02-22:34
 */
public class Student {

    private Map<String,Teacher> tMap;

    private List<Lession> llist;
    private String sId;
    private String sName;

    public void run(){
        System.out.println("学生ID："+sId+", 学生姓名："+sName);
        System.out.println(tMap);
        System.out.println(llist);
    }

    public Map<String, Teacher> gettMap() {
        return tMap;
    }

    public List<Lession> getLlist() {
        return llist;
    }

    public void setLlist(List<Lession> llist) {
        this.llist = llist;
    }

    public void settMap(Map<String, Teacher> tMap) {
        this.tMap = tMap;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "tMap=" + tMap +
                ", sId='" + sId + '\'' +
                ", sName='" + sName + '\'' +
                '}';
    }
}
