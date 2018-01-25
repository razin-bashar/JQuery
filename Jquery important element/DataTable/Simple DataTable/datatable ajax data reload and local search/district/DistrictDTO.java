package com.revesoft.springboot.web.geo.district;

import java.util.Date;

/**
 * Created by Bony on 10/26/2017.
 */
public class DistrictDTO {

    private int id;
    private int divisionId;
    private String divisionBBSCode;
    private String districtNameEng;
    private String districtNameBng;
    private String bbsCode;
    private Integer Status;
    private int createdBy;
    private String created;
    private int modifiedBy;
    private String modified;

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public int getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(int modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    public String getDivisionBBSCode() {
        return divisionBBSCode;
    }

    public void setDivisionBBSCode(String divisionBBSCode) {
        this.divisionBBSCode = divisionBBSCode;
    }

    public String getDistrictNameEng() {
        return districtNameEng;
    }

    public void setDistrictNameEng(String districtNameEng) {
        this.districtNameEng = districtNameEng;
    }

    public String getDistrictNameBng() {
        return districtNameBng;
    }

    public void setDistrictNameBng(String districtNameBng) {
        this.districtNameBng = districtNameBng;
    }

    public String getBbsCode() {
        return bbsCode;
    }

    public void setBbsCode(String bbsCode) {
        this.bbsCode = bbsCode;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }
}
