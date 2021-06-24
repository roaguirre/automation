pipeline {
    agent {
        docker {
            image "maven:3.8.1"
            label "docker"
        }
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
                sh "mvn compile exec:java -Dexec.mainClass=\"com.aguirreibarra.automation.WebTest\""
            }
        }
    }
}