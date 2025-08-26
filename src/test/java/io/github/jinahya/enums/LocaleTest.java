package io.github.jinahya.enums;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Locale;

@Slf4j
class LocaleTest {

    @Test
    void __zh() {
        log.debug("SIMPLIFIED_CHINESE: {}:", Locale.SIMPLIFIED_CHINESE);
        log.debug("TRADITIONAL_CHINESE: {}:", Locale.TRADITIONAL_CHINESE);
    }
}
