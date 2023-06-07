package org.lan.cinema.pojo;

public class CareInfo {
    String name;
    String info;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "CareInfo{" +
                "name='" + name + '\'' +
                ", info='" + info + '\'' +
                '}';
    }

    public CareInfo(String name, String info) {
        this.name = name;
        this.info = info;
    }

    public CareInfo() {
    }
}
