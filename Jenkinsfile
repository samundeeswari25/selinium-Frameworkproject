pipeline {
    agent any

    tools {
        maven 'maven'
        jdk 'jdk-21'
    }

    environment {
        BROWSER = "chrome"
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main',
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
                bat 'allure generate allure-results --clean -o allure-report'
            }
        }

        stage('Archive Reports') {
            steps {
                archiveArtifacts artifacts: 'target/*.html', fingerprint: true
                archiveArtifacts artifacts: 'allure-report/**/*', fingerprint: true
            }
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