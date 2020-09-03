package com.example.file;

import io.xjar.XKit;
import io.xjar.boot.XBoot;
import io.xjar.key.XKey;

public class XjarBuild {
    public static void main(String[] args) {
        String password = "npsty";
        try {
            XKey xKey = XKit.key(password);
            XBoot.encrypt("/Users/ruankerui/Code/Java/npsty/target/npsty.jar",
                    "/Users/ruankerui/Code/Java/npsty/target/npsty_encrypted.jar", xKey);
            System.out.println("=========sucess=======");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
