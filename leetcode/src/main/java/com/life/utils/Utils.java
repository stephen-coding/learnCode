package com.life.utils;


import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.sun.deploy.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Utils {


    /**
     * @Description: 使用阿里开源工具easyExcel导出
     * List<? extends BaseRowModel> 的作用为可以传入任意实体集合并继承BaseRowModel
     */
    public static void easyExcelExport(List<? extends BaseRowModel> resList, String fileName, HttpServletResponse response) throws IOException {
        //指定文件输出位置，使用该方法不需要引入HttpServletResponse （根据业务需求，而选其一）
        /*OutputStream outputStream =new FileOutputStream("H:/excel/file/myexcel3.xlsx");
        ExcelWriter excelWriter = EasyExcelFactory.getWriter(outputStream);*/

        //调用浏览器下载（根据业务需求，而选其一）
        String fileName11 = URLEncoder.encode(fileName, "UTF-8");//避免中文乱码
        String fileName12 = java.net.URLDecoder.decode(fileName11, "UTF-8");//避免中文乱码
        response.setContentType("APPLICATION/OCTET-STREAM");
        response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName12.getBytes("gb2312"), "ISO8859-1"));
        ServletOutputStream out = response.getOutputStream();
        ExcelWriter writer = EasyExcelFactory.getWriter(out);

        //将要输出的内容填充到Sheet里，resList.get(0).getClass()获取的就是ExcelSignpay.class
        Sheet sheet1 = new Sheet(1, 0, resList.get(0).getClass());
        //设置sheet表名
        sheet1.setSheetName("sheet1");
        /**
         * 写数据到Write上下文中
         * 第一个参数：要写入的内容、第二个参数：要写入的sheet目标
         */
        writer.write(resList, sheet1);
        out.flush();
        writer.finish();
        out.close();
    }







}
