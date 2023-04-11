pipelineJob('html-generator') {
    parameters {
        stringParam('DEPLOYED_BY',
            defaultValue = '',
            description = 'Identifies who generated the latest HTML.'
        )
    }
    definition {
        cpsScm {
            scm {
                git {
                    remote { 
                        url('https://github.com/Denny2020/g-html-renderer.git') // Your Github repo
                        credentials('go-html-renderer') // Credentials ID from the previous step
                    }
                    branch('dynamic-html') // Use 'branch' instead of 'branches'
                    scriptPath('Jenkinsfile')
                }
            }
        }
    }
}
