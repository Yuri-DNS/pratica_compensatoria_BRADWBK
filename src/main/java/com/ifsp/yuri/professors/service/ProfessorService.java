package com.ifsp.yuri.professors.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ifsp.yuri.professors.model.Professor;
import com.ifsp.yuri.professors.repository.ProfessorRepository;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }

    public Professor getProfessorById(String id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado com id: " + id));
    }

    public Professor createProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public void deleteProfessor(String id) {
        if (!professorRepository.existsById(id)) {
            throw new RuntimeException("Professor não encontrado com id: " + id);
        }
        professorRepository.deleteById(id);
    }

    public Professor updateProfessor(String id, Professor updatedProfessor) {
        if (!professorRepository.existsById(id)) {
            throw new RuntimeException("Professor não encontrado com id: " + id);
        }
        updatedProfessor.setId(id);
        return professorRepository.save(updatedProfessor);
    }

}
