package com.mindtree.patientservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.mindtree.patientservice.entity.PatientEntity;
import com.mindtree.patientservice.pojo.Doctor;
import com.mindtree.patientservice.repository.PatientRepository;

@Service
public class PatientService {
	@Autowired
	private PatientRepository repository;
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	public void savePatient(PatientEntity patient) throws Exception {
		
		List<Doctor> ls = webClientBuilder.build().get()
				.uri("http://localhost:8020/DOCTOR-SERVICE/getDoctor")
				.retrieve()
				.bodyToMono(new ParameterizedTypeReference<List<Doctor>>() {})
				.block();
		
		for(Doctor doc: ls) {
			if(patient.getVisitedDoctor()== doc.getId()) {
				repository.save(patient);
				return ;
			}
		}
		
		throw new Exception("Doctor not found");
		
		
	}
	
	public PatientEntity getPatient(int id) throws Exception {
		Optional<PatientEntity> patOptional = repository.findById(id);
		if(patOptional.isPresent()) {
			return patOptional.get();
		} else {
			throw new Exception("Patient not found");
		}
	}
	
	public List<PatientEntity> getVisitedPatientList(int id){
		List<PatientEntity> patlist = new ArrayList<>();
		for(PatientEntity pat:repository.findAll()) {
			if(id == pat.getVisitedDoctor()) {
				patlist.add(pat);
			}
		}
		return patlist;
	}

}
