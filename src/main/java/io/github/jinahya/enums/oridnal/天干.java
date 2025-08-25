package io.github.jinahya.enums.oridnal;

import io.github.jinahya.enums.philocophy.陰陽;

/**
 * Constants of <a href="https://en.wikipedia.org/wiki/Heavenly_Stems">the ten Heavenly Stems</a>.
 *
 * @author Jin Kwon &lt;onacit_at_gmail.com&gt;
 * @see <a href="https://zh.wikipedia.org/wiki/%E5%A4%A9%E5%B9%B2">天干 (Wikipedia)</a>
 */
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
    陰陽 陰陽() {
        if (ordinal() % 2 == 0) {
            return 陰陽.陽;
        } else {
            return 陰陽.陰;
        }
    }
}
