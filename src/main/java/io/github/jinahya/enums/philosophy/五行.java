package io.github.jinahya.enums.philosophy;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Constants for <a href="https://en.wikipedia.org/wiki/Wuxing_(Chinese_philosophy)">Wuxing (Chinese philosophy)</a>.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see <a href="https://zh.wikipedia.org/wiki/%E4%BA%94%E8%A1%8C">五行</a> (Wikipedia)
 * @see <a href="https://ko.wikipedia.org/wiki/%EC%98%A4%ED%96%89">오행</a> (Wikipedia)
 */
@SuppressWarnings({"NonAsciiCharacters", "java:S115"})
public enum 五行 {

    /**
     * Wood.
     */
    木,

    /**
     * Fire.
     */
    火,

    /**
     * Earth.
     */
    土,

    /**
     * Metal.
     */
    金,

    /**
     * Water.
     */
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
                        if (name.equals(value.name(Locale.KOREAN))) {
                            return value;
                        }
                    }
                    throw new IllegalArgumentException("no value for dayOfWeek: " + dow);
                }
        );
    }

    // -----------------------------------------------------------------------------------------------------------------
    public String name(final Locale locale) {
        Objects.requireNonNull(locale, "locale is null");
        return localesAndNames.computeIfAbsent(locale, l -> {
            try {
                final var bundle = ResourceBundle.getBundle(getClass().getName(), locale);
                return bundle.getString(name());
            } catch (final MissingResourceException mre) {
                return name();
            }
        });
    }

    // -----------------------------------------------------------------------------------------------------------------
    private final Map<Locale, String> localesAndNames = new ConcurrentHashMap<>();
}
