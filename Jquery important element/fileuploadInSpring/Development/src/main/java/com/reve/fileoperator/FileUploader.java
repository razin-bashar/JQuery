package com.reve.fileoperator;

import com.reve.Meeting.Meeting;
import com.reve.Meeting.MeetingService;
import com.reve.constant.Constant;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by reve on 7/15/2018.
 */
@RestController
public class FileUploader {
//    @Value("${file.upload.path}")
    @Autowired
    MeetingService meetingService;
    @Autowired
    FileInfoService fileInfoService;

    @RequestMapping("/fileupload")
    public ModelAndView fileupload(Model model) {
        ModelAndView modelAndView = new ModelAndView("util/fileupload");
        File file = new File(Constant.FILE_UPLOAD_DIR);

        modelAndView.addObject("files", file.listFiles());
        return modelAndView;
    }
	
	@RequestMapping("/fileupload2")
    public ModelAndView fileupload2(Model model) {
        ModelAndView modelAndView = new ModelAndView("util/fileupload2");
        File file = new File(Constant.FILE_UPLOAD_DIR);

        modelAndView.addObject("files", file.listFiles());
        return modelAndView;
    }

    @RequestMapping(value = "/uploaddoc", method = RequestMethod.POST)
    public String uploadingPost(@RequestParam("uploadingFiles") MultipartFile[] uploadingFiles, Constant.FileType fileType){
        System.out.println(Constant.FILE_UPLOAD_DIR);
        List<FileInfo> list = new ArrayList<>();
        try {
            for (MultipartFile uploadedFile : uploadingFiles) {
                File file = new File(Constant.FILE_UPLOAD_DIR + uploadedFile.getOriginalFilename());
                FileInfo fileInfo = new FileInfo();
                fileInfo.setFileType(fileType);
                fileInfo.setFileName( uploadedFile.getOriginalFilename());
                fileInfo.setFilePath(Constant.FILE_UPLOAD_DIR + uploadedFile.getOriginalFilename());
                System.out.println(uploadedFile.getOriginalFilename());
                String[] splited = uploadedFile.getOriginalFilename().split("\\.");
                fileInfo.setExtension("."+splited[splited.length-1]);
                list.add(fileInfo);
                uploadedFile.transferTo(file);
            }
        }catch (Exception e){
            e.printStackTrace();
        }



        return "redirect:/";
    }

    private void saveToDatabase(FileInfo fileInfo,Long id){
        Meeting meeting = meetingService.findByOne(id);
        fileInfo.setMeeting(meeting);
        fileInfoService.save(fileInfo);
    }

    @RequestMapping("/save-file")
    public void saveFile(HttpServletRequest servletRequest,
                         @RequestParam("multipartFile") MultipartFile multipartFile,
                         @RequestParam("kope") String hi,
                         @RequestParam("hope") String hello
                         ) {

        String fileName = multipartFile.getOriginalFilename();

        try {
            File file = new File(Constant.FILE_UPLOAD_DIR + fileName);
            FileInfo fileInfo = new FileInfo();
            System.out.println(hi+"--->"+hello);
            //fileInfo.setFileType(fileType);
            fileInfo.setFileName( fileName);
            fileInfo.setFilePath(Constant.FILE_UPLOAD_DIR + fileName);
            String[] splited = fileName.split("\\.");
            fileInfo.setExtension("."+splited[splited.length-1]);
            Long id = new Long(1);
            multipartFile.transferTo(file);

            saveToDatabase(fileInfo,id);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
	
	
	
	@RequestMapping("/singleFileUpload")
    public void singleFileUpload(HttpServletRequest servletRequest,
                         @RequestParam("multipartFile") MultipartFile multipartFile
                         
                         ) {

        String fileName = multipartFile.getOriginalFilename();

        try {
            File file = new File(Constant.FILE_UPLOAD_DIR + fileName);
            FileInfo fileInfo = new FileInfo();
            System.out.println(hi+"--->"+hello);
            //fileInfo.setFileType(fileType);
            fileInfo.setFileName( fileName);
            fileInfo.setFilePath(Constant.FILE_UPLOAD_DIR + fileName);
            String[] splited = fileName.split("\\.");
            fileInfo.setExtension("."+splited[splited.length-1]);
            Long id = new Long(1);
            multipartFile.transferTo(file);

            saveToDatabase(fileInfo,id);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}
