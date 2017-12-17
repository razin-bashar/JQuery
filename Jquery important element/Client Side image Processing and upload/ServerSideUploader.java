public String fileChecker(MultipartFile file) {

        File file1 = new File(file.getOriginalFilename());
        String filename = file.getOriginalFilename();
//        try {
//            file.transferTo(file1);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //String mimeType = new MimetypesFileTypeMap().getContentType(file1);
        String mimeType = "";

        if (context.getMimeType(filename) == null) {
            return "invalid";
        } else {
            mimeType = context.getMimeType(filename);
            String[] fileType = mimeType.split("/");
            return fileType[0];
        }


    }

    public String upload(MultipartFile file, String uploadFolder, String fileName) {
        String filepath = "";

        String Name = file.getOriginalFilename();

        String ext = ".png";
        if(file.getContentType().equals("image/png"))ext = ".png";
        else if (file.getContentType().equals("image/jpeg"))ext = ".jpg";

        String checker = "";
        if(!Name.equals("blob")) {
            checker = fileChecker(file);
            if (checker.equals("invalid")) {
                return "invalid";
            }
            if (!checker.equals("image")) {
                return "invalid";
            }
        }

        if (file.isEmpty()) {
            return "invalid";
        } else {

            try {

                // Get the file and save it somewhere
                byte[] bytes = file.getBytes();
                Path path = Paths.get(uploadFolder + fileName + ext);
                Files.write(path, bytes);

                filepath = fileName + ext;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return filepath;
        //return PathBuilder.profilePicPath;

    }