package io.github.jinahya.enums.time;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.MonthDay;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SuppressWarnings({
        "java:S3577" // Test classes should comply with a naming convention
})
class 二十四節氣Test {

    static Stream<二十四節氣> valueStream() {
        return Arrays.stream(二十四節氣.values());
    }

    static IntStream longitudeStream() {
        return valueStream().mapToInt(二十四節氣::longitude);
    }

    static Stream<MonthDay> dateStream() {
        return valueStream().map(二十四節氣::date);
    }

    static Stream<Arguments> valueAndLongitudeArgumentsStream() {
        return valueStream().map(v -> Arguments.of(v, v.longitude()));
    }

    static Stream<Arguments> valueAndDateArgumentsStream() {
        return valueStream().map(v -> Arguments.of(v, v.date()));
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("valueOfLongitude(longitude)")
    @MethodSource({"valueAndLongitudeArgumentsStream"})
    @ParameterizedTest
    void valueOfLongitude__(final 二十四節氣 value, final int longitude) {
        assertThat(二十四節氣.valueOfLongitude(longitude)).isSameAs(value);
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("valueOfDate(date)")
    @MethodSource({"valueAndDateArgumentsStream"})
    @ParameterizedTest
    void valueOfDate__(final 二十四節氣 value, final MonthDay date) {
        assertThat(二十四節氣.valueOfDate(date)).isSameAs(value);
    }

    // -----------------------------------------------------------------------------------------------------------------
    二十四節氣Test() {
        super();
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("no duplicate longitudes")
    @Test
    void longitudes_noDuplicates() {
        assertThat(longitudeStream()).doesNotHaveDuplicates();
    }

    @MethodSource({"valueAndLongitudeArgumentsStream"})
    @ParameterizedTest
    void longitude(final 二十四節氣 value, final int longitude) {
        log.debug("value: {}, longitude: {}", value, longitude);
        assertThat(longitude).isNotNegative().isLessThan(360).satisfies(l -> {
            assertThat(l % 15).isZero();
        });
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("no duplicate dates")
    @Test
    void dates_noDuplicates() {
        assertThat(dateStream())
                .doesNotHaveDuplicates();
    }

    // -----------------------------------------------------------------------------------------------------------------
    @DisplayName("ko_KR")
    @MethodSource({"valueStream"})
    @ParameterizedTest
    void __ko_KR(final 二十四節氣 value) {
        final var locale = Locale.of("ko", "KR");
        final var name = value.name(locale);
        log.debug("value: {}, name: {}", value, name);
    }

    @DisplayName("ko_KP")
    @MethodSource({"valueStream"})
    @ParameterizedTest
    void __ko_KP(final 二十四節氣 value) {
        final var locale = Locale.of("ko", "KP");
        final var name = value.name(locale);
        log.debug("value: {}, name: {}", value, name);
    }

    @DisplayName("zh_TW")
    @MethodSource({"valueStream"})
    @ParameterizedTest
    void __zh_TW(final 二十四節氣 value) {
        final var locale = Locale.of("zh", "TW");
        final var name = value.name(locale);
        log.debug("value: {}, name: {}", value, name);
    }

    @DisplayName("vi")
    @MethodSource({"valueStream"})
    @ParameterizedTest
    void __vi(final 二十四節氣 value) {
        final var locale = Locale.of("vi");
        final var name = value.name(locale);
        log.debug("value: {}, name: {}", value, name);
    }
}