package com.atl.edusoftware.data.repository

import com.atl.edusoftware.data.model.Logs
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository


@Repository
interface LogsRepository extends CrudRepository<Logs, Long> {
    Logs findByUserIdAndChapterId(Long userId, Integer chapterId)

    List<Logs> findByUserIdOrderByChapterIdAsc(Long userId)

    @Query("SELECT SUM(studentStats)/COUNT(id) as avg FROM Logs  WHERE chapterId = :chapterId group by chapter_id")
    Double findTotalAveragePerChapter(@Param("chapterId") Integer chapterId)


}