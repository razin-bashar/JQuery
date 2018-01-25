package com.revesoft.springboot.web.geo.upazilla;

import java.io.Serializable;

/**
 * Created by reve on 10/26/2017.
 */
public class UpazillaDTO implements Serializable{
    private int id;
    private int geoDivisionId;
    private int geoDistrictId;
    private String divisionBbsCode;
    private String districtBbsCode;
    private String upazillaNameEng;
    private String upazillaNameBng;
    private String bbsCode;
    private int status;
    private int createdBy;
    private int modifiedBy;

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public int getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(int modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getDivisionBbsCode() {
        return divisionBbsCode;
    }

    public void setDivisionBbsCode(String divisionBbsCode) {
        this.divisionBbsCode = divisionBbsCode;
    }

    public UpazillaDTO() {


    }

    public UpazillaDTO(int id, int geoDivisionId, int geoDistrictId, String divisionBbsCode, String districtBbsCode, String upazillaNameEng, String upazillaNameBng, String bbsCode, int status) {
        this.id = id;
        this.geoDivisionId = geoDivisionId;
        this.geoDistrictId = geoDistrictId;
        this.districtBbsCode = districtBbsCode;
        this.upazillaNameEng = upazillaNameEng;
        this.upazillaNameBng = upazillaNameBng;
        this.bbsCode = bbsCode;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGeoDivisionId() {
        return geoDivisionId;
    }

    public void setGeoDivisionId(int geoDivisionId) {
        this.geoDivisionId = geoDivisionId;
    }

    public int getGeoDistrictId() {
        return geoDistrictId;
    }

    public void setGeoDistrictId(int geoDistrictId) {
        this.geoDistrictId = geoDistrictId;
    }

    public String getDistrictBbsCode() {
        return districtBbsCode;
    }

    public void setDistrictBbsCode(String districtBbsCode) {
        this.districtBbsCode = districtBbsCode;
    }

    public String getUpazillaNameEng() {
        return upazillaNameEng;
    }

    public void setUpazillaNameEng(String upazillaNameEng) {
        this.upazillaNameEng = upazillaNameEng;
    }

    public String getUpazillaNameBng() {
        return upazillaNameBng;
    }

    public void setUpazillaNameBng(String upazillaNameBng) {
        this.upazillaNameBng = upazillaNameBng;
    }

    public String getBbsCode() {
        return bbsCode;
    }

    public void setBbsCode(String bbsCode) {
        this.bbsCode = bbsCode;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
