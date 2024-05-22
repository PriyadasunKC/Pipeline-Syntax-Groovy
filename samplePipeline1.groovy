// Staring of the pipeline code
pipeline {

    // Define the worker node to execute the pipeline (Master or Slave)
    agent any

    // Define the stages of the pipeline
    stages {

        // Define the stage 'one'
        stage('one') {

            // Define what to do in the stage 'one'
            steps {
                sh "touch file1"
            }
        }
    }
}