package com.simpastudio.loading.lines.data.repository;

import com.simpastudio.loading.lines.data.model.internal.SimCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SimCityRepository extends JpaRepository<SimCity, Long> {
    @Query(value = "SELECT * FROM Sim_City ORDER BY RAND() LIMIT 1", nativeQuery = true)
    SimCity random();

    @Query(value = "SELECT * FROM Sim_City ORDER BY RAND() LIMIT ?1", nativeQuery = true)
    List<SimCity> random(int limit);
}
