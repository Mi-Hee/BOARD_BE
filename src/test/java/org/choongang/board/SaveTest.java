package org.choongang.board;

import org.choongang.board.controllers.RequestBoardConfig;
import org.choongang.board.repositories.BoardRepository;
import org.choongang.board.service.BoardConfigSaveService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = "spring.profiles.active=test")
public class SaveTest {

    @Autowired
    private BoardConfigSaveService saveService;

    @Autowired
    private BoardRepository repository;

    private RequestBoardConfig form;

    @BeforeEach
    void init() {
        form = new RequestBoardConfig();
        form.setBid("notice");
        form.setBName("공지사항");
    }
    
    @Test
    @DisplayName("게시판 설정 저장 테스트")
    void saveServiceTest() {
        saveService.save(form);

        String bid = form.getBid();
        assertTrue(repository.existsById(bid));
    }
}
