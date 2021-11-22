package com.disqo.noteservice.dto;

import javax.validation.constraints.NotEmpty;
import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Dto class to create request for CRUD operations on Notes.
 *
 * @author Haridas Parekh
 */
@Data
@Builder
public class NotesRequestDto {

    @NotBlank
    @Size(max = 50)
    private String title;

    @Size(max = 1000)
    @Column(name = "note")
    private String note;
}
