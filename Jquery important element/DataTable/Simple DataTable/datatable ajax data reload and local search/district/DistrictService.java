package com.revesoft.springboot.web.geo.district;

import com.revesoft.springboot.web.geo.history.GenericDTO;
import com.revesoft.springboot.web.geo.history.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Bony on 10/26/2017.
 */
@Service
public class DistrictService {
    @Autowired
    private DistrictDAO districtDAO;
    public ArrayList<DistrictDTO> getAllDistrict(){
        ArrayList<DistrictDTO>data=new ArrayList<>();
        try{
            data=districtDAO.getAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;

    }
    public ArrayList<DistrictDTO> getDivWiseDistrict(int divisionId){
        ArrayList<DistrictDTO>data=new ArrayList<>();
        try{
            data=districtDAO.get(divisionId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;

    }
    public ArrayList<DistrictDTO> getDivWiseDistrictCity(int divisionId){
        ArrayList<DistrictDTO>data=new ArrayList<>();
        try{
            data=districtDAO.getCityDis(divisionId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;

    }
    public DistrictDTO getDistrict(int Id){
       DistrictDTO districtDTO=new DistrictDTO();
        try{
            districtDTO=districtDAO.getDistrict(Id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return districtDTO;

    }
    public void add(DistrictDTO districtDTO){

        try {
            districtDAO.addDistrict(districtDTO);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void update(DistrictDTO districtDTO){

        try {
            districtDAO.updateDistrict(districtDTO);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void delete(int id)
    {
        try {
            districtDAO.deleteDistrict(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public ArrayList<DistrictDTO> getDistrictListByDivisionIds(int[] ids) {
        ArrayList<DistrictDTO> districtDTOS =null;
        try {
            districtDTOS =districtDAO.getDistrictListByDivisionIds(ids);
        }catch (Exception e){
            e.printStackTrace();
        }
        return districtDTOS;
    }

    public void changeUpazilla(int parentId, int userId, ArrayList<Integer> sourceListId, ArrayList<Integer> sourceDisId,
                               int sourceType, int destType){
        try {
            districtDAO.changeTotalGeoUpazilla(parentId,userId,sourceListId,sourceDisId,sourceType,destType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void changeThana(int parentId, int userId, ArrayList<Integer> sourceListId, ArrayList<Integer> sourceDisId,
                             int sourceType, int destType){
        try {
            districtDAO.changeTotalGeoThana(parentId,userId,sourceListId,sourceDisId,sourceType,destType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String currentChain(int id){
        HistoryService historyService = new HistoryService();
        GenericDTO genericDTO = historyService.currentChain(id,2 );
        String presentCondition ="বর্তমান অবস্থা : <br/><br/> জেলাটি <a href=\"#\">"+genericDTO.getDivisionName()+"</a>";
        presentCondition += " বিভাগের অন্তর্ভুক্ত।";
        return presentCondition;
    }

    String childDetail(int id){
        HistoryService historyService = new HistoryService();
        ArrayList<GenericDTO> genericDTOS= historyService.getChildDetail(id,2);
        Map<Integer,List<GenericDTO>> upalist = new HashMap<Integer,List<GenericDTO>>();
        Map<Integer,List<GenericDTO>> thalist = new HashMap<Integer,List<GenericDTO>>();
        for(int i =0; i<genericDTOS.size(); i++) {
            GenericDTO genericDTO = genericDTOS.get(i);
            if(genericDTO.getTypeName().equals("3")) {
                List<GenericDTO> temp = upalist.get(genericDTO.getDistrictId());
                if (temp != null) {
                    temp.add(genericDTO);
                    upalist.put(genericDTO.getDistrictId(), temp);
                } else {
                    List<GenericDTO> l = new ArrayList<>();
                    l.add(genericDTO);
                    upalist.put(genericDTO.getDistrictId(), l);
                }
            }
            else{
                List<GenericDTO> temp = thalist.get(genericDTO.getDistrictId());
                if (temp != null) {
                    temp.add(genericDTO);
                    thalist.put(genericDTO.getDistrictId(), temp);
                } else {
                    List<GenericDTO> l = new ArrayList<>();
                    l.add(genericDTO);
                    thalist.put(genericDTO.getDistrictId(), l);
                }
            }
        }
        String fromWhomDistrictBuildUp ="জেলাটি  <br/><ul style=margin-left:5px;>";
        int len = upalist.size();
        int k=0;
        for (Map.Entry<Integer, List<GenericDTO>> entry : upalist.entrySet())
        {
            System.out.println(entry.getKey() + "/" + entry.getValue());
            List<GenericDTO> l = entry.getValue();
            fromWhomDistrictBuildUp += "<li> "+l.get(0).getDivisionName()+" বিভাগের "+l.get(0).getDistrictName()+" জেলার <ul>";
            for(int i=0;i<l.size();i++) {
                fromWhomDistrictBuildUp +="<li>"+l.get(i).getUpazilaName()+"</li>";
            }
            if((len-2)!=k++)fromWhomDistrictBuildUp +="উপজেলা </ul></li>";
            else fromWhomDistrictBuildUp +="উপজেলা এবং </ul></li>";

        }
        len = thalist.size();
        k=0;
        for (Map.Entry<Integer, List<GenericDTO>> entry : thalist.entrySet())
        {
            System.out.println(entry.getKey() + "/" + entry.getValue());
            List<GenericDTO> l = entry.getValue();
            fromWhomDistrictBuildUp += "<li> "+l.get(0).getDivisionName()+" বিভাগের "+l.get(0).getDistrictName()+" জেলার <ul>";
            for(int i=0;i<l.size();i++) {
                fromWhomDistrictBuildUp +="<li>"+l.get(i).getThanaName()+"</li>";
            }
            if((len-2)!=k++)fromWhomDistrictBuildUp +="থানা </ul></li>";
            else fromWhomDistrictBuildUp +="থানা এবং </ul></li>";

        }
        fromWhomDistrictBuildUp +=" </ul>নিয়ে গঠিত হয়েছিল।";
        return fromWhomDistrictBuildUp;
    }


    String makeSentence(GenericDTO previous, GenericDTO current){ // based on division,name,bbscode
        String binarySentence = "";
        String exactSentence = current.getFromDate()+" থেকে "+current.getToDate()+" পর্যন্ত ";
        if(previous.getDivisionName().equals(current.getDistrictName()))binarySentence +="1";
        else binarySentence +="0";

        if(previous.getDistrictName().equals(current.getDistrictName()))binarySentence +="1";
        else binarySentence +="0";


        if(binarySentence.charAt(0)=='0')exactSentence += current.getDivisionName()+" বিভাগের অধীনে ";
        if(binarySentence.charAt(1)=='0')exactSentence += current.getDistrictName()+" নামে ";
        exactSentence += "ছিল। ";

        return exactSentence;

    }
    String parentDetail(int id){
        String parentDetail ="জেলাটি ";
        HistoryService historyService = new HistoryService();
        GenericDTO currentinfo = historyService.currentChain(id,2 );
        ArrayList<GenericDTO> genericDTOS= historyService.getParentDetail(id,2);
        GenericDTO previousinfo = null;
        int len = genericDTOS.size();
        for(int i=0;i<len;i++){
            previousinfo = genericDTOS.get(i);
            if(i==len-1)parentDetail += makeSentence(currentinfo,previousinfo);
            else  parentDetail += makeSentence(currentinfo,previousinfo)+"<br/> এটার আগে  ";
            currentinfo = previousinfo;
        }
        return parentDetail;
    }
}
