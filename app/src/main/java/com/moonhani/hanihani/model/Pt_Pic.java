package com.moonhani.hanihani.model;

/**
 * Created by monwa on 2016-08-11.
 */
public class Pt_Pic {
    private String CAP_PATH;
    private String CAP_WDATE;
    private String CAP_REMARK;
    private String CAP_BIGO1;

    public Pt_Pic(String CAP_PATH, String CAP_WDATE, String CAP_REMARK, String CAP_BIGO1) {
        this.CAP_PATH = CAP_PATH;
        this.CAP_WDATE = CAP_WDATE;
        this.CAP_REMARK = CAP_REMARK;
        this.CAP_BIGO1 = CAP_BIGO1;
    }

    public String getCAP_PATH() {
        return CAP_PATH;
    }

    public void setCAP_PATH(String CAP_PATH) {
        this.CAP_PATH = CAP_PATH;
    }

    public String getCAP_WDATE() {
        return CAP_WDATE;
    }

    public void setCAP_WDATE(String CAP_WDATE) {
        this.CAP_WDATE = CAP_WDATE;
    }

    public String getCAP_REMARK() {
        return CAP_REMARK;
    }

    public void setCAP_REMARK(String CAP_REMARK) {
        this.CAP_REMARK = CAP_REMARK;
    }

    public String getCAP_BIGO1() {
        return CAP_BIGO1;
    }

    public void setCAP_BIGO1(String CAP_BIGO1) {
        this.CAP_BIGO1 = CAP_BIGO1;
    }


}
