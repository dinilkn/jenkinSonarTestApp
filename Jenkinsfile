pipeline{

agent any
 stages{
  
    stage('checkout from SCM'){
     steps{
          echo 'Checking out Code from Git'
          git credentialsId: 'de97785c-b80c-4e7d-8f05-60377dc48cde', url: 'https://github.com/dinilkn/jenkinSonarTestApp.git'

     }
   }
 }


}
