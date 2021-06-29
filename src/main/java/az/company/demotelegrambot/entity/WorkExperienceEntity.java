package az.company.demotelegrambot.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "work_ecperience")
public class WorkExperienceEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Basic(optional = false)
    @Column(name = "company_name")
    private String companyName;

    @Basic(optional = false)
    @Column(name = "date_from_on_work")
    private LocalDate dateFromOnWork;

    @Basic(optional = false)
    @Column(name = "date_to_on_work")
    private LocalDate dateToOnWork;

    @Basic(optional = false)
    @Column(name = "specialization_on_work")
    private String specializationOnWork;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity userEntity;

    public Long getId() {
        return id;
    }

    public WorkExperienceEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public WorkExperienceEntity setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public LocalDate getDateFromOnWork() {
        return dateFromOnWork;
    }

    public WorkExperienceEntity setDateFromOnWork(LocalDate dateFromOnWork) {
        this.dateFromOnWork = dateFromOnWork;
        return this;
    }

    public LocalDate getDateToOnWork() {
        return dateToOnWork;
    }

    public WorkExperienceEntity setDateToOnWork(LocalDate dateToOnWork) {
        this.dateToOnWork = dateToOnWork;
        return this;
    }

    public String getSpecializationOnWork() {
        return specializationOnWork;
    }

    public WorkExperienceEntity setSpecializationOnWork(String specializationOnWork) {
        this.specializationOnWork = specializationOnWork;
        return this;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public WorkExperienceEntity setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }
}
