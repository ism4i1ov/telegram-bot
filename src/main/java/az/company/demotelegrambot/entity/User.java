package az.company.demotelegrambot.entity;

import az.company.demotelegrambot.dto.UserDto;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Basic(optional = false)
    private Long id;

    @Column(name = "name")
    @Basic(optional = false)
    private String name;

    @Column(name = "surname")
    @Basic(optional = false)
    private String surname;

    @Column(name = "username")
    @Basic(optional = false)
    private String username;

    @Column(name = "chat_id")
    @Basic(optional = false)
    private Long chatId;

    @Column(name = "state_id")
    @Basic(optional = false)
    private Integer stateId;

    @Column(name = "phone")
    @Basic(optional = false)
    private String phone;

    @Column(name = "email")
    @Basic(optional = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public User setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public Long getChatId() {
        return chatId;
    }

    public User setChatId(Long chatId) {
        this.chatId = chatId;
        return this;
    }

    public Integer getStateId() {
        return stateId;
    }

    public User setStateId(Integer stateId) {
        this.stateId = stateId;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public Role getRole() {
        return role;
    }

    public User setRole(Role role) {
        this.role = role;
        return this;
    }

    public static User toEntity(UserDto userDto) {
        return new User().setStateId(userDto.getStateId())
                .setName(userDto.getName())
                .setSurname(userDto.getSurname())
                .setUsername(userDto.getUsername())
                .setChatId(userDto.getChatId())
                .setPhone(userDto.getPhone())
                .setEmail(userDto.getEmail());
    }
}
