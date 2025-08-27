package io.github.jinahya.enums.philosophy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.time.DayOfWeek;

@Slf4j
class 五行Test {

    @EnumSource(DayOfWeek.class)
    @ParameterizedTest
    void valueOf__DayOfWeek(final DayOfWeek dayOfWeek) {
        try {
            final var value = 五行.valueOf(dayOfWeek);
            log.debug("dayOfWeek: {}, value: {}", dayOfWeek, value);
        } catch (final IllegalArgumentException iae) {
            iae.printStackTrace();
        }
    }
}
