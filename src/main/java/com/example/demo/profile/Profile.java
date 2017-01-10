package com.example.demo.profile;

/**
 * Profile
 *
 * @author herohyohwan@gmail.com
 * @date 2017.01.09
 */
public enum Profile {
    /**
     * Dev profile.
     */
    DEV("dev"),
    /**
     * Test profile.
     */
    TEST("test"),
    /**
     * Staging profile.
     */
    STAGING("staging"),
    /**
     * Production profile.
     */
    PRODUCTION("production"),
    ;

    /**
     * The Config name.
     */
    private final String configName;

    /**
     * Instantiates a new Profile.
     *
     * @param ConfigName the config name
     */
    private Profile(String ConfigName) {
        this.configName = ConfigName;
    }

    /**
     * Gets config name.
     *
     * @return the config name
     */
    public String getConfigName() {
        return configName;
    }
}
