pipeline {
    agent any

    stages {
        stage('Check kubectl version') {
            steps {
                // Use PowerShell to check kubectl version
                powershell '''
                    kubectl version --client
                '''
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                // Use PowerShell to deploy the Kubernetes manifest
                powershell '''
                    kubectl apply -f app.yaml  # Ensure the file name matches
                '''
            }
        }
    }

    post {
        always {
            cleanWs()  // Cleans up the workspace after the pipeline run
        }
    }
}
