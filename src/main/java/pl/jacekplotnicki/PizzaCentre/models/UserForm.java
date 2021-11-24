package pl.jacekplotnicki.PizzaCentre.models;

import lombok.Data;

@Data
public class UserForm {
    private String email;
    private String name;
    private String address;
    private String tel;
}
