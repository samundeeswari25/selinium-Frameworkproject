pipeline {
    agent any

    tools {
        maven 'maven'
        jdk 'JDK21'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'master',
                url: 'https://github.com/samundeeswari25/selinium-Frameworkproject.git'
            }
        }

        stage('Clean Project') {
            steps {
                bat 'mvn clean'
            }
        }

        stage('Run Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Generate Allure Report') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/**/*'
        }
    }

   post {
       always {
           publishHTML([
               allowMissing: false,
               alwaysLinkToLastBuild: true,
               keepAll: true,
               reportDir: 'target',
               reportFiles: 'cucumber-report.html',
               reportName: 'Cucumber Report'
           ])
       }

        success {
            echo 'Execution completed successfully'
        }

        failure {
            echo 'Execution failed'
        }
    }
}