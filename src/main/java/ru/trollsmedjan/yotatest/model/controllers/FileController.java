package ru.trollsmedjan.yotatest.model.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.xml.sax.SAXException;
import ru.trollsmedjan.yotatest.model.services.XMLBuildingService;
import ru.trollsmedjan.yotatest.model.services.XMLParsingService;

import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.Iterator;

/**
 * Created by finnetrolle on 21.05.2015.
 */
@RestController
public class FileController {

    @Autowired
    private XMLParsingService xmlParsingService;

    @Autowired
    private XMLBuildingService xmlBuildingService;

    @RequestMapping(value="/download/{id}", method = RequestMethod.GET)
    public void downloadFile(@PathVariable Long id, HttpServletResponse response) {
        try {
            xmlBuildingService.createXML(id, response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody
    FileUploadInfo upload(MultipartHttpServletRequest request, HttpServletResponse response) {

        Iterator<String> iterator =  request.getFileNames();
        FileUploadInfo fileUploadInfo = new FileUploadInfo();

        try {
            xmlParsingService.processUploadedFile(request.getFile(iterator.next()));
        } catch (IOException e) {
            fileUploadInfo.errorMessage = "Failed with IOException: " + e.getMessage();
            return fileUploadInfo;
        } catch (ParserConfigurationException e) {
            fileUploadInfo.errorMessage = "Failed with ParserConfigurationException: " + e.getMessage();
            return fileUploadInfo;
        } catch (SAXException e) {
            fileUploadInfo.errorMessage = "Failed with SAXException: " + e.getMessage();
            return fileUploadInfo;
        }

        fileUploadInfo.success = true;
        return fileUploadInfo;

    }

    class FileUploadInfo {
        public boolean success = false;
        public String errorMessage;
    }

}
