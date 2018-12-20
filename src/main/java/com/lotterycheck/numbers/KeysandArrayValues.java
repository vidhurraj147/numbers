package com.lotterycheck.numbers;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class KeysandArrayValues {

	public static HashMap<String, ArrayList<Integer>> gethashMap(String type){
		 HashMap<String, ArrayList<Integer>> hm = new HashMap<String, ArrayList<Integer>>();
	        HashMap<String, ArrayList<Integer>> hmSortedAsc = new HashMap<String, ArrayList<Integer>>();
	        HashMap<String, ArrayList<Integer>> hmSortedDsc = new HashMap<String, ArrayList<Integer>>();
	        ArrayList<Integer> myArray= new ArrayList<Integer>();
//	        for(int i = 2002;i<2019;i++){
//	        	hm.put(i, myArray);
//	        }
	        
	        InputStream ExcelFileToRead;
			try {
				ExcelFileToRead = new FileInputStream("C:\\Users\\Lenovo\\workspace\\numbers\\src\\main\\java\\com\\lotterycheck\\numbers\\powerballhistoryNEW.xlsx");
		        XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
		        XSSFWorkbook test = new XSSFWorkbook(); 
		
		        XSSFSheet sheet = wb.getSheetAt(0);
		        XSSFRow row; 
		        XSSFCell cell;
		
		        java.util.Iterator<Row> rows = sheet.rowIterator();
		        int count = 0;
		        String dateCurrent = "";
		        ArrayList<Integer> numbers = null; // = new ArrayList<Integer>();
		        ArrayList<Integer> numbersAsc = null;
		        ArrayList<Integer> numbersDsc = null;
		        while (rows.hasNext())
		        {
		            row=(XSSFRow) rows.next();
		            java.util.Iterator<Cell> cells = row.cellIterator();
		            while (cells.hasNext())
		            {
		            	count++;
		                cell=(XSSFCell) cells.next();
		                
		                if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
		                {
		                	dateCurrent = cell.getStringCellValue();
		                	numbers = new ArrayList<Integer>();
		                	numbersAsc =  new ArrayList<Integer>();
		                	numbersDsc =  new ArrayList<Integer>();
		                }
		                else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
		                {	
		                	numbers.add((int) cell.getNumericCellValue());
		                	numbersAsc.add((int) cell.getNumericCellValue());
		                	numbersDsc.add((int) cell.getNumericCellValue());
		                }
		                else
		                {
		                	
		                }
		            }
		            //System.out.println("date is "+dateCurrent+ " values are "+numbers);
		            hm.put(dateCurrent,numbers);
		            Collections.sort(numbersAsc);
		            //System.out.println("date is "+dateCurrent+ " values are "+numbers);
		            hmSortedAsc.put(dateCurrent,numbersAsc);
		            Collections.sort(numbersDsc);
		            Collections.reverse(numbersDsc);
		            //System.out.println("date is "+dateCurrent+ " values are "+numbers);
		            hmSortedDsc.put(dateCurrent,numbersDsc);
		            //System.out.println();
		        }
		        //System.out.println("Map_ACTUAL"+hm);
		        //System.out.println("Map_ASC"+hmSortedAsc);
		        //System.out.println("Map_DSC"+hmSortedDsc);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(type.equals("Map_ACTUAL")){
				return hm;
			}if(type.equals("Map_ASC")){
				return hmSortedAsc;
			}if(type.equals("Map_DSC")){
				return hmSortedDsc;
			}
		return null;
		
	}
}
