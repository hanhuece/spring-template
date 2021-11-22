package com.disqo.noteservice.dto;

import lombok.*;

@Data
@Builder
public class NotesResponseDto {

    private Long noteId;
    private String title;
    private String note;

}
