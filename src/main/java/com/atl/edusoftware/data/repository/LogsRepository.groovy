package com.atl.edusoftware.data.repository

import com.atl.edusoftware.data.model.Logs
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository


@Repository
interface LogsRepository extends CrudRepository<Logs, Long> {
    Logs findByUserIdAndChapterId(Long userId, Integer chapterId)

    List<Logs> findByUserIdOrderByChapterIdAsc(Long userId)

    @Query("SELECT SUM(testStats)/COUNT(id) as avg FROM Logs  WHERE chapterId = :chapterId AND testStats IS NOT NULL group by chapter_id")
    Double findTotalAveragePerChapter(@Param("chapterId") Integer chapterId)

    @Modifying
    @Query("UPDATE Logs SET is_theory_read = false WHERE  user_id = :userId AND chapter_id = :chapterId")
    void setIsTheoryReadToFalse(@Param("userId") Long userId, @Param("chapterId") Integer chapterId)
}