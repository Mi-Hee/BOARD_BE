package org.choongang.board.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.choongang.board.service.BoardConfigSaveService;
import org.choongang.commons.exceptions.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/board/config")
@RequiredArgsConstructor
public class BoardConfigController {

    private final BoardConfigSaveService saveService;
    private final BoardConfigValidator validator;

    @PostMapping
    public ResponseEntity save(@Valid @RequestBody RequestBoardConfig form, Errors errors) {
        validator.validate(form, errors);

        errorProcess(errors);

        saveService.save(form);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    private void errorProcess(Errors errors) {
        if (errors.hasErrors()) {
            throw new BadRequestException(errors);
        }
    }
}
