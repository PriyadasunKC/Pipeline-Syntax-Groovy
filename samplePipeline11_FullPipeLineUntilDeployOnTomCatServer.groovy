pipeline {
    agent {
        label 'slave2'
    }
    environment {
        GIT_BRANCH = 'main'
        GIT_URL = 'https://github.com/PriyadasunKC/jenkins.git'
    }
        stages {
            stage('checkout') {
                steps {

                    git branch:"${GIT_BRANCH}" , url:"${GIT_URL}"
                }
            }
            stage('build') {
                steps {
                    sh 'mvn compile'
                }
            }
            stage('test') {
                steps {
                    sh 'mvn test'
                }
            }
            stage('artifacts') {
                steps {
                    sh 'mvn clean package'
                }
            }
            stage('deploy') {
                steps {
                    deploy adapters: [
                        tomcat9(
                            credentialsId: '26c1cfb7-12f7-497e-ad36-105227b42a1e', 
                            url: 'http://localhost:8080'
                        )
                    ], contextPath: 'netflix', war: '**/target/*.war'
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
