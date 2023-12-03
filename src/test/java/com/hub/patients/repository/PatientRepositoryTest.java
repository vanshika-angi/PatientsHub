package com.hub.patients.repository;

import com.hub.patients.model.Patient;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class PatientRepositoryTest {

    @Autowired
    PatientRepository patientRepository;

    Patient patient;
    @BeforeEach
    void setUp() {

        patient = new Patient("Patient1","P1",
                "Number1","Address1","HeadAche");
        patientRepository.save(patient);


    }

    @AfterEach
    void tearDown() {
        patient = null;
        patientRepository.deleteAll();

    }

    //TestCase Success
    @Test
    void testfindByPatientName_Found(){
        List<Patient> patientList = patientRepository.findByPatientName("Patient1");
        Assertions.assertThat(patientList.get(0).getPatientId()).isEqualTo(patient.getPatientId());
        Assertions.assertThat(patientList.get(0).getPatientAddress()).isEqualTo(patient.getPatientAddress());
    }


    //Testcase failure
    @Test
    void testfindByPatientName_NotFound(){
        List<Patient> patientList = patientRepository.findByPatientName("Patient6");
        Assertions.assertThat(patientList.isEmpty()).isTrue();

    }
}
