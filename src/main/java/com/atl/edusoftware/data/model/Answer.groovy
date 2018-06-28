package com.atl.edusoftware.data.model

import com.fasterxml.jackson.annotation.JsonBackReference

import javax.persistence.*

@Entity
class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id

    @Column(name = "answer_text")
    String answerText

    @Column(name = "is_correct")
    Boolean isCorrect

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    @JsonBackReference
    Question questionId

}