package com.cognizant.eremenko.competiotionGame.repository;

import com.cognizant.eremenko.competiotionGame.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The tasks repository
 *
 * @author Andrei Eremenko
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, String> {
}
