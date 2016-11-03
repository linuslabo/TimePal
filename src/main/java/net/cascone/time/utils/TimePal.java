package net.cascone.time.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.Objects;

@SuppressWarnings({ "unused", "WeakerAccess" })
public class TimePal {

    static {
        /* Setting defaults */
        DEFAULT_ZONE_OFFSET = ZoneOffset.UTC;
        DEFAULT_DATE_TIME_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    }

    // -------------------------------------------------------------------------
    // --- Custom Date and Time Patterns
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // --- Available Zones
    // -------------------------------------------------------------------------

    public final static ZoneOffset DEFAULT_ZONE_OFFSET;

    // -------------------------------------------------------------------------
    // --- Formatter list
    // -------------------------------------------------------------------------

    /**
     * The default formatter (An instance of {@link DateTimeFormatter#ISO_LOCAL_DATE_TIME} by default)
     */
    public final static DateTimeFormatter DEFAULT_DATE_TIME_FORMATTER;

    // -------------------------------------------------------------------------
    // --- Retrieving current time
    // -------------------------------------------------------------------------

    /**
     * Obtains a {@link String} representation of the current point on the time-line
     *
     * @return a {@link String} representation of the current point on the time-line
     */
    public static String now() {
        return format(Instant.now());
    }

    public static String now(DateTimeFormatter dateTimeFormatter) {
        return format(dateTimeFormatter, Instant.now());
    }

    public static Instant thisInstant() {
        return Instant.now();
    }

    public static Date thisDate() {
        return new Date();
    }

    public static LocalDateTime thisDateTime() {
        return LocalDateTime.now();
    }

    // -------------------------------------------------------------------------
    // --- Conversions
    // -------------------------------------------------------------------------

    /**
     * Obtains an instance of {@code Date} from an {@code Instant} object.
     *
     * @param instant the temporal unit to convert
     * @return a {@code Date} representing the same point on the time-line as the provided instant
     * @see Date:from
     */
    public Date convertToDate(Instant instant) {
        return Date.from(instant);
    }

    /**
     * Converts a {@link LocalDateTime} to a {@link Date} using using DEFAULT_ZONE_OFFSET
     *
     * @param localDateTime the temporal unit to convert
     * @return the {@link Date} representation of the {@link LocalDateTime} argument, using DEFAULT_ZONE_OFFSET
     */
    public Date convertToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.toInstant(DEFAULT_ZONE_OFFSET));
    }

    /**
     * Converts this {@code Date} object to an {@code Instant}.
     *
     * @param date the date to convert
     * @return an instant representing the same point on the time-line as this {@code Date} object
     * @see Date:toInstant
     */
    public Instant convertToInstant(Date date) {
        return date.toInstant();
    }

    // -------------------------------------------------------------------------
    // --- Comparison
    // -------------------------------------------------------------------------

    /**
     * Compares two {@link Date} objects
     *
     * @param aDate       a {@link Date} object
     * @param anotherDate a {@link Date} object
     * @return negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
     * @see Objects:compare
     */
    public static int compare(Date aDate, Date anotherDate) {
        return Objects.compare(aDate, anotherDate, Date::compareTo);
    }

    /**
     * Compares two {@link Instant} objects
     *
     * @param anInstant      a {@link Instant} object
     * @param anotherInstant a {@link Instant} object
     * @return negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
     * @see Objects:compare
     */
    public static int compare(Instant anInstant, Instant anotherInstant) {
        return Objects.compare(anInstant, anotherInstant, Instant::compareTo);
    }

    /**
     * Checks if a given {@link Date} is in the future
     *
     * @param date the point on the time-line to check
     * @return true if it is in the future, false otherwise
     */
    public static boolean isFuture(Date date) {
        return date.after(thisDate());
    }

    /**
     * Checks if a given {@link Instant} is in the future
     *
     * @param instant the point on the time-line to check
     * @return true if it is in the future, false otherwise
     */
    public static boolean isFuture(Instant instant) {
        return instant.isAfter(thisInstant());
    }

    /**
     * Checks if a given {@link Date} is in the past
     *
     * @param date the point on the time-line to check
     * @return true if it is in the past, false otherwise
     */
    public static boolean isPast(Date date) {
        return date.before(thisDate());
    }

    /**
     * Checks if a given {@link Instant} is in the past
     *
     * @param instant the point on the time-line to check
     * @return true if it is in the past, false otherwise
     */
    public static boolean isPast(Instant instant) {
        return instant.isBefore(thisInstant());
    }

    // -------------------------------------------------------------------------
    // --- Format time
    // -------------------------------------------------------------------------

    public static String format(TemporalAccessor temporalAccessor) {
        return DEFAULT_DATE_TIME_FORMATTER.withZone(DEFAULT_ZONE_OFFSET).format(temporalAccessor);
    }

    public static String format(DateTimeFormatter formatter, TemporalAccessor temporalAccessor) {
        return formatter.withZone(DEFAULT_ZONE_OFFSET).format(temporalAccessor);
    }

    public static String format(DateTimeFormatter formatter, TemporalAccessor temporalAccessor, ZoneOffset zoneOffset) {
        return formatter.withZone(zoneOffset).format(temporalAccessor);
    }

    // -------------------------------------------------------------------------
    // ---
    // --- Private Constructor
    // ---
    // -------------------------------------------------------------------------

    private TimePal() {
        // does not allow public initialization
    }
}
