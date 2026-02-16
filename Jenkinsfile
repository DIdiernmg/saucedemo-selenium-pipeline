pipeline {
    agent any

    // 1. Disparador: Revisa GitHub cada 2 minutos en busca de cambios
    triggers {
        pollSCM('H/2 * * * *') 
    }

    // 2. Herramientas: Configuración exacta de tu Jenkins local
    tools {
        maven 'Maven_3.9.6' 
        jdk 'Java_17'
    }

    stages {
        stage('Checkout') {
            steps {
                // Descarga el código desde el repositorio actual
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                // Ejecuta la limpieza y los tests de SauceDemo
                bat 'mvn clean test'
            }
        }
    }

    // 3. Post-acciones: Generación de reportes y metadatos
    post {
        always {
            script {
                // Recupera la sección 'Environment' en Allure
                // Se crean las propiedades dinámicamente antes de generar el reporte
                bat """
                if not exist "target\\allure-results" mkdir "target\\allure-results"
                echo Browser=Chrome > target/allure-results/environment.properties
                echo Tester=Didier Marin (Tiko) >> target/allure-results/environment.properties
                echo OS=Windows 11 >> target/allure-results/environment.properties
                echo Project=SauceDemo-Automation-QA >> target/allure-results/environment.properties
                echo Java_Version=17 >> target/allure-results/environment.properties
                """
                
                // Genera el reporte visual para Anthology
                allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
            }
        }
    }
}