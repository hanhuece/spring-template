package com.disqo.noteservice.controller;

import com.disqo.noteservice.domain.AppUser;
import com.disqo.noteservice.domain.Note;
import com.disqo.noteservice.dto.NotesRequestDto;
import com.disqo.noteservice.dto.NotesResponseDto;
import com.disqo.noteservice.service.NotesService;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class to handle CRUD operations on Notes.
 *
 * @author Haridas Parekh
 */
@RestController
@RequestMapping("/api/v1.0/notes")
@CommonsLog
@AllArgsConstructor
public class NotesController {

  private final NotesService notesService;

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<NotesResponseDto> addNote(Authentication authentication,
      @Valid @RequestBody NotesRequestDto notesRequestDto) {

    User user = (User) authentication.getPrincipal();

    Note newNote = Note.builder().note(notesRequestDto.getNote())
        .userId(Long.parseLong(user.getUsername()))
        .title(notesRequestDto.getTitle()).build();
    newNote = notesService.add(newNote);

    NotesResponseDto notesResponseDto = NotesResponseDto.builder().noteId(newNote.getId())
        .title(newNote.getTitle())
        .note(newNote.getNote())
        .build();

    return new ResponseEntity<>(notesResponseDto, HttpStatus.OK);
  }

}
