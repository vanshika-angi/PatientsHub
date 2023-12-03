package com.hub.patients.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="patient_info")
public class Patient {

    private String patientName;
    @Id
    private String patientId;
    private String patientNumber;
    private String patientAddress;


    private String issueDescription;


    public Patient() {
    }

    public Patient(String patientName, String patientId, String patientNumber, String patientAddress, String issueDescription) {
        this.patientName = patientName;
        this.patientId = patientId;
        this.patientNumber = patientNumber;
        this.patientAddress = patientAddress;
        this.issueDescription = issueDescription;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

}
