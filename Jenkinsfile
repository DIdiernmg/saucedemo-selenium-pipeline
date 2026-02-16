pipeline {
    agent any

    // Disparadores: Configura a Jenkins para que trabaje solo
    triggers {
        // Revisa GitHub cada 2 minutos. La 'H' distribuye la carga del servidor.
        pollSCM('H/2 * * * *') 
    }

    tools {
        // Estos nombres deben coincidir exactamente con tu 'Global Tool Configuration'
        maven 'Maven_3.9.6' 
        jdk 'Java_17'
    }

    stages {
        stage('Checkout') {
            steps {
                // Descarga el código fuente desde tu repositorio en GitHub
                checkout scm
            }
        }

        stage('Limpieza y Build') {
            steps {
                // 'bat' se usa para ejecutar comandos de Windows (CMD)
                // mvn clean: borra la carpeta target anterior
                // mvn test: compila y ejecuta las pruebas de TestNG
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            // Esta sección se ejecuta siempre, sin importar si el test pasó o falló
            script {
                // Genera el reporte de Allure usando los resultados en target/allure-results
                allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
            }
        }
    }
}