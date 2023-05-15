package com.example.demo.repository;

import com.example.demo.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {

    @Override
    @Query("select t from Contract t where t.id IN (:ids)")
    List<Contract> findAllById(@Param("ids") Iterable<Long> ids);

    @Override
    @Query("select t from Contract t where t.id =:id")
    Optional<Contract> findById (@Param("id")  Long id);
}
