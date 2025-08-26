package io.github.jinahya.enums.ordinal;

import java.util.*;
import java.util.function.BiConsumer;

public enum 六十干支 {

    // empty
    ;

    private static final List<天干> heavenlyStems = List.of(天干.values());

    private static final List<地支> earthlyBranches = List.of(地支.values());

    private static void acceptEachCombination(final BiConsumer<? super 天干, ? super 地支> consumer) {
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
        acceptEachCombination((hs, eb) -> {
            names.add(hs.name() + eb.name());
        });
        NAMES = Collections.unmodifiableList(names);
    }

    public static List<String> names() {
        return NAMES;
    }

    // -----------------------------------------------------------------------------------------------------------------
    public static List<String> names(final Locale locale) {
        Objects.requireNonNull(locale, "locale is null");
        final var names = new ArrayList<String>();
        acceptEachCombination((hs, eb) -> {
            final var heavenlyStemName = hs.name(locale);
            final var earthlyBranchName = eb.name(locale);
            names.add(heavenlyStemName + earthlyBranchName);
        });
        return names;
    }

    // -----------------------------------------------------------------------------------------------------------------
    六十干支() {
    }
}
