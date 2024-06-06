package com.spring.rest.springrest.constant;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Component
public class Constans {
    public static final String DEBIT = "DEBIT";
    public static final String CREDIT = "CREDIT";

    public static final String INSUFFICIENT_BALANCE = "Saldo no disonible";
    public static final String ACCOUNT_NOT_FOUND = "Cuenta no encontrada";


    public Date truncateTime(Date date) {
        LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime truncatedDateTime = localDateTime.withHour(0).withMinute(0).withSecond(0).withNano(0);
        return Date.from(truncatedDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public Date endOfDay(Date date) {
        LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime endOfDayDateTime = localDateTime.withHour(23).withMinute(59).withSecond(59).withNano(999999999);
        return Date.from(endOfDayDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }


}
