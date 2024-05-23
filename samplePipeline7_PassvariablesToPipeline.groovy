pipeline {
    agent any

    environment {
        GIT_BRANCH = 'main'
        GIT_URL = 'https://github.com/PriyadasunKC/jenkins.git'
    }
    
    stages {
        stage ('Checkout') {
            steps {
                git branch: "${GIT_BRANCH}" , url:"${GIT_URL}"
            }
        }
    }
}