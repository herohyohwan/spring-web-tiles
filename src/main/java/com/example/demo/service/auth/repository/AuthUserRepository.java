package com.example.demo.service.auth.repository;

import com.example.demo.service.auth.model.AuthUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * AuthUserRepository
 *
 * @author herohyohwan@gmail.com
 * @date 2017.01.09
 */
public interface AuthUserRepository {

    /**
     * Find auth user.
     *
     * @param id the id
     *
     * @return the auth user
     */
    AuthUser find(@Param("id") String id);

    /**
     * Exists boolean.
     *
     * @param id the id
     *
     * @return the boolean
     */
    boolean exists(@Param("id") String id);

    /**
     * Create.
     *
     * @param user the user
     */
    void create(@Param("user") AuthUser user);

    /**
     * Update.
     *
     * @param user the user
     */
    void update(@Param("user") AuthUser user);

    /**
     * Delete boolean.
     *
     * @param id the id
     *
     * @return the boolean
     */
    boolean delete(@Param("id") String id);

    /**
     * Update login time int.
     *
     * @param id the id
     *
     * @return the int
     */
    int updateLoginTime(@Param("id") String id);

    /**
     * Gets all.
     *
     * @return the all
     */
    List<AuthUser> getAll();

    /**
     * Delete all int.
     *
     * @return the int
     */
    int deleteAll(); // for testing
}
