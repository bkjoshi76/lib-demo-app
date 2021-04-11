package com.prerana.android.swadhishta;

public class ScanInfo {

    // static variable single_instance of type Singleton
    private static ScanInfo single_instance = null;

    // variable of type String
    public String ScanId;

    // private constructor restricted to this class itself
    private ScanInfo()
    {
        ScanId = "";
    }

    // static method to create instance of Singleton class
    public static ScanInfo getInstance()
    {
        if (single_instance == null)
            single_instance = new ScanInfo();

        return single_instance;
    }

    public String getScanId()
    {
        return ScanId;
    }

    public void setScanId(String id)
    {
        ScanId = id;
    }
}
