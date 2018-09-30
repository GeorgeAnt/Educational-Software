package com.atl.edusoftware.business.services

import com.atl.edusoftware.commons.Result
import com.atl.edusoftware.data.model.Logs
import com.atl.edusoftware.data.repository.ChapterRepository
import com.atl.edusoftware.data.repository.LogsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LogsService {

    @Autowired
    LogsRepository logsRepository

    @Autowired
    ChapterRepository chapterRepository

    void insertOrUpdateOnLogs(Logs log) {
        /**
         * If there is a previous log with same chapter and user id,
         * Pass the log id to our new log and save(update) the old log.
         * Else save(insert) a new log for this user and chapter.
         * **/
        if (logsRepository.findByUserIdAndChapterId(log.userId, log.chapterId)) {
            Logs logDb = logsRepository.findByUserIdAndChapterId(log.userId, log.chapterId)
            log.Id = logDb.id
            log.isTheoryRead ?: logDb.isTheoryRead
            log.testStats ?: logDb.testStats
        }
        logsRepository.save(log)
    }

    /**
     * We check the cases.
     * 1.Below 50% 50%-80% or higher 80%.
     * 2.Below average score for the chapter.
     * 3.Above average score for the chapter.
     * **/
    @Transactional
    Result handleResults(Logs log) {
        Double totalAveragePerChapter = logsRepository?.findTotalAveragePerChapter(log.chapterId) ?: 0
        logsRepository.setAverageScore(totalAveragePerChapter, log.chapterId)
        Result result = new Result()
        result.message = ""

        if (log.testStats < 50) {
            result.message += "You definitely need to study the theory first and retry, this chapter in your account is set as non read. "
            logsRepository.setIsTheoryReadToFalse(log.userId, log.chapterId)
            result.flag = 0
        } else if (log.testStats < 80) {
            result.message += "Good try you still have some fields that can be improved by checking the theory! "
            result.flag = 1
        } else {
            result.message += "Great Job!!You are close to a perfect score !"
            result.flag = 2
        }

        if (log.testStats < totalAveragePerChapter && totalAveragePerChapter) {
            result.message += "You score less than the other participants!"
        } else if (totalAveragePerChapter) {
            result.message += "You score more than the average user keep up the good work !"
        }
        result = ['message': result.message, 'flag': result.flag]
        return result
    }

    List<Logs> getLogsByUserId(Long userId) {
        logsRepository.findByUserIdOrderByChapterIdAsc(userId)
    }

    Logs getLogByUserIdAndChapterId(Long userId, int chapterId) {
        logsRepository.findByUserIdAndChapterId(userId, chapterId)
    }

}
