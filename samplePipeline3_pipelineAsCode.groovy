pipeline {
    agent any
    stages {
        stage ('one') {
            
            // Define what to do in the stage 'one' using steps
            steps {

                // Checkout the code from the repository
                git branch: 'main' url 'https://github.com/PriyadasunKC/jenkins.git'

                // Build the code using maven
                sh 'mvn compile'

                // Test the code using maven test
                sh 'mvn test'

                // Create artifacts the code using maven package 
                sh 'mvn clean package'
            }
        }
    }
}