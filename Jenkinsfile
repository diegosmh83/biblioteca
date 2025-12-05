pipeline {
   agent any

   tools {
      jdk 'jdk-21'
      maven 'Maven3.9.11'
   }

   environment{
       VERSION_BACK = "2.0.1"
   }

   stages {

       stage('Show messages'){

       steps {
           echo "Primer stage del pipeline"
           echo "A continuacion hacemos checkout del proyecto"
       }

     }

     stage('Checkout proyecto'){
         steps {
             git branch: 'master',
                  url: 'https://github.com/diegosmh83/biblioteca.git'
         }
     }

     stage('Comandos Maven'){
         steps {
         bat 'mvn clean package'
         }

     }

     stage('Crea Directorio'){
         steps{
             bat 'mkdir v%VERSION_BACK%'
         }
     }

     stage('Copiar ficheros'){
         steps{
             bat 'xcopy /Y ".\\target\\*.jar" ".\\"v%VERSION_BACK%""'
         }
         post {
             success {
                bat 'echo "Despues de copiar los ficheros correctamente"'
             }
             failure {
                bat 'echo "ERROR copiando los ficheros"'
             }
             always {
                bat 'echo "Esto se ejecuta siempre tras el stage copiar ficheros"'
             }
         }
     }

   }

}