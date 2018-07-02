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
    Double averageScore = 0.0

    @Column(columnDefinition = "TEXT")
    String chapterTheory

    @OneToMany(mappedBy = "chapter", cascade = CascadeType.ALL)
    List<Question> questions
}
