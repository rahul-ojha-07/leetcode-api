package in.rahulojha.leetcodeapi.entity;

import java.util.List;

public record UserSessionProgress(
        List<QuestionCount> allQuestionsCount,
        User matchedUser

) {
}
