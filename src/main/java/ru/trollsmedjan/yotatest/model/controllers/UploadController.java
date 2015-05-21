package ru.trollsmedjan.yotatest.model.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.xml.sax.SAXException;
import ru.trollsmedjan.yotatest.model.helpers.ExtendedSAXParser;
import ru.trollsmedjan.yotatest.model.services.XMLParsingService;

import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.util.Iterator;
import java.util.UUID;

/**
 * Created by finnetrolle on 21.05.2015.
 */
@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private XMLParsingService xmlParsingService;



    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    String upload(MultipartHttpServletRequest request, HttpServletResponse response) {

        Iterator<String> iterator =  request.getFileNames();

        try {
            xmlParsingService.processUploadedFile(request.getFile(iterator.next()));
        } catch (IOException e) {
            return "Failed with: " + e.getMessage();
        } catch (ParserConfigurationException e) {
            return "Failed with: " + e.getMessage();
        } catch (SAXException e) {
            return "Failed with: " + e.getMessage();
        }

        return "success";

    }

}
