package org.choongang.board.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.choongang.commons.entities.BaseMember;
import org.choongang.member.constants.Authority;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Board extends BaseMember {

    @Id
    @Column(length = 45)
    private String bid;

    @Column(length = 20, nullable = false)
    private String bName;

    private boolean active; // 게시판 사용 여부

    private int pagePerRows = 20; // 한 페이지 당 게시글 수
    
    private int pageRanges = 10; // 페이지 구간 갯수

    @Lob
    private String category;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private Authority writeAuthority = Authority.ALL;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private Authority listAuthority = Authority.ALL;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private Authority viewAuthority = Authority.ALL;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private Authority commentAuthority = Authority.ALL;

}
