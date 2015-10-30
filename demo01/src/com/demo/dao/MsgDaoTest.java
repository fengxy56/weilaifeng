package com.demo.dao;

import java.util.List;

import org.junit.Test;

import com.demo.entity.Msg;

public class MsgDaoTest {

	@Test
	public void testFindAll() throws Exception {
		MsgDao dao = new MsgDao();
		List<Msg> msgs = dao.findAll();
		System.out.println(msgs);
	}
	
	//@Test
	public void testSave() throws Exception{
		MsgDao dao = new MsgDao();
		Msg m = new Msg();
		m.setName("asd");
		m.setEmail("dasfa@126.com");
		m.setSubject("dasf");
		m.setMessage("dasffffdasfas");
		dao.save(m);
	}
}
