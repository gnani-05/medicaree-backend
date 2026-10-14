package com.medicaree.backend;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/doctors")
@CrossOrigin(origins = "http://localhost:5173")
public class DoctorController {

private final DoctorRepository doctorRepository;

public DoctorController(DoctorRepository doctorRepository) {
    this.doctorRepository = doctorRepository;
}

@GetMapping
public List<Doctor> getAllDoctors() {
    return doctorRepository.findAll();
}

@GetMapping("/{id}")
public Doctor getDoctorById(@PathVariable Long id) {
    return doctorRepository.findById(id).orElse(null);
}

}