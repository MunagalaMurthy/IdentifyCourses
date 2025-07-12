package com.cognizant.TS03ForEnterprise;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cognizant.base.Base_Test;
import com.cognizant.utilities.ExcelUtils;

public class TSForEnterpriseForm extends Base_Test{
	
	ExcelUtils eu = new ExcelUtils(System.getProperty("user.dir") + "\\src\\test\\testdata\\FormTestData.xlsx");
	List<List<String>> testData = new ArrayList<>();
	
	
	@BeforeTest
	public void readTestData() {
		int rows;
		try {
			rows = eu.getRowCount("FormTestData");
			for(int i = 0;i<rows;i++) {
				List<String> row = new ArrayList<String>();
				int cols = eu.getCellCount("FormTestData", i);
				for(int j = 0;j<cols;j++) {
					row.add(eu.getCellData("FormTestData", i, j));
				}
				testData.add(row);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void tofillBusinessSalesForm() {
		String title = fep.fillFormForBusinessSales(testData.get(1).get(0), testData.get(1).get(1), testData.get(1).get(2), testData.get(1).get(3), testData.get(1).get(4), testData.get(1).get(5), testData.get(1).get(8), testData.get(1).get(12), testData.get(1).get(9), testData.get(1).get(10));
		Assert.assertTrue(title.contains("Thank you"));
		driver.navigate().to(url);
	}
	
	@Test
	public void tofillCollegeSupportForm() {
		String title = fep.fillFormForCollege(testData.get(2).get(0), testData.get(2).get(1), testData.get(2).get(2), testData.get(2).get(3), testData.get(2).get(4), testData.get(2).get(15), testData.get(2).get(6), testData.get(2).get(7), testData.get(2).get(13), testData.get(2).get(14),testData.get(2).get(8),testData.get(2).get(9),testData.get(2).get(10));
		Assert.assertTrue(title.contains("Thank you"));
	}
	
}
