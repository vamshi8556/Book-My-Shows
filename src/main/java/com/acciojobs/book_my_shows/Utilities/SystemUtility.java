package com.acciojobs.book_my_shows.Utilities;

import lombok.Synchronized;

import java.util.Random;

public class SystemUtility {
    private  static final Random random = new Random();

    public synchronized static String generateUserId() {
        int number = 100000 + random.nextInt(900000);
        return "USR" + number;
    }
}
