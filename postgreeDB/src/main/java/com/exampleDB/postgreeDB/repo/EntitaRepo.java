package com.exampleDB.postgreeDB.repo;

import com.exampleDB.postgreeDB.dto.EntitaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EntitaRepo extends JpaRepository<EntitaDTO, Integer> {

    //JPQL
    @Query("SELECT e FROM EntitaDTO e WHERE e.id = ?1")
    EntitaDTO getEntByID(Long id);

    //JPQL
    @Modifying
    @Query("DELETE FROM EntitaDTO e WHERE e.id = ?1")
    Long deleteEnt(Long id);

    //SQL
    @Modifying
    @Query(value = "INSERT INTO EntitaDTO (nome, simpatico) VALUES (:nome, :simpatico)", nativeQuery = true)
    Long insert(@Param("nome") String nome, @Param("simpatico") String simpatico);
}
