def call(String credId, String imagename) {
    withCredentials([usernamePassword(
        credentialsId: dockerhubcredss,
        passwordVariable: "dockerhubpass",
        usernameVariable: "dockerhubuser"
    )]) {
        sh """
            echo "\$dockerhubpass" | docker login -u "\$dockerhubuser" --password-stdin
            docker image tag ${imagename} \$dockerhubuser/${imagename}:latest
            docker push \$dockerhubuser/${imagename}:latest
        """
    }
}
