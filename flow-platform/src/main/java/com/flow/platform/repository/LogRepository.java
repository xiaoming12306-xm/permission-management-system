package com.flow.platform.repository;

import com.flow.platform.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
    List<Log> findByUsername(String username);
    List<Log> findByOperation(String operation);
}
