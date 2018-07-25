package com.myoa.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import com.myoa.pojo.system.SysUser;


/**
 * excel处理工具
 * @author caish
 * @date 2018年7月17日 
 */
public class ExcelUtil {


	/**
	 * 一百万处理思路
	 * @param valueDataDto
	 * @param path
	 * @throws IOException
	 */
	//public void exportBigDataExcel(ValueDataDto valueDataDto, String path) throws IOException {
	public void exportBigDataExcel(String path) throws IOException {
		// 最重要的就是使用SXSSFWorkbook，表示流的方式进行操作
		// 在内存中保持100行，超过100行将被刷新到磁盘
		SXSSFWorkbook wb = new SXSSFWorkbook(100);
		Sheet sh = wb.createSheet(); // 建立新的sheet对象
		Row row = sh.createRow(0);   // 创建第一行对象
		// -----------定义表头-----------
		Cell cel0 = row.createCell(0);
		cel0.setCellValue("姓名");
		Cell cel2 = row.createCell(1);
		cel2.setCellValue("邮箱");
		Cell cel3 = row.createCell(2);
		cel3.setCellValue("手机号");
		Cell cel4 = row.createCell(3);
		// ---------------------------
		List<SysUser> list = new ArrayList<>();
		// 数据库中存储的数据行
		int page_size = 10000;
		// 求数据库中待导出数据的行数
		// int list_count = this.daoUtils.queryListCount(this.valueDataDao
		//		.queryExportSQL(valueDataDto).get("count_sql"));
		int list_count = 1000000;
		// 根据行数求数据提取次数
		int export_times = list_count % page_size > 0 ? list_count / page_size
				+ 1 : list_count / page_size;
		// 按次数将数据写入文件
		for (int j = 0; j < export_times; j++) {
//			list = this.valueDataDao.queryPageList(this.valueDataDao
//					.queryExportSQL(valueDataDto).get("list_sql"), j + 1,
//					page_size);
			
			int len = list.size() < page_size ? list.size() : page_size;
			for (int i = 0; i < len; i++) {
				Row row_value = sh.createRow(j * page_size + i + 1);
				Cell cel0_value = row_value.createCell(0);
				cel0_value.setCellValue(list.get(i).getName());
				Cell cel2_value = row_value.createCell(1);
				cel2_value.setCellValue(list.get(i).getEmail());
				Cell cel3_value = row_value.createCell(2);
				cel3_value.setCellValue(list.get(i).getPhone());
			}
				list.clear(); // 每次存储len行，用完了将内容清空，以便内存可重复利用
		}
		FileOutputStream fileOut = new FileOutputStream(path);
		wb.write(fileOut);
		fileOut.close();
		wb.dispose();
	}
	
	/**
	 * 1百万以上处理思路
	 * @param isClose
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void jdbcex(boolean isClose) throws InstantiationException, IllegalAccessException, 
				ClassNotFoundException, SQLException, IOException, InterruptedException {
			
		String xlsFile = "f:/poiSXXFSBigData.xlsx";		//输出文件
		//内存中只创建100个对象，写临时文件，当超过100条，就将内存中不用的对象释放。
		Workbook wb = new SXSSFWorkbook(100);			//关键语句
		Sheet sheet = null;		//工作表对象
		Row nRow = null;		//行对象
		Cell nCell = null;		//列对象
	 
		//使用jdbc链接数据库
		Class.forName("com.mysql.jdbc.Driver").newInstance();  
		String url = "jdbc:mysql://localhost:3306/bigdata?characterEncoding=UTF-8";
		String user = "root";
		String password = "123456";
		//获取数据库连接
		Connection conn = DriverManager.getConnection(url, user,password);   
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		String sql = "select * from hpa_normal_tissue limit 1000000";   //100万测试数据
		ResultSet rs = stmt.executeQuery(sql);  
		
		ResultSetMetaData rsmd = rs.getMetaData();
		long  startTime = System.currentTimeMillis();	//开始时间
		System.out.println("strat execute time: " + startTime);
			
		int rowNo = 0;		//总行号
		int pageRowNo = 0;	//页行号
			
		while(rs.next()) {
			//打印300000条后切换到下个工作表，可根据需要自行拓展，2百万，3百万...数据一样操作，只要不超过1048576就可以
			if(rowNo%300000==0){
				System.out.println("Current Sheet:" + rowNo/300000);
				sheet = wb.createSheet("我的第"+(rowNo/300000)+"个工作簿");//建立新的sheet对象
				sheet = wb.getSheetAt(rowNo/300000);		//动态指定当前的工作表
				pageRowNo = 0;		//每当新建了工作表就将当前工作表的行号重置为0
			}	
			rowNo++;
			nRow = sheet.createRow(pageRowNo++);	//新建行对象
	 
			// 打印每行，每行有6列数据   rsmd.getColumnCount()==6 --- 列属性的个数
			for(int j=0;j<rsmd.getColumnCount();j++){
				nCell = nRow.createCell(j);
				nCell.setCellValue(rs.getString(j+1));
			}
				
			if(rowNo%10000==0){
				System.out.println("row no: " + rowNo);
			}
//			Thread.sleep(1);	//休息一下，防止对CPU占用，其实影响不大
		}
			
		long finishedTime = System.currentTimeMillis();	//处理完成时间
		System.out.println("finished execute  time: " + (finishedTime - startTime)/1000 + "m");
			
		FileOutputStream fOut = new FileOutputStream(xlsFile);
		wb.write(fOut);
		fOut.flush();		//刷新缓冲区
		fOut.close();
			
		long stopTime = System.currentTimeMillis();		//写文件时间
		System.out.println("write xlsx file time: " + (stopTime - startTime)/1000 + "m");
			
		if(isClose){
			this.close(rs, stmt, conn);
		}
	}
		
	//执行关闭流的操作
	private void close(ResultSet rs, Statement stmt, Connection conn ) throws SQLException{
		rs.close();   
		stmt.close();   
		conn.close(); 
	}
	
	public static void main(String[] args) throws Exception {
		ExcelUtil tm = new ExcelUtil();
		tm.jdbcex(true);
	}
}
