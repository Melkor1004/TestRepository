package com.laptrinhjavaweb.buildingForSearch;

public class BuildingSearch {

    private String nameBuilding;
    private String street;
    private String ward;
    private String district;
    private Integer rentPriceFrom;
    private Integer rentPriceTo;
    private Integer rentareaFrom;
    private Integer rentareaTo;
    private Integer staffId;
    private String[] renttype;

    public String getNameBuilding() {
        return nameBuilding;
    }

    public void setNameBuilding(String nameBuilding) {
        this.nameBuilding = nameBuilding;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }



    public Integer getRentareaFrom() {
        return rentareaFrom;
    }

    public void setRentareaFrom(Integer rentareaFrom) {
        this.rentareaFrom = rentareaFrom;
    }

    public Integer getRentareaTo() {
        return rentareaTo;
    }

    public void setRentareaTo(Integer rentareaTo) {
        this.rentareaTo = rentareaTo;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String[] getRenttype() {
        return renttype;
    }

    public void setRenttype(String[] renttype) {
        this.renttype = renttype;
    }

    public Integer getRentPriceFrom() {
        return rentPriceFrom;
    }

    public void setRentPriceFrom(Integer rentPriceFrom) {
        this.rentPriceFrom = rentPriceFrom;
    }

    public Integer getRentPriceTo() {
        return rentPriceTo;
    }

    public void setRentPriceTo(Integer rentPriceTo) {
        this.rentPriceTo = rentPriceTo;
    }
}
