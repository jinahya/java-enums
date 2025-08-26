package io.github.jinahya.enums.ordinal;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * Constants of <a href="https://en.wikipedia.org/wiki/Earthly_Branches">the twelve Earthly Branches</a>.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see <a href="https://zh.wikipedia.org/wiki/%E5%9C%B0%E6%94%AF">地支 (Wikipedia)</a>
 */
@SuppressWarnings({
        "java:S100", // Method names should comply with a naming convention
        "java:S115", // Constant names should comply with a naming convention
        "java:S116"  // Field names should comply with a naming convention
})
public enum 地支 {

    子, // 자

    丑, // 축

    寅, // 인

    卯, // 묘

    辰, // 진

    巳, // 사

    午, // 오

    未, // 미

    申, // 신

    酉, // 유

    戌, // 술

    亥; // 해

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
