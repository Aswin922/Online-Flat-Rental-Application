
import React, { useEffect, useState } from 'react';
import axios from 'axios';


function ViewLandlord() {

  let initiallandlord={flatList:[], landlordAge: '', landlordId: '', landlordName: ''};
    const [landlordid,setLandlordid] = useState('');
    const [landlordDetails,setLandlordDetails] = useState(initiallandlord);
    const [formErrors, setFormErrors] = useState({});
    const [isSubmit, setIsSubmit] = useState(false);

   const handleBtnClick = (e)=>{
    e.preventDefault();
    setFormErrors(validate(landlordid));
    setIsSubmit(true);
    axios.get(`http://localhost:8080/landlord/viewlandlord/${landlordid}`)
       .then((response) => {setLandlordDetails(response.data)
        setLandlordid(0);}).catch(error => console.log(error.message));
  }
  useEffect(() => {
    console.log(formErrors);
    if (Object.keys(formErrors).length === 0 && isSubmit) {
      console.log(landlordid);
    }
  }, [formErrors]);

  const validate = (values) => {
    const errors = {};
    if (!values) {
        errors.landlordid = "Landlord id is required!";
    }
    return errors;
  };

console.log(landlordDetails);
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
    <h1 className="form-text ">View LandLord By ID</h1>
    <br/>
    <input name="landlordname" type="number" placeholder="Landlord ID" className="username"
    value = {landlordid} onChange={e=>setLandlordid(e.target.value)}/>
    <p>{formErrors.landlordid}</p>
    <br/>
    <button className="btn" data-testid="button" onClick={handleBtnClick}>View Landlord</button>
   </form>
   

 <table className="table table-data table-striped table-bordered view-table">
    <thead>
        <tr className="table-warning">
          <th className="col-md-2">ID</th>
          <th className="col-md-3">Landlord Name</th>
          <th className="col-md-1">Age</th>
          <th className="col-md-3">Flat List</th>
        </tr>
      </thead>
      <tbody className="table-success ">
        <tr>
          <td className="col-md-2">{landlordDetails&&landlordDetails.landlordId}</td>
          <td className="col-md-3">{landlordDetails&&landlordDetails.landlordName}</td>
          <td className="col-md-1">{landlordDetails&&landlordDetails.landlordAge}</td>
          <td className="col-md-3">{landlordDetails&&landlordDetails.flatList.map(flat=><div>{flat.flatId}</div>)}</td>
        </tr>
      </tbody>

  </table>     


    </React.Fragment>
    );
}

export default ViewLandlord;