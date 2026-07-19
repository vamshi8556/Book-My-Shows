package com.acciojobs.book_my_shows.Utilities;

import lombok.Synchronized;

import java.lang.ref.Reference;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

public class SystemUtility {
    private static final Random random = new Random();
    private static final LocalDateTime referencetime = LocalDateTime.of(2020,1,1,0,0,0);
    public synchronized static String generateUserId() {
        int number = 100000 + random.nextInt(900000);
        return "USR" + number;
    }
    public static Long Convertshowtimeintoseconds(LocalDateTime time){
        return Duration.between(referencetime,time).getSeconds();
    }
}
