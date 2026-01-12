pipeline {
    agent any

    tools {
          jdk 'jdk-21'
          maven 'Maven3.9.11'
       }

    environment {
        VERSION_BACK = "2.0.1"
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Package') {
            steps {
                bat 'mvn package'
            }
        }

        stage('Move jar') {
            steps {
                bat '''
                    if exist versiones (
                        rmdir /s /q versiones
                    )
                '''
            }
            post {
                success {
                    bat '''
                        mkdir versiones
                        copy target\\*-%VERSION%.jar versiones\\
                    '''
                }
            }
        }
    }
}

