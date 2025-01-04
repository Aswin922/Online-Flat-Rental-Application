import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

function AddUser() {

  let initialuser={userId:0,userName:'',password:'',userType:''};
  let [user,setUser]=useState(initialuser);
  const [formErrors, setFormErrors] = useState({});
  const [isSubmit, setIsSubmit] = useState(false);

  function handleBtnClick(e)
  {
      e.preventDefault();
      setFormErrors(validate(user));
      setIsSubmit(true);
      const URL='http://localhost:8080/users/addUser';
      axios.post(URL,user).then((response) => 
      {
          window.alert("User Added...");
          setUser(initialuser);
      }).catch(error => console.log(error.message))
  }

  useEffect(() => {
    console.log(formErrors);
    if (Object.keys(formErrors).length === 0 && isSubmit) {
      console.log(user);
    }
  }, [formErrors]);

  const validate = (values) => {
    const errors = {};
    if (!values.userName) {
      errors.userName = "Username is required!";
    }
    if (!values.userType) {
      errors.userType = "User type is required!";
    } 
    if (!values.password) {
      errors.password = "Password is required";
    } else if (values.password.length < 4) {
      errors.password = "Password must be more than 4 characters";
    } else if (values.password.length > 10) {
      errors.password = "Password cannot exceed more than 10 characters";
    }
    return errors;
  };

  return (
      <React.Fragment>
        <nav className="navbar navbar-dark bg-dark justify-content-between fixed-top">
        <button className="btn btn-outline-danger my-2 my-sm-0 logout-btn"><a href="/admin">Admin Panel</a></button>
        <span className="header-right">Flat Rental Application</span>
        <form className="form-inline">
       
          <button className="btn btn-outline-danger my-2 my-sm-0 logout-btn" type="submit"><a href="/login">Logout</a></button>
        </form>
      </nav>
        {Object.keys(formErrors).length === 0 && isSubmit ? (
        <div className="ui message success">User Added.</div>
      ) : (<></>
        // <pre>{JSON.stringify(user, undefined, 2)}</pre>
      )}
    <form className="c2" method="POST">
    <h1 className="form-text ">Add User</h1>
    <br/><br/><br/><br/>
        <label>Username</label>
       <input name="username" type="text" placeholder="Username*" className="username"
       value={user.userName} onChange={e=>setUser({...user,userName:e.target.value})}
       />
       <p>{formErrors.userName}</p>
       <br/>
       <label>Password</label>
       <input name="password" type="password" placeholder="Password*" className="username"
       value={user.password} onChange={e=>setUser({...user,password:e.target.value})}
       />
       <p>{formErrors.password}</p>
       <br/>
       <label>UserType</label>
       <select name="usertype" className="username" 
        value={user.userType} 
        onChange={e=>setUser({...user,userType:e.target.value})}
       >
         <option value="">Select one option</option>
         <option value="landlord">Landlord</option>
         <option value="tenant">Tenant</option>
         <option value="admin">Admin</option>

       </select>
       <p>{formErrors.userType}</p>
    <br/>
    <button className="btn" type="submit" data-testid="button" onClick={handleBtnClick}>Add User</button>
        </form>
     </React.Fragment>
    );
}

export default AddUser;