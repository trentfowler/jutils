package dev.tfowler.jutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class PropertyLoader {
  public static Properties fromFile(final File file) throws IOException {
    Properties properties = new Properties();
    try (InputStream fis = new FileInputStream(file)) {
      properties.load(fis);
    }
    return properties;
  }

  public static Properties fromName(final String fileName) throws IOException {
    return fromFile(new File(fileName));
  }

  public static Properties fromUrl(final URL url) throws IOException {
      return fromFile(getFileFromURL(url));
  }

  private static File getFileFromURL(final URL url) throws IOException {
    try {
      return new File(url.toURI());
    } catch (Exception e) {
      throw new IOException("Invalid URL syntax.", e);
    }
  }
}
