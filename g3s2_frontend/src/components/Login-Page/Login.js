/* eslint-disable eqeqeq */
import React from 'react';
import axios from 'axios';
import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import styles from '../Login-Page/login.module.css';
import { Link } from 'react-router-dom';

function Login() {
  const history=useNavigate();
  const initialValues={username:"",password:"",usertype:""};
  const [formValues, setFormValues] = useState(initialValues);
  const [formErrors, setFormErrors] = useState({});
  const [isSubmit, setIsSubmit] = useState(false);
  var isLogged= false;

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormValues({ ...formValues, [name]: value });
  };

  const fetchUsers = async() =>{
    await axios.get('http://localhost:8080/users/viewAllUsers',{headers:{"Content-Type" : "application/json"}}).then((data)=>{
      //Consider num=[0];
    for(let i=0;i<data.data.length;i++){
      if(data.data[i].password==formValues.password && data.data[i].userType==formValues.usertype && data.data[i].userName==formValues.username ){
        console.log("Logged In");
         //dispatch(login());
        isLogged=true;
        if(data.data[i].userType==="admin"){
          history("/admin");
        }else if(data.data[i].userType==="tenant"){
          history("/tenant");
        }
        else if(data.data[i].userType==="landlord"){
         history("/landlord");
       }
        break;
      }else{
        isLogged=false;
        validate(formValues);
      }
    }}).catch((error)=>console.log(error));
  }
 
    //console.log(fetchUsers);
  const handleSubmit = (e) => {
    e.preventDefault();
    setFormErrors(validate(formValues));
    setIsSubmit(true);
  };

  useEffect(() => {
    console.log(formErrors);
    if (Object.keys(formErrors).length === 0 && isSubmit) {
      console.log(formValues);
    }
  }, [formErrors, formValues, isSubmit]);
  
  const validate = (values) => {
   const errors = {};
   if (!values.username) {
     errors.username = "Username is Required!";
   }
   if (!values.userType) {
     errors.userType = "User Type is Required!";
   } 
   if (!values.password) {
     errors.password = "Password is Required!";
   } else if (values.password.length < 4) {
     errors.password = "Password must be more than 4 Characters!";
   } else if (values.password.length > 10) {
     errors.password = "Password cannot exceed more than 10 Characters!";
   }
   if(!isLogged){
      errors.login="Invalid Credentials!";
    }
    return errors;
  };

  return (
   <React.Fragment>
      {Object.keys(formErrors).length === 0 && isSubmit ? (
        <div className="ui message success">Signed in successfully</div>
      ) : (<></>
      //   <pre>{JSON.stringify(formValues, undefined, 2)}</pre>
      )}
      <div className={styles.loginbox}>   
           <div className={styles.c1}>
             
              <div className={styles.c11}>

                     <h1 className={styles.mainhead}>Welcome</h1>
                     <br/><br/>
                     <h4>Register as</h4>
                     <h5>or</h5>
                     <button id="formlogin" className={styles.btnreg} ><Link to='/registerLandlord'>Landlord</Link></button>
                     <button id="formlogin" className={styles.btnregt} ><Link to='/registerTenant'>Tenant</Link></button>
              </div>
          </div>
          <div className={styles.c2}>
      <form className={styles.signin} onSubmit={handleSubmit}>
        <h1 className={styles.signup1}>Login Form</h1>
        
          <label>Username</label>
            <input
              name="username" type="text" required={true} placeholder="Username*" className={styles.username}
              value={formValues.username}
              onChange={handleChange}
            />
          
          <p>{formErrors.loginName}</p>
          
          <label>Password</label>
            <input
              name="password" type="password" required={true} placeholder="Password*" className={styles.username}
              value={formValues.password}
              onChange={handleChange}
            />
          
          <p>{formErrors.email}</p>
          
          <label>UserType</label>
       <select name="usertype" required={true} className={styles.username}  
              value={formValues.usertype}
              onChange={handleChange}
            >
            <option value="">Select one option</option>
         <option value="landlord">Landlord</option>
         <option value="tenant">Tenant</option>
         <option value="admin">Admin</option>

       </select>
          
          <p>{formErrors.password}</p>
          <button id="formlogin" type="submit" className={styles.btnlogin} onClick={fetchUsers} data-testid="button">Submit</button>
          <p>{formErrors.login}</p>  
        
      </form>
      </div>
      <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
               <script src="script.js" type="text/jsx"></script>
    </div>
   </React.Fragment>
  )
}

export default Login;
