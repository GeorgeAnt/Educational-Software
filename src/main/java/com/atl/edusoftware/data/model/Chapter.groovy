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

    @Column
    String chapterTheory
}
