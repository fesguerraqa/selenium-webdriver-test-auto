package com.testauto.commoncode;

import java.util.concurrent.TimeUnit;

public class HelperTools {

    /**
     * Verbose sleep with loop of text
     */
    public static void mySleep(int sleepTimeInSecs, String text) throws InterruptedException {

        System.out.println("\n\n" + text);

        for (int x = sleepTimeInSecs; x != 0; x--){
            System.out.println("Slept " +  x + " out of:" + sleepTimeInSecs);
            TimeUnit.SECONDS.sleep(1);
        }
    }
}