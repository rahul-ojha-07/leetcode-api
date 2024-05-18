package in.rahulojha.leetcodeapi.controller.problemsolvepage;

import in.rahulojha.leetcodeapi.entity.RecentACSubmission;
import in.rahulojha.leetcodeapi.entity.RequestParamsDTO;
import in.rahulojha.leetcodeapi.service.LeetCodeService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LeetCodeProblemSolvePageController {

    @NonNull
    private final LeetCodeService leetCodeService;

    /**
     * Retrieves a list of recent Accepted Submissions based on the provided RequestParamsDTO.
     *
     * @param requestParams The RequestParamsDTO containing the username and limit for the submissions.
     * @return A ResponseEntity containing a list of RecentACSubmission objects representing the recent submissions.
     */
    @GetMapping("/recent-ac-submissions")
    ResponseEntity<List<RecentACSubmission>> getRecentACSubmissions(@RequestBody RequestParamsDTO requestParams) {
        return ResponseEntity.ok(leetCodeService.getRecentACSubmissionsList(requestParams.username(),
                requestParams.limit()));

    }
}
