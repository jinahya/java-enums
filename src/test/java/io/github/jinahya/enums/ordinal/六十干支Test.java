package io.github.jinahya.enums.ordinal;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SuppressWarnings({
        "NonAsciiCharacters",
        "java:S117", // Local variable and method parameter names should comply with a naming convention
        "java:S3577" // Test classes should comply with a naming convention
})
class 六十干支Test {

    static List<String> displayNames_ko() {
        return 六十干支.name(Locale.KOREAN);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Test
    void names__() {
        final var names = 六十干支.names();
        assertThat(names).hasSize(60);
        names.forEach(n -> {
            log.debug("name: {}", n);
        });
    }

    // -----------------------------------------------------------------------------------------------------------------
    @MethodSource({"java.util.Locale#availableLocales"})
    @ParameterizedTest
    void names__(final Locale locale) {
        final var names = 六十干支.name(locale);
        assertThat(names).hasSize(60);
        names.forEach(n -> {
            log.debug("name: {}", n);
        });
    }

    @DisplayName("displayName(ko)")
    @Test
    void names__ko() {
        final var locale = ThreadLocalRandom.current().nextBoolean() ? Locale.of("ko") : Locale.KOREAN;
        final var names = 六十干支.name(locale);
        assertThat(names).hasSize(60);
        names.forEach(n -> {
            log.debug("name: {}", n);
        });
    }

    // -----------------------------------------------------------------------------------------------------------------
    @MethodSource({
            "io.github.jinahya.enums.ordinal.六十干支#names"
    })
    @ParameterizedTest
    void 天干__(final String name) {
        final var 天干 = 六十干支.天干(name);
        log.debug("天干: {}", 天干);
        assertThat(天干).isNotNull();
    }

    @MethodSource({
            "displayNames_ko"
    })
    @ParameterizedTest
    void 天干__kr(final String displayName) {
        final var 天干 = 六十干支.天干(Locale.KOREAN, displayName);
        log.debug("天干: {}", 天干);
        assertThat(天干).isNotNull();
    }

    // -----------------------------------------------------------------------------------------------------------------
    @MethodSource({
            "io.github.jinahya.enums.ordinal.六十干支#names"
    })
    @ParameterizedTest
    void 地支__(final String name) {
        final var 地支 = 六十干支.地支(name);
        log.debug("地支: {}", 地支);
        assertThat(地支).isNotNull();
    }

    @MethodSource({
            "displayNames_ko"
    })
    @ParameterizedTest
    void 地支__kr(final String displayName) {
        final var 地支 = 六十干支.地支(Locale.KOREAN, displayName);
        log.debug("地支: {}", 地支);
        assertThat(地支).isNotNull();
    }
}
