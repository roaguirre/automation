pipeline {
    agent any

    tools {
        maven "3.8.1"
    }

    stages {
        stage("Setup") {
            steps {
                sh "mvn --version"
            }
        }
        stage("Validate") {
            steps {
                sh "mvn verify"
            }
        }
        stage("Compile") {
            steps {
                sh "mvn clean install"
            }
        }
        stage("Test") {
            steps {
                sh "mvn clean install"
            }
        }
        stage("Package") {
            steps {
                sh "mvn clean install"
            }
        }
        stage("Verify") {
            steps {
                sh "mvn clean install"
            }
        }
        stage("Install") {
            steps {
                sh "mvn clean install"
            }
        }
        stage("Run") {
            steps {
                echo 'Hello world'
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}