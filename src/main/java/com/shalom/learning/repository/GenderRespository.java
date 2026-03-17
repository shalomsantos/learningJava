package com.shalom.learning.repository;

import com.shalom.learning.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRespository extends JpaRepository<Gender, Long> {}
