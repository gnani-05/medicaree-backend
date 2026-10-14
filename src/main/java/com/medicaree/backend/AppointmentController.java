package com.medicaree.backend;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/appointments")
@CrossOrigin(origins = "http://localhost:5173")
public class AppointmentController {

private final AppointmentRepository appointmentRepository;
private final DoctorRepository doctorRepository;

public AppointmentController(
        AppointmentRepository appointmentRepository,
        DoctorRepository doctorRepository) {
    this.appointmentRepository = appointmentRepository;
    this.doctorRepository = doctorRepository;
}

@PostMapping
public ResponseEntity<?> bookAppointment(@RequestBody Appointment appointment) {
    if (appointment.getPatientName() == null
            || appointment.getPatientEmail() == null
            || appointment.getDoctorId() == null
            || appointment.getDate() == null
            || appointment.getTime() == null) {
        return ResponseEntity.badRequest().body("Please fill all required fields.");
    }

    Doctor doctor = doctorRepository.findById(appointment.getDoctorId())
            .orElse(null);

    if (doctor == null) {
        return ResponseEntity.badRequest().body("Doctor not found.");
    }

    appointment.setDoctorName(doctor.getName());
    appointment.setSpecialization(doctor.getSpecialization());
    appointment.setStatus("PENDING");

    return ResponseEntity.ok(appointmentRepository.save(appointment));
}

@GetMapping
public List<Appointment> getAllAppointments() {
    return appointmentRepository.findAll();
}

@GetMapping("/patient/{email}")
public List<Appointment> getPatientAppointments(@PathVariable String email) {
    return appointmentRepository.findByPatientEmail(email);
}

@GetMapping("/doctor/{doctorId}")
public List<Appointment> getDoctorAppointments(@PathVariable Long doctorId) {
    return appointmentRepository.findByDoctorId(doctorId);
}

@PutMapping("/{id}/status")
public ResponseEntity<?> updateAppointmentStatus(
        @PathVariable Long id,
        @RequestBody Map<String, String> request) {

    String status = request.get("status");

    if (status == null
            || !(status.equals("ACCEPTED") || status.equals("REJECTED"))) {
        return ResponseEntity.badRequest()
                .body("Status must be ACCEPTED or REJECTED.");
    }

    Appointment appointment = appointmentRepository.findById(id)
            .orElse(null);

    if (appointment == null) {
        return ResponseEntity.notFound().build();
    }

    appointment.setStatus(status);
    return ResponseEntity.ok(appointmentRepository.save(appointment));
}

}