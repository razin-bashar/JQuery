package com.revesoft.springboot.web.geo.division;


import com.revesoft.springboot.web.geo.history.GenericDTO;
import com.revesoft.springboot.web.geo.history.HistoryDTO;
import com.revesoft.springboot.web.geo.history.HistoryService;
import com.revesoft.springboot.web.model.SQLStatementCreator;
import org.jose4j.json.internal.json_simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Created by Bony on 10/30/2017.
 */
@RestController
public class DivisionController {

    @Autowired
    DivisionService divisionService;
    @RequestMapping(value="divisionlist",method = RequestMethod.GET)
    public ModelAndView getAllDivision(HttpServletRequest request, @RequestParam int menuid){
        ArrayList<DivisionDTO> data=divisionService.getDivisionData();
        ModelAndView modelAndView=new ModelAndView();
        request.getSession().setAttribute("divisionmenuid",menuid);
        modelAndView.addObject("list",data);
        modelAndView.addObject("menuid",menuid);
        modelAndView.setViewName("geo/division/divisionlist");
        return modelAndView;
    }

    @RequestMapping(value="divisiondata" ,method = RequestMethod.GET)
    @ResponseBody

    public ArrayList<DivisionDTO> getDiv(){
        return divisionService.getDivisionData();
    }



    @RequestMapping(path="divisionlistdata")
    @ResponseBody
    JSONObject divisionPage(HttpServletRequest request, HttpServletResponse response)throws Exception {

        Integer pageNumber = 0;
        if (null != request.getParameter("iDisplayStart"))
            pageNumber = (Integer.valueOf(request.getParameter("iDisplayStart"))/10)+1;

        //Fetch search parameter
        String searchParameter = request.getParameter("sSearch");
        Integer pageDisplayLength =0;
        //Fetch Page display length
        if(request.getParameter("iDisplayLength") !=null)pageDisplayLength = Integer.valueOf(request.getParameter("iDisplayLength"));

        ArrayList<DivisionDTO> List;

         List = divisionService.getDivisionData();


         int i=new SQLStatementCreator().tableDatacount("geo_divisions");
        JSONObject obj=new JSONObject();
        obj.put("iTotalRecords",i);
        obj.put("iTotalDisplayRecords",i);
        obj.put("aaData",List.toArray());
        //return list2;

        return obj;
    }

    @RequestMapping(value = "divisionadd",method = RequestMethod.GET)
    public ModelAndView addForm(HttpServletRequest request,HttpServletResponse response)
    {
        String url=request.getHeader("Referer");
        //Cookie cookie=new Cookie("url",url);
        //response.addCookie(cookie);
        return new ModelAndView("geo/division/divisionadd");
    }
    @RequestMapping(value = "divisionadd",method = RequestMethod.POST)
    public ModelAndView addDiv(HttpServletRequest request,HttpServletResponse response,
                               RedirectAttributes rattrs,@RequestParam String divnameeng,
                               @RequestParam String divnamebng,
                               @RequestParam String bbscode,
                               @RequestParam int status){

        DivisionDTO divisionDTO=new DivisionDTO();
        divisionDTO.setDivisionName(divnameeng);
        divisionDTO.setDivisionNameBng(divnamebng);
        divisionDTO.setBbsCode(bbscode);
        divisionDTO.setStatus(status);
        divisionDTO.setCreatedBy(1);
        divisionDTO.setCreated(LocalDateTime.now().toString());
        boolean Id = divisionService.Add(divisionDTO);

        //String url=response.g;

        ModelAndView  modelAndView=new ModelAndView();
        modelAndView.setViewName("redirect:divisionlist?menuid="+request.getSession().getAttribute("divisionmenuid"));

        //rattrs.addFlashAttribute("menuid",request.getSession().getAttribute("divisionmenuid"));
        return modelAndView;


       // return new RedirectView("");

    }

    @RequestMapping(value = "divisionedit",method = RequestMethod.POST)
    public ModelAndView editForm(@RequestParam int id,@RequestParam String divnameeng,
                                 @RequestParam String divnamebng,@RequestParam String bbscode,@RequestParam int status){
        DivisionDTO divisionDTO=new DivisionDTO();
        divisionDTO.setId(id);
        divisionDTO.setDivisionName(divnameeng);
        divisionDTO.setDivisionNameBng(divnamebng);
        divisionDTO.setBbsCode(bbscode);
        divisionDTO.setStatus(status);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("division",divisionDTO);
        modelAndView.setViewName("geo/division/divisionedit");
        return modelAndView;
    }
    @RequestMapping(value = "divisionupdate",method = RequestMethod.POST)
    @ResponseBody
    public RedirectView editDiv(HttpServletRequest request,@RequestParam int id,@RequestParam String divnameeng,@RequestParam String olddivnameeng,
                                @RequestParam String divnamebng,@RequestParam String olddivnamebng ,
                                @RequestParam String bbscode,@RequestParam String oldbbscode)
    {



        if(bbscode.equals(oldbbscode) && divnamebng.equals(olddivnamebng) && divnameeng.equals(olddivnameeng))
        {

            return new RedirectView("divisionlist?menuid="+request.getSession().getAttribute("divisionmenuid"));
        }
        else {
            DivisionDTO divisionDTO = new DivisionDTO();
            divisionDTO.setId(id);
            divisionDTO.setDivisionName(divnameeng);
            divisionDTO.setDivisionNameBng(divnamebng);
            divisionDTO.setBbsCode(bbscode);
            divisionDTO.setModifiedBy(1);
            divisionDTO.setModified(LocalDateTime.now().toString());
            boolean success = divisionService.update(divisionDTO, 1);
            return new RedirectView("divisionlist?menuid="+request.getSession().getAttribute("divisionmenuid"));
        }


    }
    @RequestMapping(value = "divisiondelete",method = RequestMethod.POST)
    public void deleteDiv(@RequestParam int id){


        DivisionDTO divisionDTO=new DivisionDTO();
        divisionDTO.setId(id);
        divisionDTO.setModifiedBy(1);
        divisionDTO.setModified(LocalDateTime.now().toString());
        boolean success=divisionService.delete(divisionDTO);

    }

    @RequestMapping(path = "test")
    public ArrayList<HistoryDTO> test(){
        DivisionDAO divisionDAO=new DivisionDAO();
        ArrayList<HistoryDTO> data=new ArrayList<>();
       //DetailsDTO data=new DetailsDTO();
        HistoryService historyService =new HistoryService();
//        int divid=24;
//        ArrayList<Integer>disid=new ArrayList<>();
//        disid.add(18);
//        disid.add(19);
//        disid.add(20);
//        disid.add(21);
//        disid.add(23);

        try{
         data= historyService.getCityHistory(21);

        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }

    @RequestMapping(value = "divisionassign", method = RequestMethod.GET)
    ModelAndView divisionAssign(){
        ModelAndView form = new ModelAndView("geo/division/divisionassign");
        form.addObject("division",divisionService.getDivisionData());
        return form;
    }

    @RequestMapping(value = "divisionassign", method = RequestMethod.POST)
    RedirectView divisionAssign(HttpServletRequest request,@RequestParam(value = "divdata")int target, @RequestParam(value = "parentid[]")int [] divisionIds, @RequestParam(value = "childid[]")int[] districtIds){


        ArrayList<Integer> disIds = new ArrayList<Integer>();
        for (int index = 0; index < districtIds.length; index++)
        {
            disIds.add(districtIds[index]);
        }

        ArrayList<Integer> divIds = new ArrayList<Integer>();
        for (int index = 0; index < divisionIds.length; index++)
        {
            divIds.add(divisionIds[index]);
        }
        try {
            divisionService.changeTotalGeoService(target,1,disIds,divIds,1,1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new RedirectView("divisionlist?menuid="+request.getSession().getAttribute("divisionmenuid"));
    }

    @RequestMapping(value = "divisionhistory",method = RequestMethod.GET)
    ModelAndView divisionHistory(@RequestParam int id, @RequestParam String name){
        ModelAndView form = null;
        form = new ModelAndView("geo/division/divisionhistory");
        form.addObject("id",id);
        form.addObject("name",name);

        return form;
    }

    @RequestMapping(value = "historydivision",method = RequestMethod.GET)
    @ResponseBody
    ArrayList<GenericDTO> getDivisionChildDetail(@RequestParam int id){
        HistoryService historyService = new HistoryService();
        ArrayList<GenericDTO> genericDTOS= historyService.getChildDetail(id,1);
        return genericDTOS;
    }


}
