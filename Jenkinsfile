pipeline {
    agent any

    stages {
        stage('Build with Maven') {
            tools {
                maven 'maven'
            }
            steps {
                sh 'mvn --version'
                sh 'java -version'
                sh 'mvn clean package -Dmaven.test.failure.ignore=true'
            }
        }

        stage('Deploy Spring Boot to DEV') {
            steps {
                echo 'Deploying and cleaning'
                sh '''
                    docker compose down || echo "No existing containers"
                    docker compose -f docker-compose.yml build
                    docker compose -f docker-compose.yml up -d --scale web=2
                    docker compose ps
                 '''
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}