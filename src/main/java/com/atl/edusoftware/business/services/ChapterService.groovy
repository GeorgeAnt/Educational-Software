package com.atl.edusoftware.business.services

import com.atl.edusoftware.data.model.Chapter
import com.atl.edusoftware.data.repository.ChapterRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ChapterService {

    @Autowired
    ChapterRepository chapterRepository

    Iterable<Chapter> getAllChapterData() {
        return chapterRepository.findAll()
    }

    Chapter getChapterById(int chapterId) {
        return chapterRepository.findOne(chapterId)
    }

    void saveChapter(Chapter chapter) {
        chapterRepository.save(chapter)
    }

    void deleteChapter(Chapter chapter) {
        chapterRepository.delete(chapter)
    }
}
