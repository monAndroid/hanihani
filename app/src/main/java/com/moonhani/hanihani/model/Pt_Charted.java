package com.moonhani.hanihani.model;

/**
 * Created by monwa on 2016-08-11.
 */
public class Pt_Charted {
    private int TOTAL;
    private int  BIBO;

    public Pt_Charted(int TOTAL, int BIBO) {
        this.TOTAL = TOTAL;
        this.BIBO = BIBO;
    }

    public int getTOTAL() {
        return TOTAL;
    }

    public void setTOTAL(int TOTAL) {
        this.TOTAL = TOTAL;
    }

    public int getBIBO() {
        return BIBO;
    }

    public void setBIBO(int BIBO) {
        this.BIBO = BIBO;
    }
}
