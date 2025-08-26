package io.github.jinahya.enums.ordinal;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;

public enum 六十干支 {

    // empty
    ;

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
    static final List<String> NAMES;

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

    public static List<String> names(final Locale locale) {
        Objects.requireNonNull(locale, "locale is null");
        return LOCALES_AND_NAMES.computeIfAbsent(locale, l -> {
            final var names = new ArrayList<String>();
            acceptEachPair((hs, eb) -> {
                final var heavenlyStemName = hs.name(l);
                final var earthlyBranchName = eb.name(l);
                names.add(heavenlyStemName + earthlyBranchName);
            });
            return names;
        });
    }
}
