package demo;

import java.net.URL;
import java.net.URLClassLoader;

public class UClassloader extends URLClassLoader
{

    public UClassloader(URL[] urls)
    {
        super(urls);
    }
}
