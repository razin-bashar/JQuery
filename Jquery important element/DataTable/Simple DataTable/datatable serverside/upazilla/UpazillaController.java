package com.revesoft.springboot.web.geo.upazilla;

import com.revesoft.springboot.web.geo.district.DistrictDTO;
import com.revesoft.springboot.web.geo.district.DistrictService;
import com.revesoft.springboot.web.geo.division.DivisionDTO;
import com.revesoft.springboot.web.geo.division.DivisionService;
import com.revesoft.springboot.web.geo.history.HistoryService;
import com.revesoft.springboot.web.geo.policy.GeoPolicyDTO;
import com.revesoft.springboot.web.geo.policy.GeoPolicyService;
import com.revesoft.springboot.web.geo.union.UnionService;
import com.revesoft.springboot.web.model.SQLStatementCreator;
import org.jose4j.json.internal.json_simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.ArrayList;

/**
 * Created by reve on 10/30/2017.
 */
@RestController
public class UpazillaController {
    @Autowired
    DivisionService divisionService;
    @Autowired
    DistrictService districtService;
    @Autowired
    UpazillaService upazillaService;
    @Autowired
    HistoryService historyService;

    @RequestMapping(value = "/upazillalist", method = RequestMethod.GET)
    public ModelAndView upazillaShow(HttpServletRequest request,@RequestParam int menuid) {
        ModelAndView upazillaShow = new ModelAndView("geo/upazilla/upazillalist");
        request.getSession().setAttribute("upazillamenuid",menuid);
        upazillaShow.addObject("menuid",menuid);
        return upazillaShow;
    }


    @RequestMapping(value = "/upazillapagedata", method = RequestMethod.GET)
    @ResponseBody
    JSONObject upazillaPage(HttpServletRequest request, HttpServletResponse response) throws Exception{

        int displayLength=1;
        if(request.getParameter("iDisplayLength") !=null)displayLength = Integer.valueOf(request.getParameter("iDisplayLength"));
        Integer pageNumber = 0;
        if (null != request.getParameter("iDisplayStart"))
            pageNumber = (Integer.valueOf(request.getParameter("iDisplayStart"))/displayLength)+1;


        //Fetch search parameter
        String searchParameterEncode = request.getParameter("sSearch");

        ArrayList<UpazillaDTO> listUpazilla = null;

        if(!searchParameterEncode.equals(";")&& searchParameterEncode.contains(";")) {
            String[] searchparameter = searchParameterEncode.split(";");

            int parameterSizeLength = searchparameter.length;
            if(parameterSizeLength>1){
                listUpazilla = upazillaService.getUpazillaListbyPage(pageNumber, displayLength,searchparameter);
            }
            else {
                listUpazilla = upazillaService.getUpazillaListbyPage(pageNumber, displayLength, searchparameter[0]);
            }
        }
        else {

            listUpazilla = upazillaService.getUpazillaListbyPage(pageNumber, displayLength);

        }

//
//        //Fetch search parameter
//        String searchParameter = request.getParameter("sSearch");
//        Integer pageDisplayLength =0;
//        //Fetch Page display length
//        if(request.getParameter("iDisplayLength") !=null)pageDisplayLength = Integer.valueOf(request.getParameter("iDisplayLength"));
//
//
//
//        if(pageDisplayLength == 0 || pageDisplayLength==null)listUpazilla = upazillaService.getUpazillaListbyPage(1,10);
//        else listUpazilla = upazillaService.getUpazillaListbyPage(pageNumber,pageDisplayLength);
//
//        UpazillaDTO list2[] = new UpazillaDTO[listUpazilla.size()];
//        list2 = listUpazilla.toArray(list2);
//
//        JSONObject obj=new JSONObject();
//        obj.put("iTotalRecords",new SQLStatementCreator().tableDatacount("geo_upazilas"));
//        obj.put("iTotalDisplayRecords",new SQLStatementCreator().tableDatacount("geo_upazilas"));
//        obj.put("aaData",list2);
//        //return list2;
        JSONObject obj=new JSONObject();
        obj.put("iTotalRecords", upazillaService.getCount());
        obj.put("iTotalDisplayRecords", upazillaService.getCount());
        obj.put("aaData", listUpazilla);
        return obj;
    }

    @RequestMapping(value = "/upazillaadd", method = RequestMethod.GET)
    ModelAndView addUpazillaView (){
        ModelAndView addUpazillaForm = new ModelAndView("geo/upazilla/upazillaadd");
        ArrayList<DivisionDTO>divisionList=divisionService.getDivisionData();
        addUpazillaForm.addObject("division", divisionList);
        return addUpazillaForm;
    }
    @RequestMapping(value = "/addupazilla",method = RequestMethod.POST)
    public RedirectView addUpazilla(HttpServletRequest request, Principal principal, RedirectAttributes rattrs, @RequestParam String upazillanameeng,
                                    @RequestParam String upazillanamebng,
                                    @RequestParam String upazillabbscode,
                                    @RequestParam String divisionbbscode,
                                    @RequestParam String districtbbscode,
                                    @RequestParam int divdata,
                                    @RequestParam int disdata){
        UpazillaDTO upazilla = new UpazillaDTO();
        upazilla.setUpazillaNameEng(upazillanameeng);
        upazilla.setUpazillaNameBng(upazillanamebng);
        upazilla.setBbsCode(upazillabbscode);
        upazilla.setGeoDivisionId(divdata);
        upazilla.setGeoDistrictId(disdata);
        upazilla.setDivisionBbsCode(divisionbbscode);
        upazilla.setDistrictBbsCode(districtbbscode);
        upazilla.setCreatedBy(1);
        upazillaService.addUpazilla(upazilla);

        RedirectView rd=new RedirectView("upazillalist?menuid="+request.getSession().getAttribute("upazillamenuid"));
        return rd;

    }




    @RequestMapping(value = "/upazillaedit",method = RequestMethod.POST)
    ModelAndView editUpazillaView (Principal principal,
                                   @RequestParam int id,
                                   @RequestParam String upazillanameeng,
                                   @RequestParam String upazillanamebng,
                                   @RequestParam String upazillabbscode,
                                   @RequestParam String divisionbbscode,
                                   @RequestParam String districtbbscode,
                                   @RequestParam int divId,
                                   @RequestParam int disId){
        ModelAndView editUpazillaForm = new ModelAndView("geo/upazilla/upazillaedit");

        UpazillaDTO upazilla = new UpazillaDTO();
        upazilla.setId(id);
        upazilla.setUpazillaNameEng(upazillanameeng);
        upazilla.setUpazillaNameBng(upazillanamebng);
        upazilla.setBbsCode(upazillabbscode);
        upazilla.setDivisionBbsCode(divisionbbscode);
        upazilla.setDistrictBbsCode(districtbbscode);
        upazilla.setGeoDivisionId(divId);
        upazilla.setGeoDistrictId(disId);


        ArrayList<DivisionDTO>divisionList=divisionService.getDivisionData();
        editUpazillaForm.addObject("division", divisionList);

        ArrayList<DistrictDTO>districtList = districtService.getDivWiseDistrict(divId);
        editUpazillaForm.addObject("district", districtList);
        editUpazillaForm.addObject("upazilla", upazilla);
        return editUpazillaForm;
    }

    @RequestMapping(value = "/editupazilla",method = RequestMethod.POST)
    RedirectView editUpazilla (HttpServletRequest request, Principal principal,
                               @RequestParam int id,
                               @RequestParam String upazillanameeng,
                               @RequestParam String upazillanamebng,
                               @RequestParam String upazillabbscode,
                               @RequestParam String divisionbbscode,
                               @RequestParam String districtbbscode,
                               @RequestParam int divdata,
                               @RequestParam int disdata) {


        UpazillaDTO upazilla = new UpazillaDTO();
        upazilla.setId(id);
        upazilla.setUpazillaNameEng(upazillanameeng);
        upazilla.setUpazillaNameBng(upazillanamebng);
        upazilla.setBbsCode(upazillabbscode);
        upazilla.setDivisionBbsCode(divisionbbscode);
        upazilla.setDistrictBbsCode(districtbbscode);
        upazilla.setGeoDivisionId(divdata);
        upazilla.setGeoDistrictId(disdata);
        upazilla.setModifiedBy(1);
        upazillaService.editUpazilla(upazilla);
        RedirectView rd=new RedirectView("upazillalist?menuid="+request.getSession().getAttribute("upazillamenuid"));
        return rd;

    }

    @RequestMapping(value = "/upazilladelete",method = RequestMethod.POST)
    void deleteUpazilla (Principal principal,
                                 @RequestParam int id
    ) {

        upazillaService.deleteUpazilla(id);

    }

    @RequestMapping(value = "/upazillalistbydistrictid",method = RequestMethod.POST)
    @ResponseBody
    ArrayList<UpazillaDTO> upazillaListByDistrictId (Principal principal,
                               @RequestParam int id) {

        ArrayList<UpazillaDTO> upazillaListbyDistrictId = upazillaService.getUpazillaListbyDistrictId(id);
        return upazillaListbyDistrictId;

    }

    @RequestMapping(value = "/getupazilalistbydistrictids",method = RequestMethod.POST)
    ArrayList<UpazillaDTO>getUpazillaListByDistrictIds(@RequestParam(value="id[]")int[]ids){
        ArrayList<UpazillaDTO> upazillaDTOS = null;
        upazillaDTOS = upazillaService.getUpazillaListByDistrictIds(ids);
        return upazillaDTOS;
    }

    @RequestMapping(value = "upazillaassign", method = RequestMethod.GET)
    ModelAndView upazillaAssignForm(){
        ModelAndView form =new ModelAndView("geo/upazilla/upazillaassign");
        form.addObject("division",divisionService.getDivisionData());
        return form;
    }
    @RequestMapping(value = "assignupazilla", method = RequestMethod.POST)
    RedirectView upazillaAssign(HttpServletRequest request, @RequestParam int divdata, @RequestParam int disdata, @RequestParam int upadata, @RequestParam(value = "parentid[]")int[] upazillaIds,@RequestParam(value = "childid[]")String[] childIds){
        ArrayList<Integer> municipalityIds = new ArrayList<>();
        ArrayList<Integer> unionIds = new ArrayList<>();
        ArrayList<Integer> upaIds = new ArrayList<>();
        for(int i=0;i<childIds.length;i++){
            String content = childIds[i];
            String[] splited = content.split(":");
            int geotype = Integer.parseInt(splited[2]);
            int id = Integer.parseInt(splited[1]);
            if(geotype == 6 )unionIds.add(id);
            else if(geotype ==7 )municipalityIds.add(id);
        }
        for(int i=0;i<upazillaIds.length;i++){

            upaIds.add(upazillaIds[i]);
        }

        upazillaService.upazillaAssign(upadata, upaIds, unionIds, municipalityIds);
        RedirectView rd=new RedirectView("upazillalist?menuid="+request.getSession().getAttribute("upazillamenuid"));
        return rd;
    }

    @RequestMapping(value = "upazillahistory",method = RequestMethod.GET)
    ModelAndView upzillahistoryHistory(@RequestParam int id, @RequestParam String name){
        ModelAndView form = null;
        form = new ModelAndView("geo/upazilla/upazillahistory");
        form.addObject("id",id);
        form.addObject("name",name);
//        form.addObject("label","<h3><span class=\"label label-info\">"+name+"</span>\n" +
//                "                                        <span class=\"label label-danger\">"+":"+"</span>\n" +
//                "                                        <span class=\"label label-default\">"+"\n" +
//                "উপজেলা"+"</span></h3>");
//        form.addObject("currentchain",upazillaService.currentChain(id,name));
//        form.addObject("childdetail",upazillaService.childDetail(id,name));
//        form.addObject("parentdetail",upazillaService.parentDetail(id,name));

        return form;
    }

    @RequestMapping(value = "historyupazilla",method = RequestMethod.GET)
    JSONObject historyUpazilla(@RequestParam int id){
//        ModelAndView form = null;
//        form = new ModelAndView("geo/upazilla/upazillahistory");
//        form.addObject("label","<h3><span class=\"label label-info\">"+name+"</span>\n" +
//                "                                        <span class=\"label label-danger\">"+":"+"</span>\n" +
//                "                                        <span class=\"label label-default\">"+"\n" +
//                "উপজেলা"+"</span></h3>");
//        form.addObject("currentchain",upazillaService.currentChain(id,name));
//        form.addObject("childdetail",upazillaService.childDetail(id,name));
//        form.addObject("parentdetail",upazillaService.parentDetail(id,name));
        JSONObject js  = new JSONObject();
        js.put("cc",historyService.currentChain(id,3));
        js.put("cd",historyService.getChildDetail(id,3));
        js.put("pd",historyService.getParentDetail(id,3));
        return js;

    }
}
