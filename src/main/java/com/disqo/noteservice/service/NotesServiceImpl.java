package com.disqo.noteservice.service;

import com.disqo.noteservice.domain.Note;
import com.disqo.noteservice.repositories.NotesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
class NotesServiceImpl implements NotesService {

  private final NotesRepository notesRepository;

  public Note add(Note note) {
    return notesRepository.save(note);
  }

}
