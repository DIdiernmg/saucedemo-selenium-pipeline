pipeline {
    agent any

    tools {
        // Nombres corregidos para que coincidan EXACTAMENTE con tu Jenkins
        maven 'Maven_3.9.6' 
        jdk 'Java_17'
    }

    stages {
        stage('Checkout') {
            steps {
                // Descarga el código desde el nuevo repositorio de SauceDemo
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                // Ejecuta la limpieza y los tests de TestNG en Windows
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            // Genera el reporte de Allure pase lo que pase
            script {
                allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
            }
        }
    }
}