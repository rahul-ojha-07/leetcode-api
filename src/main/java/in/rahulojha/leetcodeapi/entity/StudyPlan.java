package in.rahulojha.leetcodeapi.entity;

import java.util.Date;

public record StudyPlan(

        QuestionInfo nextQuestionInfo,
        Date quittedAt,
        Date startedAt,
        ProblemsStudyPlanAds plan,
        Date latestSubmissionAt,
        String id,
        Date allCompletedAt,
        long finishedQuestionNum
) {
}
