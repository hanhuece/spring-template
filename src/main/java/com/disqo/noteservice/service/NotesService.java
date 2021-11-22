package com.disqo.noteservice.service;

import com.disqo.noteservice.domain.Note;
import com.disqo.noteservice.dto.NotesRequestDto;
import org.springframework.security.core.userdetails.User;

public interface NotesService {

    Note add(Note note);

}
