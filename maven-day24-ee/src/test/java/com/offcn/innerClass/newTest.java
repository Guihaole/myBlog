package com.offcn.innerClass;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class newTest {
    @Test
    public void start() {
        Consumer<Integer> consumer = (o) -> System.out.println(o);
        consumer.accept(1);
        Supplier<String> supplier = () -> "username";
        System.out.println(supplier.get());
        Function<String, String> function = (o) -> o.length() + "牛逼";
        System.out.println(function.apply("username"));
        Predicate<String> predicate = (s) -> "0".equals(s);
        System.out.println(predicate.test("0"));
        System.out.println("-------------------------------------------时间api");
        //时间api
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy--MM--dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(timeFormatter.format(now));
        TemporalAccessor temporalAccessor = timeFormatter.parse("2000--09--09 14:13:33");
        System.out.println(temporalAccessor);
        //时间转换
        Date date = new Date();
        //date-->localdateTime
        LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        //localDateTime
        Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
    }
}
