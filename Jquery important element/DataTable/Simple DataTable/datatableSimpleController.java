@RequestMapping(value = "/unionpage", method = RequestMethod.GET)
    @ResponseBody
    JSONObject unionPage(HttpServletRequest request) {
        int displayLength=1;
        if(request.getParameter("iDisplayLength") !=null)displayLength = Integer.valueOf(request.getParameter("iDisplayLength"));
        Integer pageNumber = 0;
        if (null != request.getParameter("iDisplayStart"))
            pageNumber = (Integer.valueOf(request.getParameter("iDisplayStart"))/displayLength)+1;

        //Fetch search parameter
        String searchParameterEncode = request.getParameter("sSearch");

        UnionService unionService = new UnionService();
        ArrayList<UnionDTO> listUnion = null;

        if(!searchParameterEncode.equals(";")&& searchParameterEncode.contains(";")) {
            String[] searchparameter = searchParameterEncode.split(";");

            int parameterSizeLength = searchparameter.length;
            if(parameterSizeLength>1){
                listUnion = unionService.getUnionListbyPage(pageNumber, displayLength,searchparameter);
            }
            else {
                listUnion = unionService.getUnionListbyPage(pageNumber, displayLength, searchparameter[0]);
            }
        }
        else {

            listUnion = unionService.getUnionListbyPage(pageNumber, displayLength);

        }
        JSONObject obj = new JSONObject();
        obj.put("iTotalRecords", unionService.getCount());
        obj.put("iTotalDisplayRecords", unionService.getCount());
        obj.put("aaData", listUnion);

         return obj;
    }