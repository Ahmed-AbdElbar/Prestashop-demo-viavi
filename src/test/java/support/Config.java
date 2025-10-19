package support;

import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class Config {
    private static final Properties p = new Properties();
    static {
        try (InputStream is = Config.class.getClassLoader().getResourceAsStream("config.properties")) {
            p.load(is);
        } catch (Exception e) { throw new RuntimeException("Cannot load config.properties", e); }
    }
    public static String getProp(String k){
        return p.getProperty(k);
    }
    public static Duration explicitWait(){
        return Duration.ofSeconds(Long.parseLong(getProp("explicitWait")));
    }
    public static Duration implicitWait(){
        return Duration.ofSeconds(Long.parseLong(getProp("implicitWait")));
    }
    public static boolean headless(){
        return Boolean.parseBoolean(getProp("headless"));
    }
}
