package com.moonhani.hanihani.model;

import android.view.View;

import java.util.ArrayList;

/**
 * Simple POJO model for example
 */
public class Pt {

    private String name;
    private String birth;
    private String firstDate;
    private String lastDate;
    private int visitCount;
    private String age;
    private String sex;

    //private View.OnClickListener requestBtnClickListener;

    public Pt() {
    }

    public Pt(String name, String birth, String firstDate, String lastDate, int visitCount, String age, String sex) {
        this.name = name;
        this.birth = birth;
        this.firstDate = firstDate;
        this.lastDate = lastDate;
        this.visitCount = visitCount;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(String firstDate) {
        this.firstDate = firstDate;
    }

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
/*
    public View.OnClickListener getRequestBtnClickListener() {
        return requestBtnClickListener;
    }

    public void setRequestBtnClickListener(View.OnClickListener requestBtnClickListener) {
        this.requestBtnClickListener = requestBtnClickListener;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pt pt = (Pt) o;

        if (visitCount != pt.visitCount) return false;
        if (name != null ? !name.equals(pt.name) : pt.name != null) return false;
        if (birth != null ? !birth.equals(pt.birth) : pt.birth != null)
            return false;
        if (firstDate != null ? !firstDate.equals(pt.firstDate) : pt.firstDate != null)
            return false;
        if (lastDate != null ? !lastDate.equals(pt.lastDate) : pt.lastDate != null)
            return false;
        if (age != null ? !age.equals(pt.age) : pt.age != null) return false;
        return !(sex != null ? !sex.equals(pt.sex) : pt.sex != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (birth != null ? birth.hashCode() : 0);
        result = 31 * result + (firstDate != null ? firstDate.hashCode() : 0);
        result = 31 * result + (lastDate != null ? lastDate.hashCode() : 0);
        result = 31 * result + visitCount;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        return result;
    }
*/
    /**
     * @return List of elements prepared for tests
     */
    public static ArrayList<Pt> getTestingList() {
        ArrayList<Pt> pts = new ArrayList<>();
        pts.add(new Pt("문정삼", "1968-12-25", "2016-08-09", "2016-09-09", 11, "47", "남"));
        pts.add(new Pt("$23", "$116", "W 36th St, NY, 10015", "W 114th St, NY, 10037", 10, "TODAY", "11:10 AM"));
        pts.add(new Pt("$63", "$350", "W 36th St, NY, 10029", "56th Ave, NY, 10041", 0, "TODAY", "07:11 PM"));
        pts.add(new Pt("$19", "$150", "12th Ave, NY, 10012", "W 57th St, NY, 10048", 8, "TODAY", "4:15 AM"));
        pts.add(new Pt("$5", "$300", "56th Ave, NY, 10041", "W 36th St, NY, 10029", 0, "TODAY", "06:15 PM"));
        return pts;

    }

}