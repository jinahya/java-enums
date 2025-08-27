package io.github.jinahya.enums.philosophy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class 陰陽Test {

    static Stream<陰陽> valueStream() {
        return Arrays.stream(陰陽.values());
    }

//    static IntStream longitudeStream() {
//        return valueStream().mapToInt(陰陽::longitude);
//    }
//
//    static Stream<MonthDay> dateStream() {
//        return valueStream().map(陰陽::date);
//    }
//
//    static Stream<Arguments> valueAndLongitudeArgumentsStream() {
//        return valueStream().map(v -> Arguments.of(v, v.longitude()));
//    }
//
//    static Stream<Arguments> valueAndDateArgumentsStream() {
//        return valueStream().map(v -> Arguments.of(v, v.date()));
//    }

    // ---------------------------------------------------------------------------------------------------- CONSTRUCTORS
    陰陽Test() {
        super();
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("ko")
    @MethodSource({"valueStream"})
    @ParameterizedTest
    void name__ko(final 陰陽 value) {
        final var locale = ThreadLocalRandom.current().nextBoolean() ? Locale.of("ko") : Locale.KOREAN;
        final var name = value.name(locale);
        log.debug("value: {}, name: {}", value, name);
    }

    @DisplayName("zh_CN")
    @MethodSource({"valueStream"})
    @ParameterizedTest
    void __zh_CN(final 陰陽 value) {
        final var locale = ThreadLocalRandom.current().nextBoolean()
                           ? Locale.SIMPLIFIED_CHINESE
                           : Locale.of("zh", "CN");
        final var name = value.name(locale);
        log.debug("value: {}, name: {}", value, name);
    }

    @DisplayName("zh_TW")
    @MethodSource({"valueStream"})
    @ParameterizedTest
    void __zh_TW(final 陰陽 value) {
        final var locale = ThreadLocalRandom.current().nextBoolean()
                           ? Locale.TRADITIONAL_CHINESE
                           : Locale.of("zh", "TW");
        final var name = value.name(locale);
        log.debug("value: {}, name: {}", value, name);
        assertThat(name).isEqualTo(value.name());
    }
}
