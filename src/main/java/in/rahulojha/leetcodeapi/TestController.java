package in.rahulojha.leetcodeapi;

import in.rahulojha.leetcodeapi.entity.QuestionMetaData;
import in.rahulojha.leetcodeapi.service.LeetCodeService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class TestController {


    @NonNull
    LeetCodeService leetCodeService;

    @GetMapping("/test")
    ResponseEntity<List<String>> test() {
        return ResponseEntity.ok(leetCodeService.getProblemsetQuestionList("\"\"", 0, 100, new HashMap<>()).stream()
                .map(QuestionMetaData::titleSlug).toList());
    }
}
