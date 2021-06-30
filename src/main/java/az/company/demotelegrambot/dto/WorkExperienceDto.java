package az.company.demotelegrambot.dto;

import az.company.demotelegrambot.entity.WorkExperienceEntity;

import javax.persistence.*;
import java.io.Serializable;

public class WorkExperienceDto implements Serializable {

    private Long id;
    private String companyName;
    private String workExperienceYears;
    private String specializationOnWork;

    public static WorkExperienceDto toDto(WorkExperienceEntity experienceEntity) {
        return new WorkExperienceDto().setId(experienceEntity.getId())
                .setCompanyName(experienceEntity.getCompanyName())
                .setSpecializationOnWork(experienceEntity.getSpecializationOnWork())
                .setWorkExperienceYears(experienceEntity.getWorkExperienceYears());
    }

    public Long getId() {
        return id;
    }

    public WorkExperienceDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public WorkExperienceDto setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getWorkExperienceYears() {
        return workExperienceYears;
    }

    public WorkExperienceDto setWorkExperienceYears(String workExperienceYears) {
        this.workExperienceYears = workExperienceYears;
        return this;
    }

    public String getSpecializationOnWork() {
        return specializationOnWork;
    }

    public WorkExperienceDto setSpecializationOnWork(String specializationOnWork) {
        this.specializationOnWork = specializationOnWork;
        return this;
    }
}
