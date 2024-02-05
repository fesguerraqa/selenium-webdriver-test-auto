package com.testauto.commoncode;

import java.util.concurrent.TimeUnit;

public class HelperTools {

    /**
     * This is a convenience method to aid visually inspecting how the test is proceeding.
     * WARNING: Excessive usage can slow down a test's runtime.
     */
    public static void mySleep(int sleepTimeInSecs, String text) throws InterruptedException {

        System.out.println("\n\n" + text);

        for (int x = sleepTimeInSecs; x != 0; x--){
            System.out.println("Slept " +  x + " out of:" + sleepTimeInSecs);
            TimeUnit.SECONDS.sleep(1);
        }
    }
}