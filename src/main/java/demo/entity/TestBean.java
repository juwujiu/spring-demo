package demo.entity;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class TestBean
{
    @NotNull(message = "id isn't allowed null!")
    String id;
    List<String> names;
    String status;
}
