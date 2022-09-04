package com.mindtree.patientservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.patientservice.entity.PatientEntity;
import com.mindtree.patientservice.service.PatientService;

@RestController
public class PatientController {
	@Autowired
	private PatientService service;
	
	@PostMapping("/addPatient")
	public ResponseEntity<String> savePatient(@RequestBody PatientEntity patient) throws Exception {
		service.savePatient(patient);
		return new ResponseEntity<String>("Patient saved successfully",HttpStatus.OK);
	}
	
	@GetMapping("/getPatient/{id}")
	public PatientEntity getPatient(@PathVariable int id) throws Exception {
		return service.getPatient(id);
	}
	
	@GetMapping("/getPatientList/{id}")
	public List<PatientEntity> getVisitedPatientList(@PathVariable int id){
		return service.getVisitedPatientList(id);
	}

}
