package com.siferga.notes.repository;

import org.eclipse.jgit.notes.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepository extends MongoRepository<Note, String> {

    public List<Note> findNotesByPatientId(Long patientId);

    Optional<Note> findNotesById(String id);
}
