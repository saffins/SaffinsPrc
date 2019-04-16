package Rought;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class App2 {
	
	Map<Integer,String> mp = new HashMap<Integer,String>();
	
	SoftAssert ass = new SoftAssert();

	@Test(priority=1)
	public void m1() {

		try{
		      assertEquals("Test", "Preferences saved");

			System.out.println("before fail");
		}catch(AssertionError e){
			System.out.println("after fail");
			
		}

	}

	@Test(priority=5)
	public void m2() {

		
		System.out.println("m2");

	

	}

	@Test(priority=4)
	public void m3() {

		
		System.out.println("m3");


	}

	@Test(priority=3)
	public void m4() {

		System.out.println("m4");


	}
	
	@AfterTest
	public void read(){
		
		Set<Integer> values = mp.keySet();
		
		
		for(Integer val : values){
			
			System.out.println(mp.get(val));
			
		}
		
		
	}
}
