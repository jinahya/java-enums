package io.github.jinahya.enums.ordinal;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatCode;

@Slf4j
@SuppressWarnings({
        "java:S2577" // Test classes should comply with a naming convention
})
class 天干Test {

    static Stream<天干> valueStream() {
        return Arrays.stream(天干.values());
    }

    static Stream<Arguments> valueAndLocaleArgumentsStream() {
        return valueStream()
                .flatMap(v -> Locale.availableLocales().map(l -> Arguments.of(v, l)));
    }

    // -----------------------------------------------------------------------------------------------------------------
    @MethodSource({"valueAndLocaleArgumentsStream"})
    @ParameterizedTest
    void name__(final 天干 value, final Locale locale) {
        assertThatCode(() -> {
            final var name = value.name(locale);
            log.debug("value: {}, name: {}, locale: {}", value, name, locale);
        });
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("ko")
    @MethodSource({"valueStream"})
    @ParameterizedTest
    void name__ko(final 天干 value) {
        final var locale = ThreadLocalRandom.current().nextBoolean() ? Locale.of("ko") : Locale.KOREAN;
        final var name = value.name(locale);
        log.debug("value: {}, name: {}", value, name);
    }
}
