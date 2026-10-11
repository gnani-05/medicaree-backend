package com.medicare;

import jakarta.persistence.*;

@Entity
public class Doctor {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String name;
private String specialization;
private String qualification;
private int experience;
private String availableDays;
private String timing;
private double fee;

public Doctor() {
}

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getSpecialization() {
    return specialization;
}

public void setSpecialization(String specialization) {
    this.specialization = specialization;
}

public String getQualification() {
    return qualification;
}

public void setQualification(String qualification) {
    this.qualification = qualification;
}

public int getExperience() {
    return experience;
}

public void setExperience(int experience) {
    this.experience = experience;
}

public String getAvailableDays() {
    return availableDays;
}

public void setAvailableDays(String availableDays) {
    this.availableDays = availableDays;
}

public String getTiming() {
    return timing;
}

public void setTiming(String timing) {
    this.timing = timing;
}

public double getFee() {
    return fee;
}

public void setFee(double fee) {
    this.fee = fee;
}

}