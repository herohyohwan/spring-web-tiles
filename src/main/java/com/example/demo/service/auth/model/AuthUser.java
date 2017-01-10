package com.example.demo.service.auth.model;

import com.google.common.base.Objects;

import java.util.Date;

/**
 * AuthUser
 *
 * @author herohyohwan@gmail.com
 * @date 2017.01.09
 */
public class AuthUser implements User {
    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = 231239230192111L;
    /**
     * The Id.
     */
    private final String id;
    /**
     * The Name.
     */
    private final String name;
    /**
     * The Employee no.
     */
    private final String employeeNo;
    /**
     * The Email.
     */
    private final String email;
    /**
     * The Team name.
     */
    private final String teamName;
    /**
     * The Last login time.
     */
    private final Date lastLoginTime;

    /**
     * Instantiates a new Auth user.
     */
    private AuthUser() {
        this(null, null, null, null, null, null);
    }

    /**
     * Instantiates a new Auth user.
     *
     * @param id            the id
     * @param name          the name
     * @param employeeNo    the employee no
     * @param email         the email
     * @param teamName      the team name
     * @param lastLoginTime the last login time
     */
    private AuthUser(
            String id,
            String name,
            String employeeNo,
            String email,
            String teamName,
            Date lastLoginTime) {
        this.id = id;
        this.name = name;
        this.employeeNo = employeeNo;
        this.email = email;
        this.teamName = teamName;
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * Create builder.
     *
     * @param userId the user id
     *
     * @return the builder
     */
    public static Builder create(String userId) {
        return new Builder().id(userId);
    }

    /**
     * Copy of builder.
     *
     * @param user the user
     *
     * @return the builder
     */
    public static Builder copyOf(User user) {
        return new Builder()
                .id(user.getId())
                .name(user.getName())
                .employeeNo(user.getEmployeeNo())
                .email(user.getEmail())
                .teamName(user.getTeamName());
    }

    /**
     * Copy of builder.
     *
     * @param user the user
     *
     * @return the builder
     */
    public static Builder copyOf(AuthUser user) {
        return new Builder()
                .id(user.getId())
                .name(user.getName())
                .employeeNo(user.getEmployeeNo())
                .email(user.getEmail())
                .teamName(user.getTeamName())
                .lastLoginTime(user.getLastLoginTime());
    }


    /**
     * Gets id.
     *
     * @return the id
     */
    @Override
    public String getId() {
        return id;
    }


    /**
     * Gets name.
     *
     * @return the name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Gets employee no.
     *
     * @return the employee no
     */
    @Override
    public String getEmployeeNo() {
        return employeeNo;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    @Override
    public String getEmail() {
        return email;
    }

    /**
     * Gets team name.
     *
     * @return the team name
     */
    @Override
    public String getTeamName() {
        return teamName;
    }

    /**
     * Gets last login time.
     *
     * @return the last login time
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * Equals boolean.
     *
     * @param o the o
     *
     * @return the boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equal(id, user.getId());
    }

    /**
     * Hash code int.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return id.hashCode();
    }

    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "AuthUser{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", employeeNo='" + employeeNo + '\'' +
                ", email='" + email + '\'' +
                ", teamName='" + teamName + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                '}';
    }

    /**
     * Builder
     *
     * @author herohyohwan@gmail.com
     * @date 2017.01.09
     */
    public static class Builder {
        /**
         * The Id.
         */
        private String id = null;
        /**
         * The Name.
         */
        private String name = null;
        /**
         * The Employee no.
         */
        private String employeeNo = null;
        /**
         * The Email.
         */
        private String email = null;
        /**
         * The Team name.
         */
        private String teamName = null;
        /**
         * The Last login time.
         */
        private Date lastLoginTime = null;

        /**
         * Id builder.
         *
         * @param id the id
         *
         * @return the builder
         */
        private Builder id(String id) {
            this.id = id;
            return this;
        }

        /**
         * Name builder.
         *
         * @param name the name
         *
         * @return the builder
         */
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        /**
         * Employee no builder.
         *
         * @param employeeNo the employee no
         *
         * @return the builder
         */
        public Builder employeeNo(String employeeNo) {
            this.employeeNo = employeeNo;
            return this;
        }

        /**
         * Email builder.
         *
         * @param email the email
         *
         * @return the builder
         */
        public Builder email(String email) {
            this.email = email;
            return this;
        }

        /**
         * Team name builder.
         *
         * @param teamName the team name
         *
         * @return the builder
         */
        public Builder teamName(String teamName) {
            this.teamName = teamName;
            return this;
        }

        /**
         * Last login time builder.
         *
         * @param lastLoginTime the last login time
         *
         * @return the builder
         */
        public Builder lastLoginTime(Date lastLoginTime) {
            this.lastLoginTime = lastLoginTime;
            return this;
        }

        /**
         * Build auth user.
         *
         * @return the auth user
         */
        public AuthUser build() {
            return new AuthUser(id, name, employeeNo, email, teamName, lastLoginTime);
        }
    }
}
