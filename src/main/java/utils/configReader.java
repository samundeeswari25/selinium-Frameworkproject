package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configReader {

    Properties pro;

    public void  configReader() throws IOException {
        FileInputStream f = new FileInputStream("src/test/resources/config.properties");

        pro = new Properties();
        pro.load(f);
    }

    public String getBrowser(){return pro.getProperty("browser");}

    public String getUrl(){return pro.getProperty("url");}

    public String getUserName(){return pro.getProperty("User_name");}

    public String getpassword(){return pro.getProperty("password");}


    }



