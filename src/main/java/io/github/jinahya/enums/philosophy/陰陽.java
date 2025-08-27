package io.github.jinahya.enums.philosophy;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Constants of {@code Yin} and {@code Yang}.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see <a href="https://en.wikipedia.org/wiki/Yin_and_yang">Yin and yang</a>
 */
@SuppressWarnings({
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
    public String displayName(final Locale locale) {
        Objects.requireNonNull(locale, "locale is null");
        return localesAndDisplayNames.computeIfAbsent(locale, l -> {
            try {
                final var bundle = ResourceBundle.getBundle(getClass().getName(), l);
                return bundle.getString(name());
            } catch (final MissingResourceException mre) {
                return name();
            }
        });
    }

    // -----------------------------------------------------------------------------------------------------------------
    private final Map<Locale, String> localesAndDisplayNames = new ConcurrentHashMap<>();
}
