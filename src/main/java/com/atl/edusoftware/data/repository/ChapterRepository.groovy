package com.atl.edusoftware.data.repository

import com.atl.edusoftware.data.model.Chapter
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ChapterRepository extends CrudRepository<Chapter, Integer> {
    Chapter findByChapterId(Integer chapterId)
}