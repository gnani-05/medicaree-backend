package com.medicaree.backend;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

private final UserRepository userRepository;

public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
}

@PostMapping("/register")
public ResponseEntity<?> register(@RequestBody User user) {

    if (user.getName() == null || user.getEmail() == null
            || user.getPassword() == null || user.getRole() == null) {
        return ResponseEntity.badRequest().body("Please fill all fields.");
    }

    String role = user.getRole().toUpperCase();

    if (!role.equals("PATIENT") && !role.equals("DOCTOR")) {
        return ResponseEntity.badRequest()
                .body("Registration is available for patients and doctors only.");
    }

    if (userRepository.existsByEmail(user.getEmail())) {
        return ResponseEntity.badRequest().body("Email already registered.");
    }

    user.setRole(role);
    return ResponseEntity.ok(userRepository.save(user));
}

@PostMapping("/login")
public ResponseEntity<?> login(@RequestBody Map<String, String> request) {

    String email = request.get("email");
    String password = request.get("password");
    String requestedRole = request.get("role");

    if (email == null || password == null || requestedRole == null) {
        return ResponseEntity.badRequest().body("Enter email, password, and role.");
    }

    User user = userRepository.findByEmail(email).orElse(null);

    if (user == null || !user.getPassword().equals(password)
            || !user.getRole().equalsIgnoreCase(requestedRole)) {
        return ResponseEntity.status(401).body("Invalid login details or role.");
    }

    return ResponseEntity.ok(Map.of(
            "id", user.getId(),
            "name", user.getName(),
            "email", user.getEmail(),
            "role", user.getRole(),
            "doctorId", user.getDoctorId() == null ? "" : user.getDoctorId()
    ));
}

}