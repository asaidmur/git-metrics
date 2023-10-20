# Git Metrics

Git Metrics is a Kotlin SpringBoot application that gathers metrics via Github's GraphQL API, organizing it into usable data and outputs as a csv file.

further improvements to be considered:
- integration with AWS Lambda
- visualization strategy
- integration with CI/CD platform


## Authentication

Need to ensure correct Github Personal Access Token is available to use in API calls
https://docs.github.com/en/graphql/guides/forming-calls-with-graphql#authenticating-with-a-personal-access-token

## Installation

./gradlew bootRun

## Usage
http://localhost:8080/all?owner={repo-owner}&repo={repo-name}

http://localhost:8080/open?owner={repo-owner}&repo={repo-name}

http://localhost:8080/closed?owner={repo-owner}&repo={repo-name}

http://localhost:8080/merged?owner={repo-owner}&repo={repo-name}

so for example, if you want to see information on merged pull requests:
http://localhost:8080/merged?owner=asaidmur&repo=git-metrics

output:

```
{
  "data" : {
    "repository" : {
      "pullRequests" : {
        "totalCount" : 4,
        "nodes" : [ {
          "title" : "first commit of README",
          "createdAt" : "2023-10-17T20:29:01Z",
          "closedAt" : "2023-10-17T20:36:34Z",
          "mergedAt" : "2023-10-17T20:36:34Z"
        }, {
          "title" : "creating an open branch for testing",
          "createdAt" : "2023-10-17T23:06:36Z",
          "closedAt" : "2023-10-18T01:06:09Z",
          "mergedAt" : "2023-10-18T01:06:09Z"
        }, {
          "title" : "Convert to kotlin",
          "createdAt" : "2023-10-18T01:05:59Z",
          "closedAt" : "2023-10-18T01:06:07Z",
          "mergedAt" : "2023-10-18T01:06:07Z"
        }, {
          "title" : "dev init commit",
          "createdAt" : "2023-10-19T04:04:59Z",
          "closedAt" : "2023-10-19T04:05:29Z",
          "mergedAt" : "2023-10-19T04:05:29Z"
        } ]
      }
    }
  }
}
```

## Contributing

TBD


## License

[MIT](https://choosealicense.com/licenses/mit/)
