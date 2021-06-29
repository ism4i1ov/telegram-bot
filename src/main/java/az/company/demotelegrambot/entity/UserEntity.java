package az.company.demotelegrambot.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @Column(name = "surname")
    private String surname;

    @Basic(optional = false)
    @Column(name = "fatherName")
    private String fatherName;

    @Basic(optional = false)
    @Column(name = "birthDay")
    private LocalDate birthDay;

    @Basic(optional = false)
    @Column(name = "username")
    private String username;

    @Basic(optional = false)
    @Column(name = "chatId")
    private Long chatId;

    @Basic(optional = false)
    @Column(name = "address")
    private String address;

    @OneToMany
    private List<WorkExperienceEntity> workExperienceEntities;

    @OneToOne(mappedBy = "userEntity")
    private DevelopmentLangEntity developmentLangEntity;

    public Long getId() {
        return id;
    }

    public UserEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public UserEntity setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getFatherName() {
        return fatherName;
    }

    public UserEntity setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public Long getChatId() {
        return chatId;
    }

    public UserEntity setChatId(Long chatId) {
        this.chatId = chatId;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserEntity setAddress(String address) {
        this.address = address;
        return this;
    }

    public List<WorkExperienceEntity> getWorkExperienceEntities() {
        return workExperienceEntities;
    }

    public UserEntity setWorkExperienceEntities(List<WorkExperienceEntity> workExperienceEntities) {
        this.workExperienceEntities = workExperienceEntities;
        return this;
    }

    public DevelopmentLangEntity getDevelopmentLangEntity() {
        return developmentLangEntity;
    }

    public UserEntity setDevelopmentLangEntity(DevelopmentLangEntity developmentLangEntities) {
        this.developmentLangEntity = developmentLangEntities;
        return this;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public UserEntity setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
        return this;
    }

}
