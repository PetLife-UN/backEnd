package com.petlife.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.petlife.backend.requestModels.request.ApplyForm;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "applicationForm")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApplicationForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 150)
    private String name;

    @NotBlank
    @Size(max = 50)
    private String email;

    @Size(max = 9)
    private String telNumber;

    @NotBlank
    @Size(max = 10)
    private String movilNumber;

    @NotNull
    private Date date ;

    @NotBlank
    @Size(max = 30)
    private String city;

    @NotBlank
    @Size(max = 30)
    private String department;

    @NotBlank
    @Size(max = 60)
    private String address;

    @NotNull
    private int age;

    @Size(max = 30)
    private String occupation;

    @NotNull
    private int familyMembers;

    private int averageAge;

    @NotBlank
    @Size(max = 30)
    private String whoAutho;

    @NotNull
    private Boolean familyAgreement;

    @NotBlank
    @Size(max = 600)
    private String reason;

    @NotBlank
    @Size(max = 100)
    private String restingPlace;

    @NotBlank
    @Size(max = 100)
    private String careOption;

    @NotNull
    private boolean allergies;

    @NotNull
    private boolean animalExperience;

    @Size(max = 50)
    private String experienceType;

    private int experienceLife;

    @Size(max = 90)
    private String experienceNow;

    @Size(max = 50)
    private String experienceReason;

    @NotNull
    private boolean adjustmentPeriod;

    private String adjustmentPeriodTime;

    @NotNull
    private boolean followingAgreement;

    @NotBlank
    @Size(max = 25)
    private String communication;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "pet_id", nullable = false)
    private Pet pet;

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

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public ApplicationForm() {
    }

    public ApplicationForm(ApplyForm apf, Pet pet_id){
        this.name = apf.getName();
        this.email = apf.getEmail();
        this.telNumber = (!apf.getTelNumber().equals(""))? apf.getTelNumber(): "No aplica";
        this.movilNumber = apf.getMovilNumber();
        this.date = apf.getDate();
        this.city = apf.getCity();
        this.department = apf.getDepartment();
        this.address = apf.getAddress();
        this.age = apf.getAge();
        this.occupation = (!apf.getOccupation().equals(""))? apf.getOccupation(): "Confidencial";
        this.familyMembers = apf.getFamilyMembers();
        this.averageAge = (apf.getAverageAge() != 0)? apf.getAverageAge(): 0;
        this.whoAutho = apf.getWhoAutho();
        this.familyAgreement = apf.getFamilyAgreement();
        this.reason = apf.getReason();
        this.restingPlace = apf.getRestingPlace();
        this.careOption = apf.getCareOption();
        this.allergies = apf.isAllergies();
        this.animalExperience = apf.isAnimalExperience();
        this.experienceType = (!apf.getExperienceType().equals(""))? apf.getExperienceType(): "No aplica";
        this.experienceLife = (apf.getExperienceLife() != 0)? apf.getExperienceLife(): 0;
        this.experienceNow  = (!apf.getExperienceNow().equals(""))? apf.getExperienceNow(): "No aplica";
        this.experienceReason = (!apf.getExperienceReason().equals(""))? apf.getExperienceReason(): "No aplica";
        this.adjustmentPeriod = apf.isAdjustmentPeriod();
        this.adjustmentPeriodTime = (!apf.isAdjustmentPeriodTime().equals("") )? apf.isAdjustmentPeriodTime(): "No aplica";
        this.followingAgreement = apf.isFollowingAgreement();
        this.communication = apf.getCommunication();
        this.pet = pet_id;
    }


}
