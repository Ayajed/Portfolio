function validate(){
    console.log("Submitted!")
  
    var firstname = document.getElementById('firstname').value
    var lastname = document.getElementById('lastname').value
    var username = document.getElementById('username').value
    var email = document.getElementById('email').value
    var password = document.getElementById('password').value
  
    if(validateFirstName(firstname) == false){
      return
    }
  
    if(validateLastName(lastname) == false){
      return
    }
  
    if(validateUsername(username) == false){
      return
    }
  
    if(validateEmail(email) == false){
      return
    }

    if(validatePassword(password) == false){
        return
    }
  
    document.getElementById('message').innerText = "Successfully Registered!"
    
  }
  
  function validateFirstName(firstname){
      if(firstname.length < 1){
        alert("First name required")
          return false;
      }

    for(var i = 0; i < firstname.length; i++){
      if(!(firstname[i] >= 'A' && firstname[i] <= 'Z') && !(firstname[i] >= 'a' && firstname[i] <= 'z')){
        alert("First name must contain alpha characters only")
        return false 
      }
    }
  
    return true 
  }
  
  function validateLastName(lastname){
    if(lastname.length < 1){
        alert("Last name required")
          return false;
      }

    for(var i = 0; i < lastname.length; i++){
      if(!(lastname[i] >= 'A' && lastname[i] <= 'Z') && !(lastname[i] >= 'a' && lastname[i] <= 'z')){
        alert("Last name must contain alpha characters only")
        return false 
      }
    }
  
    return true 
  }
  
  function validateUsername(username){
    if(username.length < 1){
        alert("Username required")
          return false;
      }

    for(var i = 0; i < username.length; i++){
      if(!(username[i] >= 'A' && username[i] <= 'Z') && !(username[i] >= 'a' && username[i] <= 'z') && !(username[i] >= '0' && username[i] <= '9')){
        alert("Username cannot contain special characters")
        return false
      }
    }
  
    return true
  }
  
  function validateEmail(email){
    if(email.length < 1){
        alert("Email required")
          return false;
      }

    var flag = 0
    for(var i = 0; i < email.length; i++){
      if(email[i] == '@'){
        flag = 1
      }
  
      if(email[i] == '@' && email[i+1] == '.'){
        alert(". cannot be placed right after @")
        return false
      }
    }
  if(flag == 0){
      alert("Email must contain @")
      return false 
    }
  
    if(!email.endsWith('.com') && !email.endsWith('.co.id')){
      alert("Email must end with either .com or .co.id")
      return false
    }
  
    return true 
  }

  function validatePassword(password){
    if(password.length < 1 ){
        alert("Password required")
          return false;
      }
  }