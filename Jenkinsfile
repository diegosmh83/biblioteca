pipeline {
   agent any

   tool {
      jdk 'jdk-21'
      maven 'Maven 3.9.11'
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

     stage('Maven clean'){
         steps {
         bat 'mvn clean'
         }

     }


   }
}