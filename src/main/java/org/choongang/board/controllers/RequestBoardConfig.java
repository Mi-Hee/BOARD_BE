package org.choongang.board.controllers;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.choongang.member.constants.Authority;

@Data
public class RequestBoardConfig {

    private String mode = "add";

    @NotBlank
    private String bid;

    @NotBlank
    private String bName;

    private boolean active; // 게시판 사용 여부

    private int pagePerRows = 20; // 한 페이지 당 게시글 수

    private int pageRanges = 10; // 페이지 구간 갯수

    private String category;

    private String writeAuthority = Authority.ALL.name();

    private String listAuthority = Authority.ALL.name();

    private String viewAuthority = Authority.ALL.name();

    private String commentAuthority = Authority.ALL.name();
}
