package demo;

import org.springframework.core.ResolvableType;

public class Test17
{

    public static void main(String[] args)
    {
        t();
    }

    private static void t()
    {
        ResolvableType type = ResolvableType.forClass(NameRule.class);
        System.out.println(type);
    }
}
