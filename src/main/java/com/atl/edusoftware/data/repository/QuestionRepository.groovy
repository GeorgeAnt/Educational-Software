package com.atl.edusoftware.data.repository

import com.atl.edusoftware.data.model.Chapter
import com.atl.edusoftware.data.model.Question
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface QuestionRepository extends CrudRepository<Question, Long> {
    List<Question> findFirst10ByChapter(Chapter chapter)

    @Query(nativeQuery = true, value = "SELECT  *  FROM question as q  ORDER BY  random() LIMIT 10")
    List<Question> findQuestionsInRandomOrder()

}