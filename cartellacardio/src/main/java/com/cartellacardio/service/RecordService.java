package com.cartellacardio.service;

import java.util.List;

import com.cartellacardio.entity.Cartella;

public interface RecordService {
	
	public List<Cartella> getRecords(int id);
	
	public void saveRecord(Cartella cartella);

}
