pipeline {
    agent any
    stages {
        stage ('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/PriyadasunKC/jenkins.git'
            }
        }
        stage ('Build') {
            steps {
                sh 'mvn compile'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('codeQuality') {
            steps {
                sh '''
                    mvn sonar:sonar \
                        -Dsonar.projectKey=netflix \
                        -Dsonar.host.url=http://35.180.132.231:9000 \
                        -Dsonar.login=5190001f00936677bc55fd2591acf33d7c8910a1 
                '''
            }
        }
        stage('Deploy') {
            steps {
                sh 'mvn clean package'
            }
        }
    }
}