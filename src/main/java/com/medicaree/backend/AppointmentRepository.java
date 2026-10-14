package com.medicaree.backend;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

List<Appointment> findByPatientEmail(String patientEmail);

List<Appointment> findByDoctorId(Long doctorId);

}