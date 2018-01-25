package com.revesoft.springboot.web.geo.division;

import com.revesoft.springboot.web.geo.history.GenericDTO;
import com.revesoft.springboot.web.geo.history.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Bony on 10/22/2017.
 */
@Service
public class DivisionService {
    @Autowired
    DivisionDAO divisionDAO;
    public ArrayList<DivisionDTO> getDivisionData(){

        ArrayList<DivisionDTO>data=new ArrayList<>();
        try {
            data=divisionDAO.getAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }
    public DivisionDTO getDivisionService(int id){

        DivisionDTO data=new DivisionDTO();
        try {
            data=divisionDAO.get(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }
    public boolean Add(DivisionDTO divisionDTO)
    {
        boolean success=false;
        try {
            success=divisionDAO.add(divisionDTO);
        }catch (Exception e){
            e.printStackTrace();
        }
        return success;
    }
    public void changeTotalGeoService
            (int divId,int userId,ArrayList<Integer>disId,ArrayList<Integer> sourceDivId ,int sourceType,int destType) throws Exception {
        try {
            divisionDAO.changeTotalGeo(divId,userId,disId,sourceDivId,sourceType,destType);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean update(DivisionDTO divisionDTO,int userId)
    {
        boolean success=false;
        try {
            success=divisionDAO.update(divisionDTO,userId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return success;
    }
    public boolean delete(DivisionDTO divisionDTO)
    {
        boolean success=false;
        try {
            success=divisionDAO.delete(divisionDTO);
        }catch (Exception e){
            e.printStackTrace();
        }
        return success;
    }

    public long getNextID()
    {
        long id=-1;
        try {
            id=divisionDAO.idGen();
        }catch (Exception e){
            e.printStackTrace();
        }
        return id;
    }
    public String consistOf(int id) {
            HistoryService historyService = new HistoryService();
            ArrayList<GenericDTO> genericDTOS= historyService.getChildDetail(id,1);
            Map<Integer,List<GenericDTO>> list = new HashMap<Integer,List<GenericDTO>>();
            for(int i =0; i<genericDTOS.size(); i++) {
                GenericDTO genericDTO = genericDTOS.get(i);
                List <GenericDTO> temp = list.get(genericDTO.getDivisionId());
                if(temp!=null) {
                    temp.add(genericDTO);
                    list.put(genericDTO.getDivisionId(),temp);
                }
                else {
                    List<GenericDTO> l = new ArrayList<>();
                    l.add(genericDTO);
                    list.put(genericDTO.getDivisionId(),l);
                }
            }
            String fromWhomDivisionBuildUp ="বিভাগটি <br/><ul style=margin-left:5px;>";
            int len = list.size();
            int k=0;
            for (Map.Entry<Integer, List<GenericDTO>> entry : list.entrySet())
            {
                System.out.println(entry.getKey() + "/" + entry.getValue());
                List<GenericDTO> l = entry.getValue();
                fromWhomDivisionBuildUp += "<li> "+l.get(0).getDivisionName()+" বিভাগের<ul>";
                for(int i=0;i<l.size();i++) {
                    fromWhomDivisionBuildUp +="<li>"+l.get(i).getDistrictName()+"</li>";
                }
                if((len-2)!=k++)fromWhomDivisionBuildUp +="জেলা </ul></li>";
                else fromWhomDivisionBuildUp +="জেলা এবং </ul></li>";

            }
            fromWhomDivisionBuildUp +=" </ul>নিয়ে গঠিত হয়েছিল।";
            return fromWhomDivisionBuildUp;

    }
}
