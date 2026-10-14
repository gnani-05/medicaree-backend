package com.medicaree.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

@Bean
CommandLineRunner loadData(
        DoctorRepository doctorRepository,
        UserRepository userRepository) {

    return args -> {

        if (doctorRepository.count() == 0) {
            Doctor d1 = new Doctor();
            d1.setName("Dr. Ravi Kumar");
            d1.setSpecialization("Cardiologist");
            d1.setQualification("MBBS, MD");
            d1.setExperience(12);
            d1.setAvailableDays("Monday-Friday");
            d1.setTiming("10:00 AM - 2:00 PM");
            d1.setFee(700);
            doctorRepository.save(d1);

            Doctor d2 = new Doctor();
            d2.setName("Dr. Priya Sharma");
            d2.setSpecialization("Gynecologist");
            d2.setQualification("MBBS, MS");
            d2.setExperience(8);
            d2.setAvailableDays("Monday, Wednesday, Friday");
            d2.setTiming("2:00 PM - 6:00 PM");
            d2.setFee(600);
            doctorRepository.save(d2);

            Doctor d3 = new Doctor();
            d3.setName("Dr. Anil Reddy");
            d3.setSpecialization("Dentist");
            d3.setQualification("BDS, MDS");
            d3.setExperience(10);
            d3.setAvailableDays("Tuesday, Thursday, Saturday");
            d3.setTiming("9:00 AM - 1:00 PM");
            d3.setFee(500);
            doctorRepository.save(d3);
        }

        if (!userRepository.existsByEmail("admin@medicare.com")) {
            User admin = new User();
            admin.setName("MediCare Admin");
            admin.setEmail("admin@medicare.com");
            admin.setPassword("Admin@123");
            admin.setRole("ADMIN");
            userRepository.save(admin);
        }
    };
}

}