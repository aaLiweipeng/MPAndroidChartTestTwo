package com.charlie.mpandroidcharttest.Model;

public class DataGroup {
    public static int id = 1;
    public float wendu;
    public float shidu;
    public float guangdu;
    public float yanwu;
    public int cid;

    public DataGroup(float w,float s,float g, float y){
        this.wendu = w;
        this.shidu = s;
        this.guangdu = g;
        this.yanwu= y;
        cid = id++;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        DataGroup.id = id;
    }

    public float getWendu() {
        return wendu;
    }

    public void setWendu(float wendu) {
        this.wendu = wendu;
    }

    public float getShidu() {
        return shidu;
    }

    public void setShidu(float shidu) {
        this.shidu = shidu;
    }

    public float getGuangdu() {
        return guangdu;
    }

    public void setGuangdu(float guangdu) {
        this.guangdu = guangdu;
    }

    public float getYanwu() {
        return yanwu;
    }

    public void setYanwu(float yanwu) {
        this.yanwu = yanwu;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "这是第"+cid+"组的数据：温度："+wendu+
                " ； 湿度："+shidu+
                "；光度："+ guangdu+
                "；烟雾："+ yanwu;
    }
}
