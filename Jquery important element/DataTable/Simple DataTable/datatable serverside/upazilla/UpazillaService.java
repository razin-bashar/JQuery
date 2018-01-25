package com.revesoft.springboot.web.geo.upazilla;

import com.revesoft.springboot.web.geo.history.GenericDTO;
import com.revesoft.springboot.web.geo.history.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by reve on 10/26/2017.
 */
@Service
public class UpazillaService {
    @Autowired
    UpazillaDAO upazillaDAO;
    public UpazillaService() {
        upazillaDAO = new UpazillaDAO();
    }

    public ArrayList<UpazillaDTO> getUpazillaListbyPage(int pageNumber, int displayLength) {
        ArrayList<UpazillaDTO> upazillaDTOS = null;
        try {
            upazillaDTOS = upazillaDAO.getUpazillaListbyPage(pageNumber,displayLength);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return upazillaDTOS;
    }

    public ArrayList<UpazillaDTO> getUpazillaListbyPage(Integer pageNumber, int displayLength, String[] searchparameter) {
        ArrayList<UpazillaDTO> upazillaDTOS = null;
        try {
            upazillaDTOS = upazillaDAO.getUpazillaListbyPage(pageNumber,displayLength,searchparameter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return upazillaDTOS;
    }

    public ArrayList<UpazillaDTO> getUpazillaListbyPage(Integer pageNumber, int displayLength, String searchparameter) {
        ArrayList<UpazillaDTO> upazillaDTOS = null;
        try {
            upazillaDTOS = upazillaDAO.getUpazillaListbyPage(pageNumber,displayLength,searchparameter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return upazillaDTOS;
    }
    public int getCount() {

        return upazillaDAO.getCount();


    }
    public ArrayList<UpazillaDTO> getUpazillaListbyDistrictId(int districtId) {
        try {
            return upazillaDAO.getUpazillaListbyDistrictId(districtId);
        } catch (Exception e) {
           e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void addUpazilla(UpazillaDTO upazillaDTO) {
        try {

           // return upazillaDAO.add(upazillaDTO);

           // return upazillaDAO.add(upazillaDTO);

            upazillaDAO.add(upazillaDTO);

        } catch (Exception e) {
           e.printStackTrace();
        }

    }



    public void editUpazilla(UpazillaDTO upazillaDTO) {
        try {
            upazillaDAO.edit(upazillaDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deleteUpazilla(int id) {
        try {
            upazillaDAO.delete(id);
        } catch (Exception e) {
           e.printStackTrace();
        }

    }

    public int getId(){
        return upazillaDAO.getId();
    }


    public ArrayList<UpazillaDTO> getUpazillaListByDistrictIds(int[] ids) {
        ArrayList<UpazillaDTO> upazillaDTOS = null;
        try {
            upazillaDTOS = upazillaDAO.getUpazillaListByDistrictIds(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return upazillaDTOS;
    }

    public void upazillaAssign(){

    }

    public void upazillaAssign(int upadata, ArrayList<Integer> upaIds, ArrayList<Integer> unionIds, ArrayList<Integer> municipalityIds) {
        try {
            upazillaDAO.changeTotalGeoUpazila(upadata, 1,  municipalityIds, unionIds, upaIds);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String currentChain(int id, String name) {
        HistoryService historyService = new HistoryService();
        GenericDTO genericDTO = historyService.currentChain(id,3 );
        String presentCondition ="বর্তমান অবস্থা : <br/><br/> উপজেলাটি <a href=\"#\">"+genericDTO.getDistrictName()+"</a>";
        presentCondition += "জেলার অধীনে আছে এবং <a href=\"#\">"+genericDTO.getDivisionName()+" </a>";
        presentCondition += " বিভাগের অন্তর্ভুক্ত।";
        return presentCondition;
    }

    public String childDetail(int id, String name) {
        HistoryService historyService = new HistoryService();
        ArrayList<GenericDTO> genericDTOS= historyService.getChildDetail(id,3);
        Map<Integer,List<GenericDTO>> unolist = new HashMap<Integer,List<GenericDTO>>();
        Map<Integer,List<GenericDTO>> munilist = new HashMap<Integer,List<GenericDTO>>();
        for(int i =0; i<genericDTOS.size(); i++) {
            GenericDTO genericDTO = genericDTOS.get(i);
            if(genericDTO.getTypeName().equals("6")) {
                List<GenericDTO> temp = unolist.get(genericDTO.getDistrictId());
                if (temp != null) {
                    temp.add(genericDTO);
                    unolist.put(genericDTO.getDistrictId(), temp);
                } else {
                    List<GenericDTO> l = new ArrayList<>();
                    l.add(genericDTO);
                    unolist.put(genericDTO.getDistrictId(), l);
                }
            }
            else{
                List<GenericDTO> temp = munilist.get(genericDTO.getDistrictId());
                if (temp != null) {
                    temp.add(genericDTO);
                    munilist.put(genericDTO.getDistrictId(), temp);
                } else {
                    List<GenericDTO> l = new ArrayList<>();
                    l.add(genericDTO);
                    munilist.put(genericDTO.getDistrictId(), l);
                }
            }
        }
        String fromWhomDistrictBuildUp ="উপজেলাটি  <br/><ul style=margin-left:5px;>";
        int len = unolist.size();
        int k=0;
        for (Map.Entry<Integer, List<GenericDTO>> entry : unolist.entrySet())
        {
            System.out.println(entry.getKey() + "/" + entry.getValue());
            List<GenericDTO> l = entry.getValue();
            fromWhomDistrictBuildUp += "<li> "+l.get(0).getDivisionName()+" বিভাগের "+l.get(0).getDistrictName()+" জেলার "+l.get(0).getUpazilaName()+" উপজেলার <ul>";
            for(int i=0;i<l.size();i++) {
                fromWhomDistrictBuildUp +="<li>"+l.get(i).getUnionName()+"</li>";
            }
            if((len-2)!=k++)fromWhomDistrictBuildUp +="ইউনিয়ন </ul></li>";
            else fromWhomDistrictBuildUp +="ইউনিয়ন এবং </ul></li>";

        }
        len = munilist.size();
        k=0;
        for (Map.Entry<Integer, List<GenericDTO>> entry : munilist.entrySet())
        {
            System.out.println(entry.getKey() + "/" + entry.getValue());
            List<GenericDTO> l = entry.getValue();
            fromWhomDistrictBuildUp += "<li> "+l.get(0).getDivisionName()+" বিভাগের "+l.get(0).getDistrictName()+" জেলার "+l.get(0).getUpazilaName()+" উপজেলার <ul>";
            for(int i=0;i<l.size();i++) {
                fromWhomDistrictBuildUp +="<li>"+l.get(i).getMunicipalityName()+"</li>";
            }
           // if((len-2)!=k++)fromWhomDistrictBuildUp +="পৌরসভা </ul></li>";
           // else fromWhomDistrictBuildUp +="পৌরসভা এবং </ul></li>";

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

        if(previous.getUpazilaName().equals(current.getUpazilaName()))binarySentence +="1";
        else binarySentence +="0";


       /* if(binarySentence.charAt(0)=='0'){
            exactSentence += current.getDivisionName()+" বিভাগের অন্তর্ভুক্ত ";
            if(binarySentence.charAt(1)=='1')exactSentence += current.getDistrictName()+" জেলার অধীনে ";
        }

        if(binarySentence.charAt(1)=='0'){
            if(binarySentence.charAt(0)=='1')exactSentence += current.getDivisionName()+" বিভাগের অন্তর্ভুক্ত ";
            exactSentence += current.getDistrictName()+" জেলার অধীনে ";
        }

        if(binarySentence.charAt(2)=='0')exactSentence += current.getUpazilaName()+" নামে ";*/
        if(binarySentence.contains("0")){
            exactSentence += current.getDivisionName()+" বিভাগের "+ current.getDistrictName()+" জেলার অধীনে " + current.getUpazilaName()+" নামে ";
        }
        exactSentence += "ছিল। ";

        return exactSentence;

    }

    public String parentDetail(int id, String name) {
        String parentDetail ="উপজেলাটি ";
        HistoryService historyService = new HistoryService();
        GenericDTO currentinfo = historyService.currentChain(id,3 );
        ArrayList<GenericDTO> genericDTOS= historyService.getParentDetail(id,3);
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
