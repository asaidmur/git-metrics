package com.gitmetrics.app.controller

import com.gitmetrics.app.service.GitHubService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class GitHubController (private val gitHubService: GitHubService){
    @GetMapping("/all", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun fetchAllPullRequests(@RequestParam owner: String, @RequestParam repo: String): Map<String, Any> {
        return gitHubService.fetchAllPullRequests(owner, repo)
    }
    @GetMapping("/closed", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun fetchClosedPullRequests(@RequestParam owner: String, @RequestParam repo: String): Map<String, Any> {
        return gitHubService.fetchClosedPullRequests(owner, repo)
    }
    @GetMapping("/open", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun fetchOpenPullRequests(@RequestParam owner: String, @RequestParam repo: String): Map<String, Any> {
        return gitHubService.fetchOpenPullRequests(owner, repo)
    }
    @GetMapping("/merged", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun fetchMergedPullRequests(@RequestParam owner: String, @RequestParam repo: String): Map<String, Any> {
        return gitHubService.fetchMergedPullRequests(owner, repo)
    }
}