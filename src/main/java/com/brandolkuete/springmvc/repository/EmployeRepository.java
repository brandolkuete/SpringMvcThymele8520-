package com.brandolkuete.springmvc.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brandolkuete.springmvc.models.Employe;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {

    List<Employe> findAllByActive(boolean bool);

    Employe findOneByCode(String code);

    boolean existsByCodeIgnoreCase(String code);
}
