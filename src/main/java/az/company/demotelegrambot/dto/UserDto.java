package az.company.demotelegrambot.dto;

import az.company.demotelegrambot.entity.Role;
import az.company.demotelegrambot.entity.User;

import java.io.Serializable;


public class UserDto implements Serializable {
    private Long id;
    private String name;
    private String surname;
    private String username;
    private Long chatId;
    private Integer stateId;
    private String phone;
    private String email;
    private Role role;

    public UserDto() {
    }

    public Long getId() {
        return id;
    }

    public UserDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public UserDto setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public Long getChatId() {
        return chatId;
    }

    public UserDto setChatId(Long chatId) {
        this.chatId = chatId;
        return this;
    }

    public Integer getStateId() {
        return stateId;
    }

    public UserDto setStateId(Integer stateId) {
        this.stateId = stateId;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserDto setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public Role getRole() {
        return role;
    }

    public UserDto setRole(Role role) {
        this.role = role;
        return this;
    }

    public static UserDto toDto(User user) {
        return new UserDto().setId(user.getId())
                .setStateId(user.getStateId())
                .setName(user.getName())
                .setSurname(user.getSurname())
                .setUsername(user.getUsername())
                .setChatId(user.getChatId())
                .setId(user.getId())
                .setRole(user.getRole())
                .setEmail(user.getEmail())
                .setPhone(user.getPhone());
    }

    public static UserDto getInstance() {
        return new UserDto();
    }

    @Override
    public String toString() {
        return String.format("UserDto[id=%d, name='%s', surname='%s', username='%s', chatId=%d, stateId=%d, phone='%s', email='%s', role=%s]", id, name, surname, username, chatId, stateId, phone, email, role);
    }
}
