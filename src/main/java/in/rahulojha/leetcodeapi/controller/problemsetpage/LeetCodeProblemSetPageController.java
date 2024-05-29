package in.rahulojha.leetcodeapi.controller.problemsetpage;

import in.rahulojha.leetcodeapi.entity.ProblemsStudyPlanAds;
import in.rahulojha.leetcodeapi.entity.QuestionMetaData;
import in.rahulojha.leetcodeapi.entity.RequestParamsDTO;
import in.rahulojha.leetcodeapi.entity.SiteAnnouncement;
import in.rahulojha.leetcodeapi.service.LeetCodeService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LeetCodeProblemSetPageController {

    @NonNull
    private final LeetCodeService leetCodeService;

    /**
     * Retrieves a list of questions from the problem set based on category, skip, limit, and filters.
     *
     * @param requestParams The RequestParamsDTO containing the category slug, skip, limit, and filters for the query.
     * @return A ResponseEntity containing a list of QuestionMetaData objects representing the retrieved questions.
     */
    @GetMapping("/problemset-questions")
    ResponseEntity<List<QuestionMetaData>> getProblemsetQuestions(@RequestBody RequestParamsDTO requestParams) {
        return ResponseEntity.ok(leetCodeService.getProblemsetQuestionList(requestParams.categorySlug(),
                requestParams.skip(),
                requestParams.limit(),
                requestParams.filters()));
    }

    // controller for site-announcements

    @GetMapping("/site-announcements")
    ResponseEntity<SiteAnnouncement> getSiteAnnouncements() {
        return ResponseEntity.ok(leetCodeService.getSiteAnnouncements());
    }


    //controller for problemsetstudyplan

    @GetMapping("/problemset-study-plan")
    ResponseEntity<List<ProblemsStudyPlanAds>> getProblemsetStudyPlan() {
        return ResponseEntity.ok(leetCodeService.getProblemsetStudyPlan());
    }
}
