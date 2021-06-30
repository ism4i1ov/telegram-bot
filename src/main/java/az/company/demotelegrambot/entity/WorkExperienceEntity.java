package az.company.demotelegrambot.entity;


import javax.persistence.*;
import java.io.Serializable;

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
    @Column(name = "work_experience_years")
    private String workExperienceYears;

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

    public String getWorkExperienceYears() {
        return workExperienceYears;
    }

    public WorkExperienceEntity setWorkExperienceYears(String workExperienceYears) {
        this.workExperienceYears = workExperienceYears;
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
