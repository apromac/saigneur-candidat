pipeline {
    #agent { docker { image 'maven:3.8.4-openjdk-11-slim' } }
    agent any
    environment {
        DOCKER_IMAGE_NAME = "saigneur-candidat"
        BUILD_TAG = "v1.0.${BUILD_NUMBER}"
        CONTAINER_NAME = "msaigneur-candidat"
        CONTAINER_PORT = 9003
        IMAGE_DEFAULT_DIR = "/usr/local/microservice/msaigneur"
        VOLUME_NAME = "postgres_data"
    }
    stages {
        stage('Compilation du code source') {
            steps {
                echo 'Compilation du code source ...'
                sh 'mvn --version'
                sh 'mvn clean install -DskipTests'
            }
        }
        /*
        stage ('Arret des services du docker-compose') {
        }

        stage('Mise en marche des services du docker-compose') {
            steps {
                echo 'Compilation du Docker Compose ...'
                sh 'docker-compose --version'
                sh 'docker-compose build'

                echo 'Demarrage du Docker Compose ...'
                sh 'docker-compose up -d'
            }
        }

        stage ('Affichage des containers mis en service') {
            steps {
                echo 'Affichage des containers en service ...'
                sh 'docker ps'

                echo 'Affichage des volumes existant ...'
                sh 'docker volume ls'
            }
        }
        */
    }
}

