package io.github.jinahya.enums.ordinal;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SuppressWarnings({
        "java:S3577" // Test classes should comply with a naming convention
})
class 六十干支Test {

    @Test
    void names__() {
        final var names = 六十干支.names();
        assertThat(names).hasSize(60);
        names.forEach(n -> {
            log.debug("name: {}", n);
        });
    }

    @MethodSource({"java.util.Locale#availableLocales"})
    @ParameterizedTest
    void names__(final Locale locale) {
        final var names = 六十干支.names(locale);
        assertThat(names).hasSize(60);
        names.forEach(n -> {
            log.debug("name: {}", n);
        });
    }

    @DisplayName("name(ko)")
    @Test
    void names__ko() {
        final var locale = ThreadLocalRandom.current().nextBoolean() ? Locale.of("ko") : Locale.KOREAN;
        final var names = 六十干支.names(locale);
        assertThat(names).hasSize(60);
        names.forEach(n -> {
            log.debug("name: {}", n);
        });
    }
}
