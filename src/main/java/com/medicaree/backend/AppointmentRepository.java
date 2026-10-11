package com.medicare;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

List<Appointment> findByPatientEmail(String patientEmail);

List<Appointment> findByDoctorId(Long doctorId);

}