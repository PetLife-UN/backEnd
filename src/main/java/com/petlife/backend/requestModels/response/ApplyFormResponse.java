package com.petlife.backend.requestModels.response;

import com.petlife.backend.models.ApplicationForm;
import com.petlife.backend.models.Pet;
import com.petlife.backend.requestModels.request.ApplyForm;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class ApplyFormResponse {

    private Long id;
    private String name;
    private String email;
    private String telNumber;
    private String movilNumber;
    private Date date ;
    private String city;
    private String department;
    private String address;
    private int age;
    private String occupation;
    private int familyMembers;
    private int averageAge;
    private String whoAutho;
    private Boolean familyAgreement;
    private String reason;
    private String restingPlace;
    private String careOption;
    private boolean allergies;
    private boolean animalExperience;
    private String experienceType;
    private int experienceLife;
    private String experienceNow;
    private String experienceReason;
    private boolean adjustmentPeriod;
    private String adjustmentPeriodTime;
    private boolean followingAgreement;
    private String communication;
    private PetResponse pet;
    private boolean publicationVisible;

    public ApplyFormResponse() {

    }

    public ApplyFormResponse(Long id, String name, String email, String telNumber, String movilNumber, Date date, String city, String department, String address, int age, String occupation, int familyMembers, int averageAge, String whoAutho, Boolean familyAgreement, String reason, String restingPlace, String careOption, boolean allergies, boolean animalExperience, String experienceType, int experienceLife, String experienceNow, String experienceReason, boolean adjustmentPeriod, String adjustmentPeriodTime, boolean followingAgreement, String communication, boolean publicationVisible, Pet pet) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.telNumber = telNumber;
        this.movilNumber = movilNumber;
        this.date = date;
        this.city = city;
        this.department = department;
        this.address = address;
        this.age = age;
        this.occupation = occupation;
        this.familyMembers = familyMembers;
        this.averageAge = averageAge;
        this.whoAutho = whoAutho;
        this.familyAgreement = familyAgreement;
        this.reason = reason;
        this.restingPlace = restingPlace;
        this.careOption = careOption;
        this.allergies = allergies;
        this.animalExperience = animalExperience;
        this.experienceType = experienceType;
        this.experienceLife = experienceLife;
        this.experienceNow = experienceNow;
        this.experienceReason = experienceReason;
        this.adjustmentPeriod = adjustmentPeriod;
        this.adjustmentPeriodTime = adjustmentPeriodTime;
        this.followingAgreement = followingAgreement;
        this.communication = communication;
        this.publicationVisible = publicationVisible;
        this.pet = new PetResponse(pet);
    }

    public ApplyFormResponse(ApplicationForm apply) {
        this.id = apply.getId();
        this.name = apply.getName();
        this.email = apply.getEmail();
        this.telNumber = apply.getTelNumber();
        this.movilNumber = apply.getMovilNumber();
        this.date = apply.getDate();
        this.city = apply.getCity();
        this.department = apply.getDepartment();
        this.address = apply.getAddress();
        this.age = apply.getAge();
        this.occupation = apply.getOccupation();
        this.familyMembers = apply.getFamilyMembers();
        this.averageAge = apply.getAverageAge();
        this.whoAutho = apply.getWhoAutho();
        this.familyAgreement = apply.getFamilyAgreement();
        this.reason = apply.getReason();
        this.restingPlace = apply.getRestingPlace();
        this.careOption = apply.getCareOption();
        this.allergies = apply.isAllergies();
        this.animalExperience = apply.isAnimalExperience();
        this.experienceType = apply.getExperienceType();
        this.experienceLife = apply.getExperienceLife();
        this.experienceNow = apply.getExperienceNow();
        this.experienceReason = apply.getExperienceReason();
        this.adjustmentPeriod = apply.isAdjustmentPeriod();
        this.adjustmentPeriodTime = apply.getAdjustmentPeriodTime();
        this.followingAgreement = apply.isFollowingAgreement();
        this.communication = apply.getCommunication();
        this.publicationVisible = apply.isPublicationVisible();
        this.pet = new PetResponse(apply.getPet());
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

    public String getAdjustmentPeriodTime() {
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

    public PetResponse getPet() {
        return pet;
    }

    public void setPet(PetResponse pet) {
        this.pet = pet;
    }

    public boolean isPublicationVisible() {
        return publicationVisible;
    }

    public void setPublicationVisible(boolean publicationVisible) {
        this.publicationVisible = publicationVisible;
    }
}
