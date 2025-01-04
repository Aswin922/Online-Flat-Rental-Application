import React, { useEffect, useState } from 'react';
import axios from 'axios';

function ViewAllTenant() {

    let initialCustomers=[];
    let [tenants,setTenants]=useState(initialCustomers);

    useEffect(() => {
        const URL = 'http://localhost:8080/tenant/gettenants';
        axios.get(URL).then((response) => {
            setTenants(response.data);
        })
        .catch((error) => console.log(error));
    },[]);

     function goToAddCustomer(){
    //     //props.history.push('/addCustomer');
     }


  return (
      <React.Fragment>
        <nav className="navbar navbar-dark bg-dark justify-content-between fixed-top">
        <button className="btn btn-outline-danger my-2 my-sm-0 logout-btn"><a href="/admin">Admin Panel</a></button>
        <span className="header-right">Flat Rental Application</span>
        <form className="form-inline">
       
          <button className="btn btn-outline-danger my-2 my-sm-0 logout-btn" type="submit"><a href="/login">Logout</a></button>
        </form>
      </nav>
            <table className="table table-data table-striped table-bordered">
    <thead>
        <tr className="table-warning">
        <th>ID</th>
        <th>HOUSE NO</th>
            <th>STREET</th>
            <th>CITY</th>
            <th>PIN</th>
            <th>STATE</th>
            <th>COUNTRY</th>
          <th>Age</th>
        </tr>
      </thead>
      <tbody className="table-success ">
      {
                tenants.map (
                    tenant =>
        <tr>
         <td>{tenant&&tenant.tenantId}</td>
          <td>{tenant.taddress&&tenant.taddress.houseNo}</td>
          <td>{tenant.taddress&&tenant.taddress.street}</td>
          <td>{tenant.taddress&&tenant.taddress.city}</td>
          <td>{tenant.taddress&&tenant.taddress.pin}</td>
          <td>{tenant.taddress&&tenant.taddress.state}</td>
          <td>{tenant.taddress&&tenant.taddress.country}</td>
          <td>{tenant&&tenant.age}</td>
        </tr>
      
                )}
      </tbody>

  </table> 
    </React.Fragment>
    );
}

export default ViewAllTenant;