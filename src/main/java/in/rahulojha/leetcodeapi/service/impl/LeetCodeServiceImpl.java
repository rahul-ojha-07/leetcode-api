package in.rahulojha.leetcodeapi.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.rahulojha.leetcodeapi.entity.GlobalData;
import in.rahulojha.leetcodeapi.entity.QuestionMetaData;
import in.rahulojha.leetcodeapi.entity.RecentACSubmission;
import in.rahulojha.leetcodeapi.service.LeetCodeService;
import in.rahulojha.leetcodeapi.utils.HTTPUtils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static in.rahulojha.leetcodeapi.constants.LoggingConstants.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class LeetCodeServiceImpl implements LeetCodeService {

    @NonNull
    private final HTTPUtils httpUtils;

    @NonNull
    private final ObjectMapper objectMapper;

    /**
     * Retrieves a list of recent Accepted Submissions based on the username and limit.
     *
     * @param userName The username of the user.
     * @param limit The maximum number of recent submissions to retrieve.
     * @return A list of RecentACSubmission objects representing the recent submissions.
     */
    @Override
    public List<RecentACSubmission> getRecentACSubmissionsList(String userName, long limit) {
        // Construct the GraphQL query based on the input parameters
        String query = """
                {"query": "query recentAcSubmissions($username: String!, $limit: Int!) { recentAcSubmissionList(username: $username, limit: $limit) { id title titleSlug timestamp}}", "variables": {"username":"%s", "limit":%d}}
                """.formatted(userName, limit);

        log.info(GENERATED_QUERY, query);

        try {
            // Send the GraphQL query to the LeetCode API and get the response
            String responseString = httpUtils.getResponseStringForQuery(query);
            log.info(RECEIVED_RESPONSE, responseString);

            // Parse the JSON response to extract the recent submission list
            String json = objectMapper.readTree(responseString)
                    .get("data")
                    .get("recentAcSubmissionList")
                    .toString();
            // Convert the JSON to a list of RecentACSubmission objects
            return objectMapper.readValue(json, new TypeReference<>() {});

        } catch (IOException e) {
            log.error(ERROR_OCCURRED, e);
        }
        return new ArrayList<>();
    }

    /**
     * Retrieves a list of questions from the problem set based on category, skip, limit, and filters.
     *
     * @param categorySlug The category slug for filtering.
     * @param skip The number of questions to skip.
     * @param limit The maximum number of questions to retrieve.
     * @param filters Additional filters for the query.
     * @return A list of QuestionMetaData objects representing the retrieved questions.
     */
    @Override
    public List<QuestionMetaData> getProblemsetQuestionList(String categorySlug, long skip, long limit, Map<String, String> filters) {
        // GraphQL query to fetch the problem set question list
        String query = """
                {"query":"query problemsetQuestionList($categorySlug: String, $limit: Int, $skip: Int, $filters: QuestionListFilterInput) {  problemsetQuestionList: questionList(    categorySlug: $categorySlug    limit: $limit    skip: $skip    filters: $filters  ) {    total: totalNum    questions: data {      acRate      difficulty      freqBar      frontendQuestionId: questionFrontendId      isFavor      paidOnly: isPaidOnly      status      title      titleSlug      topicTags {        name        id        slug      }      hasSolution      hasVideoSolution    }  }}    ","variables":{"categorySlug":%s,"skip":%d,"limit":%d,"filters":%s},"operationName":"problemsetQuestionList"}
                """.formatted(categorySlug, skip, limit, httpUtils.convertMapToString(filters));
        // write information to log
        log.info( GENERATED_QUERY, query);

        try {
            // Send the GraphQL query to the LeetCode API and get the response
            String responseString = httpUtils.getResponseStringForQuery(query);
            log.info(RECEIVED_RESPONSE, responseString);

            // Parse the JSON response to extract the recent submission list
            JsonNode jsonNode = objectMapper.readTree(responseString)
                    .get("data")
                    .get("problemsetQuestionList");

            String json = jsonNode
                    .get("questions")
                    .toString();

            log.info("Total number of questions: {}", jsonNode.get("total").toString());

            // Convert the JSON to a list of RecentACSubmission objects
            return objectMapper.readValue(json, new TypeReference<>() {});

        } catch (IOException e) {
            log.error(ERROR_OCCURRED, e);
        }

        return new ArrayList<>();
    }

    /**
     * Retrieves the global data.
     *
     * @return The global data.
     */
    @Override
    public GlobalData getGlobalData() {
        String query = """
        {"operationName":"globalData","variables":{},"query":"query globalData {  userStatus { userId    isSignedIn    isAdmin    isStaff    isSuperuser    isMockUser    isTranslator    isPremium    isVerified    checkedInToday    username    realName    avatar    optedIn    requestRegion    region    activeSessionId    permissions    notificationStatus {      lastModified      numUnread } } }"}
        """;
        log.info(GENERATED_QUERY, query);

        try {
            // Send the GraphQL query to the LeetCode API and get the response
            String responseString = httpUtils.getResponseStringForQuery(query);
            log.info(RECEIVED_RESPONSE, responseString);

            // Parse the JSON response to extract the global data
            String globalData = objectMapper.readTree(responseString)
                    .get("data")
                    .get("userStatus")
                    .toString();

            // Convert the JSON to GlobalData object
            return objectMapper.readValue(globalData, new TypeReference<>() {});

        } catch (IOException e) {
            log.error(ERROR_OCCURRED, e);
        }
        return null;
    }

}
