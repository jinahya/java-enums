package io.github.jinahya.enums;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

@Slf4j
class DayOfWeekTest {

    @EnumSource(DayOfWeek.class)
    @ParameterizedTest
    void __CHINA(final DayOfWeek dayOfWeek) {
        for (var textStyle : TextStyle.values()) {
            final var value = dayOfWeek.getDisplayName(textStyle, Locale.CHINA);
            log.debug("dayOfWeek: {}, textStyle: {}, value: {}", dayOfWeek, textStyle, value);
        }
    }

    @EnumSource(DayOfWeek.class)
    @ParameterizedTest
    void __TRANDITIONAL_CHINESE(final DayOfWeek dayOfWeek) {
        for (var textStyle : TextStyle.values()) {
            final var value = dayOfWeek.getDisplayName(textStyle, Locale.TRADITIONAL_CHINESE);
            log.debug("dayOfWeek: {}, textStyle: {}, value: {}", dayOfWeek, textStyle, value);
        }
    }

    @EnumSource(DayOfWeek.class)
    @ParameterizedTest
    void __SIMPLIFIED_CHINESE(final DayOfWeek dayOfWeek) {
        for (var textStyle : TextStyle.values()) {
            final var value = dayOfWeek.getDisplayName(textStyle, Locale.SIMPLIFIED_CHINESE);
            log.debug("dayOfWeek: {}, textStyle: {}, value: {}", dayOfWeek, textStyle, value);
        }
    }

    @EnumSource(DayOfWeek.class)
    @ParameterizedTest
    void __KOREAN(final DayOfWeek dayOfWeek) {
        for (var textStyle : TextStyle.values()) {
            final var value = dayOfWeek.getDisplayName(textStyle, Locale.KOREAN);
            log.debug("dayOfWeek: {}, textStyle: {}, value: {}", dayOfWeek, textStyle, value);
        }
    }
}
