pipeline{
 agent any
 stages{
    stage('Compile Stage'){
        steps{
                withMaven(maven : 'apache maven'){
                    sh 'mvn clean compile'
                }
         }
    }

     stage('Testing Stage'){
        steps{
            withMaven(maven : 'apache maven'){
                sh 'mvn test'
            }
        }
     }

      stage('Deployment Stage'){
             steps{
                 withMaven(maven : 'apache maven'){
                     sh 'mvn deploy'
                 }
             }
          }

      }

      post{
          success{
      		office365ConnectorSend color: 'green', message: "FAILURES after JOB: ${env.JOB_NAME}    BUILD NO:  ${env.BUILD_NUMBER} committed by  ${env.CHANGE_AUTHOR} -- ${env.CHANGE_AUTHOR_DISPLAY_NAME}  --  [View on Jenkins]  (${env.BUILD_URL})", status: 'Success', webhookUrl: "${env.HOOK}"
      		
          failure{
             office365ConnectorSend color: 'red', message: "FAILURES after JOB: ${env.JOB_NAME}    BUILD NO:  ${env.BUILD_NUMBER} committed by ${env.CHANGE_AUTHOR} -- ${env.CHANGE_AUTHOR_DISPLAY_NAME}  CURRENT BUILD -- ${currentBuild.currentResult}-- DURATION ${currentBuild.currentResult} -- USER ID -- ${env.BUILD_USER_ID}  --- ${GIT_COMMIT} -- [View on Jenkins]  (${env.BUILD_URL})", status: 'Failure', webhookUrl: "${env.HOOK}"
          }
      }


 }