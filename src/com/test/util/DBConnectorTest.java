package com.test.util;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;

import org.junit.Test;

import com.ruda.util.DBConnector;

public class DBConnectorTest {

	
	@Test
	public void test() throws Exception {
		Connection con = DBConnector.getConnection();
		assertNotNull(con);
	}
	

}
