package utils;

import org.openqa.selenium.devtools.v143.storage.model.SharedStorageReportingMetadata;

import java.util.Map;

public class ExcelManager {

    private static ThreadLocal<Map<String,String>>testdata = new ThreadLocal<>();

    public static void setTestdata(Map<String, String> data){
        testdata.set(data);

    }
    public static String getdata(String key){
        return testdata.get().get(key);
    }
    public static void unloadData(){
        testdata.remove();
    }
    public static Map<String,String>getAllData(){
        return testdata.get();
    }
}
