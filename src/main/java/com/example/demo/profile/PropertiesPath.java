package com.example.demo.profile;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


/**
 * PropertiesPath
 *
 * @author herohyohwan@gmail.com
 * @date 2017.01.09
 */
public class PropertiesPath {
    /**
     * The Profile.
     */
    private final CurrentProfile profile;

    /**
     * Instantiates a new Properties path.
     *
     * @param profile the profile
     */
    public PropertiesPath(CurrentProfile profile) {
        this.profile = profile;
    }

    /**
     * Gets base path.
     *
     * @return the base path
     */
    public String getBasePath() {
        return "properties/" + profile.getProfile().getConfigName() + "/";
    }

    /**
     * Gets resource.
     *
     * @param filename the filename
     *
     * @return the resource
     */
    public Resource getResource(String filename) {
        return new ClassPathResource(getBasePath() + filename);
    }

    /**
     * Gets path.
     *
     * @param filename the filename
     *
     * @return the path
     */
    public String getPath(String filename) {
        return getBasePath() + filename;
    }
}
