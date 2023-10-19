package com.gitmetrics.app.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader

@FeignClient(name = "githubClient", url = "https://api.github.com")
interface GitHubFeignClient {

    @PostMapping("/graphql", produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun executeQuery(@RequestHeader("Authorization") token: String, @RequestBody queryBody: String): Map<String, Any>
}