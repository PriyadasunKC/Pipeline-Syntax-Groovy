pipeline {
    agent any
    stages {
        stage ('one') {

            // Checkout the code from the repository
            git branch: 'main' url: 'https://github.com/PriyadasunKC/jenkins.git'
            
            // build test get artifcats using steps in a single shell
            sh '''
                mvn compile
                mvn test
                mvn clean package
            '''
        }
    }
}