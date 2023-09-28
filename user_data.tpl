#!/bin/bash
sudo yum update -y
# Install Docker and Docker Compose
sudo amazon-linux-extras install docker -y
sudo service docker start
sudo usermod -aG docker ec2-user
sudo curl -L "https://github.com/docker/compose/releases/latest/download/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose
# Create a directory for Docker Compose files
mkdir my_app
cd my_app

#CHANGE_ME ACCESS_KEY     SECRET_KEY   REGION_ID
aws configure set aws_access_key_id ACCESS_KEY && aws configure set aws_secret_access_key SECRET_KEY && aws configure set default.region REGION_ID

#CHANGE_ME ACCOUNT_ID     REGION_ID
aws ecr get-login-password --region REGION_ID | docker login --username AWS --password-stdin ACCOUNT_ID.dkr.ecr.REGION_ID.amazonaws.com


# Create a Docker Compose YAML file (docker-compose.yml) for MongoDB and Spring Boot
cat <<EOL > docker-compose.yml
version: '3'
services:
  mongodb:
    image: mongo:4.4
    ports:
    - "27017:27017"
  springboot:
    image: 574625588165.dkr.ecr.us-east-1.amazonaws.com/my-docker-repo:latest
    ports:
    - "8080:8080"
    depends_on:
    - mongodb
EOL

# Start the services using Docker Compose
docker-compose up -d
