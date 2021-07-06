package com.highradius;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Flipkart_assignment {

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/flipkart";

	 
	   static final String USER = "root";
	   static final String PASS = "root";
	   
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.flipkart.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input")).sendKeys("7735943908");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input")).sendKeys("Password");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='col-12-12 _2oO9oE']/div[@class='_3OO5Xc']/input[@class='_3704LK']")).sendKeys("smartphone"+ Keys.ENTER);
		Thread.sleep(2000);
		Select price_select = new Select(driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div/div[1]/div/section[2]/div[4]/div[1]/select")));
		price_select.selectByValue("7000");
	    Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='_24_Dny']")).click();
		driver.findElement(By.xpath("//input[@class = '_34uFYj']")).sendKeys("ASUS");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(), 'ASUS')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(), '3★ & above')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(), 'Price -- Low to High')]")).click();
		Thread.sleep(2000);
		List<String> str = new ArrayList<String>();
		List<String>model_lst  = new ArrayList<String>();
		List<String>rating_lst  = new ArrayList<String>();
		List<String>rating_count_lst  = new ArrayList<String>();
		List<String>price_lst  = new ArrayList<String>();
		List<String>availability_lst  = new ArrayList<String>();
		List<WebElement> lst = driver.findElements(By.xpath("//*[@class='_1AtVbE col-12-12']/div"));
		String availability;
		for(int i =2;i<=lst.size()-3;i++)
		{
		
			WebElement model_name = driver.findElement(By.xpath("//*[@class='_1AtVbE col-12-12']["+i+"]//div[@class= 'col col-7-12']/div[@class='_4rR01T']"));
			WebElement rating = driver.findElement(By.xpath("//*[@class='_1AtVbE col-12-12']["+i+"]//div[@class= 'col col-7-12']//div[@class='_3LWZlK']"));
			WebElement rating_count = driver.findElement(By.xpath("//*[@class='_1AtVbE col-12-12']["+i+"]//div[@class= 'col col-7-12']//span[@class='_2_R_DZ']"));
			WebElement price = driver.findElement(By.xpath("//*[@class='_1AtVbE col-12-12']["+i+"]//div[@class = '_30jeq3 _1_WHN1']"));
			WebElement description = driver.findElement(By.xpath("//*[@class='_1AtVbE col-12-12']["+i+"]//div[@class= 'col col-7-12']/div[@class='fMghEO']"));
			WebElement liElements =  driver.findElement(By.xpath("//*[@class='_1AtVbE col-12-12']["+i+"]//div[@class = '_2QcLo-']"));
			Boolean a= check_availibility(liElements);
			
			if(a)
			{
				availability = "1";
			}
			else
			{
				availability = "0";
			}
			String s = description.getText().toString();
			String model_str = model_name.getText().toString();
			String rating_str = rating.getText().toString();
			String rating_count_str = rating_count.getText().toString();
			String price_str = price.getText().toString();
			String liElements_str = availability;
			str.add(s);
			model_lst.add(model_str);
			rating_lst.add(rating_str); 
			rating_count_lst.add(rating_count_str); 
			price_lst.add(price_str); 
			availability_lst.add(liElements_str); 
		   
		 }
		driver.findElement(By.xpath("//a[@class='ge-49M']")).click();
		Thread.sleep(2000);
		String availability1;
		List<WebElement> lst1 = driver.findElements(By.xpath("//*[@class='_1AtVbE col-12-12']/div"));
		for(int i =2;i<=lst1.size()-3;i++)
		{
			//System.out.println(i);
			WebElement model_name1 = driver.findElement(By.xpath("//*[@class='_1AtVbE col-12-12']["+i+"]//div[@class= 'col col-7-12']/div[@class='_4rR01T']"));
			WebElement rating1 = driver.findElement(By.xpath("//*[@class='_1AtVbE col-12-12']["+i+"]//div[@class= 'col col-7-12']//div[@class='_3LWZlK']"));
			WebElement rating_count1 = driver.findElement(By.xpath("//*[@class='_1AtVbE col-12-12']["+i+"]//div[@class= 'col col-7-12']//span[@class='_2_R_DZ']"));
			WebElement price1 = driver.findElement(By.xpath("//*[@class='_1AtVbE col-12-12']["+i+"]//div[@class = '_30jeq3 _1_WHN1']"));
			WebElement description1 = driver.findElement(By.xpath("//*[@class='_1AtVbE col-12-12']["+i+"]//div[@class= 'col col-7-12']/div[@class='fMghEO']"));
			WebElement liElements1 =  driver.findElement(By.xpath("//*[@class='_1AtVbE col-12-12']["+i+"]//div[@class = '_2QcLo-']"));
			Boolean a1= check_availibility(liElements1);
			
			if(a1)
			{
				availability1 = "1";
			}
			else
			{
				availability1 = "0";
			}
			String s1 = description1.getText().toString();
			
			String model_str1 = model_name1.getText().toString();
			String rating_str1 = rating1.getText().toString();
			String rating_count_str1 = rating_count1.getText().toString();
			String price_str1 = price1.getText().toString();
			String liElements_str1 = availability1;
			str.add(s1);
			model_lst.add(model_str1);
			rating_lst.add(rating_str1); 
			rating_count_lst.add(rating_count_str1); 
			price_lst.add(price_str1); 
			availability_lst.add(liElements_str1); 
		   
		 }
		
		
		Connection conn = null;
		Statement stmt = null;
		try{

		      Class.forName("com.mysql.cj.jdbc.Driver");
              conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      String sql;
		      sql = "INSERT INTO mobile_db(pk_id,model_name,rating,rating_count,price,ram,front_camera_mp,rear_camera_mp,capacity,available) VALUES (?,?,?,?,?,?,?,?,?,?)";
		      PreparedStatement statement = conn.prepareStatement(sql);
		      int c=0;
		      Pojo studObj= new Pojo();
		      for(int j =0; j< str.size();j++)
			 {
		    	  studObj.setmodel_name(model_lst.get(j));
		    	  studObj.setrating(rating_lst.get(j));
				Pattern pattern4 = Pattern.compile("(\\d*),?(\\d*)");
		        Matcher macher4 = pattern4.matcher(rating_count_lst.get(j));
		        if(macher4.find())
		        {
		        	
		        	studObj.setrating_count(macher4.group(1)+macher4.group(2));
		        	
		        }
		        Pattern pattern6 = Pattern.compile("(\\d*),?(\\d\\d*)");
		        Matcher macher6 = pattern6.matcher(price_lst.get(j));
		        if(macher6.find())
		        {
		        	
		        	studObj.setprice(macher6.group(1)+macher6.group(2));
		        	
		        }
		        studObj.setavailable(availability_lst.get(j));	
				Pattern pattern1 = Pattern.compile("(\\d*\\sGB)");
		        Matcher macher1 = pattern1.matcher(str.get(j));
		        if(macher1.find())
		        {
		        	
		        	studObj.setram(macher1.group(1));
		        	
		        }
		       Pattern pattern2 = Pattern.compile("(\\d*\\smAh)");
		        Matcher macher2 = pattern2.matcher(str.get(j));
		        if(macher2.find())
		        {
		        	
		        	studObj.setcapacity(macher2.group(1));
		        	
		        }
		        Pattern pattern3 = Pattern.compile("\\|\\s(\\d*MP)");
		         Matcher macher3 = pattern3.matcher(str.get(j));
		        if(macher3.find())
		        {
		        	
		        	studObj.setfront_camera_mp(macher3.group(1));
		        			        }
		        Pattern pattern5 = Pattern.compile("Display\\s+([\\w\\s\\+]+)\\s+(Rear\\s+Camera)?");
		         Matcher macher5 = pattern5.matcher(str.get(j));
		        if(macher5.find())
		        {
		        	
		        	studObj.setrear_camera_mp(macher5.group(1));
		        	
		        }
		        statement.setInt(1,++c);
		    	statement.setString(2, studObj.getmodel_name());
		      	statement.setFloat(3,Float.parseFloat(studObj.rating()) );
		      	statement.setInt(4,Integer.parseInt(studObj.getrating_count()));
		      	statement.setFloat(5,Float.parseFloat(studObj.getprice()));
		      	statement.setString(6, studObj.getram());
		      	statement.setString(7, studObj.getfront_camera_mp());
		      	statement.setString(8, studObj.getrear_camera_mp());
		      	statement.setString(9, studObj.getcapacity());
		      	statement.setBoolean(10,Boolean.parseBoolean(studObj.getavailable()));
		      	statement.addBatch();
		      	statement.executeBatch();
		        
				
			 }
		      
		    }catch(SQLException se){
		      
		      se.printStackTrace();
		   }catch(Exception e){
		     
		      e.printStackTrace();
		   }finally{
		      	      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se) {
		         se.printStackTrace();
		      }
		   }
		
		
		
		driver.findElement(By.xpath("//div[contains(text(), 'Newest First')]")).click();
		for(int i =1;i<= 3;i++)
		{
			new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='_1AtVbE col-12-12']["+i+"]//div[@class='MIXNux']//div[@class='_24_Dny']"))).click();
		}
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class = '_11o22n _87aCMT']"))).click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='_1EDlbo _17qiPn']"))).click();
	    driver.findElement(By.xpath("//input[@placeholder='Choose Brand']")).sendKeys("Apple");
	    driver.findElement(By.xpath("//div[@title='APPLE']")).click();
	    new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='_18OcjB _1cpOwe'][2]//div[@class='_1EDlbo _17qiPn']"))).click();
	    driver.findElement(By.xpath("//div[@title='Apple iPhone XR (White, 128 GB) (Includes EarPods, Power Adapter)']")).click();
	    Thread.sleep(2000);
	    File sc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sc, new File("C:/Users/KIIT/Desktop/H2H(Summer)/image.png"));
	    driver.navigate().back();
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class = '_2id1nE']"))).click();
		Actions action = new Actions(driver);
		WebElement menuOption = driver.findElement(By.xpath(".//div[contains(text(),'Arpan')]"));
	    action.moveToElement(menuOption).perform();
	    WebElement selectMenuOption = driver.findElement(By.xpath(".//div[contains(text(),'Logout')]"));
	    selectMenuOption.click();
	    driver.close();
		
}
	public static boolean check_availibility(WebElement li) throws NoSuchElementException {
		 try {
			 WebElement avail = li.findElement(By.className("_192laR"));
		    	return false;
		 }
		catch(Exception exception){
			return true;
		}
	}
}
