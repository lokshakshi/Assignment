package com.mindbowser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcraft.jsch.Logger;
import com.mindbowser.model.ManagerEntity;
import com.mindbowser.repository.ManagerRepository;


@Component
public class ManagerService {
	
	@Autowired
	ManagerRepository managerRepository;
	
	public List<ManagerEntity> getManagerDetails()
	{
	return managerRepository.findAll();
	}
	
	public void saveUpdateManagerDetails(ManagerEntity managerEntity) throws Exception {
		 managerRepository.save(managerEntity);
	}
	
	public void deleteManager(String managerid) throws Exception {
		System.out.print("checking manageId" +Integer.parseInt(managerid));
		 managerRepository.deleteById(Integer.parseInt(managerid));
	}
}
