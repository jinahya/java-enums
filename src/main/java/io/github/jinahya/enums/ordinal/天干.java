package io.github.jinahya.enums.ordinal;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * Constants of <a href="https://en.wikipedia.org/wiki/Heavenly_Stems">the ten Heavenly Stems</a>.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see <a href="https://zh.wikipedia.org/wiki/%E5%A4%A9%E5%B9%B2">天干 (Wikipedia)</a>
 */
@SuppressWarnings({
        "java:S100", // Method names should comply with a naming convention
        "java:S115", // Constant names should comply with a naming convention
        "java:S116"  // Field names should comply with a naming convention
})
public enum 天干 {

    甲, // 갑

    乙, // 을

    丙, // 병

    丁, // 정

    戊, // 무

    己, // 기

    庚, // 경

    辛, // 신

    壬, // 임

    癸; // 계

    // -----------------------------------------------------------------------------------------------------------------

    public String name(final Locale locale) {
        Objects.requireNonNull(locale, "locale is null");
        final var baseName = getClass().getName();
        try {
            final var bundle = ResourceBundle.getBundle(baseName, locale);
            return bundle.getString(name());
        } catch (final MissingResourceException mre) {
            return name();
        }
    }

    /**
     * Returns the value of {@link io.github.jinahya.enums.philosophy.陰陽} associated with this value.
     *
     * @return the value of {@link io.github.jinahya.enums.philosophy.陰陽} associated with this value.
     */
    io.github.jinahya.enums.philosophy.陰陽 陰陽() {
        if (陰陽 == null) {
            陰陽 = ordinal() % 2 == 0
                    ? io.github.jinahya.enums.philosophy.陰陽.陽
                    : io.github.jinahya.enums.philosophy.陰陽.陰;
        }
        return 陰陽;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private io.github.jinahya.enums.philosophy.陰陽 陰陽;
}
