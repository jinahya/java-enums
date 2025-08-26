package io.github.jinahya.enums.oridnal;

import io.github.jinahya.enums.philocophy.陰陽;

/**
 * Constants of <a href="https://en.wikipedia.org/wiki/Earthly_Branches">the twelve Earthly Branches</a>.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see <a href="https://zh.wikipedia.org/wiki/%E5%9C%B0%E6%94%AF">地支 (Wikipedia)</a>
 */
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

    /**
     * Returns the value of {@link 陰陽} associated with this value.
     *
     * @return the value of {@link 陰陽} associated with this value.
     */
    陰陽 陰陽() {
        if (陰陽 == null) {
            陰陽 = ordinal() % 2 == 0 ? 陰陽.陽 : 陰陽.陰;
        }
        return 陰陽;
    }

    // -----------------------------------------------------------------------------------------------------------------
    private 陰陽 陰陽;
}
