package io.github.jinahya.enums.time;

import java.time.Month;
import java.time.MonthDay;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Constants of the <a href="https://en.wikipedia.org/wiki/Solar_term">Solar term</a>.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Solar_term">Solar term</a>
 */
@SuppressWarnings({
        "java:S115" // Constant names should comply with a naming convention
})
public enum 二十四節氣 {

    /**
     * Beginning of Spring.
     */
    立春(MonthDay.of(Month.FEBRUARY, 4)),

    /**
     * Rain Water.
     */
    雨水(MonthDay.of(Month.FEBRUARY, 19)),

    /**
     * Awakening of Insects.
     */
    惊蛰(MonthDay.of(Month.MARCH, 5)),

    /**
     * Spring Equinox.
     */
    春分(MonthDay.of(Month.MARCH, 20)),

    /**
     * Pure Brightness.
     */
    清明(MonthDay.of(Month.APRIL, 5)),

    /**
     * Grain Rain.
     */
    谷雨(MonthDay.of(Month.APRIL, 20)),

    /**
     * Beginning of Summer.
     */
    立夏(MonthDay.of(Month.MAY, 5)),

    /**
     * Grain Buds.
     */
    小满(MonthDay.of(Month.MAY, 21)),

    /**
     * Grain in Ear.
     */
    芒种(MonthDay.of(Month.JUNE, 6)),

    /**
     * Summer Solstice.
     */
    夏至(MonthDay.of(Month.JUNE, 21)),

    /**
     * Minor Heat.
     */
    小暑(MonthDay.of(Month.JULY, 7)),

    /**
     * Major heat.
     */
    大暑(MonthDay.of(Month.JULY, 22)),

    /**
     * Beginning of Autumn.
     */
    立秋(MonthDay.of(Month.AUGUST, 7)),

    /**
     * End of Heat.
     */
    处暑(MonthDay.of(Month.AUGUST, 23)),

    /**
     * White Dew.
     */
    白露(MonthDay.of(Month.SEPTEMBER, 7)),

    /**
     * Autumn Equinox.
     */
    秋分(MonthDay.of(Month.SEPTEMBER, 23)),

    /**
     * Cold Dew.
     */
    寒露(MonthDay.of(Month.OCTOBER, 8)),

    /**
     * Frost's Descent.
     */
    霜降(MonthDay.of(Month.OCTOBER, 23)),

    /**
     * Beginning of Winter.
     */
    立冬(MonthDay.of(Month.NOVEMBER, 7)),

    /**
     * Minor Snow.
     */
    小雪(MonthDay.of(Month.NOVEMBER, 22)),

    /**
     * Major Snow.
     */
    大雪(MonthDay.of(Month.DECEMBER, 7)),

    /**
     * Winter Solstice.
     */
    冬至(MonthDay.of(Month.DECEMBER, 22)),

    /**
     * Minor Cold.
     */
    小寒(MonthDay.of(Month.JANUARY, 5)),

    /**
     * Major Cold.
     */
    大寒(MonthDay.of(Month.JANUARY, 20));

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<Integer, 二十四節氣> LONGITUDES_AND_VALUES;

    static {
        LONGITUDES_AND_VALUES = Arrays.stream(values())
                .collect(
                        Collectors.toUnmodifiableMap(
                                二十四節氣::longitude,
                                Function.identity()
                        )
                );
    }

    private static final Map<MonthDay, 二十四節氣> DATES_AND_VALUES;

    static {
        DATES_AND_VALUES = Arrays.stream(values())
                .collect(
                        Collectors.toUnmodifiableMap(
                                二十四節氣::date,
                                Function.identity()
                        )
                );
    }

    // -----------------------------------------------------------------------------------------------------------------
    public static 二十四節氣 valueOfLongitude(final int longitude) {
        return Optional.ofNullable(LONGITUDES_AND_VALUES.get(longitude))
                .orElseThrow(() -> new IllegalArgumentException("no value for longitude(" + longitude + ")"));
    }

    public static 二十四節氣 valueOfDate(final MonthDay date) {
        Objects.requireNonNull(date, "date is null");
        return Optional.ofNullable(DATES_AND_VALUES.get(date))
                .orElseThrow(() -> new IllegalArgumentException("no value for date(" + date + ")"));
    }

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS
    二十四節氣(final MonthDay date) {
        this.date = Objects.requireNonNull(date, "date is null");
    }

    // -----------------------------------------------------------------------------------------------------------------
    public String name(final Locale locale) {
        Objects.requireNonNull(locale, "locale is null");
        try {
            final var bundle = ResourceBundle.getBundle(getClass().getName(), locale);
            return bundle.getString(name());
        } catch (final MissingResourceException mre) {
            return name();
        }
    }

    // ------------------------------------------------------------------------------------------------------- longitude
    public int longitude() {
        var result = longitude;
        if (result == null) {
            longitude = result = (315 + (ordinal() * 15)) % 360;
        }
        return result;
    }

    // ------------------------------------------------------------------------------------------------------------ date
    public MonthDay date() {
        return date;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private volatile Integer longitude;

    private final MonthDay date;
}
