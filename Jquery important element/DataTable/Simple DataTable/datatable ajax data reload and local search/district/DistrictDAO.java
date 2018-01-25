package com.revesoft.springboot.web.geo.district;

import com.revesoft.springboot.web.geo.citycorporation.CityCorporationDTO;
import com.revesoft.springboot.web.geo.division.DivisionDTO;
import com.revesoft.springboot.web.geo.municipality.MunicipalityDAO;
import com.revesoft.springboot.web.geo.municipality.MunicipalityDTO;
import com.revesoft.springboot.web.geo.postoffice.PostOfficeDTO;
import com.revesoft.springboot.web.geo.thana.ThanaDTO;
import com.revesoft.springboot.web.geo.union.UnionDAO;
import com.revesoft.springboot.web.geo.union.UnionDTO;
import com.revesoft.springboot.web.geo.upazilla.UpazillaDAO;
import com.revesoft.springboot.web.geo.upazilla.UpazillaDTO;
import com.revesoft.springboot.web.model.SQLJsonData;
import com.revesoft.springboot.web.model.SQLStatementCreator;
import com.revesoft.springboot.web.util.AllTable;
import com.revesoft.springboot.web.util.BatchStatementAdder;
import databasemanager.DatabaseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
@Repository
public class DistrictDAO {

    SQLStatementCreator sc = new SQLStatementCreator();

    @Autowired
    BatchStatementAdder batchStatementAdder;


    public DistrictDTO dtoSetter( ResultSet rs) throws Exception{


        DistrictDTO districtDTO=new DistrictDTO();

        districtDTO.setId(rs.getInt("id"));
        districtDTO.setDivisionId(rs.getInt("geo_division_id"));
        districtDTO.setDivisionBBSCode(rs.getString("division_bbs_code"));
        districtDTO.setDistrictNameEng(rs.getString("district_name_eng"));
        districtDTO.setDistrictNameBng(rs.getString("district_name_bng"));
        districtDTO.setBbsCode(rs.getString("bbs_code"));
        districtDTO.setStatus(rs.getInt("status"));
        return  districtDTO;
    }



    public ArrayList<DistrictDTO> getAll() throws Exception {
        ArrayList<DistrictDTO> data = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from " + AllTable.TBL_GEO_DISTRICT+ " where status=1";
        try {
            connection = DatabaseManager.getInstance().getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                DistrictDTO districtDTO = dtoSetter(rs);

                data.add(districtDTO);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (ps != null) ps.close();
            if (connection != null) connection.close();
        }

        return data;

    }

    public ArrayList<DistrictDTO> get(int divisionId) throws Exception {
        ArrayList<DistrictDTO> data = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from " + AllTable.TBL_GEO_DISTRICT+  " where geo_division_id=? and status=1";
        try {
            connection = DatabaseManager.getInstance().getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, divisionId);
            rs = ps.executeQuery();
            while (rs.next()) {
                DistrictDTO districtDTO = dtoSetter(rs);
                data.add(districtDTO);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (ps != null) ps.close();
            if (connection != null) connection.close();
        }

        return data;

    }

    public ArrayList<DistrictDTO> getCityDis(int divisionId) throws Exception {
        ArrayList<DistrictDTO> data = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from " +AllTable.TBL_GEO_DISTRICT+  " d INNER JOIN "  + AllTable.TBL_GEO_CITY_CORP+ " c on " +
                " d.id=c.geo_district_id where " +
                " d.geo_division_id=? and d.status=1 ";
        try {
            connection = DatabaseManager.getInstance().getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, divisionId);
            rs = ps.executeQuery();
            while (rs.next()) {
                DistrictDTO districtDTO = dtoSetter(rs);
                data.add(districtDTO);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (ps != null) ps.close();
            if (connection != null) connection.close();
        }
        return data;

    }

    public DistrictDTO getDistrict(int id) throws SQLException {
        DistrictDTO districtDTO = new DistrictDTO();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from " +AllTable.TBL_GEO_DISTRICT+  " where id=? and status=1 ";
        try {
            connection = DatabaseManager.getInstance().getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                districtDTO = dtoSetter(rs);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (ps != null) ps.close();
            if (connection != null) connection.close();
        }

        return districtDTO;
    }

    public void addDistrict(DistrictDTO districtDTO) throws SQLException {

        Connection cn = null;
        PreparedStatement ps = null;
        // ResultSet rs = null;
        String sql = null;
        long ID;
        try {
            cn = DatabaseManager.getInstance().getConnection();
            ID=DatabaseManager.getInstance().getNextSequenceId(AllTable.TBL_GEO_DISTRICT);
            sql = " insert into " +AllTable.TBL_GEO_DISTRICT+
                    " (id, geo_division_id,division_bbs_code,district_name_eng,district_name_bng,bbs_code,status,created_by,created) " +
                    " values (?,?,?,?,?,?,?,?,?)";
            ps = cn.prepareStatement(sql);
            int k = 0;
            ps.setLong(++k,ID);
            ps.setInt(++k, districtDTO.getDivisionId());
            ps.setString(++k, districtDTO.getDivisionBBSCode());
            ps.setString(++k, districtDTO.getDistrictNameEng());
            ps.setString(++k, districtDTO.getDistrictNameBng());
            ps.setString(++k, districtDTO.getBbsCode());
            ps.setInt(++k, districtDTO.getStatus());
            ps.setInt(++k, districtDTO.getCreatedBy());
            ps.setString(++k, districtDTO.getCreated());

            ps.executeUpdate();


        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (ps != null) ps.close();
            if (cn != null) cn.close();
        }


    }

    public void updateDistrict(DistrictDTO districtDTO) throws Exception {

        Connection cn = null;
        PreparedStatement ps = null;
        // ResultSet rs = null;
        String sql = null;
        long ID;
        try {
            cn = DatabaseManager.getInstance().getConnection();
            sql = "update " +AllTable.TBL_GEO_DISTRICT+
                    " set geo_division_id=?,division_bbs_code=?,district_name_eng=?,district_name_bng=?,bbs_code=?,modified_by=? ,modified=? where id=?";
            ps = cn.prepareStatement(sql);
            int k = 0;
            ps.setInt(++k, districtDTO.getDivisionId());
            ps.setString(++k, districtDTO.getDivisionBBSCode());
            ps.setString(++k, districtDTO.getDistrictNameEng());
            ps.setString(++k, districtDTO.getDistrictNameBng());
            ps.setString(++k, districtDTO.getBbsCode());

            ps.setInt(++k, districtDTO.getModifiedBy());
            ps.setString(++k, districtDTO.getModified());
            ps.setInt(++k, districtDTO.getId());

            ps.executeUpdate();


        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            if (ps != null) ps.close();
            if (cn != null) cn.close();
        }
    }

    public void deleteDistrict(int id)throws Exception {

        Connection cn = null;
        PreparedStatement ps = null;
        // ResultSet rs = null;
        String sql = null;
        long ID;
        try {
            cn = DatabaseManager.getInstance().getConnection();
            sql = "update " +AllTable.TBL_GEO_DISTRICT+ " set status=0 where id=? ";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            if (ps != null) ps.close();
            if (cn != null) cn.close();
        }

    }

    public ArrayList<DistrictDTO> getDistrictListByDivisionIds(int[] ids) throws Exception {

        ArrayList<DistrictDTO> districtDTOS = new ArrayList<>();
        ResultSet rs = null;
        String condition = null;
        Connection con = null;
        try {
            con = DatabaseManager.getInstance().getConnection();
            condition = ""; //geo_upazila_id =? or geo_upazila_id=? or geo_upazila_id=?";

            for (int i = 0; i < ids.length; i++) {
                if (i < ids.length - 1) condition += " i:geo_division_id =  " + ids[i] + " or";
                else condition += " i:geo_division_id = " + ids[i];
            }
            SQLJsonData data = new SQLJsonData();
            data.add("all", "");
            rs = sc.select(con, AllTable.TBL_GEO_DISTRICT, data, condition);
            while (rs.next()) {
                DistrictDTO districtDTO = dtoSetter(rs);

                districtDTOS.add(districtDTO);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sc.ps != null) sc.ps.close();
            if (con != null) con.close();
        }
        return districtDTOS;
    }

    public void changeTotalGeoCity
            (int parentId, int userId, ArrayList<Integer> sourceListId, ArrayList<Integer> sourceDisId,
             int sourceType, int destType) throws Exception {


        Connection cn = null;
        //PreparedStatement ps = null;

        Statement stmt = null;

        StringBuilder builder = new StringBuilder();
        String parentName="geo_district_id";

        for (int i = 0; i < sourceListId.size(); i++) {
            builder.append(sourceListId.get(i) + ",");
        }
        ArrayList<CityCorporationDTO>citys=new ArrayList<>();
        for (int id:sourceListId
             ) {
            CityCorporationDTO cityCorporationDTO=new CityCorporationDTO();
            cityCorporationDTO.setId(id);
            citys.add(cityCorporationDTO);



        }
        String param = builder.deleteCharAt(builder.length() - 1).toString();
        try {
            cn = DatabaseManager.getInstance().getConnection();
            stmt = cn.createStatement();
            cn.setAutoCommit(false);

            for (int disid:sourceDisId) {

                stmt = batchStatementAdder.cityStatementAdd(stmt, parentName, parentId, userId, citys);
            }


            stmt.executeBatch();
            cn.commit();


        } catch (Exception e) {
            cn.rollback();
            e.printStackTrace();
        } finally {
            if (stmt != null) stmt.close();
            if (cn != null) cn.close();
        }

    }


    public void changeTotalGeoUpazilla
            (int parentId, int userId, ArrayList<Integer> sourceListId, ArrayList<Integer> sourceDisId,
             int sourceType, int destType) throws Exception {

        Connection cn = null;
        Statement stmt = null;
        String parentName="geo_district_id";

        ArrayList<UpazillaDTO>upazilas=new ArrayList<>();

        for (int id:sourceListId
                ) {
            UpazillaDTO upazillaDTO=new UpazillaDTO();
            upazillaDTO.setId(id);
            upazilas.add(upazillaDTO);

        }

        try {
            cn = DatabaseManager.getInstance().getConnection();
            stmt = cn.createStatement();
            cn.setAutoCommit(false);

           if(sourceListId.size()>0){
               for( int disid:sourceDisId){

                   stmt=batchStatementAdder.upazilaStatementAdd(stmt,parentName,parentId,userId,upazilas);
               }
           }

            stmt.executeBatch();
            cn.commit();
        } catch (Exception e) {
            cn.rollback();
            e.printStackTrace();
        } finally {
            if (stmt != null) stmt.close();
            if (cn != null) cn.close();
        }

    }

    public void changeTotalGeoThana
            (int parentId, int userId, ArrayList<Integer> sourceListId, ArrayList<Integer> sourceDisId,
             int sourceType, int destType) throws Exception {


        Connection cn = null;
        //PreparedStatement ps = null;

        Statement stmt = null;

        String parentName="geo_district_id";

        ArrayList<ThanaDTO>thanas=new ArrayList<>();
        for (int id:sourceListId
                ) {
            ThanaDTO thanaDTO=new ThanaDTO();
            thanaDTO.setId(id);
            thanas.add(thanaDTO);

        }


        try {
            cn = DatabaseManager.getInstance().getConnection();
            stmt = cn.createStatement();
            cn.setAutoCommit(false);

            if(sourceListId.size()>0){
                for( int disid:sourceDisId){

                    stmt=batchStatementAdder.thanaStatementAdd(stmt,parentName,parentId,userId,thanas);
                }
            }


            stmt.executeBatch();
            cn.commit();


        } catch (Exception e) {
            cn.rollback();
            e.printStackTrace();
        } finally {
            if (stmt != null) stmt.close();
            if (cn != null) cn.close();
        }

    }

    public void changeTotalGeoPost
            (int parentId, int userId, ArrayList<Integer> sourceListId, ArrayList<Integer> sourceDisId,
             int sourceType, int destType ) throws Exception {


        Connection cn = null;
        //PreparedStatement ps = null;

        Statement stmt = null;

        String parentName="geo_district_id";

        ArrayList<PostOfficeDTO>postOfficeDTOS=new ArrayList<>();
        for (int id:sourceListId
                ) {
            PostOfficeDTO postOfficeDTO=new PostOfficeDTO();
            postOfficeDTO.setId(id);
            postOfficeDTOS.add(postOfficeDTO);

        }

        try {
            cn = DatabaseManager.getInstance().getConnection();
            stmt = cn.createStatement();
            cn.setAutoCommit(false);

            //district history

            if(sourceListId.size()>0){
                for( int disid:sourceDisId){

                    stmt=batchStatementAdder.postStatementAdd(stmt,parentName,parentId,userId,postOfficeDTOS);
                }
            }


            stmt.executeBatch();
            cn.commit();


        } catch (Exception e) {
            cn.rollback();
            e.printStackTrace();
        } finally {
            if (stmt != null) stmt.close();
            if (cn != null) cn.close();
        }

    }
}
