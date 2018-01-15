pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        build(job: 'docker1', propagate: true)
      }
    }
  }
}