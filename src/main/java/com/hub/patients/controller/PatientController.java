package com.hub.patients.controller;

import com.hub.patients.model.Patient;
import com.hub.patients.response.ResponseHandler;
import com.hub.patients.service.PatientService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patienthub")
public class PatientController {

    PatientService patientService;
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }


    //Read specific patients
    @GetMapping("{patientId}")
    public ResponseEntity<Object> getPatientDetails(@PathVariable("patientId") String patientId)
    {

       return ResponseHandler.responseBuilder("Requested Patient details are given here", HttpStatus.OK, patientService.getPatientDetails(patientId));

    }

    //Read all patients
    @GetMapping()
    public List<Patient> getAllPatientDetails()
    {

        return patientService.getAllPatient();

    }

    @PostMapping
    public String createPatientDetails(@RequestBody Patient patient){

        patientService.createPatientDetails(patient);
        return "Success: " + patient.getPatientName();
    }

    @PutMapping
    public String UpdatePatientDetails(@RequestBody Patient patient){

        patientService.updatePatientDetails(patient);
        return "Updated: " + patient.getPatientName();
    }

    @DeleteMapping("{patientId}")
    public String DeletePatientDetails(@PathVariable("patientId") String patientId){

        String patientName = patientId;
        patientService.deletePatientDetails(patientId);
        return "Deleted: " + patientId;
    }

}
