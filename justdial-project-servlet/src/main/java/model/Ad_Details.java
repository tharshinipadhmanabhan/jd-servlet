package model;


public class Ad_Details {
    private int id;
    private String ad_name;
    private long contactNum;
    private String category;
    private String subCategory;
    private String f_d_num;
    private String area;
    private String city;
    private String district;
    private String state;
    private String country;
    private String opnTime;
    private String clsTime;
    private String holiday;
    private String desc;

    
    public Ad_Details(int id, String ad_name, long contactNum, String category, String subCategory, String f_d_num,
            String area, String city, String district, String state, String country, String opnTime, String clsTime,
            String holiday, String desc) {
        this.id = id;
        this.ad_name = ad_name;
        this.contactNum = contactNum;
        this.category = category;
        this.subCategory = subCategory;
        this.f_d_num = f_d_num;
        this.area = area;
        this.city = city;
        this.district = district;
        this.state = state;
        this.country = country;
        this.opnTime = opnTime;
        this.clsTime = clsTime;
        this.holiday = holiday;
        this.desc = desc;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getAd_name() {
        return ad_name;
    }


    public void setAd_name(String ad_name) {
        this.ad_name = ad_name;
    }


    public long getContactNum() {
        return contactNum;
    }


    public void setContactNum(long contactNum) {
        this.contactNum = contactNum;
    }


    public String getCategory() {
        return category;
    }


    public void setCategory(String category) {
        this.category = category;
    }


    public String getSubCategory() {
        return subCategory;
    }


    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }


    public String getF_d_num() {
        return f_d_num;
    }


    public void setF_d_num(String f_d_num) {
        this.f_d_num = f_d_num;
    }


    public String getArea() {
        return area;
    }


    public void setArea(String area) {
        this.area = area;
    }


    public String getCity() {
        return city;
    }


    public void setCity(String city) {
        this.city = city;
    }


    public String getDistrict() {
        return district;
    }


    public void setDistrict(String district) {
        this.district = district;
    }


    public String getState() {
        return state;
    }


    public void setState(String state) {
        this.state = state;
    }


    public String getCountry() {
        return country;
    }


    public void setCountry(String country) {
        this.country = country;
    }


    public String getOpnTime() {
        return opnTime;
    }


    public void setOpnTime(String opnTime) {
        this.opnTime = opnTime;
    }


    public String getClsTime() {
        return clsTime;
    }

    public void setClsTime(String clsTime) {
        this.clsTime = clsTime;
    }


    public String getHoliday() {
        return holiday;
    }


    public void setHoliday(String holiday) {
        this.holiday = holiday;
    }


    public String getDesc() {
        return desc;
    }


    public void setDesc(String desc) {
        this.desc = desc;
    }

    
    

    
}
