node {
   stage('Preparation') { 
      git 'https://github.com/RichardKnowles/fleetman-webapp'
   }
   stage('Build') {
      sh "mvn -DskipTests clean package"
   }
   stage('Results') {
      archive 'target/*.war'
   }
   stage('Deploy') {      
      withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', accessKeyVariable: 'AWS_ACCESS_KEY_ID', credentialsId: 'awscredentials', secretKeyVariable: 'AWS_SECRET_ACCESS_KEY']]) {
         ansiblePlaybook credentialsId: 'ssh-credentials', installation: 'ansible-installation', playbook: 'deploy.yaml', sudoUser: null      
      }     
   }
}
