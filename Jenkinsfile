pipeline {
    agent any
    environment {
        DOCKER_IMAGE_NAME = "saigneur-candidat"
        BUILD_TAG = "v1.0.${BUILD_NUMBER}"
        CONTAINER_NAME = "saigneur-candidat"
        CONTAINER_PORT = 9003
        IMAGE_DEFAULT_DIR = "/usr/local/microservice/"
        VOLUME_NAME = "vmfirca-images"
    }
    stages {
        stage ('Compilation du code source') {
        }
        stage ('Construction de l image docker') {
        }
        stage ('Arret et suppression du conteneur si celui-ci existe') {
        }
        stage ('Mise en marche du conteneur') {
        }
    }
}
