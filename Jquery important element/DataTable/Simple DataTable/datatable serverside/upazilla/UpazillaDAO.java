package com.revesoft.springboot.web.geo.upazilla;

import com.revesoft.springboot.web.geo.division.DivisionDTO;
import com.revesoft.springboot.web.geo.municipality.MunicipalityDAO;
import com.revesoft.springboot.web.geo.municipalityward.MunicipalityWardDAO;
import com.revesoft.springboot.web.geo.municipalityward.MunicipalityWardDTO;
import com.revesoft.springboot.web.model.Ministry;
import com.revesoft.springboot.web.model.SQLJsonData;
import com.revesoft.springboot.web.model.SQLStatementCreator;
import databasemanager.DatabaseManager;
import org.jose4j.json.internal.json_simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by reve on 10/26/2017.
 */

//id, geo_division_id, geo_district_id, division_bbs_code, district_bbs_code, upazilla_name_eng, upazilla_name_bng, bbs_code, status
@Repository
public class UpazillaDAO {

    private int id =-1;

    @Autowired

    private SQLStatementCreator sc;

    private int count =-1;

    public ArrayList<UpazillaDTO> getAllUpazilla() throws Exception{
        Connection con = null;
        PreparedStatement ps = null;
        String sql = null;

        ArrayList<UpazillaDTO> upazillaList = new ArrayList<>();
        try{
            con = DatabaseManager.getInstance().getConnection();
            sql = "select * from geo_upazilas";
            ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

            while(resultSet.next()){
                upazillaList.add(new UpazillaDTO(resultSet.getInt("id"),
                        resultSet.getInt("geo_division_id"),
                        resultSet.getInt("geo_district_id"),
                        resultSet.getString("division_bbs_code"),
                        resultSet.getString("district_bbs_code"),
                        resultSet.getString("upazila_name_eng"),
                        resultSet.getString("upazila_name_bng"),
                        resultSet.getString("bbs_code"),
                        resultSet.getInt("status")));
            }
        }
        catch (Exception ex){
            System.out.println("Exception " + ex);
        } finally {
            if(ps != null)ps.close();
            if(con != null)con.close();
        }
        return upazillaList;
    }

    //@Razin
    public UpazillaDTO getUpazillabyId(int id) throws Exception{
        Connection con = null;
        PreparedStatement ps = null;

        String sql = null;
        try{
            con = DatabaseManager.getInstance().getConnection();
            sql = "select * from geo_upazilas where id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet resultSet = ps.executeQuery();

            while(resultSet.next()){

                return new UpazillaDTO(resultSet.getInt("id"),
                        resultSet.getInt("geo_division_id"),
                        resultSet.getInt("geo_district_id"),
                        resultSet.getString("division_bbs_code"),
                        resultSet.getString("district_bbs_code"),
                        resultSet.getString("upazila_name_eng"),
                        resultSet.getString("upazila_name_bng"),
                        resultSet.getString("bbs_code"),
                        resultSet.getInt("status"));

            }
        }
        catch (Exception ex){
            System.out.println("Exception " + ex);
        } finally {
            if(ps != null)ps.close();
            if(con != null)con.close();
        }
        return  new UpazillaDTO();
    }

    public ArrayList<UpazillaDTO> getUpazillaListbyDistrictId(int districtId) throws Exception{
        Connection con = null;
        PreparedStatement ps = null;
        ArrayList<UpazillaDTO> upazillaList = new ArrayList<>();
        String sql = null;
        try{
            con = DatabaseManager.getInstance().getConnection();
            sql = "select * from geo_upazilas where geo_district_id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1,districtId);
            ResultSet resultSet = ps.executeQuery();

            while(resultSet.next()){

                upazillaList.add(new UpazillaDTO(resultSet.getInt("id"),
                        resultSet.getInt("geo_division_id"),
                        resultSet.getInt("geo_district_id"),
                        resultSet.getString("division_bbs_code"),
                        resultSet.getString("district_bbs_code"),
                        resultSet.getString("upazila_name_eng"),
                        resultSet.getString("upazila_name_bng"),
                        resultSet.getString("bbs_code"),
                        resultSet.getInt("status")));

            }
        }
        catch (Exception ex){
            System.out.println("Exception " + ex);
        } finally {
            if(ps != null)ps.close();
            if(con != null)con.close();
        }
        return  upazillaList;
    }

    public ArrayList<UpazillaDTO> getUpazillaListbyPage(int page, int pageSize) throws Exception{
        Connection con = null;
        PreparedStatement ps = null;
        String sql = null;

        ArrayList<UpazillaDTO> upazillaList = new ArrayList<>();
        try{
            con = DatabaseManager.getInstance().getConnection();
            sql = "select * from geo_upazilas limit "+(page-1)*pageSize+","+pageSize;
            ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

//            SQLStatementCreator sc = new SQLStatementCreator();
//            JSONObject js = new JSONObject();
//
//            js.put("geo_division_id",3);
//            js.put("geo_district_id",2);
//            js.put("division_bbs_code","56");
//            js.put("district_bbs_code","45");
//            js.put("upazila_name_eng","bbbbbb");
//            js.put("upazila_name_bng","ahare");
//            js.put("bbs_code","34");
//            js.put("status",0);
//            js.put("modified_by",2);
//            js.put("modified",java.sql.Timestamp.from(java.time.Instant.now()));
//            JSONObject wh = new JSONObject();
//            wh.put("id",700);
//            js.put("where",wh);
//            ps = sc.create(con,"delete","geo_upazilas",js);
//            ps.executeUpdate();


            while(resultSet.next()){
                upazillaList.add(new UpazillaDTO(resultSet.getInt("id"),
                        resultSet.getInt("geo_division_id"),
                        resultSet.getInt("geo_district_id"),
                        resultSet.getString("division_bbs_code"),
                        resultSet.getString("district_bbs_code"),
                        resultSet.getString("upazila_name_eng"),
                        resultSet.getString("upazila_name_bng"),
                        resultSet.getString("bbs_code"),
                        resultSet.getInt("status")));
            }
            count = sc.tableDatacount("geo_upazilas");
        }
        catch (Exception ex){
            System.out.println("Exception " + ex);
        } finally {
            if(ps != null)ps.close();
            if(con != null)con.close();
        }
        return upazillaList;
    }


    public ArrayList<UpazillaDTO> getUpazillaListbyPage(Integer pageNumber, int displayLength, String searchparameter) throws Exception{
        Connection con = null;
        ArrayList<UpazillaDTO> upazillaList = new ArrayList<>();
        try{

//            "SELECT  * FROM (" +
//                    "SELECT * FROM geo_unions WHERE upazila_name_eng LIKE '%"+searchparameter+"%' OR upazila_name_bng LIKE '%"+searchparameter+"%' OR bbs_code LIKE '%"+searchparameter+"%')" +
//                    "limit" +(page-1)*pageSize+","+pageSize

//            count = sc.tempTableDatacount( con,"SELECT  count(s.id) as size FROM (" +
//                            "SELECT id FROM geo_unions WHERE upazila_name_eng LIKE '%"+searchparameter+"%' OR upazila_name_bng LIKE '%"+searchparameter+"%' OR bbs_code LIKE '%"+searchparameter+"%')" +
//                            " As s");

            con = DatabaseManager.getInstance().getConnection();
            SQLJsonData js = new SQLJsonData();
            JSONObject or1 = new JSONObject();
            or1.put("upazila_name_eng","%"+searchparameter+"%");
            or1.put("upazila_name_bng","%"+searchparameter+"%");
            or1.put("bbs_code","%"+searchparameter+"%");
            js.addtoConditionORLike(
                    "or1",or1);
            js.addPage("page",(pageNumber-1)*displayLength,displayLength);
            count = sc.searchCount(con,"geo_upazilas",js);
            ResultSet resultSet = sc.search(con,"geo_upazilas", js);

            while(resultSet.next()){
                upazillaList.add(new UpazillaDTO(resultSet.getInt("id"),
                        resultSet.getInt("geo_division_id"),
                        resultSet.getInt("geo_district_id"),
                        resultSet.getString("division_bbs_code"),
                        resultSet.getString("district_bbs_code"),
                        resultSet.getString("upazila_name_eng"),
                        resultSet.getString("upazila_name_bng"),
                        resultSet.getString("bbs_code"),
                        resultSet.getInt("status")));
            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        } finally {
            if(sc.ps != null)sc.ps.close();
            if(con != null)con.close();
        }
        return upazillaList;
    }

    public ArrayList<UpazillaDTO> getUpazillaListbyPage(Integer pageNumber, int displayLength, String[] searchparameter) throws Exception {
        Connection con = null;
        ArrayList<UpazillaDTO> upazillaList = new ArrayList<>();
        String condition ="";
        SQLJsonData js = new SQLJsonData();
        try{

            int searchParamSize = searchparameter.length;
            for(int i=0;i<searchParamSize;i++){
                String s = searchparameter[i];
                if(!s.equals("null") && !s.equals("-1") && !s.equals("")){

                    switch (i){
//                        case 0:
//                            JSONObject or1 = new JSONObject();
//                            or1.put("upazila_name_eng","%"+searchparameter[0]+"%");
//                            or1.put("upazila_name_bng","%"+searchparameter[0]+"%");
//                            js.addtoConditionORLike("or1",or1);
//                            break;
//                        case 1:
//                            js.addtoConditionANDLike("bbs_code","%"+searchparameter[1]+"%");
//                            break;
                        case 0:
                            js.addtoConditionANDEquall("geo_division_id",Integer.parseInt(searchparameter[0]));
                            break;
                        case 1:
                            js.addtoConditionANDEquall("geo_district_id",Integer.parseInt(searchparameter[1]));
                            break;
                    }
                }
            }
            con = DatabaseManager.getInstance().getConnection();
            js.addPage("page",(pageNumber-1)*displayLength,displayLength);
            count = sc.searchCount(con,"geo_upazilas",js);
            ResultSet resultSet =sc.search(con,"geo_upazilas",js);
            while(resultSet.next()){
                upazillaList.add(new UpazillaDTO(resultSet.getInt("id"),
                        resultSet.getInt("geo_division_id"),
                        resultSet.getInt("geo_district_id"),
                        resultSet.getString("division_bbs_code"),
                        resultSet.getString("district_bbs_code"),
                        resultSet.getString("upazila_name_eng"),
                        resultSet.getString("upazila_name_bng"),
                        resultSet.getString("bbs_code"),
                        resultSet.getInt("status")));
            }
        }
        catch (Exception ex){
           ex.printStackTrace();
        } finally {
            if(sc.ps != null)sc.ps.close();
            if(con != null)con.close();
        }
        return upazillaList;
    }
    //@Razin
    public void add(UpazillaDTO upazilla) throws Exception{
        String sql = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con= DatabaseManager.getInstance().getConnection();

            sql = "insert into geo_upazilas(id, geo_division_id, geo_district_id, division_bbs_code, district_bbs_code, upazila_name_eng, upazila_name_bng, bbs_code, status, created_by, created, modified) values(?,?,?,?,?,?,?,?,?,?,?,?)";
            ps=con.prepareStatement(sql);

            long ID = DatabaseManager.getInstance().getNextSequenceId("geo_upazilas");
            //appMenuDTO.id= ID;

            id = (int)ID;
            int k=0;

            ps.setInt(++k,id);
            ps.setInt(++k,upazilla.getGeoDivisionId());
            ps.setInt(++k,upazilla.getGeoDistrictId());
            ps.setString(++k,upazilla.getDivisionBbsCode());
            ps.setString(++k,upazilla.getDistrictBbsCode());
            ps.setString(++k,upazilla.getUpazillaNameEng());
            ps.setString(++k,upazilla.getUpazillaNameBng());
            ps.setString(++k,upazilla.getBbsCode());
            ps.setInt(++k,1);
            ps.setInt(++k,upazilla.getCreatedBy());
            ps.setTimestamp(++k, java.sql.Timestamp.from(java.time.Instant.now()));
            ps.setTimestamp(++k, java.sql.Timestamp.from(java.time.Instant.now()));
            ps.executeUpdate();


        }catch (Exception e){
            e.printStackTrace();
        } finally {
            if(ps != null)ps.close();
            if(con != null)con.close();
        }
    }

    //@Razin
    public void edit(UpazillaDTO upazilla) throws Exception{
        String sql = null;
        Connection con = null;
        PreparedStatement ps = null;
        try {

            con = DatabaseManager.getInstance().getConnection();
            sql = "Update geo_upazilas SET geo_division_id=?, geo_district_id=?, division_bbs_code=?, district_bbs_code=?, upazila_name_eng=?, upazila_name_bng=?, bbs_code=?, status=?, modified_by=?, modified=? WHERE id = ?";
            ps = con.prepareStatement(sql);

            int k=0;
            ps.setInt(++k,upazilla.getGeoDivisionId());
            ps.setInt(++k,upazilla.getGeoDistrictId());
            ps.setString(++k,upazilla.getDivisionBbsCode());
            ps.setString(++k,upazilla.getDistrictBbsCode());
            ps.setString(++k,upazilla.getUpazillaNameEng());
            ps.setString(++k,upazilla.getUpazillaNameBng());
            ps.setString(++k,upazilla.getBbsCode());
            ps.setInt(++k,1);
            ps.setInt(++k,upazilla.getModifiedBy());
            ps.setTimestamp(++k, java.sql.Timestamp.from(java.time.Instant.now()));
            ps.setInt(++k,upazilla.getId());
            ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(ps != null)ps.close();
            if(con != null)con.close();
        }
    }

    //@Razin
    public void delete(int id) throws Exception{
        String sql = null;
        Connection con = null;
        PreparedStatement ps = null;
        try {

            con = DatabaseManager.getInstance().getConnection();
            sql = "Update geo_upazilas SET status=?, modified_by=?, modified=? WHERE id = ?";
            ps = con.prepareStatement(sql);

            int k=0;
            ps.setInt(++k,0);
            ps.setInt(++k,1);
            ps.setTimestamp(++k, java.sql.Timestamp.from(java.time.Instant.now()));
            ps.setInt(++k,id);
            ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(ps != null)ps.close();
            if(con != null)con.close();
        }

    }

    public int getId(){
        return id;
    }

    public ArrayList<UpazillaDTO> getUpazillaListByDistrictIds(int[] ids) throws Exception{
        ArrayList<UpazillaDTO> upazillaDTOS = new ArrayList<>();
        ResultSet resultSet=null;
        String condition = null;
        Connection con=null;
        try {
            con = DatabaseManager.getInstance().getConnection();
            condition = ""; //geo_upazila_id =? or geo_upazila_id=? or geo_upazila_id=?";

            for(int i=0;i<ids.length;i++){
                if(i<ids.length-1)condition += " i:geo_district_id =  "+ids[i]+" or";
                else condition += " i:geo_district_id = "+ids[i];
            }
            SQLJsonData data =new SQLJsonData();
            data.add("all","");
            resultSet =  sc.select(con,"geo_upazilas", data, condition);
            while(resultSet.next()){
                upazillaDTOS.add(new UpazillaDTO(resultSet.getInt("id"),
                        resultSet.getInt("geo_division_id"),
                        resultSet.getInt("geo_district_id"),
                        resultSet.getString("division_bbs_code"),
                        resultSet.getString("district_bbs_code"),
                        resultSet.getString("upazila_name_eng"),
                        resultSet.getString("upazila_name_bng"),
                        resultSet.getString("bbs_code"),
                        resultSet.getInt("status")));

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(sc.ps!=null)sc.ps.close();
            if(con!=null)con.close();
        }
        return upazillaDTOS;
    }


    public int nextgroup(Connection cn){


        //PreparedStatement ps = null;

        int groupid=0;
        PreparedStatement stmt = null;
        ResultSet rs=null;
        String sql=" Select group_id from geo_history order by desc limit 1";
        try {

            stmt = cn.prepareStatement(sql);
            rs=stmt.executeQuery();
            while (rs.next()){
                groupid=rs.getInt("group_id");

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return groupid+1;

    }

    public Statement statementAdder(Statement stmt,int parentId,int userId, ArrayList<Integer> sourceMuniListId,ArrayList<Integer>sourceUnionListId)throws Exception{

        if(sourceUnionListId.size()>0) {
            for (int unionId:sourceUnionListId) {

                long ID = DatabaseManager.getInstance().getNextSequenceId("geo_history");
                String q16 = "insert into geo_history (id,parent_id,source_id,name_eng,name_bng,bbs_code,status,created_by,modified_by," +
                        "created,modified,expired_by )" +
                        " select " + ID +  " , geo_upazila_id,id,union_name_eng,union_name_bng,bbs_code,status,created_by,modified_by,created,modified,"
                        + userId +
                        " from geo_unions where id = " + unionId ;
                stmt.addBatch(q16);

                String q17 = " insert into geo_mappings(geo_history_id,geo_current_id,geo_current_type,geo_source_type) " +
                        " select " +ID+ ",geo_unions.id ,6,6 from geo_unions" +
                        " where geo_unions.id = " + unionId ;
                stmt.addBatch(q17);


                String q18 = "  update geo_unions set geo_upazila_id= " + parentId +
                        " where id = " + unionId ;
                stmt.addBatch(q18);

            }
        }

        if(sourceMuniListId.size()>0) {

            // int groupid=nextgroup(cn);

            for (int muniId:sourceMuniListId) {

                long ID = DatabaseManager.getInstance().getNextSequenceId("geo_history");
                String q19 = "insert into geo_history (id,parent_id,source_id,name_eng,name_bng,bbs_code,status,created_by" +
                        ",modified_by,created,modified,expired_by)" +
                        " select " +ID+ " , geo_upazila_id,id,municipality_name_eng,municipality_name_bng,bbs_code,status,created_by,modified_by,created,modified, " + userId +
                        " from geo_municipalities where id = " +muniId ;
                stmt.addBatch(q19);

                String q20 = " insert into geo_mappings ( geo_history_id,geo_current_id,geo_current_type,geo_source_type)" +
                        " select "+ ID+ " ,geo_municipalities.id,7,7 from geo_municipalities " +
                        " where geo_municipalities.id = " + muniId ;
                stmt.addBatch(q20);


                String q21 = "update geo_municipalities set geo_upazila_id = " + parentId +
                        " where id = " + muniId ;
                stmt.addBatch(q21);
//
//
                //muni ward


                int count=new MunicipalityWardDAO().getMunicipalityWardCount(muniId);
                ArrayList<Long> wardIds=new ArrayList<>();
                ArrayList<MunicipalityWardDTO> wordLists = new MunicipalityWardDAO().getMunicipalityWardListByMunicipalityId(muniId);
                for(int i=1;i<=count;i++){
                    long IDs=DatabaseManager.getInstance().getNextSequenceId("geo_history");
                    wardIds.add(IDs);
                }
                int i=0;

                for (Long wardId:wardIds) {

                    //long wid=DatabaseManager.getInstance().getNextSequenceId("geo_history");

                    String q22 = " insert into geo_history ( id ,parent_id,source_id,name_eng,name_bng,bbs_code,status,created_by," +
                            "modified_by,created,modified,expired_by)" +
                            " select " +wardId+ " , geo_municipality_id,id ,ward_name_eng,ward_name_bng,bbs_code,status,created_by,modified_by,created,modified," + userId +
                            " from geo_municipality_wards where id = " + wordLists.get(i).getId();
                    stmt.addBatch(q22);
                    String q23 = " insert into geo_mappings(geo_history_id,geo_current_id,geo_current_type,geo_source_type)" +
                            " select "+wardId+ ",geo_municipality_wards.id,10,10 from geo_municipality_wards " +
                            " where geo_municipality_wards.id  = " +  wordLists.get(i).getId();
                    stmt.addBatch(q23);
                    String q24 = " update geo_municipality_wards set geo_upazila_id = " + parentId +
                            " where id  = " +  wordLists.get(i).getId() ;
                    stmt.addBatch(q24);
                    i++;

                }


            }

        }

        return stmt;




    }


    public boolean changeTotalGeoUpazila
            (int parentId, int userId, ArrayList<Integer> sourceMuniListId,ArrayList<Integer>sourceUnionListId,
             ArrayList<Integer> sourceUpaId)
            throws Exception {


        Connection cn = null;
        //PreparedStatement ps = null;
        boolean res=false;

        Statement stmt = null;
        String param=" ";


        try {
            cn = DatabaseManager.getInstance().getConnection();
            stmt = cn.createStatement();
            cn.setAutoCommit(false);

            stmt=statementAdder(stmt,parentId,userId,sourceMuniListId,sourceUnionListId);


            stmt.executeBatch();
            res=true;
            cn.commit();


        } catch (Exception e) {
            cn.rollback();
            res=false;
            e.printStackTrace();
        } finally {
            if (stmt != null) stmt.close();
            if (cn != null) cn.close();
        }

        return res;
    }

    public int getCount() {
        return count;
    }



}
