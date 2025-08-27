package io.github.jinahya.enums.philosophy;

import io.github.jinahya.enums.EnumUtils;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

/**
 * Constants of inter-promoting of {@link 五行}.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see 五行相剋
 */
@SuppressWarnings({
        "NonAsciiCharacters",
        "java:S115" // Constant names should comply with a naming convention
})
public enum 五行相生 {

    /**
     * Wood({@link 五行#木 木}) feeds Fire({@link 五行#火 火}) as fuel.
     */
    木生火(五行.木, 五行.火),

    /**
     * Fire({@link 五行#火 火}) produces Earth({@link 五行#土 土}) (ash, lava).
     */
    火生土(五行.火, 五行.土),

    /**
     * Earth({@link 五行#土 土}) bears Metal({@link 五行#金 金}) (geological processes produce minerals).
     */
    土生金(五行.土, 五行.金),

    /**
     * Metal({@link 五行#金 金}) collects, filters and purifies Water({@link 五行#水 水}) (water vapor condenses on metal, for
     * example).
     */
    金生水(五行.金, 五行.水),

    /**
     * Water({@link 五行#水 水}) nourishes Wood({@link 五行#木 木}) (water leads to growth of flowers, plants and other changes
     * in nature).
     */
    水生木(五行.水, 五行.木);

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<五行, 五行相生> SUBJECTIVES_AND_VALUES = Collections.unmodifiableMap(
            EnumUtils.mapValuesBy(五行相生.class, v -> v.subjective, () -> new EnumMap<>(五行.class))
    );

    /**
     * Returns the value whose {@link #subjective} matches to specified value.
     *
     * @param subjective the value for {@link #subjective} to match.
     * @return the value whose {@link #subjective} matches to {@code subjective}.
     */
    public static 五行相生 valueOfSubjective(final 五行 subjective) {
        Objects.requireNonNull(subjective, "subjective is null");
        final var value = SUBJECTIVES_AND_VALUES.get(subjective);
        if (value == null) {
            throw new IllegalArgumentException("no value for subjective: " + subjective);
        }
        return value;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<五行, 五行相生> OBJECTIVES_AND_VALUES = Collections.unmodifiableMap(
            EnumUtils.mapValuesBy(五行相生.class, v -> v.objective, () -> new EnumMap<>(五行.class))
    );

    /**
     * Returns the value whose {@link #objective} matches to specified value.
     *
     * @param objective the value for {@link #objective} to match.
     * @return the value whose {@link #objective} matches to {@code objective}.
     */
    public static 五行相生 valueOfObjective(final 五行 objective) {
        Objects.requireNonNull(objective, "objective is null");
        final var value = OBJECTIVES_AND_VALUES.get(objective);
        if (value == null) {
            throw new IllegalArgumentException("no value for objective: " + objective);
        }
        return value;
    }

    // -----------------------------------------------------------------------------------------------------------------
    五行相生(final 五行 subjective, final 五行 objective) {
        Objects.requireNonNull(subjective, "subjective is null");
        Objects.requireNonNull(objective, "objective is null");
        if (subjective == objective) {
            throw new IllegalArgumentException("subjective(" + subjective + ") == objective(" + objective + ")");
        }
        this.subjective = subjective;
        this.objective = objective;
    }

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * The subjective phase of this inter-promoting.
     */
    public final 五行 subjective;

    /**
     * The objective phase of this inter-promoting.
     */
    public final 五行 objective;
}
