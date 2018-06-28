package com.atl.edusoftware.data.repository

import com.atl.edusoftware.data.model.Question
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface QuestionRepository extends CrudRepository<Question, Long> {
    List<Question> findFirst3ByChapterId(int chapterId)//TODO remove THe TOP 3

    @Query(nativeQuery = true, value = "SELECT *  FROM question as q  INNER JOIN answer AS a on q.id = a.question_id ORDER BY  random() LIMIT 3")
    List<Question> findQuestionsInRandomOrder()

    @Query(nativeQuery = true, value = "SELECT *  FROM question as q  ORDER BY id DESC LIMIT 1")
    Question findFirstByOrderByIdDesc()

}