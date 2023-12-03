package com.hub.patients.service.impl;

import com.hub.patients.model.Patient;
import com.hub.patients.repository.PatientRepository;
import com.hub.patients.service.PatientService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;


class PatientServiceImplTest {

    @Mock
    private PatientRepository patientRepository;
    private PatientService patientService;
    AutoCloseable autoCloseable;
    Patient patient;


    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        patientService = new PatientServiceImpl(patientRepository);
        patient = new Patient("Patient1","P1",
                "Number1","Address1","HeadAche");
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testcreatePatientDetails() {
        mock(Patient.class);
        mock(PatientRepository.class);

        when(patientRepository.save(patient)).thenReturn(patient);
        Assertions.assertThat(patientService.createPatientDetails(patient)).isEqualTo("Success: Patient1");

    }

    @Test
    void testupdatePatientDetails() {
        mock(Patient.class);
        mock(PatientRepository.class);

        when(patientRepository.save(patient)).thenReturn(patient);
        Assertions.assertThat(patientService.updatePatientDetails(patient)).isEqualTo("Updated: Patient1");

    }

    @Test
    void testgetPatientDetails() {
        mock(Patient.class);
        mock(PatientRepository.class);

        when(patientRepository.findById("1")).thenReturn(Optional.ofNullable(patient));
        Assertions.assertThat(patientService.getPatientDetails("1").getPatientName()).isEqualTo(patient.getPatientName());
    }

    @Test
    void getByPatientName() {
        mock(Patient.class);
        mock(PatientRepository.class);

        when(patientRepository.findByPatientName("Patient1")).thenReturn(
            new ArrayList<Patient>(Collections.singleton(patient)));

        Assertions.assertThat(patientService.getByPatientName("Patient1").get(0).getPatientId()).isEqualTo(patient.getPatientId());

    }

    @Test
    void testdeletePatientDetails() {
        mock(Patient.class);
        mock(PatientRepository.class, CALLS_REAL_METHODS);

        Mockito.doAnswer(Answers.CALLS_REAL_METHODS).when(
                patientRepository).deleteById(any());
        Assertions.assertThat(patientService.deletePatientDetails("P1")).isEqualTo("Deleted !!");


    }

    @Test
    void testgetAllPatient() {
        mock(Patient.class);
        mock(PatientRepository.class);
        when(patientRepository.findAll()).thenReturn(
             new ArrayList<Patient>(Collections.singleton(patient))
        );

        Assertions.assertThat(patientService.getAllPatient().get(0).getPatientNumber()).isEqualTo(patient.getPatientNumber());

    }


}