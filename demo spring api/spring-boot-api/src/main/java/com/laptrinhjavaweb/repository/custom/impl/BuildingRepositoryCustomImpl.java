package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.custom.IBuildingRepositoryCustom;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BuildingRepositoryCustomImpl implements IBuildingRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<BuildingEntity> findAll(String nameOfBuilding, String streetOfBuilding, Integer rentpriceFrom, Integer rentpriceTo,
                                        String codeOfDistrict, String[] codeOfRenttype, Long staffId,
                                        Integer rentAreaValueTo,
                                        Integer rentAreaValueFrom) {


        StringBuilder sql = new StringBuilder("SELECT  b.name, b.ward, b.street, d.name from building b");
        StringBuilder condition = new StringBuilder(" where 1 = 1");

        if(nameOfBuilding != null && nameOfBuilding != ""){
            condition.append(" and b.name like '%" + nameOfBuilding + "'%");
        }

        if(streetOfBuilding != null && streetOfBuilding != ""){
            condition.append(" and b.street like '%" + streetOfBuilding +"'%");
        }

        if(rentpriceFrom != null && rentpriceTo != null){
            condition.append(" and (b.rentprice > " + rentpriceFrom +" and b.rentprice < "+ rentpriceTo +")");
        }
        else if (rentpriceFrom != null){
            condition.append(" and b.rentprice > " + rentpriceFrom);
        }
        else if(rentpriceTo != null){
            condition.append(" and b.rentprice < " + rentpriceTo);
        }

        if(codeOfDistrict != null){
            sql.append(" inner join district on b.districtid = district.id");
            condition.append(" and district.code like '"+ codeOfDistrict +"'");
        }

        if (staffId != null){
            sql.append(" inner join assignmentbuilding on b.id = assignmentbuilding.buildingid");
            condition.append(" and assignmentbuilding.staffid = "+ staffId +"");
        }

        if(rentAreaValueFrom != null && rentAreaValueTo != null){
            condition.append("exists (select * from rentarea where b.id = rentarea.buildingid and (rentarea.value > "+ rentAreaValueFrom +" and rentarea.value <= "+ rentAreaValueTo +"))");
        }
        else if (rentAreaValueFrom != null){
            condition.append("exists (select * from rentarea where b.id = rentarea.buildingid and (rentarea.value > "+ rentAreaValueFrom + ")");
        }
        else if(rentAreaValueTo != null){
            condition.append("exists (select * from rentarea where b.id = rentarea.buildingid and (rentarea.value < "+ rentAreaValueFrom + ")");
        }

        if(codeOfRenttype.length > 0){
            sql.append(" inner join buildingrenttype on b.id = buildingrenttype.buildingid " +
                    "inner join renttype on rennttype.id = buildingrenttype.renttypeid");

            StringBuilder subSql = new StringBuilder(" and renttype.code in (");
            for(int i = 0; i < codeOfRenttype.length; i++){
               subSql.append(codeOfRenttype[i]);
               if(i < codeOfRenttype.length - 1){ subSql.append(","); }
            }

            condition.append(subSql);
        }

        StringBuilder finalQuery = sql.append(condition).append(" groupby b.id");
        String stringQuery = finalQuery.toString();

        Query query = entityManager.createNativeQuery(stringQuery,BuildingEntity.class);

        return query.getResultList();
    }
}
