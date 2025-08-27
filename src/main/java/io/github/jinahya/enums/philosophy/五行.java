package io.github.jinahya.enums.philosophy;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Constants for <a href="https://en.wikipedia.org/wiki/Wuxing_(Chinese_philosophy)">Wuxing (Chinese philosophy)</a>.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see <a href="https://zh.wikipedia.org/wiki/%E4%BA%94%E8%A1%8C">五行</a> (Wikipedia)
 * @see <a href="https://ko.wikipedia.org/wiki/%EC%98%A4%ED%96%89">오행</a> (Wikipedia)
 */
// https://www.compart.com/en/unicode/block/U+1F300
// https://www.compart.com/en/unicode/block/U+1F700 (Alchemical Symbols)
// https://www.compart.com/en/unicode/block/U+3200 (Enclosed CJK Letters and Months)
@SuppressWarnings({"NonAsciiCharacters", "java:S115"})
public enum 五行 {

    /**
     * Wood.
     */
    // https://www.compart.com/en/unicode/block/U+1F300
    // https://www.compart.com/en/unicode/U+1F332 (Evergreen Tree \ Miscellaneous Symbols and Pictographs)
    // https://www.compart.com/en/unicode/U+328D (Enclosed CJK Letters and Months)
    木,

    /**
     * Fire.
     */
    // https://www.compart.com/en/unicode/U+1F525 (Miscellaneous Symbols and Pictographs)
    // https://www.compart.com/en/unicode/U+1F702 (Alchemical Symbols)
    // https://www.compart.com/en/unicode/U+328B (Enclosed CJK Letters and Months)
    火,

    /**
     * Earth.
     */
    // https://www.compart.com/en/unicode/U+1F30F (Miscellaneous Symbols and Pictographs)
    // https://www.compart.com/en/unicode/U+1F703 (Alchemical Symbols)
    // https://www.compart.com/en/unicode/U+328F (Enclosed CJK Letters and Months)
    土,

    /**
     * Metal.
     */
    // https://www.compart.com/en/unicode/U+1F71A (Alchemical Symbols)
    // https://www.compart.com/en/unicode/U+328E (Enclosed CJK Letters and Months)
    金,

    /**
     * Water.
     */
    // https://www.compart.com/en/unicode/U+1F30A
    // https://www.compart.com/en/unicode/U+1F704 (Alchemical Symbols)
    // https://www.compart.com/en/unicode/U+328C (Enclosed CJK Letters and Months)
    水;

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<DayOfWeek, 五行> DAY_OF_WEEKS_AND_VALUES = new ConcurrentHashMap<>();

    /**
     * Returns the value associated with the specified day-of-week.
     *
     * @param dayOfWeek the day-of-week.
     * @return the value associated with {@code dayOfWeek}.
     * @apiNote Note that an {@link IllegalArgumentException} will be thrown for {@link DayOfWeek#MONDAY} and
     * {@link DayOfWeek#SATURDAY}.
     */
    public static 五行 valueOf(final DayOfWeek dayOfWeek) {
        return DAY_OF_WEEKS_AND_VALUES.computeIfAbsent(
                dayOfWeek,
                dow -> {
                    final var name = dow.getDisplayName(TextStyle.NARROW, Locale.KOREAN);
                    for (final var value : values()) {
                        if (name.equals(value.displayName(Locale.KOREAN))) {
                            return value;
                        }
                    }
                    throw new IllegalArgumentException("no value for dayOfWeek: " + dow);
                }
        );
    }

    // -----------------------------------------------------------------------------------------------------------------
    public String displayName(final Locale locale) {
        Objects.requireNonNull(locale, "locale is null");
        return localesAndDisplayNames.computeIfAbsent(locale, l -> {
            try {
                final var bundle = ResourceBundle.getBundle(getClass().getName(), locale);
                return bundle.getString(name());
            } catch (final MissingResourceException mre) {
                return name();
            }
        });
    }

    // -----------------------------------------------------------------------------------------------------------------
    private final Map<Locale, String> localesAndDisplayNames = new ConcurrentHashMap<>();
}
