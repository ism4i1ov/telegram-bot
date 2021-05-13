package az.company.demotelegrambot.dto;

import java.io.Serializable;

public class RoleDto implements Serializable {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public RoleDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RoleDto setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return String.format("RoleDto[id=%d, name='%s']", id, name);
    }
}
