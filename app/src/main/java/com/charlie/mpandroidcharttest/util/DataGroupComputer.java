package com.charlie.mpandroidcharttest.util;

import com.charlie.mpandroidcharttest.Model.DataGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataGroupComputer {

    List<DataGroup> dataList = new ArrayList<DataGroup>();
    List<Float> WDList = new ArrayList<Float>();
    List<Float> SDList = new ArrayList<Float>();
    List<Float> GDList = new ArrayList<Float>();
    List<Float> YWList = new ArrayList<Float>();


    //********************************s
    public String getTheAvgOfList(List<Float> list) {

        float total = 0.0f;
        for(int i=0;i<list.size();i++){
            total += list.get(i);
        }
        //avg就是平均数
        float avg = total/list.size();

        return ""+avg;
    }

    public String getTheMaxOfList(List<Float> list) {
        return ""+Collections.max(list);
    }

    public String getTheMinOfList(List<Float> list) {
        return ""+Collections.min(list);
    }

    //********************************

    public void add(DataGroup dataGroup) {
        dataList.add(dataGroup);
    }

    public List<DataGroup> getDataList() {
        return this.dataList;
    }

    public void setDataStringAndChangeItToDataList(String string) {
        String[] splitAddress=string.split("\\*");
        for(int i=0;i<40;) {
            int j = i;
            float w = Float.parseFloat(splitAddress[j++]);
            float s = Float.parseFloat(splitAddress[j++]);
            float g = Float.parseFloat(splitAddress[j++]);
            float y = Float.parseFloat(splitAddress[j++]);
            DataGroup dataGroup = new DataGroup(w, s, g, y);
            i = j;
            dataList.add(dataGroup);
        }
    }

    public void testAllData() {
        System.out.println(getDataString());
        System.out.println("下面是以上十组组装数据的温度值:");
        System.out.println(getWDString());
        System.out.println("下面是以上十组组装数据的湿度值:");
        System.out.println(getSDString());
        System.out.println("下面是以上十组组装数据的光敏阻值:");
        System.out.println(getGDString());
        System.out.println("下面是以上十组组装数据的烟雾值:");
        System.out.println(getYWString());
    }

    //返回十个温度数据组装成的List
    public List<Float> getWenduDataList() {
        List<Float> wenduDataList = new ArrayList<>();

        for(DataGroup dataGroup : dataList) {
            wenduDataList.add(dataGroup.wendu);
        }
        return wenduDataList;
    }

    public List<Float> getShiduDataList() {
        List<Float> shiduDataList = new ArrayList<>();

        for(DataGroup dataGroup : dataList) {
            shiduDataList.add(dataGroup.shidu);
        }
        return shiduDataList;
    }

    public List<Float> getGuangduduDataList() {
        List<Float> guangduDataList = new ArrayList<>();

        for(DataGroup dataGroup : dataList) {
            guangduDataList.add(dataGroup.guangdu);
        }
        return guangduDataList;
    }

    public List<Float> getYanwuDataList() {
        List<Float> yanwuDataList = new ArrayList<>();

        for(DataGroup dataGroup : dataList) {
            yanwuDataList.add(dataGroup.yanwu);
        }
        return yanwuDataList;
    }



    //测试数据,返回十个数据字符串，每个换行
    public String getWDString() {
        return getSingleDataString(getWenduDataList());
    }

    public String getSDString() {
        return getSingleDataString(getShiduDataList());
    }

    public String getGDString() {
        return getSingleDataString(getGuangduduDataList());
    }

    public String getYWString() {
        return getSingleDataString(getYanwuDataList());
    }



    //接收一个List，组装成字符串
    public String getSingleDataString(List<Float> SingleDataList) {
        String dataString = new String();

        for(Float sd : SingleDataList) {
            dataString += sd.toString();
            dataString += "\n";
        }

        return dataString;
    }

    //测试数据,返回十个组装数据字符串，每个换行
    //"这是第1组的数据：温度：29.04 ； 湿度：60.1；光度：2555.0；烟雾：500.0"
    public String getDataString() {
        // TODO Auto-generated method stub
        String dataString = new String();
        for(DataGroup dataGroup : dataList) {
            dataString += dataGroup.toString();
            dataString += "\n";
        }
        return dataString;
    }
}
