package com.cognizant.TS03ForEnterprise;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cognizant.base.Base_Test;
import com.cognizant.utilities.ExcelUtils;

public class TSForEnterpriseForm extends Base_Test{
	
	ExcelUtils eu = new ExcelUtils(System.getProperty("user.dir") + "\\src\\test\\testdata\\FormTestData.xlsx");
	List<List<String>> testData = new ArrayList<>();
	
	
	@BeforeClass
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
	public void tc01tofillBusinessSalesForm() {
		String title = fep.fillFormForBusinessSales(testData.get(1).get(0), testData.get(1).get(1), testData.get(1).get(2), testData.get(1).get(3), testData.get(1).get(4), testData.get(1).get(5), testData.get(1).get(8), testData.get(1).get(12), testData.get(1).get(9), testData.get(1).get(10));
		Assert.assertTrue(title.contains("Thank"));
		driver.navigate().to(url);
	}
	
	@Test
	public void tc02tofillCollegeSupportForm() {
		String title = fep.fillFormForCollege(testData.get(2).get(0), testData.get(2).get(1), testData.get(2).get(2), testData.get(2).get(3), testData.get(2).get(4), testData.get(2).get(15),testData.get(2).get(13),testData.get(2).get(14),testData.get(2).get(8),testData.get(2).get(9),testData.get(2).get(10));
		Assert.assertTrue(title.contains("Thank"));
		driver.navigate().to(url);
	}
	
	@Test
	public void tc03toFillGovernmentUpskillingForm() {
		String title = fep.fillFormForGovernmentUpskilling(testData.get(3).get(0), testData.get(3).get(1), testData.get(3).get(2), testData.get(3).get(3), testData.get(3).get(4), testData.get(3).get(5),testData.get(3).get(6), testData.get(3).get(7),testData.get(3).get(8), testData.get(3).get(12),testData.get(3).get(9),testData.get(3).get(10));
		Assert.assertTrue(title.contains("Thank"));
		driver.navigate().to(url);
	}
	
	@Test
	public void tc04toFillNonProfitForm() {
		String title = fep.fillFormForNonProfit(testData.get(4).get(0), testData.get(4).get(1), testData.get(4).get(2), testData.get(4).get(3), testData.get(4).get(4), testData.get(4).get(5),testData.get(4).get(6), testData.get(4).get(7),testData.get(4).get(8),testData.get(4).get(9),testData.get(4).get(10));
		Assert.assertTrue(title.contains("Thank"));
		driver.navigate().to(url);
	}
	
	@Test
	public void tc05toFillCollegeBusinessOthersForm() {
		String title = fep.fillFormForBusinessOthers(testData.get(5).get(0), testData.get(5).get(1), testData.get(5).get(2), testData.get(5).get(3), testData.get(5).get(4),testData.get(5).get(13),testData.get(5).get(8), testData.get(5).get(9), testData.get(5).get(10), testData.get(5).get(11));
		Assert.assertTrue(title.contains("Thank"));
		driver.navigate().to(url);
	}
	

	@Test
	public void tc06toFillBussinessForm() {
		String title = fep.fillFormForBusiness(testData.get(6).get(0), testData.get(6).get(1), testData.get(6).get(2), testData.get(6).get(3), testData.get(6).get(4),testData.get(6).get(5),testData.get(6).get(8), testData.get(6).get(9), testData.get(6).get(10));
		Assert.assertTrue(title.contains("Thank"));
		driver.navigate().to(url);
	}
	
	
	@Test
	public void tc07toFillCollegeForm() {
		String title = fep.fillFormForCollege(testData.get(7).get(0), testData.get(7).get(1), testData.get(7).get(2), testData.get(7).get(3), testData.get(7).get(4),testData.get(7).get(15),testData.get(7).get(13),testData.get(7).get(14), testData.get(7).get(8), testData.get(5).get(9), testData.get(5).get(10));
		Assert.assertTrue(title.contains("Thank"));
		driver.navigate().to(url);
	}
	
	@Test
	public void tc08toFillCollegeOthersForm() {
		String title = fep.fillFormForCollege(testData.get(8).get(0), testData.get(8).get(1), testData.get(8).get(2), testData.get(8).get(3), testData.get(8).get(4),testData.get(8).get(15),testData.get(8).get(13), testData.get(8).get(8), testData.get(8).get(9), testData.get(8).get(10));
		Assert.assertTrue(title.contains("Thank"));
		driver.navigate().to(url);
	}
	
	@Test
	public void tc09toFillGovernmentLearnerForm() {
		String title = fep.fillFormForGovernmentLearner(testData.get(9).get(0), testData.get(9).get(1), testData.get(9).get(2), testData.get(9).get(3), testData.get(9).get(4),testData.get(9).get(5),testData.get(9).get(6), testData.get(9).get(7), testData.get(9).get(8), testData.get(9).get(9), testData.get(9).get(10));
		Assert.assertTrue(title.contains("Thank"));
		driver.navigate().to(url);
	}
	
	@Test
	public void tc10toFillGovernmentForm() {
		String title = fep.fillFormForGovernmentOthers(testData.get(10).get(0),testData.get(10).get(1), testData.get(10).get(2), testData.get(10).get(3), testData.get(10).get(4), testData.get(10).get(5), testData.get(10).get(6), testData.get(10).get(7), testData.get(10).get(8), testData.get(10).get(9), testData.get(10).get(10), testData.get(10).get(11));
		Assert.assertTrue(title.contains("Thank"));
		driver.navigate().to(url);
	}
	
	@Test
	public void tc11toFillNonProfitOthersForm() {
		String title = fep.fillFormForNonProfitOthers(testData.get(11).get(0),testData.get(11).get(1), testData.get(11).get(2), testData.get(11).get(3), testData.get(11).get(4), testData.get(11).get(5), testData.get(11).get(6), testData.get(11).get(7), testData.get(11).get(8), testData.get(11).get(9), testData.get(11).get(10), testData.get(11).get(11));
		Assert.assertTrue(title.contains("Thank"));
		driver.navigate().to(url);
	}
	
	@Test
	public void tc12toFillNonProfitOthersForm() {
		String title = fep.fillFormForNonProfitSales(testData.get(12).get(0),testData.get(12).get(1), testData.get(12).get(2), testData.get(12).get(3), testData.get(12).get(4), testData.get(12).get(5), testData.get(12).get(6), testData.get(12).get(7), testData.get(12).get(8), testData.get(12).get(12), testData.get(12).get(9), testData.get(12).get(10));
		Assert.assertTrue(title.contains("Thank"));
		driver.navigate().to(url);
	}
	
	@Test
	public void tc13toFillBusinessForm() {
		String title = fep.fillFormForBusiness(testData.get(13).get(0),testData.get(13).get(1), testData.get(13).get(2), testData.get(13).get(3), testData.get(13).get(4), testData.get(13).get(5), testData.get(13).get(8),testData.get(13).get(9),testData.get(13).get(10));
		Assert.assertTrue(title.contains("Must be"));
		driver.navigate().to(url);
	}
	
	@Test
	public void tc14toFillCollegeForm() {
		String title = fep.fillFormForCollege(testData.get(14).get(0),testData.get(14).get(1), testData.get(14).get(2), testData.get(14).get(3), testData.get(14).get(4), testData.get(14).get(15), testData.get(14).get(6), testData.get(14).get(7),testData.get(14).get(13),testData.get(14).get(14), testData.get(14).get(8), testData.get(14).get(9),testData.get(14).get(10));
		Assert.assertTrue(title.contains("Must be"));
		driver.navigate().to(url);
	}
	
	@Test
	public void tc15toFillCollegeForm() {
		String title = fep.fillFormForNonProfit(testData.get(15).get(0),testData.get(15).get(1), testData.get(15).get(2), testData.get(15).get(3), testData.get(15).get(4), testData.get(15).get(5), testData.get(14).get(6), testData.get(14).get(7), testData.get(14).get(8), testData.get(14).get(9),testData.get(14).get(10));
		Assert.assertTrue(title.contains("Thank"));
		driver.navigate().to(url);
	}
	
	
}
