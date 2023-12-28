package util;

import java.io.InputStream;

public class ResourceProviderUtil {
    public static InputStream getResource(String name) {

        return Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream(name);
    }
}