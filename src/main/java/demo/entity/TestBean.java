package demo.entity;

import java.util.List;

import lombok.Data;

@Data
public class TestBean
{
    String id;
    List<String> names;
    String status;
}
