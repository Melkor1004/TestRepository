package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.buildingForSearch.BuildingSearch;
import com.laptrinhjavaweb.entity.BuildingEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class BuildingRepositoryCustom implements IBuildingRepositoryCustom{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<BuildingEntity> findAllCustom(BuildingSearch building) {
        return null;
    }

    //Test native sql, print native sql in console
    @Override
    public String printStringSql(BuildingSearch building) {
        /*Query query = entityManager.createNativeQuery(renderNativeSql(building),BuildingEntity.class);*/
        return renderNativeSql(building);
    }

    //Build the query naturally
    String renderNativeSql(BuildingSearch building){
        //initialize value of defalut sql
        StringBuilder sqlDefault = new StringBuilder("select b.name, b.ward, b.street, d.name from building b");
        //initialize value of condition of sql
        StringBuilder condition = new StringBuilder(" where 1 = 1");

        //condition of building
        if(building.getNameBuilding() != null && building.getNameBuilding() != ""){
            condition.append(" and b.name like '%" + building.getNameBuilding() + "%'");
        }
        if(building.getStreet() != null && building.getStreet() != ""){
            condition.append(" and b.street like '%" + building.getStreet() + "%'");
        }
        if(building.getWard() != null && building.getWard() != ""){
            condition.append(" and b.ward like '%" + building.getWard() + "%'");
        }
        if(building.getRentPriceFrom() != null && building.getRentPriceTo() != null){
            condition.append(" and ( b.rentprice between "+ building.getRentPriceFrom() +" and "+ building.getRentPriceTo() +")");
        }
        else if(building.getRentPriceFrom() != null){
            condition.append(" and b.rentprice >= "+ building.getRentPriceFrom() +"");
        }
        else if(building.getRentPriceTo() != null){
            condition.append(" and b.rentprice <= "+ building.getRentPriceTo() +"");
        }

        //condition of rentarea
        if(building.getRentareaFrom() != null && building.getRentareaTo() != null){
            condition.append(" and EXISTS (SELECT * FROM rentarea ra WHERE ra.buildingid = b.id and ra.value BETWEEN "+ building.getRentareaFrom() +" AND "+ building.getRentareaTo() +")");
        }
        else if(building.getRentareaFrom() != null){
            condition.append(" and EXISTS (SELECT * FROM rentarea ra WHERE ra.buildingid = b.id and ra.value >= "+ building.getRentareaFrom() +")");
        }
        else if(building.getRentareaTo() != null){
            condition.append(" and EXISTS (SELECT * FROM rentarea ra WHERE ra.buildingid = b.id and ra.value <= "+ building.getRentareaTo() +")");
        }

        //condition of district
        if(building.getDistrict() != null){
            //create relationship
            sqlDefault.append(" inner join district d on d.id = b.districtid");
            //add condition
            condition.append(" and d.code like '%" + building.getDistrict() + "%'");
        }

        //condition of asignmentBuilding to find staffId
        if(building.getStaffId() != null){
            //create relationship
            sqlDefault.append(" inner join assignmentbuilding ab on b.id = ab.buildingid");
            //add condition
            condition.append(" and ab.staffid = " + building.getStaffId());
        }

        //condition of renttype
        if(building.getRenttype() != null){
            //create relationship
            sqlDefault.append(" inner join buildingrenttype bt on b.id = bt.buildingid");
            sqlDefault.append(" inner join renttype rt on bt.renttypeid = rt.id");
            //add condition
            StringBuilder subCondition = new StringBuilder(" and rt.code in (");
            for(int i = 0; i < building.getRenttype().length; i ++){
                subCondition.append("'" + building.getRenttype()[i] + "'");
                if(i < building.getRenttype().length - 1){
                    subCondition.append(",");
                }
            }
            subCondition.append(")");

            condition.append(subCondition);
        }

        //merge all sql into only one query
        StringBuilder lastSql = sqlDefault.append(condition).append(" group by b.id;");

        return lastSql.toString();
    }

    //Build the query by JPQL
    String renderJPQL(BuildingSearch building){

        StringBuilder jpqlDefalut = new StringBuilder("FROM BuildingEntity b");
        StringBuilder conditionJpql = new StringBuilder("where 1 = 1");

        //condition of building
        if(building.getNameBuilding() != null && building.getNameBuilding() != ""){
            conditionJpql.append(" and b.name like '%" + building.getNameBuilding() + "%'");
        }
        if(building.getStreet() != null && building.getStreet() != ""){
            conditionJpql.append(" and b.street like '%" + building.getStreet() + "%'");
        }
        if(building.getWard() != null && building.getWard() != ""){
            conditionJpql.append(" and b.wark like '%" + building.getWard() + "%'");
        }
        if(building.getRentPriceFrom() != null && building.getRentPriceTo() != null){
            conditionJpql.append(" and ( b.rentprice between "+ building.getRentPriceFrom() +" and "+ building.getRentPriceTo() +")");
        }
        else if(building.getRentPriceFrom() != null){
            conditionJpql.append(" and b.rentprice >= "+ building.getRentPriceFrom() +"");
        }
        else if(building.getRentPriceTo() != null){
            conditionJpql.append(" and b.rentprice <= "+ building.getRentPriceTo() +"");
        }

        //condition of rentarea
        if(building.getRentareaFrom() != null && building.getRentareaTo() != null){
            conditionJpql.append(" and EXISTS (SELECT * FROM RentAreaEntity ra WHERE ra.buildingid = b.id and ra.value BETWEEN "+ building.getRentareaFrom() +" AND "+ building.getRentareaTo() +")");
        }
        else if(building.getRentareaFrom() != null){
            conditionJpql.append(" and EXISTS (SELECT * FROM RentAreaEntity ra WHERE ra.buildingid = b.id and ra.value >= "+ building.getRentareaFrom() +"");
        }
        else if(building.getRentareaTo() != null){
            conditionJpql.append(" and EXISTS (SELECT * FROM RentAreaEntity ra WHERE ra.buildingid = b.id and ra.value <= "+ building.getRentareaTo() +"");
        }

        //condition of district
        if(building.getDistrict() != null){
            //create relationship
            jpqlDefalut.append(" join b.district d");
            //add condition
            conditionJpql.append(" and d.code like '%" + building.getDistrict() + "%'");
        }

        //condition of assignmentBuilding to find staffId
        if(building.getStaffId() != null){
            //create relationship
            jpqlDefalut.append(" join b.asignmentBuildings ab");
            //add condition
            conditionJpql.append(" and ab.staff");
        }

        //merge all into only one query
        StringBuilder lastJpql = jpqlDefalut.append(conditionJpql).append(" group by b.id");

        //example of stream
        List<Integer> listInt = new ArrayList<>();

        Stream<Integer> stream = listInt.stream();
        List<Integer> evenNumber = stream.filter(p -> p%2 == 0).collect(Collectors.toList());

        Stream listStream = evenNumber.stream();
        listStream.forEach(p -> System.out.println(p));

        return lastJpql.toString();
    }


}


