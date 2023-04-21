package utility;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateUtils {
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private DateUtils() {
        throw new IllegalStateException("Utility class");
    }
    public static LocalDate parseDate(String dateString) {
        return LocalDate.parse(dateString, dateFormatter);
    }
    public static LocalDateTime parseDateTime(String dateTimeString) {
        return LocalDateTime.parse(dateTimeString, dateTimeFormatter);
    }
    public static long daysBetween(LocalDate startDate, LocalDate endDate) {
        return ChronoUnit.DAYS.between(startDate, endDate);
    }
    public static long hoursBetween(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return ChronoUnit.HOURS.between(startDateTime, endDateTime);
    }
    public static long minutesBetween(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return ChronoUnit.MINUTES.between(startDateTime, endDateTime);
    }
    public static long monthsBetween(LocalDate startDate, LocalDate endDate) {
        return ChronoUnit.MONTHS.between(startDate, endDate);
    }
    public static long yearsBetween(LocalDate startDate, LocalDate endDate) {
        return ChronoUnit.YEARS.between(startDate, endDate);
    }
    public static LocalDate today() {
        return LocalDate.now();
    }
    public static LocalDate yesterday() {
        return LocalDate.now().minusDays(1);
    }
    public static LocalDate tomorrow() {
        return LocalDate.now().plusDays(1);
    }
    public static LocalDateTime now() {
        return LocalDateTime.now();
    }
    public static LocalDateTime beforeMinutes(long minutes) {
        return LocalDateTime.now().minusMinutes(minutes);
    }
    public static LocalDateTime beforeHours(long hours) {
        return LocalDateTime.now().minusHours(hours);
    }
    public static LocalDateTime beforeDays(long days) {
        return LocalDateTime.now().minusDays(days);
    }
    public static LocalDateTime afterMinutes(long minutes) {
        return LocalDateTime.now().plusMinutes(minutes);
    }
    public static LocalDateTime afterHours(long hours) {
        return LocalDateTime.now().plusHours(hours);
    }
    public static LocalDateTime afterDays(long days) {
        return LocalDateTime.now().plusDays(days);
    }
}