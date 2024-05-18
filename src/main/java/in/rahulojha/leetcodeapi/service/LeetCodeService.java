package in.rahulojha.leetcodeapi.service;


import in.rahulojha.leetcodeapi.entity.GlobalData;
import in.rahulojha.leetcodeapi.entity.QuestionMetaData;
import in.rahulojha.leetcodeapi.entity.RecentACSubmission;

import java.util.List;
import java.util.Map;


public interface LeetCodeService {
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
}
