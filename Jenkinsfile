
pipeline {
    agent any

    environment {
        // Maven Home Configuration
        MAVEN_HOME = tool 'Maven'  // Ensure you have a Maven installation configured in Jenkins

        // Docker Hub Credentials (replace with your actual credentials)
        DOCKER_REGISTRY = "docker.io"
        DOCKER_USERNAME = "ibond.chris@gmail.com" // Replace with your Docker Hub username
        DOCKER_CREDENTIALS_ID = "dockerHubRepo" // Replace with your Docker Hub credential ID in Jenkins

        // Application and Image Details
        APP_NAME = "simple-app"
        DOCKER_IMAGE_NAME = "${DOCKER_USERNAME}/${APP_NAME}"
        DOCKER_IMAGE_TAG = "latest-${BUILD_NUMBER}"
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the source code from the repository.  Use a more specific 'checkout' step.
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Build the Spring Boot application using Maven.
                sh "${MAVEN_HOME}/bin/mvn clean package -DskipTests"
            }
        }

        stage('Test') {
            steps {
                // Run the JUnit tests.
                sh "${MAVEN_HOME}/bin/mvn test"
            }
        }

        stage('Build Docker Image') {
            steps {
                // Build the Docker image
                script {
                    def dockerImage = docker.build("${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_TAG}", '.')
                    // Store the image ID for later use (optional, but good practice)
                    env.DOCKER_IMAGE_ID = dockerImage.id()
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                // Push the Docker image to Docker Hub
                withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: env.DOCKER_CREDENTIALS_ID, usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD']]) {
                    script {
                        docker.withRegistry("${DOCKER_REGISTRY}", env.DOCKER_CREDENTIALS_ID) {
                            docker.image("${DOCKER_IMAGE_NAME}:${DOCKER_IMAGE_TAG}").push()
                        }
                    }
                }
            }
        }
    }
    // Post-build actions (optional)
    post {
        always {
            //  Clean up the workspace (optional, but recommended)
            cleanWs()
        }
        //If the build was successful
        success {
           echo "SUCCESS"
        }
        // If the build fails
        failure {
            echo "FAILED"
        }
    }
}

