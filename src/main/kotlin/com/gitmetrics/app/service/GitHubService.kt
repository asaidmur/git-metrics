package com.gitmetrics.app.service

import com.gitmetrics.app.client.GitHubFeignClient
import com.gitmetrics.app.utility.Token
import org.springframework.stereotype.Service
import java.nio.file.Files
import java.nio.file.Paths

@Service
class GitHubService(private val gitHubClient: GitHubFeignClient) {

    fun fetchAllPRData(owner: String, repo: String): Map<String, Any> {
        val queryFilePath = Paths.get("src/main/kotlin/com/gitmetrics/app/queries/PullRequests.json")
        var query = String(Files.readAllBytes(queryFilePath))
        query = String.format(query, owner, repo)
        val token = Token.getToken()
        val response = gitHubClient.executeQuery(token, query)
        return response
    }
}