package utils;

import io.github.cdimascio.dotenv.Dotenv;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configReader {

//    Properties pro;
    Dotenv dotenv;

    public   configReader() throws IOException {

        dotenv = Dotenv.configure()
                .directory(System.getProperty("user.dir"))  // ← Always finds project root
                .ignoreIfMissing()
                .load();

        // ✅ This will print the path so you can verify
        System.out.println("✅ .env loaded from: " + System.getProperty("user.dir"));

        // ✅ This will print the browser value to confirm it's reading correctly
        System.out.println("✅ Browser value: " + dotenv.get("browser"));
    }
//            FileInputStream f = new FileInputStream("src/test/resources/config.properties");
//
//            pro = new Properties();
//            pro.load(f);


    public String getBrowser(){
        return dotenv.get("browser");
    }

    public String getUrl(){
        return dotenv.get("url");
    }

    public String getUserName(){return dotenv.get("User_name");}

    public String getpassword(){return dotenv.get("password");}


    }



