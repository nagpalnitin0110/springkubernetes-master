pipeline {
    environment {
    registry = "192.168.1.15:31313/kubernetespring"
    dockerImage = ''
  }
    agent{
    kubernetes {
      label "master"
      yaml """
apiVersion: v1
kind: Pod
metadata:
labels:
  component: ci
spec:
  # Use service account that can deploy to all namespaces
  serviceAccountName: cd-jenkins
  containers:
  - name: docker
    image: docker:latest
    command:
    - cat
    tty: true
    volumeMounts:
    - mountPath: /var/run/docker.sock
      name: docker-sock
  volumes:
    - name: docker-sock
      hostPath:
        path: /var/run/docker.sock
"""
    }
}    
    tools {
        maven 'Maven'
        jdk 'Java'
    }
    stages {
        stage('Clone') {
            steps {
                git branch: 'master', credentialsId: '88507895-18ed-4d9a-b7ce-9bf7d572964a', url: 'https://github.com/bikash2807/SpringKubernetes.git'
            }
        }
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Building image') {
            steps{
                script {
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }
        stage('Deploy Image') {
            steps{
                script {
                    dockerImage.push()
            }
        }
    }
    stage('Remove Unused docker image') {
      steps{
        sh "docker rmi $registry:$BUILD_NUMBER"
      }
    }
    }
}
