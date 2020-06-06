package com.example.studyproject.design.appearance;

import android.telephony.NeighboringCellInfo;

public class Apperance {

    private ZhaoShi zhaoShi;
    private NeiGong neiGong;
    private Jingmai jingmai;

    public Apperance(){
        zhaoShi = new ZhaoShi();
        neiGong = new NeiGong();
        jingmai = new Jingmai();
    }

    public void qianKun() {
        jingmai.jm();
        neiGong.ng();
    }


}
