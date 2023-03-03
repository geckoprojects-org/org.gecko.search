pipeline  {
    agent any

    tools {
        jdk 'OpenJDK11'
    }
    options {
        buildDiscarder(logRotator(numToKeepStr: '5'))
        skipDefaultCheckout()
    }

    stages {
    	stage('Clean Workspace') {
            steps {
                // Cleanup before starting the stage
                cleanWs()
            }
        }
    	stage('Checkout') {
            steps {
                // Checkout the repository
                checkout scm 
            }
        }
        stage('Branch snapshot') {
            when { 
                branch 'develop'
            }
            steps  {
                echo "I am building on ${env.JOB_NAME}"
                sh "./gradlew clean release --info --stacktrace -Dmaven.repo.local=${WORKSPACE}/.m2"
                sh "mkdir -p $JENKINS_HOME/repo.gecko/org.gecko.search"
                sh "rm -rf $JENKINS_HOME/repo.gecko/org.gecko.search/*"
                sh "cp -r cnf/release/* $JENKINS_HOME/repo.gecko/org.gecko.search"
            }
        }
        stage('Branch main - release') {
            when { 
                branch 'main'
            }
            steps  {
                echo "I am building on ${env.JOB_NAME}"
                sh "./gradlew clean build release -Drelease.dir=$JENKINS_HOME/repo.gecko/release/org.gecko.search --info --stacktrace -Dmaven.repo.local=${WORKSPACE}/.m2"
            }
        }
    }
}
