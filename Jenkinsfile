pipeline {
    agent any

    tools {
        // Asegúrate de que estos nombres coincidan con los de tu Jenkins -> Global Tool Configuration
        maven 'maven-3.9.6'
        jdk 'java-17'
    }

    stages {
        stage('Checkout') {
            steps {
                // Descarga el código desde GitHub
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                // Ejecuta la limpieza y los tests de TestNG
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            // Genera el reporte de Allure independientemente de si el test pasó o falló
            script {
                allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
            }
        }
    }
}