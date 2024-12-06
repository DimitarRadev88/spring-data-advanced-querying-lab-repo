package com.softuni.shampooCompany.repositories;

import com.softuni.shampooCompany.entities.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabelRepository extends JpaRepository<Label, Long> {



}
