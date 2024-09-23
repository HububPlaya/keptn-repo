pipeline {
    agent any

    stages {
        stage('Check kubectl version') {
            steps {
                script {
                    sh 'kubectl version --client'
                }
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                script {
                    sh 'kubectl apply -f app.yaml'  // Ensure the file name matches
                }
            }
        }
    }

    post {
        always {
            cleanWs()  // Cleans up the workspace after the pipeline run
        }
    }
}
