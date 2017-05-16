package com.bishe.yuanye.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bishe.yuanye.common.UserAgentUtil;
import com.bishe.yuanye.dao.dto.StudentDTO;
import com.bishe.yuanye.entity.User;
import com.bishe.yuanye.service.StudentService;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by sober on 2017/5/5.
 *
 * @author sober
 * @date 2017/05/05
 */
@Controller
@RequestMapping("/table")
public class TableController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/downloadModel")
    //模板下载
    public void downloadModel(HttpServletRequest request,HttpServletResponse response) throws IOException {
        HSSFWorkbook workbook=new HSSFWorkbook();
        //创建一个sheet页
        HSSFSheet sheet = workbook.createSheet("导入班级学生信息");
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("班级名");
        row.createCell(2).setCellValue("专业名");
        //创建第一行
        HSSFRow row2 = sheet.createRow(1);
        //设置第一行的每一列的字段名称
        row2.createCell(0).setCellValue("学号");
        row2.createCell(1).setCellValue("姓名");
        //文件下载 设置一个流两个头
        //获得输出流
        ServletOutputStream outputStream = response.getOutputStream();
        String filename="导入班级学生模板.xls";
        filename=new String(filename.getBytes("UTF-8"),"ISO-8859-1");
        //防止中文乱码
        UserAgentUtil.encodeFileName(request, filename);
        //设置 内容类型  Content-Type，用于定义网络文件的类型和网页的编码，决定文件接收方将以什么形式、什么编码读取这个文件，
        response.setContentType(getContentType(filename));
        //Content-Disposition 的作用  当Content-Type 的类型为要下载的类型时 , 这个信息头会告诉浏览器这个文件的名字和类型。
        //注意：在设置Content-Disposition头字段之前，一定要设置Content-Type头字段。
        response.setHeader("content-disposition","attachment;filename="+filename);
        //文件下载
        workbook.write(outputStream);
    }



    public static String getContentType(String filename){
		String type = null;
		Path path = Paths.get(filename);
		try {
			type = Files.probeContentType(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return type;
	}


	//一键上传excel表单的功能
    @RequestMapping("/importTable")
    @ResponseBody
    public boolean importXls(@RequestParam("file")MultipartFile file,HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User)request.getSession().getAttribute("user");
        Integer teacherId = user.getId();
        Boolean flag = false;
        String className = "";
        String majorName = "";
        try{
            List<StudentDTO> list=new ArrayList<>();
            //使用apache的 POI技术可以操作office办公软件的文档
            HSSFWorkbook hssfWorkbook=new HSSFWorkbook(file.getInputStream());
            //解析第一个sheet
            HSSFSheet sheet = hssfWorkbook.getSheetAt(0);
            //foreach遍历该sheet   得到每一行的记录
            for (Row row:sheet){
                //表单第一行
                int rowNum = row.getRowNum();
                if (rowNum == 0){
                    className = row.getCell(1).getStringCellValue();
                    majorName = row.getCell(3).getStringCellValue();
                    continue;
                }
                if (rowNum == 1){
                    //忽略column行
                    continue;
                }
                // POI操作Excel时数据Cell有不同的类型，当我们试图从一个整数类型的Cell读取出一个字符串并写入数据库时，就会出现Cannot get a text value from a numeric cell的异常错误，解决办法就是先设置Cell的类型，然后就可以把纯数字作为String类型读进来了：
                row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                String studentNum = row.getCell(0).getStringCellValue();
                String studentName = row.getCell(1).getStringCellValue();

               //为每一个对象设置属性
                StudentDTO dto = new StudentDTO();
                dto.setName(studentName);
                dto.setStudentNum(Integer.parseInt(studentNum));
                dto.setUsername(studentNum);
                dto.setPassword("123456");
                dto.setIsDeleted((short)0);
                //放入集合中
                list.add(dto);
            }
            studentService.createClassAndImportStu(className,majorName,teacherId,list);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

}
