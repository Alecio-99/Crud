package com.agenda.ale.repository;

import com.agenda.ale.entity.EntityAgenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RepositoryAgenda extends JpaRepository<EntityAgenda, Long> {

    @Query(value = " select c from EntityAgenda c where c.name like %?1% ")
    ArrayList<EntityAgenda> getPorNome(String name);
}
