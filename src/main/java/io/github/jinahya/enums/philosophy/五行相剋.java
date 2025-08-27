package io.github.jinahya.enums.philosophy;

import io.github.jinahya.enums.EnumUtils;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

/**
 * Constants of inter-regulating of {@link 五行}.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see 五行相生
 */
@SuppressWarnings({
        "NonAsciiCharacters",
        "java:S115" // Constant names should comply with a naming convention
})
public enum 五行相剋 {

    /**
     * Wood({@link 五行#木}) grasps (or stabilizes) Earth({@link 五行#土}) (roots of trees can prevent soil erosion)
     */
    木剋土(五行.木, 五行.土),

    /**
     * Earth({@link 五行#土}) contains (or directs) Water({@link 五行#水}) (dams or river banks)
     */
    土剋水(五行.土, 五行.水),

    /**
     * Water({@link 五行#水}) dampens (or regulates) Fire({@link 五行#火})
     */
    水剋火(五行.水, 五行.火),

    /**
     * Fire({@link 五行#火}) melts (or refines or shapes) Metal({@link 五行#金})
     */
    火剋金(五行.火, 五行.金),

    /**
     * Metal({@link 五行#金}) chops (or carves) Wood({@link 五行#水})
     */
    金剋木(五行.金, 五行.木);

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<五行, 五行相剋> SUBJECTIVES_AND_VALUES = Collections.unmodifiableMap(
            EnumUtils.mapValuesBy(
                    五行相剋.class,
                    v -> v.subjective
            )
    );

    /**
     * Returns the value associated with the specified subjective.
     *
     * @param subjective the subjective.
     * @return the value associated with {@code subjective}.
     */
    public static 五行相剋 valueOfSubjective(final 五行 subjective) {
        Objects.requireNonNull(subjective, "subjective is null");
        final var value = SUBJECTIVES_AND_VALUES.get(subjective);
        if (value == null) {
            throw new IllegalArgumentException("no value for subjective: " + subjective);
        }
        return value;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private static final Map<五行, 五行相剋> OBJECTIVES_AND_VALUES = Collections.unmodifiableMap(
            EnumUtils.mapValuesBy(
                    五行相剋.class,
                    v -> v.objective
            )
    );

    /**
     * Returns the value associated with the specified objective.
     *
     * @param objective the objective.
     * @return the value associated with {@code objective}.
     */
    public static 五行相剋 valueOfObjective(final 五行 objective) {
        Objects.requireNonNull(objective, "objective is null");
        final var value = OBJECTIVES_AND_VALUES.get(objective);
        if (value == null) {
            throw new IllegalArgumentException("no value for objective: " + objective);
        }
        return value;
    }

    // -----------------------------------------------------------------------------------------------------------------
    五行相剋(final 五行 subjective, final 五行 objective) {
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
