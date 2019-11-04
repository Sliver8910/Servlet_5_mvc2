package com.test.notice;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ruda.notice.NoticeDAO;
import com.ruda.util.DBConnector;

public class NoticeDAOTest {
	private NoticeDAO noticeDAO;
	private Connection con;
	
	public NoticeDAOTest() throws Exception  {
		noticeDAO = new NoticeDAO();
		con = DBConnector.getConnection();
		con.setAutoCommit(false);
	}
	
	//@BeforeClass
	public static void beforeClass() {
		System.out.println("BeforeClass");
	}
	//@AfterClass
	public static void afterClass() {
		System.out.println("AfterClass");
	}
	
	
	//@Before
	public void before() {
		System.out.println("before");
	}
	@After
	public void after() throws Exception {
		System.out.println("after");
		//con.commit();
		con.rollback();
		con.setAutoCommit(true);
		con.close();
	}
	
	
	@Test
	public void listTest() throws Exception {
		noticeDAO.noticeList(con);
		
	}
	
	public void selectTest()throws Exception {
		//noticeDAO.noticeSelect(con, num);
		
	}

}
