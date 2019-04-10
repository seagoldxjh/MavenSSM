package com.xjh.controller;

import com.xjh.entity.TaskStu;
import com.xjh.service.TaskStuService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/")
public class FileController {
	
	@Autowired
	private TaskStuService taskStuService;
	
	@RequestMapping(value="upload",method={RequestMethod.POST})
	public String upload(@RequestParam("file")MultipartFile file,Model model,
						@RequestParam("taskId")int taskId, HttpServletRequest request) throws IllegalStateException, IOException {
		//获取上传图片存储目录
		String path = request.getSession().getServletContext().getRealPath("upload");
		System.out.println(path);
		//获取文件名并使用UUID生成新文件名
		String fileName  = file.getOriginalFilename();
		if(file.getBytes().length > 0) {
			String newFileName = UUID.randomUUID()+fileName.substring(fileName.lastIndexOf("."));
			//在指定上传存储目录中创建新文件
			File targetFile = new File(path,newFileName);
			//找不到指定上传图片存储目录，就新创建此目录
			if(!targetFile.exists()) {
				targetFile.mkdirs();
			}
			//将文件写入硬盘
			file.transferTo(targetFile);
			//将上传后的文件路径传到view
			model.addAttribute("fileUrl", request.getContextPath()+"/upload"+newFileName);
			model.addAttribute("newFileName",newFileName);
			String loginStuNo = (String)request.getSession().getAttribute("loginStuNo");
			TaskStu taskStu = new TaskStu(taskId, Integer.parseInt(loginStuNo));
			taskStu.setState("任务已完成");
			taskStu.setFileNmae(newFileName);
			taskStuService.finishTask(taskStu);
		}
		return "redirect:views/taskitem.jsp";
	}
	
	@RequestMapping(value="download",method={RequestMethod.POST,RequestMethod.GET})
    public ResponseEntity<byte[]> download(HttpServletRequest request,
            @RequestParam("filename") String filename)throws Exception {
       //下载文件路径
       String path = request.getServletContext().getRealPath("upload");
       File file = new File(path + File.separator + filename);
       HttpHeaders headers = new HttpHeaders();  
       //下载显示的文件名，解决中文名称乱码问题  
       String downloadFielName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
      /* String[] strArr = downloadFielName.split("/");
       //通知浏览器以attachment（下载方式）打开图片
       System.out.println(downloadFielName);
       System.out.println(strArr[1]);*/
       headers.setContentDispositionFormData("attachment",downloadFielName); 
       //application/octet-stream ： 二进制流数据（最常见的文件下载）。
       headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
       return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
               headers, HttpStatus.CREATED);  
    }
}