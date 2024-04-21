package com.leobooth.utils;

import java.time.Duration;

public class WaitUtils {

  public static void hardWaitForSeconds(long seconds) {
    hardWait(Duration.ofSeconds(seconds));
  }

  public static void hardWaitForMillis(long milliseconds) {
    hardWait(Duration.ofMillis(milliseconds));
  }

  private static void hardWait(Duration waitTime) {
    try {
      Thread.sleep(waitTime.toMillis());
    } catch (InterruptedException e) {
      System.out.println("Unable to sleep execution thread: \n" + e.getMessage());
    }
  }
}
