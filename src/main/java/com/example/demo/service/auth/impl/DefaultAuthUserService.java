package com.example.demo.service.auth.impl;

import com.example.demo.service.auth.AuthUserService;
import com.example.demo.service.auth.model.AuthUser;
import com.example.demo.service.auth.model.User;
import com.example.demo.service.auth.repository.AuthUserRepository;
import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * DefaultAuthUserService
 *
 * @author herohyohwan@gmail.com
 * @date 2017.01.09
 */
@Transactional
public class DefaultAuthUserService implements AuthUserService {
    /**
     * The Repository.
     */
    private final AuthUserRepository repository;

    /**
     * Instantiates a new Default auth user service.
     *
     * @param repository the repository
     */
    @Inject
    public DefaultAuthUserService(AuthUserRepository repository) {
        this.repository = repository;
    }


    /**
     * Registered boolean.
     *
     * @param userId the user id
     *
     * @return the boolean
     */
    @Override
    public boolean registered(String userId) {
        Preconditions.checkNotNull(userId, "userId is null");
        return repository.exists(userId);
    }

    /**
     * Registered boolean.
     *
     * @param user the user
     *
     * @return the boolean
     */
    @Override
    public boolean registered(User user) {
        Preconditions.checkNotNull(user, "user is null");
        return registered(user.getId());
    }


    /**
     * Register auth user.
     *
     * @param user the user
     *
     * @return the auth user
     */
    @Override
    public AuthUser register(User user) {
        Preconditions.checkNotNull(user, "user is null");
        repository.create(AuthUser.copyOf(user).build());
        return repository.find(user.getId());
    }

    /**
     * Unregister boolean.
     *
     * @param userId the user id
     *
     * @return the boolean
     */
    @Override
    public boolean unregister(String userId) {
        Preconditions.checkNotNull(userId, "userId is null");
        return repository.delete(userId);
    }

    /**
     * Unregister boolean.
     *
     * @param user the user
     *
     * @return the boolean
     */
    @Override
    public boolean unregister(User user) {
        Preconditions.checkNotNull(user, "user is null");
        return unregister(user.getId());
    }

    /**
     * Gets auth user.
     *
     * @param userId the user id
     *
     * @return the auth user
     */
    @Override
    public AuthUser getAuthUser(String userId) {
        Preconditions.checkNotNull(userId, "userId is null");
        return repository.find(userId);
    }

    /**
     * Gets auth user.
     *
     * @param user the user
     *
     * @return the auth user
     */
    @Override
    public AuthUser getAuthUser(User user) {
        Preconditions.checkNotNull(user, "user is null");
        return getAuthUser(user.getId());
    }

    /**
     * Gets registered users.
     *
     * @return the registered users
     */
    @Override
    public Collection<User> getRegisteredUsers() {
        return repository.getAll().stream().collect(Collectors.<User>toList());
    }
}
