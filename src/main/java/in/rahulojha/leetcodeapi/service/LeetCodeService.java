package in.rahulojha.leetcodeapi.service;


import in.rahulojha.leetcodeapi.entity.*;

import java.util.List;
import java.util.Map;


public interface LeetCodeService {



    /**
     * Retrieves the site announcements.
     *
     * @return The site announcements.
     */
    SiteAnnouncement getSiteAnnouncements();

    /**
     * Retrieves a list of recent Accepted Submissions based on the username and limit.
     *
     * @param  userName   The username of the user.
     * @param  limit      The maximum number of recent submissions to retrieve.
     * @return            A list of RecentACSubmission objects representing the recent submissions.
     */
    List<RecentACSubmission> getRecentACSubmissionsList(String userName, long limit);
    /**
     * Retrieves a list of questions from the problem set based on category, skip, limit, and filters.
     *
     * @param  categorySlug   The category slug for filtering.
     * @param  skip           The number of questions to skip.
     * @param  limit          The maximum number of questions to retrieve.
     * @param  filters        Additional filters for the query.
     * @return                A list of QuestionMetaData objects representing the retrieved questions.
     */
    List<QuestionMetaData> getProblemsetQuestionList(String categorySlug, long skip, long limit, Map<String, String> filters);


    /**
     * Retrieves the global data.
     *
     * @return The global data.
     */
    GlobalData getGlobalData();

    /**
     * Retrieves the problemset study plan.
     *
     * @return The problemset study plan.
     */
    List<ProblemsStudyPlanAds> getProblemsetStudyPlan();

    /**
     * Retrieves the daily coding challenge question.
     *
     * @return The daily coding challenge question.
     */
    DailyCodingChallengeQuestion getActiveDailyCodingChallengeQuestion();


    /**
     * Retrieves the coding challenge medal.
     * @param year The year.
     * @param month The month.
     * @return The coding challenge medal.
     */
    CodingChallengeMedal getCodingChallengeMedal(long year, long month);

    /**
     * Retrieves the current timestamp.
     *
     * @return The current timestamp.
     */
    CurrentTimestamp getCurrentTimestamp();

    MyStudyPlan getMyStudyPlan(long offset, long limit, String progressType);

    // docstring

    /**
     * Retrieves the daily coding challenge record.
     * @param year The year.
     * @param month The month.
     * @return The daily coding challenge record.
     */
    DailyCodingChallengeRecord getDailyCodingChallengeRecord(long year, long month);


    UPCOnboardingStatus getUPCOnboardingStatus();
    /**
     * Retrieves the streak counter.
     *
     * @return The streak counter.
     */
    StreakCounter getStreakCounter();

    /**
     * Retrieves the time travel ticket info.
     *
     * @return The time travel ticket info.
     */
    TimeTravelTicketInfo getTimeTravelTicketInfo();

    /**
     * Retrieves the user session progress.
     *
     * @param username The username of the user.
     * @return The user session progress.
     */
    UserSessionProgress getUserSessionProgress(String username);

}
