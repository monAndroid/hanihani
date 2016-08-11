package com.moonhani.hanihani.model;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by monwa on 2016-08-10.
 */
public class Pt {
    private String  _id;
    private String  CHARTID;
    private String  KSTATE;
    private int LAST;
    private int LAST2;
    private String  BNUM;
    private String  BTIME;
    private int BONBU;
    private int TOTAL;
    private int BIBO;
    private String  ORDER1;
    private String  chartNum;
    private String  JEJUCODE;
    private String  NAME;
    private String  JUMIN;
    private int PART;
    private int DAE;
    private String  JEUNG;
    private String  telNum;
    private String  hpNum;
    private String  bohoja;
    private String  memo;
    private String  ADDRESS2;
    private String  JTIME;
    private String  FIRSTDATE;
    private String  LASTDATE;
    private String  LASTDATE2;
    private String  ADDRESS;
    private char  SEX;
    private int  AGE;
    private List<Pt_Pic> PIC;
    private String  date;
    private int SAVEDRC;
    private int SAVEDIX;
    private int SAVEDTX;
    private Pt_Charted CHARTED;
    private String  ITYPE;
    private String  TIMER;

    public Pt(String _id, String CHARTID, String KSTATE, int LAST, int LAST2, String BNUM, String BTIME, int BONBU, int TOTAL, int BIBO, String ORDER1, String chartNum, String JEJUCODE, String NAME, String JUMIN, int PART, int DAE, String JEUNG, String telNum, String hpNum, String bohoja, String memo, String ADDRESS2, String JTIME, String FIRSTDATE, String LASTDATE, String LASTDATE2, String ADDRESS, char SEX, int AGE, List<Pt_Pic> PIC, String date, int SAVEDRC, int SAVEDIX, int SAVEDTX, Pt_Charted CHARTED, String ITYPE, String TIMER) {
        this._id = _id;
        this.CHARTID = CHARTID;
        this.KSTATE = KSTATE;
        this.LAST = LAST;
        this.LAST2 = LAST2;
        this.BNUM = BNUM;
        this.BTIME = BTIME;
        this.BONBU = BONBU;
        this.TOTAL = TOTAL;
        this.BIBO = BIBO;
        this.ORDER1 = ORDER1;
        this.chartNum = chartNum;
        this.JEJUCODE = JEJUCODE;
        this.NAME = NAME;
        this.JUMIN = JUMIN;
        this.PART = PART;
        this.DAE = DAE;
        this.JEUNG = JEUNG;
        this.telNum = telNum;
        this.hpNum = hpNum;
        this.bohoja = bohoja;
        this.memo = memo;
        this.ADDRESS2 = ADDRESS2;
        this.JTIME = JTIME;
        this.FIRSTDATE = FIRSTDATE;
        this.LASTDATE = LASTDATE;
        this.LASTDATE2 = LASTDATE2;
        this.ADDRESS = ADDRESS;
        this.SEX = SEX;
        this.AGE = AGE;
        this.PIC = PIC;
        this.date = date;
        this.SAVEDRC = SAVEDRC;
        this.SAVEDIX = SAVEDIX;
        this.SAVEDTX = SAVEDTX;
        this.CHARTED = CHARTED;
        this.ITYPE = ITYPE;
        this.TIMER = TIMER;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCHARTID() {
        return CHARTID;
    }

    public void setCHARTID(String CHARTID) {
        this.CHARTID = CHARTID;
    }

    public String getKSTATE() {
        return KSTATE;
    }

    public void setKSTATE(String KSTATE) {
        this.KSTATE = KSTATE;
    }

    public int getLAST() {
        return LAST;
    }

    public void setLAST(int LAST) {
        this.LAST = LAST;
    }

    public int getLAST2() {
        return LAST2;
    }

    public void setLAST2(int LAST2) {
        this.LAST2 = LAST2;
    }

    public String getBNUM() {
        return BNUM;
    }

    public void setBNUM(String BNUM) {
        this.BNUM = BNUM;
    }

    public String getBTIME() {
        return BTIME;
    }

    public void setBTIME(String BTIME) {
        this.BTIME = BTIME;
    }

    public int getBONBU() {
        return BONBU;
    }

    public void setBONBU(int BONBU) {
        this.BONBU = BONBU;
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

    public String getORDER1() {
        return ORDER1;
    }

    public void setORDER1(String ORDER1) {
        this.ORDER1 = ORDER1;
    }

    public String getChartNum() {
        return chartNum;
    }

    public void setChartNum(String chartNum) {
        this.chartNum = chartNum;
    }

    public String getJEJUCODE() {
        return JEJUCODE;
    }

    public void setJEJUCODE(String JEJUCODE) {
        this.JEJUCODE = JEJUCODE;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getJUMIN() {
        return JUMIN;
    }

    public void setJUMIN(String JUMIN) {
        this.JUMIN = JUMIN;
    }

    public int getPART() {
        return PART;
    }

    public void setPART(int PART) {
        this.PART = PART;
    }

    public int getDAE() {
        return DAE;
    }

    public void setDAE(int DAE) {
        this.DAE = DAE;
    }

    public String getJEUNG() {
        return JEUNG;
    }

    public void setJEUNG(String JEUNG) {
        this.JEUNG = JEUNG;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public String getHpNum() {
        return hpNum;
    }

    public void setHpNum(String hpNum) {
        this.hpNum = hpNum;
    }

    public String getBohoja() {
        return bohoja;
    }

    public void setBohoja(String bohoja) {
        this.bohoja = bohoja;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getADDRESS2() {
        return ADDRESS2;
    }

    public void setADDRESS2(String ADDRESS2) {
        this.ADDRESS2 = ADDRESS2;
    }

    public String getJTIME() {
        return JTIME;
    }

    public void setJTIME(String JTIME) {
        this.JTIME = JTIME;
    }

    public String getFIRSTDATE() {
        return FIRSTDATE;
    }

    public void setFIRSTDATE(String FIRSTDATE) {
        this.FIRSTDATE = FIRSTDATE;
    }

    public String getLASTDATE() {
        return LASTDATE;
    }

    public void setLASTDATE(String LASTDATE) {
        this.LASTDATE = LASTDATE;
    }

    public String getLASTDATE2() {
        return LASTDATE2;
    }

    public void setLASTDATE2(String LASTDATE2) {
        this.LASTDATE2 = LASTDATE2;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public char getSEX() {
        return SEX;
    }

    public void setSEX(char SEX) {
        this.SEX = SEX;
    }

    public int getAGE() {
        return AGE;
    }

    public void setAGE(int AGE) {
        this.AGE = AGE;
    }

    public List<Pt_Pic> getPIC() {
        return PIC;
    }

    public void setPIC(List<Pt_Pic> PIC) {
        this.PIC = PIC;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getSAVEDRC() {
        return SAVEDRC;
    }

    public void setSAVEDRC(int SAVEDRC) {
        this.SAVEDRC = SAVEDRC;
    }

    public int getSAVEDIX() {
        return SAVEDIX;
    }

    public void setSAVEDIX(int SAVEDIX) {
        this.SAVEDIX = SAVEDIX;
    }

    public int getSAVEDTX() {
        return SAVEDTX;
    }

    public void setSAVEDTX(int SAVEDTX) {
        this.SAVEDTX = SAVEDTX;
    }

    public Pt_Charted getCHARTED() {
        return CHARTED;
    }

    public void setCHARTED(Pt_Charted CHARTED) {
        this.CHARTED = CHARTED;
    }

    public String getITYPE() {
        return ITYPE;
    }

    public void setITYPE(String ITYPE) {
        this.ITYPE = ITYPE;
    }

    public String getTIMER() {
        return TIMER;
    }

    public void setTIMER(String TIMER) {
        this.TIMER = TIMER;
    }


    //대표 사진 1개만 리턴
    public char getSexLabel() {
        if (this.SEX == '0') {
            return '남';
        } else {
            return '여';
        }
    }

    //대표 사진 1개만 리턴
    public String getLastPic() {

        String picUrl = "http://112.133.112.77:9999/photo/thumb/default1.png";
        if (this.SEX == '0') {
            picUrl = "http://112.133.112.77:9999/photo/thumb/default0.png";
        }


        Log.i("TEST", "pic.length: " + this.PIC.size() + " pic.toString:");
        int len = this.PIC.size();

        if ( len > 0) {
            //try {
                picUrl = "http://112.133.112.77:9999/photo/thumb/" + this.PIC.get(len-1).getCAP_PATH();
           // } catch (Exception e) {

           // }

        }
        return picUrl;
    }

}
