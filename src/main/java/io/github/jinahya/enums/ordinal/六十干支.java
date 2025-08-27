package io.github.jinahya.enums.ordinal;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;

@SuppressWarnings({
        "NonAsciiCharacters",
        "java:S115" // Constant names should comply with a naming convention
})
public enum 六十干支 {

    // empty
    ;

    // -----------------------------------------------------------------------------------------------------------------
    private static final List<天干> heavenlyStems = List.copyOf(EnumSet.allOf(天干.class));

    private static final List<地支> earthlyBranches = List.copyOf(EnumSet.allOf(地支.class));

    public static void acceptEachPair(final BiConsumer<? super 天干, ? super 地支> consumer) {
        Objects.requireNonNull(consumer, "consumer is null");
        for (int s = 0, b = 0; ; s = ++s % heavenlyStems.size(), b = ++b % earthlyBranches.size()) {
            consumer.accept(heavenlyStems.get(s), earthlyBranches.get(b));
            if (s == heavenlyStems.size() - 1 && b == earthlyBranches.size() - 1) {
                break;
            }
        }
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static final List<String> NAMES;

    static {
        final List<String> names = new ArrayList<>();
        acceptEachPair((hs, eb) -> {
            names.add(hs.name() + eb.name());
        });
        NAMES = List.copyOf(names);
    }

    public static List<String> names() {
        return NAMES;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<Locale, List<String>> LOCALES_AND_NAMES = new ConcurrentHashMap<>();

    public static List<String> name(final Locale locale) {
        Objects.requireNonNull(locale, "locale is null");
        return LOCALES_AND_NAMES.computeIfAbsent(
                locale,
                l -> {
                    final var displayNames = new ArrayList<String>();
                    acceptEachPair((hs, eb) -> {
                        final var hsdn = hs.name(l);
                        final var ebdn = eb.name(l);
                        displayNames.add(hsdn + ebdn);
                    });
                    return displayNames;
                }
        );
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Returns the value of {@link 天干} associated with specified name.
     *
     * @param name the name.
     * @return the value of {@link 天干} associated with {@code name}.
     */
    public static 天干 天干(final String name) {
        Objects.requireNonNull(name, "name is null");
        final var codePoint = name.codePointAt(0);
        final var codePoints = new int[] {codePoint};
        return 天干.valueOf(
                new String(codePoints, 0, codePoints.length)
        );
    }

    /**
     * Returns the value of {@link 天干} associated with specified display name.
     *
     * @param locale a locale of the display name.
     * @param name   the display name in {@code locale}.
     * @return the value of {@link 天干} associated with {@code name}.
     */
    public static 天干 天干(final Locale locale, final String name) {
        Objects.requireNonNull(locale, "locale is null");
        Objects.requireNonNull(name, "name is null");
        final var names = name(locale);
        final var index = names.indexOf(name);
        if (index == -1) {
            throw new IllegalArgumentException("name(" + name + ") not found");
        }
        return 天干(
                names().get(index)
        );
    }

    // -----------------------------------------------------------------------------------------------------------------
    public static 地支 地支(final String name) {
        Objects.requireNonNull(name, "name is null");
        final var codePoint = name.codePointAt(1);
        final var codePoints = new int[] {codePoint};
        return 地支.valueOf(
                new String(codePoints, 0, codePoints.length)
        );
    }

    public static 地支 地支(final Locale locale, final String name) {
        Objects.requireNonNull(locale, "locale is null");
        Objects.requireNonNull(name, "name is null");
        final var names = name(locale);
        final var index = names.indexOf(name);
        if (index == -1) {
            throw new IllegalArgumentException("name(" + name + ") not found");
        }
        return 地支(
                names().get(index)
        );
    }
}
