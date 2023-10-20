package com.gitmetrics.app.service

import com.gitmetrics.app.client.GitHubFeignClient
import com.gitmetrics.app.utility.Token
import org.springframework.stereotype.Service
import java.nio.file.Files
import java.nio.file.Paths

private const val ALL_PR_QUERY = "src/main/kotlin/com/gitmetrics/app/queries/AllPullRequests.json"
private const val CLOSED_PR_QUERY = "src/main/kotlin/com/gitmetrics/app/queries/ClosedPullRequests.json"
private const val OPEN_PR_QUERY = "src/main/kotlin/com/gitmetrics/app/queries/OpenPullRequests.json"
private const val MERGED_PR_QUERY = "src/main/kotlin/com/gitmetrics/app/queries/MergedPullRequests.json"

@Service
class GitHubService(private val gitHubClient: GitHubFeignClient) {

    fun fetchAllPullRequests(owner: String, repo: String): Map<String, Any> {
        val query = generateQuery(owner, repo, ALL_PR_QUERY)
        val response = gitHubClient.executeQuery(Token.getToken(), query)
        return response
    }
    fun fetchClosedPullRequests(owner: String, repo: String): Map<String, Any> {
        val query = generateQuery(owner, repo, CLOSED_PR_QUERY)
        val response = gitHubClient.executeQuery(Token.getToken(), query)
        return response
    }
    fun fetchOpenPullRequests(owner: String, repo: String): Map<String, Any> {
        val query = generateQuery(owner, repo, OPEN_PR_QUERY)
        val response = gitHubClient.executeQuery(Token.getToken(), query)
        return response
    }
    fun fetchMergedPullRequests(owner: String, repo: String): Map<String, Any> {
        val query = generateQuery(owner, repo, MERGED_PR_QUERY)
        val response = gitHubClient.executeQuery(Token.getToken(), query)
        return response
    }
    private fun generateQuery(owner: String, repo: String, queryTemplate: String): String {
        val queryFilePath = Paths.get(queryTemplate)
        var query = String(Files.readAllBytes(queryFilePath))
        return String.format(query, owner, repo)
    }
}