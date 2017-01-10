package com.example.demo.profile;

import org.springframework.core.env.Environment;

/**
 * CurrentProfile
 *
 * @author herohyohwan@gmail.com
 * @date 2017.01.09
 */
public class CurrentProfile {

    /**
     * The Env.
     */
    private final Environment env;


    /**
     * Instantiates a new Current profile.
     *
     * @param env the env
     */
    public CurrentProfile(Environment env) {
        this.env = env;
    }

    /**
     * Gets profile.
     *
     * @return the profile
     */
    public Profile getProfile() {
        String[] profiles = env.getActiveProfiles();
        if (contains(profiles, Profile.TEST.getConfigName())) {
            return Profile.TEST;
        } else if (contains(profiles, Profile.STAGING.getConfigName())) {
            return Profile.STAGING;
        } else if (contains(profiles, Profile.PRODUCTION.getConfigName())) {
            return Profile.PRODUCTION;
        } else {
            return Profile.DEV; // as default
        }
    }

    /**
     * Contains boolean.
     *
     * @param profiles   the profiles
     * @param configName the config name
     *
     * @return the boolean
     */
    private boolean contains(String[] profiles, String configName) {
        if (profiles == null) {
            return false;
        }

        for(String profile : profiles) {
            if (profile.equalsIgnoreCase(configName)) {
                return true;
            }
        }
        return false;
    }

}
