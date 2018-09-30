package com.atl.edusoftware.data.model

import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table
class Logs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id

    @Column
    @NotNull
    Long userId

    @Column
    @NotNull
    Integer chapterId

    @Column
    Double testStats

    @Column
    Boolean isTheoryRead = false

    @Column
    Double averageScore = 0.0

}
