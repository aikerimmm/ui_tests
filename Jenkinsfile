pipeline {
    agent any

    parameters {
        choice(
                name: 'BROWSER',
                choices: ['chrome', 'firefox'],
                description: 'Выбор браузера для запуска тестов (Safari не поддерживается Selenoid)'
        )
    }

    stages {
        stage('Run Tests') {
            steps {
                sh "./gradlew clean test -Dbrowser=${params.BROWSER} || true"
            }
        }

        stage('Generate Allure Report') {
            steps {
                sh './gradlew allureReport || true'
            }
        }
    }

    post {
        always {
            echo 'Pipeline finished'
        }
    }
}