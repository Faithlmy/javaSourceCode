package com.spring.setter;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ProtocolResolver;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;

public class TestProtocolResolver implements ProtocolResolver {
    public static void main(String[] args) throws IOException {
        DefaultResourceLoader defaultResourceLoader = new DefaultResourceLoader();
        defaultResourceLoader.addProtocolResolver(new TestProtocolResolver());
        Resource resource = defaultResourceLoader.getResource("path:config.txt");

        InputStream inputStream = resource.getInputStream();
        StringBuffer out = new StringBuffer();
        byte[] b = new byte[4096];
        for (int n; (n = inputStream.read(b)) != -1; ) {
            out.append(new String(b, 0, n));
        }
        System.out.println(out);

    }


    public static final String PATH = "path:";
    @Override
    public Resource resolve(String location, ResourceLoader resourceLoader) {
        if (!location.startsWith(PATH))
            return null;
        String realPath = location.substring(5);
        String classPath = "classpath:config/" + realPath;

        return resourceLoader.getResource(classPath);
    }
}
