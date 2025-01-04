import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

function ViewAllUser() {

    let initialCustomers=[];
    let [users,setUsers]=useState(initialCustomers);

    useEffect(() => {
        const URL = 'http://localhost:8080/users/viewAllUsers';
        axios.get(URL).then((response) => {
            setUsers(response.data);
        })
        .catch((error) => console.log(error));
    },[]);

  return (
      <React.Fragment>
        
        <nav className="navbar navbar-dark bg-dark justify-content-between fixed-top">
        <button className="btn btn-outline-danger my-2 my-sm-0 logout-btn"><a href="/admin">Admin Panel</a></button>
        <span className="header-right">Flat Rental Application</span>
        <form className="form-inline">
       
          <button className="btn btn-outline-danger my-2 my-sm-0 logout-btn" type="submit"><a href="/login">Logout</a></button>
        </form>
      </nav>
            <table className="table table-data table-striped table-bordered ViewAllUsers">
                <thead>
                <tr className="table-warning">
                    <th>User ID</th>
                    <th>User Name</th>
                    <th>User Type</th>
                </tr>
                </thead>
                <tbody className="table-success ">
                {
                users.map (
                    user =>
                    <tr>
                        <td className="col-md-2">{user.userId}</td>
                        <td className="col-md-3">{user.userName}</td>
                        <td className="col-md-3">{user.userType}</td>
                </tr>
                )}
            
                                    
                </tbody>
            </table>
    </React.Fragment>
    );
}

export default ViewAllUser;