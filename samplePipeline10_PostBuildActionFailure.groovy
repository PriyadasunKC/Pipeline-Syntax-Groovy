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
                    // this will fail the build and post build action will run
                    s 'env'
                }
            }
        }
        // Post build action always runs after the build is done
        post {
            failure {
                echo 'Build is done!'
            }
        }
}
