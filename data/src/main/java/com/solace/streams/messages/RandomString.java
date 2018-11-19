package com.solace.streams.messages;

import com.solace.streams.types.Signup;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

class RandomString {

    /**
     * Generate a random string.
     */
    String nextString() {
        for (int idx = 0; idx < buf.length; ++idx)
            buf[idx] = symbols[random.nextInt(symbols.length)];
        return new String(buf);
    }

    Signup.Method nextMethod() {
        switch(random.nextInt(5)) {
            case 4: return Signup.Method.TWITTER;
            case 3: return Signup.Method.EMAIL;
            case 2: return Signup.Method.FACEBOOK;
            case 1: return Signup.Method.GITHUB;
            default: return Signup.Method.GOOGLE;
        }
    }

    static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    static final String lower = upper.toLowerCase(Locale.ROOT);

    static final String digits = "0123456789";

    static final String alphanum = upper + lower + digits;

    private final Random random;

    private final char[] symbols;

    private final char[] buf;

    RandomString(int length, Random random, String symbols) {
        if (length < 1) throw new IllegalArgumentException();
        if (symbols.length() < 2) throw new IllegalArgumentException();
        this.random = Objects.requireNonNull(random);
        this.symbols = symbols.toCharArray();
        this.buf = new char[length];
    }

    /**
     * Create an alphanumeric string generator.
     */
    RandomString(int length, Random random) {
        this(length, random, alphanum);
    }

    /**
     * Create an alphanumeric strings from a secure generator.
     */
    RandomString(int length) {
        this(length, new SecureRandom());
    }

    /**
     * Create session identifiers.
     */
    public RandomString() {
        this(21);
    }

}