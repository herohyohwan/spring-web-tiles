package com.example.demo.service.auth.model;

import java.io.Serializable;

/**
 * User
 *
 * @author herohyohwan@gmail.com
 * @date 2017.01.09
 */
public interface User extends Serializable {

    /**
     * Gets id.
     *
     * @return the id
     */
    String getId();

    /**
     * Gets name.
     *
     * @return the name
     */
    String getName();

    /**
     * Gets employee no.
     *
     * @return the employee no
     */
    String getEmployeeNo();

    /**
     * Gets email.
     *
     * @return the email
     */
    String getEmail();

    /**
     * Gets team name.
     *
     * @return the team name
     */
    String getTeamName();
}
