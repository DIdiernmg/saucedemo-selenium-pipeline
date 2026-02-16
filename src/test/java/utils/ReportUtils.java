package utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ReportUtils {
    public static void createEnvironmentFile() {
        Properties properties = new Properties();
        properties.setProperty("Ambiente", "QA - SauceDemo");
        properties.setProperty("Navegador", "Chrome");
        properties.setProperty("Ingeniero", "Didier Marin (Tiko)");
        properties.setProperty("Java.Version", System.getProperty("java.version"));
        properties.setProperty("SO", System.getProperty("os.name"));

        try {
            // Esto lo crea directamente en la carpeta que Allure va a leer
            properties.store(new FileOutputStream("allure-results/environment.properties"), "Allure Environment");
            System.out.println("✅ Environment file creado en allure-results");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}