package demo.entity;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class TestBean {
    @NotNull(message = "id isn't allowed null!")
    String id;
    String name;
    String status;
}
