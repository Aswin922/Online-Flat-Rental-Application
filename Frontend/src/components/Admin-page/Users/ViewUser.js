import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

function ViewUser() {

    const [userid,setUserid] = useState(0);
    const [userDetails,setUserDetail] = useState([]);
    const [formErrors, setFormErrors] = useState({});
    const [isSubmit, setIsSubmit] = useState(false);
 
   const handleBtnClick = (e)=>{
    e.preventDefault();
    setFormErrors(validate(userid));
    setIsSubmit(true);
    axios.get(`http://localhost:8080/users/viewUser/${userid}`)
    .then((response) => {
     setUserDetail(response.data)
     setUserid(0);}).catch(error => console.log(error.message));
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
            <form className="view-form"> 
                <h1 className="form-text ">View User By ID</h1>
                <br/>
                <label>User Id</label>
                <input name="userId" type="number" placeholder="User ID*" className="username"
                  value = {userid}
                  onChange={e=>setUserid(e.target.value)}
                
                />
                <p>{formErrors.userid}</p>
                <br/>
                <button className="btn" data-testid="button" onClick={handleBtnClick}>View User</button>
            </form>
            
        
            <table className="table table-data table-striped table-bordered view-table">
            <thead>
                <tr className="table-warning">
                <th className="col-md-2">User ID</th>
                <th className="col-md-4">User Name</th>
                <th className="col-md-4">User Type</th>
                </tr>
            </thead>
            <tbody className="table-success ">
            
                    <tr>
                        <td className="col-md-2">{userDetails.userId}</td>
                        <td className="col-md-3">{userDetails.userName}</td>
                        <td className="col-md-3">{userDetails.userType}</td>
                </tr>
                 
            </tbody>
            </table>
      </React.Fragment>
    );
}

export default ViewUser;