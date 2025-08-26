package io.github.jinahya.enums.ordinal;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Stream;

@Slf4j
@SuppressWarnings({
        "java:S2577" // Test classes should comply with a naming convention
})
class 天干Test {

    static Stream<天干> valueStream() {
        return Arrays.stream(天干.values());
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("ko")
    @MethodSource({"valueStream"})
    @ParameterizedTest
    void name__ko(final 天干 value) {
        final var locale = Locale.of("ko");
        final var name = value.name(locale);
        log.debug("value: {}, name: {}", value, name);
    }

    @DisplayName("ko")
    @MethodSource({"valueStream"})
    @ParameterizedTest
    void name__KOREAN(final 天干 value) {
        final var locale = Locale.KOREAN;
        final var name = value.name(locale);
        log.debug("value: {}, name: {}", value, name);
    }
}
