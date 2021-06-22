package com.cognizant.eremenko.competiotionGame.repository;

import com.cognizant.eremenko.competiotionGame.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * The user repository
 *
 * @author Andrei Eremenko
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

    /**
     * Returns a user payload from a database
     *
     * @param username is a username
     * @return a {@link Optional} of a {@link User}
     */
    Optional<User> findByUsername(String username);

    /**
     * Returns a user list with max value of resolved tasks
     *
     * @param pageable {@link Pageable} sets users quantity
     * @return a list of a {@link User}
     */
    List<User> findAllByOrderByScoreDesc(Pageable pageable);
}
