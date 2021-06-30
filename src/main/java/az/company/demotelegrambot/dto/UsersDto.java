package az.company.demotelegrambot.dto;

import az.company.demotelegrambot.entity.UserEntity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class UsersDto implements Serializable {

    private Long id;
    private String name;
    private String surname;
    private String fatherName;
    private LocalDate birthDay;
    private String username;
    private Long chatId;
    private String address;
    private List<WorkExperienceDto> workExperienceEntities;
    private DevelopmentLangDto developmentLangEntity;

    public static UsersDto toDto(UserEntity entity) {
        return new UsersDto().setId(entity.getId())
                .setAddress(entity.getAddress())
                .setBirthDay(entity.getBirthDay())
                .setChatId(entity.getChatId())
                .setDevelopmentLangDto(DevelopmentLangDto.toDto(entity.getDevelopmentLangEntity()))
                .setFatherName(entity.getFatherName())
                .setName(entity.getName())
                .setSurname(entity.getSurname())
                .setUsername(entity.getUsername())
                .setWorkExperienceDtos(entity.getWorkExperienceEntities().stream().map(WorkExperienceDto::toDto).collect(Collectors.toList()));
    }

    public Long getId() {
        return id;
    }

    public UsersDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UsersDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public UsersDto setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getFatherName() {
        return fatherName;
    }

    public UsersDto setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public UsersDto setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UsersDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public Long getChatId() {
        return chatId;
    }

    public UsersDto setChatId(Long chatId) {
        this.chatId = chatId;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UsersDto setAddress(String address) {
        this.address = address;
        return this;
    }

    public List<WorkExperienceDto> getWorkExperienceDtos() {
        return workExperienceEntities;
    }

    public UsersDto setWorkExperienceDtos(List<WorkExperienceDto> workExperienceDtos) {
        this.workExperienceEntities = workExperienceDtos;
        return this;
    }

    public DevelopmentLangDto getDevelopmentLangDto() {
        return developmentLangEntity;
    }

    public UsersDto setDevelopmentLangDto(DevelopmentLangDto developmentLangDto) {
        this.developmentLangEntity = developmentLangDto;
        return this;
    }

    @Override
    public String toString() {
        return String.format("UsersDto{id=%d, name='%s', surname='%s', fatherName='%s', birthDay=%s, username='%s', chatId=%d, address='%s', workExperienceEntities=%s, developmentLangEntity=%s}", id, name, surname, fatherName, birthDay, username, chatId, address, workExperienceEntities, developmentLangEntity);
    }
}
