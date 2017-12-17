  @PostMapping(value = "imagechange")
    public ModelAndView imagechange(@RequestParam("file")MultipartFile file){


        imageUpload(file,imageTypeProfile,MODULE_NAME);

        ModelAndView modelAndView=new ModelAndView();
        UserProfileDTO userProfileDTO=userProfileService.allInfo(1);
        modelAndView.addObject("userinfo",userProfileDTO);
        modelAndView.setViewName("userProfile/profile");
        return modelAndView;

       // return new RedirectView("profile");

    }

    private void imageUpload(MultipartFile file,int type,String moduelName){

        HashMap<Integer,String> mappedPath=new PathBuilder().buildPath(context,moduelName,"webapp");
        //String relativepath=System.getProperty("catalina.base")+ File.separator+
        String filepath=imageUploader.upload(file,mappedPath.get(1),"1");
        String relativepath=mappedPath.get(2);


        String pathToDB=relativepath+filepath;
        if(filepath.equals("invalid")){


        }else{
            userProfileService.setImage(1,pathToDB,type);
        }

    }