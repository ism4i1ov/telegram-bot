package az.company.demotelegrambot.dto;

import az.company.demotelegrambot.entity.DevelopmentLangEntity;

import java.io.Serializable;

public class DevelopmentLangDto implements Serializable {

    private Long id;
    private String name;
    private String skills;
    private String others;

    public static DevelopmentLangDto toDto(DevelopmentLangEntity entity) {
        return new DevelopmentLangDto().setId(entity.getId())
                .setName(entity.getName())
                .setOthers(entity.getOthers())
                .setSkills(entity.getSkills());
    }

    public Long getId() {
        return id;
    }

    public DevelopmentLangDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public DevelopmentLangDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getSkills() {
        return skills;
    }

    public DevelopmentLangDto setSkills(String skills) {
        this.skills = skills;
        return this;
    }

    public String getOthers() {
        return others;
    }

    public DevelopmentLangDto setOthers(String others) {
        this.others = others;
        return this;
    }
}
