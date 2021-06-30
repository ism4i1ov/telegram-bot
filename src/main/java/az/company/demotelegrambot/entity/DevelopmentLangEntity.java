package az.company.demotelegrambot.entity;

import az.company.demotelegrambot.dto.DevelopmentLangDto;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "development_lang")
public class DevelopmentLangEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @Column(name = "skills")
    private String skills;

    @Basic(optional = false)
    @Column(name = "others")
    private String others;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity userEntity;

    public static DevelopmentLangEntity toEntity(DevelopmentLangDto developmentLangDto, UserEntity userEntity) {
        return new DevelopmentLangEntity().setId(developmentLangDto.getId())
                .setOthers(developmentLangDto.getOthers())
                .setSkills(developmentLangDto.getSkills())
                .setName(developmentLangDto.getName())
                .setUserEntity(userEntity);
    }

    public Long getId() {
        return id;
    }

    public DevelopmentLangEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public DevelopmentLangEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getSkills() {
        return skills;
    }

    public DevelopmentLangEntity setSkills(String skills) {
        this.skills = skills;
        return this;
    }

    public String getOthers() {
        return others;
    }

    public DevelopmentLangEntity setOthers(String others) {
        this.others = others;
        return this;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public DevelopmentLangEntity setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        return this;
    }
}
