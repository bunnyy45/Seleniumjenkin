pipeline {
    agent {
        docker {
            image 'maven:3.8.1-jdk-11' 
            args '-u root'
        }
    }

    stages {
        // STAGE 1: Manual Checkout
        stage('Checkout Code') {
            steps {
                echo "Fetching code manually using git clone..."
                
                // --- CRITICAL MANUAL GIT STEP ---
                // The 'git' step checks out the code. 
                // We use the 'credentialsId' you set up in the job's global credentials store.
                git url: 'https://github.com/bunnyy45/Seleniumjenkin', 
                    branch: 'master', 
                    credentialsId: '242a59f3-dccb-4260-b168-7fdd2e504d86' 
                // --------------------------------
            }
        }
        
        // STAGE 2: Build and Compile
        stage('Build & Compile') {
            steps {
                echo 'Cleaning and Compiling Java project with Maven...'
                sh 'mvn clean compile'

			}
		}
		stage('Run Test'){
			steps{
				echo 'Executing Test cases'
				sh 'mvn test'
			}
		}
		
		stage('Published Report'){
			steps{
                echo 'Publishing Test Results to Jenkins Dashboard...'
                                junit 'target/surefire-reports/*.xml'

			}
		}
		
	}
	post{
		always{
			            echo 'CI Pipeline execution finished.'

		}
		success{
			            echo 'Build SUCCESSFUL: All tests passed.'

		}
		failure{
			            echo 'Build FAILED: Check Console Output and Test Results section for errors.'

		}
	}
}