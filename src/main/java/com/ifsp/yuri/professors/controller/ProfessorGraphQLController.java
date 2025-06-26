package com.ifsp.yuri.professors.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.ifsp.yuri.professors.model.Professor;
import com.ifsp.yuri.professors.service.ProfessorService;

@Controller
public class ProfessorGraphQLController {
    private final ProfessorService professorService;

    public ProfessorGraphQLController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @QueryMapping
    public List<Professor> professors() {
        return professorService.getAllProfessors();
    }

    @QueryMapping
    public Professor professor(@Argument String id) {
        return professorService.getProfessorById(id);
    }

    @MutationMapping
    public Professor createProfessor(@Argument String name, @Argument String email) {
        Professor professor = new Professor(name, email);
        return professorService.createProfessor(professor);
    }

    @MutationMapping
    public Professor updateProfessor(@Argument String id, @Argument String name, @Argument String email) {
        Professor updatedProfessor = new Professor(name, email);
        return professorService.updateProfessor(id, updatedProfessor);
    }

    @MutationMapping
    public String deleteProfessor(@Argument String id) {
        professorService.deleteProfessor(id);
        return "Professor com id " + id + " deletado com sucesso.";
    }

}
