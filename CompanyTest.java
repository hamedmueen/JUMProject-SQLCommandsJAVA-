package com.cognixia.jumo.jdbc.connect;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
class CompanyTest {
	private Company c1, c2;
	private int result;
	
	@Before 
	public void intialize() {
		c1 = new Company (0, "a", "b", "c", "d", "e", 5);
		c2 = new Company (1, "f", "g", "h", "i", "j", 5);
	}

	@Parameters
	

	@Test
	void testSetCompany_id() {
		c1.setCompany_id(-1);
		assertEquals(0, c1.getCompany_id());
	}

	@Test
	void testSetRevenue_in_millions() {
		c1.setRevenue_in_millions(-1);
		assertEquals(5, c1.getRevenue_in_millions());
	}

}
