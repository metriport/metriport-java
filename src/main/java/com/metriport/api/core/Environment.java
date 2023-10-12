/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.metriport.api.core;

public final class Environment {
    public static final Environment PRODUCTION = new Environment("https://api.metriport.com/medical/v1");

    private final String url;

    private Environment(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public static Environment custom(String url) {
        return new Environment(url);
    }
}
