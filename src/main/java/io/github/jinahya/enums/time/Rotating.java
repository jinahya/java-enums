package io.github.jinahya.enums.time;

interface Rotating<T extends Rotating<T>> {

    /**
     * Returns the previous value of this value.
     *
     * @return the previous value of this value.
     */
    T getPrevious();

    /**
     * Returns the next value of this value.
     *
     * @return the next value of this value.
     */
    T getNext();
}
