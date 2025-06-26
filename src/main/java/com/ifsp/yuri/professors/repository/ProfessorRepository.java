package com.ifsp.yuri.professors.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ifsp.yuri.professors.model.Professor;

public interface ProfessorRepository extends MongoRepository<Professor, String> {}
