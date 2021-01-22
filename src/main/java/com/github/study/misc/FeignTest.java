package com.github.study.misc;

import feign.Feign;
import feign.Logger;
import feign.Param;
import feign.RequestLine;
import feign.jackson.JacksonDecoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import lombok.Data;

import java.util.List;

interface GitHub {
    @RequestLine("GET /repos/{owner}/{repo}/contributors")
    List<Contributor> contributors(@Param("owner") String owner, @Param("repo") String repo);

    @RequestLine("POST /repos/{owner}/{repo}/issues")
    void createIssue(Issue issue, @Param("owner") String owner, @Param("repo") String repo);

}

@Data
class Contributor {
    String login;
    int contributions;
}

class Issue {
    String title;
    String body;
    List<String> assignees;
    int milestone;
    List<String> labels;
}

public class FeignTest {
    public static void main(String... args) {
        okhttp3.OkHttpClient delegate = new okhttp3.OkHttpClient();

        OkHttpClient client = new OkHttpClient(delegate);
        GitHub github = Feign.builder()
                .logger(new Slf4jLogger())
                .logLevel(Logger.Level.FULL)
                .decoder(new JacksonDecoder())
                .client(client)
                .target(GitHub.class, "https://api.github.com");

        // Fetch and print a list of the contributors to this library.
        List<Contributor> contributors = github.contributors("OpenFeign", "feign");
        for (Contributor contributor : contributors) {
            System.out.println(contributor.login + " (" + contributor.contributions + ")");
        }
    }
}
