pipeline {
    agent any
    tools {
        maven 'Maven 3'
        jdk 'Java 11'
    }
    options {
        buildDiscarder(logRotator(artifactNumToKeepStr: '15'))
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
            post {
                success {
                    archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
                }
            }
        }
    }
    post {
        always {
            deleteDir()
        }
    }
}