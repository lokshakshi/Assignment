package com.mindbowser.controller;

import java.security.Timestamp;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mindbowser.model.EmployeeEntity;
import com.mindbowser.model.ManagerEntity;
import com.mindbowser.service.EmployeeService;
import com.mindbowser.service.ManagerService;

@Controller
@RequestMapping(path = "/admin")
@CrossOrigin(origins = "*")
public class AdminManagerController {

	@Autowired
	ManagerService managerservice;
	
	@Autowired
	EmployeeService employeeservice;

	private static Logger logger = LoggerFactory.getLogger(AdminManagerController.class);

	@GetMapping("/managerDetails")
	@ResponseBody
	public List<ManagerEntity> getManagerDetails() {
		logger.info("ManagerDetails fetching starts");
		List<ManagerEntity> managerlist = managerservice.getManagerDetails();
		logger.info("Managerdetails fecthing completed");
		return managerlist;
	}

	@PutMapping(value = "/signUpManager", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> putRole(@RequestBody ManagerEntity managerEntity) {
		logger.info("putmanagerEntity :: start");
		logger.info("Updated managerEntity {}", managerEntity);

		HttpStatus httpStatus = null;

		String status = "";

		try {
			managerservice.saveUpdateManagerDetails(managerEntity);
			httpStatus = HttpStatus.OK;
		} catch (Exception e) {

			logger.error("Exception in putmanagerEntity", e);
			httpStatus = HttpStatus.BAD_GATEWAY;
			status = "Error occured";
		}
		logger.info("putmanagerEntity :: end");
		return new ResponseEntity<>(status, httpStatus);
	}

	@PostMapping(value = "/signUpManager", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })

	public ResponseEntity<String> postRole(@RequestBody ManagerEntity managerEntity) {

		logger.info("postmanagerEntity :: start");
		logger.info("ManagerEntity {}", managerEntity);
		HttpStatus httpStatus = null;

		String status = "";

		try {
			managerEntity.setAddress(managerEntity.getAddress());
			managerEntity.setCompany(managerEntity.getCompany());
			managerEntity.setDob(managerEntity.getDob());
			managerEntity.setEmail(managerEntity.getEmail());
			managerEntity.setFname(managerEntity.getFname());
			managerEntity.setLname(managerEntity.getLname());
			managerEntity.setId(managerEntity.getId());
			managerEntity.setPassword(managerEntity.getPassword());

			managerservice.saveUpdateManagerDetails(managerEntity);
			httpStatus = HttpStatus.OK;

		} catch (Exception e) {

			logger.error("Exception in postmanagerEntity", e);
			httpStatus = HttpStatus.BAD_GATEWAY;
			status = "Error occured";
		}

		logger.info("postmanagerEntity :: end");
		return new ResponseEntity<>(status, httpStatus);

	}

	 @DeleteMapping(value = "/delete/{managerid}", consumes = {
	 MediaType.APPLICATION_JSON_VALUE }, produces = {
	 MediaType.APPLICATION_JSON_VALUE })
	 public ResponseEntity<String> deleteRole(@PathVariable(required = true)
	 String managerid) {

	 logger.info("deleteRole :: start");
	 logger.info("managerid :: " +managerid);
	
	 HttpStatus httpStatus = null;
	
	 String status = "";
	
	 try {
	
		 managerservice.deleteManager(managerid);
	
	 httpStatus = HttpStatus.OK;
	
	 } catch (DataIntegrityViolationException e) {
	
		 logger.error("DataIntegrityViolationException in postRole", e);
	
	 httpStatus = HttpStatus.BAD_GATEWAY;
	
	 status = "Role is assigned to some user. Hence could not delete this role.";
	
	 } catch (Exception e) {
	
		 logger.error("Exception in postRole", e);
	
	 httpStatus = HttpStatus.BAD_GATEWAY;
	
	 status = "Error occured";
	
	 }
	
	 logger.info("deleteRole :: end");
	
	 return new ResponseEntity<>(status, httpStatus);
	
	 }
	 
	 ///Employee
	 
	 @GetMapping("/employeeDetails")
		@ResponseBody
		public List<EmployeeEntity> getEmployeeDetails() {
			logger.info("employeeDetails fetching starts");
			List<EmployeeEntity> employeelist = employeeservice.getEmployeeDetails();
			logger.info("employeeDetails fecthing completed");
			return employeelist;
		}

		@PutMapping(value = "/signUpEmployee", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
				MediaType.APPLICATION_JSON_VALUE })
		public ResponseEntity<String> putEmp(@RequestBody EmployeeEntity EmployeeEntity) {
			logger.info("EmployeeEntity :: start");
			logger.info("Updated EmployeeEntity {}", EmployeeEntity);

			HttpStatus httpStatus = null;

			String status = "";

			try {
				employeeservice.saveUpdateEmployeeDetails(EmployeeEntity);
				httpStatus = HttpStatus.OK;
			} catch (Exception e) {

				logger.error("Exception in putmanagerEntity", e);
				httpStatus = HttpStatus.BAD_GATEWAY;
				status = "Error occured";
			}
			logger.info("putEmployeeEntity :: end");
			return new ResponseEntity<>(status, httpStatus);
		}

		@PostMapping(value = "/signUpEmployee", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
				MediaType.APPLICATION_JSON_VALUE })

		public ResponseEntity<String> postEmp(@RequestBody EmployeeEntity employeeEntity) {

			logger.info("employeeEntity :: start");
			logger.info("employeeEntity {}", employeeEntity);
			HttpStatus httpStatus = null;

			String status = "";

			try {
				employeeEntity.setAddress(employeeEntity.getAddress());
				employeeEntity.setCity(employeeEntity.getCity());
				employeeEntity.setDob(employeeEntity.getDob());
				employeeEntity.setMobile(employeeEntity.getMobile());
				employeeEntity.setFname(employeeEntity.getFname());
				employeeEntity.setLname(employeeEntity.getLname());
				employeeEntity.setId(employeeEntity.getId());

				employeeservice.saveUpdateEmployeeDetails(employeeEntity);
				httpStatus = HttpStatus.OK;

			} catch (Exception e) {

				logger.error("Exception in employeeEntity", e);
				httpStatus = HttpStatus.BAD_GATEWAY;
				status = "Error occured";
			}

			logger.info("postmanagerEntity :: end");
			return new ResponseEntity<>(status, httpStatus);

		}

		 @DeleteMapping(value = "/deleteemp/{empid}", consumes = {
		 MediaType.APPLICATION_JSON_VALUE }, produces = {
		 MediaType.APPLICATION_JSON_VALUE })
		 public ResponseEntity<String> deleteEmp(@PathVariable(required = true)
		 String empid) {

		 logger.info("deleteEmp :: start");
		 logger.info("empid :: " +empid);
		
		 HttpStatus httpStatus = null;
		
		 String status = "";
		
		 try {		
			 employeeservice.deleteEmployee(empid);		
		 httpStatus = HttpStatus.OK;	
		 } catch (DataIntegrityViolationException e) {
			 logger.error("DataIntegrityViolationException in postRole", e);
		 httpStatus = HttpStatus.BAD_GATEWAY;
		 } catch (Exception e) {
			 logger.error("Exception in postRole", e);
		 httpStatus = HttpStatus.BAD_GATEWAY;
		 status = "Error occured";
		 }
		 logger.info("deleteEmp :: end");
		
		 return new ResponseEntity<>(status, httpStatus);
		
		 }

}
