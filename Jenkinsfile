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
                sh "mvn validate"
            }
        }
        stage("Compile") {
            steps {
                sh "mvn clean compile"
            }
        }
        stage("Test") {
            steps {
                sh "mvn test"
            }
        }
        stage("Package") {
            steps {
                sh "mvn clean package"
            }
        }
        stage("Verify") {
            steps {
                sh "mvn verify"
            }
        }
        stage("Install") {
            steps {
                sh "mvn clean install"
            }
        }
        stage("Run") {
            steps {
                java -jar com.aguirreibarra.automation-1.0-SNAPSHOT.jar
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}