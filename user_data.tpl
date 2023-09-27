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
sudo curl -L "https://github.com/docker/compose/releases/download/1.26.0/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose
# Create a Docker Compose YAML file (docker-compose.yml) for MongoDB and Spring Boot
cat <<EOL > docker-compose.yml
version: '3'
services:
  mongodb:
    image: mongo:4.4
    ports:
    - "27017:27017"
  springboot:
    image: sigmaprofil/your-spring-boot-image
    ports:
    - "8080:8080"
    depends_on:
    - mongodb
EOL

# Start the services using Docker Compose
docker-compose up -d
