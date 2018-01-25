package com.revesoft.springboot.web.geo.division;

import com.revesoft.springboot.web.geo.district.DistrictDTO;
import com.revesoft.springboot.web.geo.municipality.MunicipalityDTO;
import com.revesoft.springboot.web.geo.municipality.MunicipalityService;
import com.revesoft.springboot.web.geo.municipalityward.MunicipalityWardDAO;
import com.revesoft.springboot.web.geo.municipalityward.MunicipalityWardDTO;
import com.revesoft.springboot.web.geo.union.UnionDTO;
import com.revesoft.springboot.web.geo.union.UnionService;
import com.revesoft.springboot.web.geo.upazilla.UpazillaDTO;
import com.revesoft.springboot.web.geo.upazilla.UpazillaService;
import com.revesoft.springboot.web.util.AllTable;
import com.revesoft.springboot.web.util.BatchStatementAdder;
import com.revesoft.springboot.web.util.GeoPolicy;
import com.sun.org.apache.regexp.internal.RE;
import databasemanager.DatabaseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Bony on 10/22/2017.
 */
@Repository
public class DivisionDAO {
    private int id=-1;
    @Autowired
    BatchStatementAdder batchStatementAdder;

//    @Autowired
//    UpazillaService upazillaService;
//    @Autowired
//    UnionService unionService;
//    @Autowired
//    MunicipalityService municipalityService;





    private DivisionDTO dtoSetter(DivisionDTO divisionDTO, ResultSet rs) throws Exception{
        divisionDTO.setId(rs.getInt("id"));
        divisionDTO.setDivisionName(rs.getString("division_name_eng"));
        divisionDTO.setDivisionNameBng(rs.getString("division_name_bng"));
        divisionDTO.setBbsCode(rs.getString("bbs_code"));
        divisionDTO.setStatus(rs.getInt("status"));
        return divisionDTO;
    }


    public ArrayList<DivisionDTO> getAll() throws Exception{
        ArrayList<DivisionDTO> data=new ArrayList<>();
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="select * from " + AllTable.TBL_GEO_DIVISION+ " WHERE status=1";
        try {
            connection= DatabaseManager.getInstance().getConnection();
            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                DivisionDTO divisionDTO =new DivisionDTO();
                divisionDTO=dtoSetter(divisionDTO,rs);


                data.add(divisionDTO);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(ps != null)ps.close();
            if(connection != null)connection.close();
        }
        return data;

    }
    public DivisionDTO get(int id) throws Exception{
        DivisionDTO divisionDTO=new DivisionDTO();
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="select * from " +AllTable.TBL_GEO_DIVISION+  " where id=? and status=1";
        try {
            connection= DatabaseManager.getInstance().getConnection();
            ps=connection.prepareStatement(sql);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            while(rs.next()){
                divisionDTO=dtoSetter(divisionDTO,rs);

             }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(ps != null)ps.close();
            if(connection != null)connection.close();
        }
        return divisionDTO;

    }
    public long idGen()throws Exception{
        Connection cn = null;
        Long ID=null;
        String sql=null;
        try {
            cn = DatabaseManager.getInstance().getConnection();
            ID = DatabaseManager.getInstance().getNextSequenceId(AllTable.TBL_GEO_DIVISION);
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if(cn != null)cn.close();
        }
        return ID;

    }
    public boolean add(DivisionDTO  divisionDTO) throws Exception{
        boolean success=false;
        Connection cn = null;
        PreparedStatement ps = null;
        long ID=-1;
        // ResultSet rs = null;
        String sql=null;
        try {
            cn = DatabaseManager.getInstance().getConnection();
            sql = "insert into geo_divisions(id,bbs_code,division_name_eng,division_name_bng,status,created_by)" +
                    " values (?,?,?,?,?,?)";
            ps=cn.prepareStatement(sql);
             ID = DatabaseManager.getInstance().getNextSequenceId("geo_divisions");
            int k=0;
            ps.setLong(++k,ID);
            ps.setString(++k,divisionDTO.getBbsCode());
            ps.setString(++k,divisionDTO.getDivisionName());
            ps.setString(++k,divisionDTO.getDivisionNameBng());
            ps.setInt(++k,divisionDTO.getStatus());
            // ps.setInt(++k,1);
            ps.setInt(++k,divisionDTO.getCreatedBy());

            //rs.close();
            ps.executeUpdate();
            success=true;



        }catch (Exception ex){
            ex.printStackTrace();
            success=false;
        }finally {
            if(ps != null)ps.close();
            if(cn != null)cn.close();
        }
        return success;
    }

//    public void historyForEdit ( String tableName,int)

    public boolean update(DivisionDTO  divisionDTO,int userId) throws SQLException{
        boolean success;
        Connection cn = null;
        PreparedStatement ps = null;
        Statement history=null;
        Statement check=null;
        // ResultSet rs = null;
        String sql=null;
        long ID;
        try {
            cn = DatabaseManager.getInstance().getConnection();
  //          String q1 =  ;
            cn.setAutoCommit(false);
            history=cn.createStatement();
            check=cn.createStatement();
             String select=" Select * from";

            String q1 = " insert into geo_history (source_id,name_eng,name_bng,bbs_code,status,created_by,modified_by,created,modified,expired_by )" +
                    "select id,division_name_eng,division_name_bng,bbs_code,status,created_by,modified_by,created,modified," +
                    userId+" from geo_divisions where geo_divisions.id = " +divisionDTO.getId() ;
//            statement=cn.prepareStatement(q1);
            history.addBatch(q1);

//            String q2 = " ";




            history.executeBatch();
            sql = "UPDATE  geo_divisions set bbs_code=?,division_name_eng=?,division_name_bng=?,modified_by=?,modified=? where id=?";
            ps=cn.prepareStatement(sql);
            int k=0;

            ps.setString(++k,divisionDTO.getBbsCode());
            ps.setString(++k,divisionDTO.getDivisionName());
            ps.setString(++k,divisionDTO.getDivisionNameBng());
            // ps.setInt(++k,1);
            ps.setInt(++k,divisionDTO.getModifiedBy());
            ps.setString(++k,divisionDTO.getModified());
            ps.setInt(++k,divisionDTO.getId());

            //rs.close();
            ps.executeUpdate();
            cn.commit();
            success=true;



        }catch (Exception ex){
            ex.printStackTrace();
            success=false;
        }finally {
            if(ps != null)ps.close();
            if(cn != null)cn.close();
        }
        return success;
    }
    public boolean delete(DivisionDTO  divisionDTO) throws Exception{
        boolean success;
        Connection cn = null;
        PreparedStatement ps = null;
        // ResultSet rs = null;
        String sql=null;
        long ID;
        try {
            cn = DatabaseManager.getInstance().getConnection();
            sql = "UPDATE  geo_divisions set status=0,modified_by=?,modified=? where id=?";
            ps=cn.prepareStatement(sql);
            int k=0;

            ps.setInt(++k,divisionDTO.getModifiedBy());
            ps.setString(++k,divisionDTO.getModified());
            ps.setInt(++k,divisionDTO.getId());

            //rs.close();
            ps.executeUpdate();
            success=true;



        }catch (Exception ex){
            ex.printStackTrace();
            success=false;
        }finally {
            if(ps != null)ps.close();
            if(cn != null)cn.close();
        }
        return success;
    }



    public ArrayList<String> queryArray(int divId,ArrayList<Integer>disId){
        ArrayList<String>qArray=new ArrayList<>();
        int n=disId.size();
        StringBuilder builder = new StringBuilder();

        for( int i = 0 ; i < n; i++ ) {
            builder.append("?,");
        }
        String q1="insert into geo_history" +
                " (parent_id,source_id,name_eng,name_bng,bbs_code,status,created_by,modified_by,created,modified,expired_by,expired)" +
                "select geo_division_id,id,district_name_eng,district_name_bng,bbs_code,status,created_by,modified_by,created,modified,1,now()" +
                " from geo_districts where id in"+builder.deleteCharAt( builder.length() -1 ).toString();

        qArray.add(q1);
        String q2="insert into geo_mappings(geo_history_id,geo_current_id,geo_current_type,geo_source_type)"+
        "select geo_history.id,geo_districts.id,4,4 from geo_history,geo_districts"+
       "where geo_districts.id in"+ builder.deleteCharAt( builder.length() -1 ).toString()+ " and geo_districts.id=geo_history.source_id";
        qArray.add(q2);
        String q3="update geo_districts set geo_division_id=? where id  in"+builder.deleteCharAt( builder.length() -1 ).toString();
        return qArray;
    }


    public void checkDivhasDis(ArrayList<Integer>divList) throws  Exception{

        Connection cn = null;
        //PreparedStatement ps = null;

        PreparedStatement ps=null;
        PreparedStatement insert=null;

        ResultSet rs=null;

        //String countQ=null;
        
        try {
            cn=DatabaseManager.getInstance().getConnection();
            for (int i : divList) {

                String countQ = " select count(id) as cnt from geo_districts where geo_division_id=" + divList.get(i);
                ps=cn.prepareStatement(countQ);
                rs=ps.executeQuery();
                int size=0;
                while (rs.next())
                {
                    size=rs.getInt("cnt");


                }
                if(size>=1){
                    continue;

                } else {
                    String sq=" Update geo_divisions set status= 0 where id = "+divList.get(i);
                    insert=cn.prepareStatement(sq);
                    insert.executeUpdate();
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }





    public void changeTotalGeo
            (int divId,int userId,ArrayList<Integer>disId,ArrayList<Integer> sourceDivIds ,
             int sourceType,int destType) throws Exception{


        Connection cn = null;
        //PreparedStatement ps = null;

        Statement stmt=null;
        String parentName="geo_division_id";

        try{
            cn = DatabaseManager.getInstance().getConnection();
            stmt=cn.createStatement();
            cn.setAutoCommit(false);

            for (int divid:sourceDivIds) {
                stmt=batchStatementAdder.disStatementAdd(stmt,parentName,divId,userId,disId);

            }

            stmt.executeBatch();
            cn.commit();


        }catch (Exception e){
            cn.rollback();
            e.printStackTrace();
        }finally {
            if(stmt != null)stmt.close();
            if(cn != null)cn.close();
        }

    }
}
