pipeline {
    agent any
    environment {
        GIT_BRANCH = 'main'
        GIT_URL = 'https://github.com/PriyadasunKC/jenkins.git'
    }
        stages {
            stage('one') {
                steps {
                    git branch:"${GIT_BRANCH}" , url:"${GIT_URL}"
                }
            }
        }
        // Post build action always runs after the build is done
        post {
            success {
                echo 'Build is done!'
            }
        }
}
