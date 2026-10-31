package com.waheed.tutorial3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Compares eager string concatenation with parameterized logging.
 */
public class Application3 {

    private static final Logger LOG = LoggerFactory.getLogger(Application3.class);

    public static void main(String[] args) {
        int first = 10;
        int second = 5;
        int third = 10;

        // Intentional anti-pattern: concatenation runs even when DEBUG is disabled.
        LOG.debug("Entry number: " + first + " is " + String.valueOf(first));

        // A guard can help when constructing an argument is expensive.
        if (LOG.isDebugEnabled()) {
            LOG.debug("Entry number: " + first + " is " + String.valueOf(first));
        }

        // Placeholders avoid formatting work when DEBUG is disabled.
        LOG.debug("Entry number is {}.", first);
        LOG.debug("Number 1: {}, Number 2: {}", first, second);

        // SLF4J 1.6 accepts an argument array for three or more placeholders.
        Object[] arguments = {first, second, third};
        LOG.debug("Number 1: {}, Number 2: {} and Number 3: {}", arguments);
    }
}
