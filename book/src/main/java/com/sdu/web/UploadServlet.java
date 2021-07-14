package com.sdu.web;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (ServletFileUpload.isMultipartContent(req)){
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

            try {
                List<FileItem> list = servletFileUpload.parseRequest(req);
                for (FileItem fileItem: list
                     ) {
                    if (fileItem.isFormField()){
                        System.out.println(fileItem.getFieldName());
                        System.out.println(fileItem.getString("UTF-8"));
                    }else {
                        System.out.println(fileItem.getFieldName());
                        System.out.println(fileItem.getName());

                        fileItem.write(new File("/Users/liwei/Desktop/newJavaPro"+fileItem.getName()));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("不是文件请求！");
        }
    }
}
