pipeline {
    agent any
    stages {

        // Define the stage 'Checkout' to checkout the code from the repository
        stage ('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/PriyadasunKC/jenkins.git'
            }
        }

        // Define the stage 'Build' to build the code using maven
        stage ('Build') {
            steps {
                sh 'mvn compile'
            }
        }

        // Define the stage 'Test' to test the code using maven test
        stage ('Test') {
            steps {
                sh 'mvn test'
            }
        }

        // Define the stage 'Deploy' to deploy the code using maven package
        stage ('Deploy') {
            steps {
                sh 'mvn clean package'
            }
        }
    }
}