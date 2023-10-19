package com.gitmetrics.app.controller

import com.gitmetrics.app.service.GitHubService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class GitHubController (private val gitHubService: GitHubService){
    @GetMapping("/fetch", produces = ["application/json"])
    fun fetchData(@RequestParam owner: String, @RequestParam repo: String): Map<String, Any> {
        return gitHubService.fetchAllPRData(owner, repo)
    }
}