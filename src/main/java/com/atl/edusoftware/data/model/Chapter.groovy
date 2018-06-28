package com.atl.edusoftware.data.model

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table
class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer chapterId

    @Column
    @NotNull
    String chapterName

    /**
     * Lob is the equivelent of type text(VARCHAR(MAX)) in Postgresql
     **/
    @Lob
    String chapterTheory
}
