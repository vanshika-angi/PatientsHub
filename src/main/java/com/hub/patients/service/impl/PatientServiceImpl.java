package com.hub.patients.service.impl;

import com.hub.patients.exception.PatientNotFoundException;
import com.hub.patients.model.Patient;
import com.hub.patients.repository.PatientRepository;
import com.hub.patients.service.PatientService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public String createPatientDetails(Patient patient) {
        patientRepository.save(patient);
        return "Success: " + patient.getPatientName();
    }

    @Override
    @CachePut(cacheNames = "patient", key = "#patient.patientId")
    public String updatePatientDetails(Patient patient) {
        patientRepository.save(patient);
        return "Updated: " + patient.getPatientName();
    }

    @Override
    @Cacheable(value = "patient", key = "#patientId")
    public Patient getPatientDetails(String patientId) {
        System.out.println("Getting patient Details from DB...");
        if(patientRepository.findById(patientId).isEmpty())
            throw  new PatientNotFoundException("Requested Patient does not exist.");
        return patientRepository.findById(patientId).get();
    }

    @Override
    @CacheEvict(cacheNames="patient", key="#patientId")
    public String deletePatientDetails(String patientId) {
        patientRepository.deleteById(patientId);
        return "Deleted !!";
    }

    @Override
//    @Cacheable(value = "patient")
    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    @Override
    public List<Patient> getByPatientName(String patientName)
    {
        return patientRepository.findByPatientName(patientName);
    }
}
