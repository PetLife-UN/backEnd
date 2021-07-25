package com.petlife.backend.requestModels.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class ApplyForm {
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    private String telNumber;
    @NotBlank
    private String movilNumber;
    @NotNull
    private Date date ;
    @NotBlank
    private String city;
    @NotBlank
    private String department;
    @NotBlank
    private String address;
    @NotNull
    private int age;
    private String occupation;
    @NotNull
    private int familyMembers;
    private int averageAge;
    @NotBlank
    private String whoAutho;
    @NotNull
    private Boolean familyAgreement;
    @NotBlank
    private String reason;
    @NotBlank
    private String restingPlace;
    @NotBlank
    private String careOption;
    @NotNull
    private boolean allergies;
    @NotNull
    private boolean animalExperience;
    private String experienceType;
    private int experienceLife;
    private String experienceNow;
    private String experienceReason;
    @NotNull
    private boolean adjustmentPeriod;
    private String adjustmentPeriodTime;
    @NotNull
    private boolean followingAgreement;
    @NotBlank
    private String communication;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getMovilNumber() {
        return movilNumber;
    }

    public void setMovilNumber(String movilNumber) {
        this.movilNumber = movilNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(int familyMembers) {
        this.familyMembers = familyMembers;
    }

    public int getAverageAge() {
        return averageAge;
    }

    public void setAverageAge(int averageAge) {
        this.averageAge = averageAge;
    }

    public String getWhoAutho() {
        return whoAutho;
    }

    public void setWhoAutho(String whoAutho) {
        this.whoAutho = whoAutho;
    }

    public Boolean getFamilyAgreement() {
        return familyAgreement;
    }

    public void setFamilyAgreement(Boolean familyAgreement) {
        this.familyAgreement = familyAgreement;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRestingPlace() {
        return restingPlace;
    }

    public void setRestingPlace(String restingPlace) {
        this.restingPlace = restingPlace;
    }

    public String getCareOption() {
        return careOption;
    }

    public void setCareOption(String careOption) {
        this.careOption = careOption;
    }

    public boolean isAllergies() {
        return allergies;
    }

    public void setAllergies(boolean allergies) {
        this.allergies = allergies;
    }

    public boolean isAnimalExperience() {
        return animalExperience;
    }

    public void setAnimalExperience(boolean animalExperience) {
        this.animalExperience = animalExperience;
    }

    public String getExperienceType() {
        return experienceType;
    }

    public void setExperienceType(String experienceType) {
        this.experienceType = experienceType;
    }

    public int getExperienceLife() {
        return experienceLife;
    }

    public void setExperienceLife(int experienceLife) {
        this.experienceLife = experienceLife;
    }

    public String getExperienceNow() {
        return experienceNow;
    }

    public void setExperienceNow(String experienceNow) {
        this.experienceNow = experienceNow;
    }

    public String getExperienceReason() {
        return experienceReason;
    }

    public void setExperienceReason(String experienceReason) {
        this.experienceReason = experienceReason;
    }

    public boolean isAdjustmentPeriod() {
        return adjustmentPeriod;
    }

    public void setAdjustmentPeriod(boolean adjustmentPeriod) {
        this.adjustmentPeriod = adjustmentPeriod;
    }

    public String isAdjustmentPeriodTime() {
        return adjustmentPeriodTime;
    }

    public void setAdjustmentPeriodTime(String adjustmentPeriodTime) {
        this.adjustmentPeriodTime = adjustmentPeriodTime;
    }


    public boolean isFollowingAgreement() {
        return followingAgreement;
    }

    public void setFollowingAgreement(boolean followingAgreement) {
        this.followingAgreement = followingAgreement;
    }

    public String getCommunication() {
        return communication;
    }

    public void setCommunication(String communication) {
        this.communication = communication;
    }

    public String getAdjustmentPeriodTime() {
        return adjustmentPeriodTime;
    }

}
