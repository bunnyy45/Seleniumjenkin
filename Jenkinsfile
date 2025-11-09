pipeline{
	agent any
	
	stages{
		
		stage('1st Phase Checkout and Setup'){
			steps{
				    echo "Fetching latest code from Git repository..."

			}
		} 
		
		stage('Build and Compile'){steps{
			
		
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