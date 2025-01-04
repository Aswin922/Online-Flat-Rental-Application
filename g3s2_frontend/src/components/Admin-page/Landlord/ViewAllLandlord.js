
import React, { useEffect, useState } from 'react';
import axios from 'axios';

function ViewAllLandlord() {

  let initiallandlord=[];
    let [landlords,setLandlords]=useState(initiallandlord);

    useEffect(() => {
        const URL = 'http://localhost:8080/landlord/viewalllandlord';
        axios.get(URL).then((response) => {
            setLandlords(response.data);
        })
        .catch((error) => console.log(error));
    },[]);
    const formStyle = {
      backgroundColor: "#FFFAFA",
      //padding: "15px"
  };

   return (
      <React.Fragment><div style={formStyle}>
      <nav className="navbar navbar-dark bg-dark justify-content-between fixed-top">
      <button className="btn btn-outline-danger my-2 my-sm-0 logout-btn"><a href="/admin">Admin Panel</a></button>
        <span className="header-right">Flat Rental Application</span>
        <form className="form-inline">
       
          <button className="btn btn-outline-danger my-2 my-sm-0 logout-btn" type="submit"><a href="/login">Logout</a></button>
        </form>
      </nav>
      {/* <h1 style={mystyle}>All Flats</h1> */}
      <br/><br/><br/><br/>
        
        <table className="table table-data table-striped table-bordered">
    <thead>
        <tr className="table-warning">
          <th className="col-md-2">Landlord Id</th>
          <th className="col-md-3">Name</th>
          <th className="col-md-1">Age</th>
          <th className="col-md-3">Flat List</th>
        </tr>
      </thead>
      <tbody className="table-success ">

      {
        landlords.map (
            landlord=>
        <tr>
          <td className="col-md-2">{landlord&&landlord.landlordId}</td>
          <td className="col-md-3">{landlord&&landlord.landlordName}</td>
          <td className="col-md-1">{landlord&&landlord.landlordAge}</td>
          <td className="col-md-3">{landlord&&landlord.flatList.map(flat => <div>{flat.flatId}</div>)}</td>
        </tr>
      )}
       
      </tbody>

  </table>     
</div>


    </React.Fragment>
    );
}

export default ViewAllLandlord;