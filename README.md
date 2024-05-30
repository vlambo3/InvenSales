<a name="readme-top"></a>
# Project InvenSales
## Objetive
If you want to learn how to implement a **MICROSERVICE SECURITY ARCHITECTURE** through Identity and Access Management (IAM), I invite you to clone my repo and follow the steps detailed below.

Do you know what IAM is? IAM is responsible for the **management of user identities** in a system, such as usernames, passwords, credentials, roles, etc., and the **management of access permissions** to the resources the system or application may possess.

This means it handles both **authentication** (verifying the user's identity) and **authorization** (determining the user's access permissions).
**The main objective of an IAM** is to ensure that users have appropriate access to the resources and services necessary for their work while protecting confidential data and minimizing the risk of security breaches.

We will use *Keycloak* developed by **RedHat** as our IAM solution. Keycloak is a single sign-on solution for web applications and RESTful services. The goal of Keycloak is to simplify the development of applications and protect the applications and their services. Regarding security, we will follow the OAuth2 protocol.

Como IAM vamos a usar *Keycloak* desarrollado por **RedHat**, que es una solución de inicio de sesión único para aplicaciones web y servicios RESTful. El objetivo de Keycloak es facilitar el desarrollo de aplicaciones y la protección de las aplicaciones y sus servicios. 
En cuanto a la seguridad vamos a seguir el protocolo de OAuht2.	

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- ABOUT THE PROJECT -->
## About the Project
The application to which we will implement security consists of three services: **apigatewayservice**, **elaparato**.
The application allows only authenticated users to access it through its API GATEWAY, using the Authorization code flow to exchange a code for an Access Token with the **AUTHORIZATION SERVER**. The ms-gateway service will be a **CLIENT**.

Authenticated users can access the /test/ping endpoint in the elaparato service at localhost:9090/test/ping. Users with the admin role can access all endpoints, including viewing the list of all users. Users with the repositor role can perform CRUD operations on products, while users with the seller role can perform all operations related to sales. In this case, elaparato will serve as a **RESOURCE SERVER** and will also manage the users registered in Keycloak.

The application allows only authenticated users to access it through its API GATEWAY SERVICE, using the Authorization code flow to exchange a code for an Access Token with the **AUTHORIZATION SERVER***. The ms-gateway service will be a **CLIENT**.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Built With
The project is built with jdk 17, using Spring Boot, Spring Data JPA, Spring MVC, Spring Cloud, OAuth2, and Keycloak Admin.
<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- GETTING STARTED -->
## Getting Started!
You can clone this repository by executing the git clone command along with the URL: https://github.com/vlambo3/InvenSales from your Git Bash console.
  ```
  git clone https://github.com/vlambo3/InvenSales
  ```
<p align="right">(<a href="#readme-top">back to top</a>)</p>

## Installation
To test the services, after cloning the repository, you can run the Keycloak image in your Docker Desktop with the command:
  ```
  docker run -p 8080:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:21.0.1 start-dev
  ```
Next, you will need to import the realm JSON file attached to this project. You can do this once you have logged into your Keycloak console at localhost:8080. Click on "Create Realm," then "Browse," and select the JSON file. From here, the realm and the necessary clients will be created.

**Alert**: You will need to recreate the clients to visualize the secrets for each one and replace them in the application configuration file, in both the apigatewayservice and elaparato service. Additionally, remember to maintain the standard flow in the apigateway service and the client credentials flow in the users-client service. In the users-client service, you will also need to enable permissions to query users. This can be done from the Keycloak console by navigating to this client/service account roles/assign role/filter by clients/and assigning all user permissions.
You will need to create some users to begin testing and assign the roles at the realm level to test the endpoints. If you want to test endpoints with HTTP post/put/delete requests, you can do so using Postman by configuring this client as a Gateway with Keycloak permissions.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

I recommend accessing your browser in incognito mode whenever necessary and testing the application from any route by always starting from your apigatewayservice. When making a request, you should be automatically redirected to the Keycloak login screen, as shown in the following image:
![image](https://github.com/vlambo3/InvenSales/images/LoginKeycloak.png)

If you want to access and query the preloaded products using an SQL file, you must do so with a user that you have created and assigned the admin or seller role at the realm level and you will see the following image:
![image](https://github.com/vlambo3/InvenSales/images/Productos.png)

If I wanted to access and query the pre-loaded sales via an SQL file, I would need to do it with a user that I have created and assigned the role at the realm level, either as an admin or repository, and I would see the following image:
![image](https://github.com/vlambo3/InvenSales/images/Ventas.png)

If I wished to access and query the users stored in Keycloak's relational database, I would need to do so with a user that I have created and assigned the realm-level admin role to, and I would see the following image:
![image](https://github.com/vlambo3/InvenSales/images/Usuarios.png)

You can also log out. Keycloak allows you to log out from the main URL of your API gateway using the path localhost:9090/logout, as shown in the following image:
![image](https://github.com/vlambo3/InvenSales/images/Logout1.png)

Upon logging out, you will be offered the option to be redirected to the login page:
![image](https://github.com/vlambo3/InvenSales/images/Logout2.png)

If you want to access an endpoint again, note that the logout works correctly:
![image](https://github.com/vlambo3/InvenSales/images/Logout3.png)

It can even allow users to register, and even sign up using a social login, as shown in the following image:
![image](https://github.com/vlambo3/InvenSales/images/LoginSocial.png)


## Contacto

Project Link: [https://github.com/vlambo3/InvenSales](https://github.com/vlambo3/InvenSales)

LinkedIn Profile: [https://www.linkedin.com/in/vanina-a-godoy/](https://www.linkedin.com/in/vanina-a-godoy/)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

