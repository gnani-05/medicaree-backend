package com.medicare;

import jakarta.persistence.*;

@Entity
public class Appointment {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String patientName;
private String patientEmail;
private String patientPhone;

private Long doctorId;
private String doctorName;
private String specialization;

private String date;
private String time;

private String status = "PENDING";

public Appointment() {
}

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getPatientName() {
    return patientName;
}

public void setPatientName(String patientName) {
    this.patientName = patientName;
}

public String getPatientEmail() {
    return patientEmail;
}

public void setPatientEmail(String patientEmail) {
    this.patientEmail = patientEmail;
}

public String getPatientPhone() {
    return patientPhone;
}

public void setPatientPhone(String patientPhone) {
    this.patientPhone = patientPhone;
}

public Long getDoctorId() {
    return doctorId;
}

public void setDoctorId(Long doctorId) {
    this.doctorId = doctorId;
}

public String getDoctorName() {
    return doctorName;
}

public void setDoctorName(String doctorName) {
    this.doctorName = doctorName;
}

public String getSpecialization() {
    return specialization;
}

public void setSpecialization(String specialization) {
    this.specialization = specialization;
}

public String getDate() {
    return date;
}

public void setDate(String date) {
    this.date = date;
}

public String getTime() {
    return time;
}

public void setTime(String time) {
    this.time = time;
}

public String getStatus() {
    return status;
}

public void setStatus(String status) {
    this.status = status;
}

}