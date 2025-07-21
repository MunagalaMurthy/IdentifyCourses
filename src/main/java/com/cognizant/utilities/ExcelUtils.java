package com.cognizant.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Utility class for reading data from Excel (XLSX) files.
 * This class provides methods to get row count, cell count, and cell data
 * from a specified Excel sheet. It leverages Apache POI library for Excel operations.
 */
public class ExcelUtils {

	// FileInputStream to read the Excel file.
	private FileInputStream fi;
	// XSSFWorkbook object representing the Excel workbook.
	private XSSFWorkbook workbook;
	// XSSFSheet object representing a specific sheet within the workbook.
	private XSSFSheet sheet;
	// XSSFRow object representing a row within the sheet.
	private XSSFRow row;
	// XSSFCell object representing a cell within the row.
	private XSSFCell cell;
	// Path to the Excel file.
	private String path;

	/**
	 * Constructor for ExcelUtils.
	 * Initializes the path to the Excel file.
	 * @param path The full path to the Excel (.xlsx) file.
	 */
	public ExcelUtils(String path) {
		this.path = path;
	}

	/**
	 * Retrieves the total number of rows (last row number) in a specified Excel sheet.
	 * The row count is 0-indexed, meaning if there are 10 rows (0-9), it returns 9.
	 *
	 * @param sheetName The name of the sheet from which to get the row count.
	 * @return The 0-indexed number of the last row containing data, or -1 if the sheet is empty.
	 * @throws IOException If an I/O error occurs while reading the file.
	 */
	public int getRowCount(String sheetName) throws IOException {
		fi = new FileInputStream(path); // Open the Excel file for reading.
		workbook = new XSSFWorkbook(fi); // Create a workbook object from the input stream.
		sheet = workbook.getSheet(sheetName); // Get the specified sheet.
		int rowcount = sheet.getLastRowNum()+1; // Get the last row number (0-indexed).
		workbook.close(); // Close the workbook.
		fi.close(); // Close the file input stream.
		return rowcount;		
	}

	/**
	 * Retrieves the total number of cells (columns) in a specified row of an Excel sheet.
	 * This method returns the count of the last cell number (1-indexed).
	 *
	 * @param sheetName The name of the sheet.
	 * @param rownum The 0-indexed row number from which to get the cell count.
	 * @return The number of the last cell (column) in the specified row, or -1 if the row is empty/null.
	 * @throws IOException If an I/O error occurs while reading the file.
	 */
	public int getCellCount(String sheetName, int rownum) throws IOException {
		fi = new FileInputStream(path); // Open the Excel file for reading.
		workbook = new XSSFWorkbook(fi); // Create a workbook object from the input stream.
		sheet = workbook.getSheet(sheetName); // Get the specified sheet.
		row = sheet.getRow(rownum); // Get the specified row.
		int cellcount = row.getLastCellNum(); // Get the last cell number (1-indexed).
		workbook.close(); // Close the workbook.
		fi.close(); // Close the file input stream.
		return cellcount;
	}

	/**
	 * Retrieves the data from a specific cell in an Excel sheet.
	 * This method uses DataFormatter to return the cell content as a String,
	 * regardless of the actual cell type (e.g., numeric, string, boolean).
	 *
	 * @param sheetName The name of the sheet.
	 * @param rownum The 0-indexed row number of the cell.
	 * @param colnum The 0-indexed column number of the cell.
	 * @return The formatted string value of the cell, or an empty string if an error occurs (e.g., cell is null).
	 * @throws IOException If an I/O error occurs while reading the file.
	 */
	public String getCellData(String sheetName, int rownum, int colnum) throws IOException {
		fi = new FileInputStream(path); // Open the Excel file for reading.
		workbook = new XSSFWorkbook(fi); // Create a workbook object from the input stream.
		sheet = workbook.getSheet(sheetName); // Get the specified sheet.
		row = sheet.getRow(rownum); // Get the specified row.
		cell = row.getCell(colnum); // Get the specified cell.

		DataFormatter formatter = new DataFormatter(); // Create a DataFormatter to handle various cell types.
		String data;
		try {
			// Returns the formatted value of a cell as a String regardless of the cell type.
			data = formatter.formatCellValue(cell); 
		} catch (Exception e) {
			// If there's an exception (e.g., cell is null or empty), return an empty string.
			data = "";
		} finally {
			// Ensure workbook and FileInputStream are closed even if an exception occurs within the try block
			// This is good practice for resource management
			if (workbook != null) {
				workbook.close();
			}
			if (fi != null) {
				fi.close();
			}
		}
		return data;
	}
}