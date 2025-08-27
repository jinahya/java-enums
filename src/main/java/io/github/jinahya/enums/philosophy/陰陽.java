package io.github.jinahya.enums.philosophy;

import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Constants of {@code Yin} and {@code Yang}.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see <a href="https://en.wikipedia.org/wiki/Yin_and_yang">Yin and yang</a>
 */
@SuppressWarnings({
        "NonAsciiCharacters",
        "java:S115" // Constant names should comply with a naming convention
})
public enum 陰陽 {

    /**
     * Yin.
     */
    陰,

    /**
     * Yang.
     */
    陽;

    // -----------------------------------------------------------------------------------------------------------------
    public String name(final Locale locale) {
        Objects.requireNonNull(locale, "locale is null");
        return localesAndNames.computeIfAbsent(locale, l -> {
            try {
                final var bundle = ResourceBundle.getBundle(getClass().getName(), l);
                return bundle.getString(name());
            } catch (final MissingResourceException mre) {
                return name();
            }
        });
    }

    // -----------------------------------------------------------------------------------------------------------------
    private final Map<Locale, String> localesAndNames = new ConcurrentHashMap<>();
}
