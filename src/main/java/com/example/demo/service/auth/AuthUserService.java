package com.example.demo.service.auth;

import com.example.demo.service.auth.model.AuthUser;
import com.example.demo.service.auth.model.User;

import javax.validation.constraints.NotNull;
import java.util.Collection;

/**
 * AuthUserService
 *
 * @author herohyohwan@gmail.com
 * @date 2017.01.09
 */
public interface AuthUserService {
    /**
     * Registered boolean.
     *
     * @param userId the user id
     *
     * @return the boolean
     */
    boolean registered(String userId);

    /**
     * Registered boolean.
     *
     * @param user the user
     *
     * @return the boolean
     */
    boolean registered(User user);

    /**
     * Register auth user.
     *
     * @param user the user
     *
     * @return the auth user
     */
    @NotNull
    AuthUser register(User user);

    /**
     * Unregister boolean.
     *
     * @param userId the user id
     *
     * @return the boolean
     */
    boolean unregister(String userId);

    /**
     * Unregister boolean.
     *
     * @param user the user
     *
     * @return the boolean
     */
    boolean unregister(User user);

    /**
     * Gets auth user.
     *
     * @param userId the user id
     *
     * @return the auth user
     */
    @NotNull
    AuthUser getAuthUser(String userId);

    /**
     * Gets auth user.
     *
     * @param user the user
     *
     * @return the auth user
     */
    @NotNull
    AuthUser getAuthUser(User user);

    /**
     * Gets registered users.
     *
     * @return the registered users
     */
    Collection<User> getRegisteredUsers();
}
