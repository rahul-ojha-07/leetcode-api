package in.rahulojha.leetcodeapi.entity;

import java.util.Date;

public record DailyCodingChallengeQuestion(
        Date date,
        String userStatus,
        String link,
        QuestionMetaData question
) {
}
