package com.raju.microservedemo.client.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    private Long id;


    @NotNull
    @Size(min = 4, max = 50)
    private String username;


    @NotNull
    @Size(min = 4, max = 100)
    private String password;


    @NotNull
    @Size(min = 2, max = 50)
    private String firstname;


    @NotNull
    @Size(min = 4, max = 50)
    private String lastname;


    @NotNull
    @Size(min = 4, max = 50)
    private String email;

    @JsonIgnore

    @NotNull
    private boolean activated;


    private Set<Authority> authorities = new HashSet<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", activated=" + activated +
                '}';
    }
}
