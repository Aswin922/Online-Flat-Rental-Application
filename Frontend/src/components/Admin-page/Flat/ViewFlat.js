import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

function ViewFlat() {
  let initialFlat = [] ;
  let [flat, setFlat] = useState(initialFlat);

  const [flatId,setFlatId] = useState();
    const [btn,setButton] = useState(0);
  
useEffect(() => {
  const URL = `http://localhost:8080/flat/viewflat/${flatId}`;
  axios
    .get(URL)
    .then((response) => {
        setFlat(response.data)
        console.log(response.data)
    })
    .catch((error) => console.log(error.message));
},[btn])

console.log(flat.flatAddress);

const handleBtnClick = (e)=>{
  e.preventDefault();
  setButton(flatId)
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
      <br/><br/><br/><br/>
        
        <form className="view-form">
    <h1 className="form-text ">View Flat By ID</h1>
    <br/>
    <input name="username" type="number" placeholder="Flat ID*" className="username"
    value = {flatId}
    onChange={e=>setFlatId(e.target.value)}
    />
    
    <br/>
    <button className="btn" onClick={handleBtnClick}>View Flat</button>
   </form>
   
 <table className="table table-data table-striped table-bordered view-table">
    <thead>
        <tr className="table-warning">
        <th>Flat Id</th>
            <th>House No</th>
            <th>Street</th>
            <th>City</th>
            <th>Pin</th>
            <th>State</th>
            <th>Country</th>
            <th>Cost</th>
            <th>Availability</th>
        </tr>
      </thead>
      <tbody className="table-success ">
        <tr>
          <td>{flat&&flat.flatId}</td>
          <td>{flat&&flat.flatAddress&&flat.flatAddress.houseNo}</td>
          <td>{flat&&flat.flatAddress&&flat.flatAddress.street}</td>
          <td>{flat&&flat.flatAddress&&flat.flatAddress.city}</td>
          <td>{flat&&flat.flatAddress&&flat.flatAddress.pin}</td>
          <td>{flat&&flat.flatAddress&&flat.flatAddress.state}</td>
          <td>{flat&&flat.flatAddress&&flat.flatAddress.country}</td>
         <td>{flat&&flat.cost}</td>
         <td>{flat&&flat.availability}</td>        
        </tr>
      </tbody>
      </table>

      <button className="btn" data-testid="button" onClick={handleBtnClick}>View Flat</button>

    </React.Fragment>
    );
}

export default ViewFlat;