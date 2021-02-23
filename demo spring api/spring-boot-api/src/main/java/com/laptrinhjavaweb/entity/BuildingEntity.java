package com.laptrinhjavaweb.entity;

import org.apache.el.lang.EvaluationContext;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "building")
public class BuildingEntity extends BaseEntity {

    @OneToMany(mappedBy = "building")
    private List<RentAreaEntity> areas;

    @ManyToOne
    @JoinColumn(name = "districid", insertable = false, updatable = false)
    private DistrictEntity district;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "buildingrenttype",
            inverseJoinColumns = @JoinColumn(name = "renttypeid")
    )
    private List<RentTypeEntity> renttypes;

    @OneToMany(mappedBy = "building")
    private List<AsignmentBuildingEntity> asignmentBuildings;

   @Column(name = "name")
   private String name;

   @Column(name = "street")
   private String street;

   @Column(name = "ward")
   private String ward;


   @Column(name = "structure")
   private String structure;

   @Column(name = "numberofbasement")
   private int numberOfBasement;

   @Column(name = "floorarea")
   private int floorArea;

   @Column(name = "direction")
   private String direction;

   @Column(name = "level")
   private String level;

   @Column(name = "rentprice")
    private int rentprice;

   @Column(name = "rentpricedescription", columnDefinition = "TEXT")
    private String rentPriceDescription;

   @Column(name = "servicefee")
    private String serviceFee;

   @Column(name = "carfee")
    private String carFee;

   @Column(name = "motorbikefee")
    private String motorbikeFee;

   @Column(name = "ovetimrfee")
    private String overtimeFee;

   @Column(name = "waterfee")
   private String waterFee;

   @Column(name = "electricfee")
    private String electricFee;

   @Column(name = "deposit")
    private String deposit;

   @Column(name = "payment")
    private String payment;

   @Column(name = "renttime")
   private String rentTime;

   @Column(name = "decorationtime")
   private String decorationTime;

   @Column(name = "brokeragefee")
    private Long brokeRageFess;

   @Column(name = "note")
    private String note;

   @Column(name = "linkofbuilding")
    private String linkOfbuilding;

   @Column(name = "map")
    private String map;

   @Column(name = "image")
    private String image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public DistrictEntity getDistrict() {
        return district;
    }

    public void setDistrict(DistrictEntity district) {
        this.district = district;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public int getNumberOfBasement() {
        return numberOfBasement;
    }

    public void setNumberOfBasement(int numberOfBasement) {
        this.numberOfBasement = numberOfBasement;
    }

    public int getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(int floorArea) {
        this.floorArea = floorArea;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getRentprice() {
        return rentprice;
    }

    public void setRentprice(int rentprice) {
        this.rentprice = rentprice;
    }

    public String getRentPriceDescription() {
        return rentPriceDescription;
    }

    public void setRentPriceDescription(String rentPriceDescription) {
        this.rentPriceDescription = rentPriceDescription;
    }

    public String getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
    }

    public String getCarFee() {
        return carFee;
    }

    public void setCarFee(String carFee) {
        this.carFee = carFee;
    }

    public String getMotorbikeFee() {
        return motorbikeFee;
    }

    public void setMotorbikeFee(String motorbikeFee) {
        this.motorbikeFee = motorbikeFee;
    }

    public String getOvertimeFee() {
        return overtimeFee;
    }

    public void setOvertimeFee(String overtimeFee) {
        this.overtimeFee = overtimeFee;
    }

    public String getWaterFee() {
        return waterFee;
    }

    public void setWaterFee(String waterFee) {
        this.waterFee = waterFee;
    }

    public String getElectricFee() {
        return electricFee;
    }

    public void setElectricFee(String electricFee) {
        this.electricFee = electricFee;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getRentTime() {
        return rentTime;
    }

    public void setRentTime(String rentTime) {
        this.rentTime = rentTime;
    }

    public String getDecorationTime() {
        return decorationTime;
    }

    public void setDecorationTime(String decorationTime) {
        this.decorationTime = decorationTime;
    }

    public Long getBrokeRageFess() {
        return brokeRageFess;
    }

    public void setBrokeRageFess(Long brokeRageFess) {
        this.brokeRageFess = brokeRageFess;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getLinkOfbuilding() {
        return linkOfbuilding;
    }

    public void setLinkOfbuilding(String linkOfbuilding) {
        this.linkOfbuilding = linkOfbuilding;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<RentAreaEntity> getAreas() {
        return areas;
    }

    public void setAreas(List<RentAreaEntity> areas) {
        this.areas = areas;
    }
}
