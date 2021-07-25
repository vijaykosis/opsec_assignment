# opsec_assignment

# Steps To Execute the Assignment 

 # Download all the above module or clone the repo
 
 # Step 1
       First Run the API gateWay using netflix-eureka-naming-server module
 Run the NetflixEurekaNamingServerApplication.class java main class 
 you can  check the Api gateWay At this Link
              http://localhost:8761/
  # Step 2   
 Run the API Zuul proxy server  using netflix-zuul-api-gateway-server module     
 Run the Zuul proxy server using main class 

                
  # Step 2            
     Run the user-core Service  module using main class
# You can call the services using swagger url you can check in swagger
        http://localhost:8085/swagger-ui.html#/user-controller
        

# Sample request response from composite service is 
   url -> localhost:8085/user-core-service/createUser
   
              request payload :
                      {
        "id": "119",
        "firstName": "Ankur",
        "surName": "Khanna",
        "dob": "1991/05/19",
        "title": "software Engineer"
    }
    
    Response::
    {
    "id": "119",
    "firstName": "Ankur",
    "surName": "Khanna",
    "dob": "1991/05/19",
    "title": "software Engineer"
}

# get Api call 
  localhost:8085/user-core-service/getAllInfo
           Response -->>
           [
    {
        "id": "11",
        "firstName": "vijay",
        "surName": "koshis",
        "dob": "1991/05/19",
        "title": "software Engineer"
    },
    {
        "id": "12",
        "firstName": "vijay",
        "surName": "koshis",
        "dob": "1991/05/19",
        "title": "software Engineer"
    }
]
