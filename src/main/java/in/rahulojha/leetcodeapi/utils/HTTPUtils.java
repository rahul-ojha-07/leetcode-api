package in.rahulojha.leetcodeapi.utils;

import in.rahulojha.leetcodeapi.configs.LeetCodeConfig;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Map;

import static in.rahulojha.leetcodeapi.constants.ApplicationConstants.ACCEPT;
import static in.rahulojha.leetcodeapi.constants.ApplicationConstants.CONNECTION;
import static in.rahulojha.leetcodeapi.constants.ApplicationConstants.CONTENT_TYPE;
import static in.rahulojha.leetcodeapi.constants.ApplicationConstants.COOKIE;
import static in.rahulojha.leetcodeapi.constants.ApplicationConstants.CSRF_HEADER;
import static in.rahulojha.leetcodeapi.constants.ApplicationConstants.JSON_MEDIA_TYPE;
import static in.rahulojha.leetcodeapi.constants.ApplicationConstants.KEEP_ALIVE;
import static in.rahulojha.leetcodeapi.constants.ApplicationConstants.METHOD;
import static in.rahulojha.leetcodeapi.constants.ApplicationConstants.REFERER;
import static in.rahulojha.leetcodeapi.constants.ApplicationConstants.REFERER_URL;


@Slf4j
@Service
@RequiredArgsConstructor
public class HTTPUtils {
    @NonNull
    private final LeetCodeConfig config;

    /**
     * Constructs a Request object based on the provided query.
     *
     * @param query The query string to be included in the request.
     * @return A Request object with the query string set as the request body and necessary headers.
     */
    public String getResponseStringForQuery(String query) throws IOException {
        // Create an OkHttpClient instance
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        // Create the request body
        RequestBody requestBody = RequestBody.create(query,  MediaType.parse("application/json; charset=utf-8"));

        // Build the request with necessary headers and URL
        Request request = new Request.Builder()
                .url(config.getGraphqlUrl())
                .method(METHOD, requestBody)
                .addHeader(ACCEPT,"*/*")
                .addHeader(CONNECTION,KEEP_ALIVE)
                .addHeader(CONTENT_TYPE,JSON_MEDIA_TYPE)
                .addHeader(COOKIE, config.getCookie())
                .addHeader(REFERER, MessageFormat.format(REFERER_URL, config.getUsername()))
                .addHeader(CSRF_HEADER, config.getCsrftoken())
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.142.86 Safari/537.36")
                .build();
        // Execute the request and retrieve the response
        Response response = client.newCall(request).execute();
        assert response.body() != null;
        return response.body().string();
    }


    /**
     * Converts a Map to a string.
     *
     * @param map The map to be converted.
     * @return A string representation of the map.
     */
    @NonNull
    public String convertMapToString(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb
            .append('"').append(entry.getKey()).append('"')
            .append(":")
            .append('"').append(entry.getValue()).append('"');
        }
        sb.append('}');
        return sb.toString();
    }


}
