package com.cartellacardio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cartellacardio.dao.RecordDAO;
import com.cartellacardio.entity.Cartella;

@Service
public class RecordServiceImpl implements RecordService {

	@Autowired
	private RecordDAO recordDAO;
	
	@Override
	@Transactional
	public List<Cartella> getRecords(int id) {
		return recordDAO.getRecords(id);
	}

	@Override
	@Transactional
	public void saveRecord(Cartella cartella) {
		recordDAO.saveRecord(cartella);
	}

}
