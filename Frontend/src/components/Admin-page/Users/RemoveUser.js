import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

function RemoveUser() {

   const [userid,setUserid] = useState(0);
   const [formErrors, setFormErrors] = useState({});
    const [isSubmit, setIsSubmit] = useState(false);


  const handleBtnClick = (e)=>{
      // console.log(e.target.response)
      e.preventDefault();
      setFormErrors(validate(userid));
      setIsSubmit(true);
      axios.delete(`http://localhost:8080/users/removeUser/${userid}`)
      .then(() => {
        window.alert("User Removed");
        setUserid(0);
      }).catch(error => console.log(error.message));
  }

  useEffect(() => {
    console.log(formErrors);
    if (Object.keys(formErrors).length === 0 && isSubmit) {
      console.log(userid);
    }
  }, [formErrors]);

  const validate = (values) => {
    const errors = {};
    if (!values) {
        errors.userid = "User id is required!";
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
        <form className="c2 view-form">
            <h1 className="form-text ">Remove User By ID</h1>
           <br/>
           <label>User Id</label>
            <input name="userid" type="number" placeholder="User ID*" className="username" 
             value = {userid}
             onChange={e=>setUserid(e.target.value)}
            />
            <br/>
            <p>{formErrors.userid}</p>
            <button className="btn" data-testid="button" onClick={handleBtnClick}>Remove User</button>
         </form>
    </React.Fragment>
    );
}

export default RemoveUser; 